package com.jhlc.record.service;

import com.jhlc.record.conmmon.constant.PayChannel;
import com.jhlc.record.conmmon.constant.PayDealType;
import com.jhlc.record.core.exception.BizException;
import com.jhlc.record.core.service.BaseService;
import com.jhlc.record.dao.TChannelAccountRepository;
import com.jhlc.record.dao.TChannelAccountDetailRepository;
import com.jhlc.record.dao.TPayChannelRepository;
import com.jhlc.record.entity.TChannelAccount;
import com.jhlc.record.entity.TChannelAccountDetail;
import com.jhlc.record.entity.TPaychannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author 10096
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "accountService")
public class AccountService extends BaseService {


    @Autowired
    TChannelAccountRepository tChannelAccountRepository;
    @Autowired
    TChannelAccountDetailRepository tChannelAccountDetailRepository;
    @Autowired
    TPayChannelRepository tPayChannelRepository;

    /**
     * 操作账户，记录流水
     * 流程：1，操作账户余额，2.记录商户流水
     *
     * @param detail account_id
     *                              balanceAmt
     *                              rate_type
     *                              rate_value
     *                              order_id
     *                              userId 操作人
     *                              payChannel
     *                              dealType 1、充值 2、支付，3：转账，4:返佣,5返佣冻结
     *                              dealDesp (可不传)
     */
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void operateTheAccountAndRecord(TChannelAccountDetail detail) {
        //获取参数
        if(checkIsOperate(detail)){
            //操作账户
            operatingAccount(detail);
            //记录流水
            recordBill(detail);
        }
    }

    /**
     * 该操作是否具备执行条件判断执行条件
     * ps：并不需要抛异常还要下一次记账
     * @param detail
     * @return
     */
    private boolean checkIsOperate(TChannelAccountDetail detail) {
        boolean flag = true;
        if (detail.getOrderId() == null) {
            TChannelAccountDetail tmp =  TChannelAccountDetail.builder()
                    .accountId(detail.getAccountId())
                    .orderId(detail.getOrderId())
                    .amt(detail.getAmt())
                    .dealType(detail.getDealType()).build();
            Long count = tChannelAccountDetailRepository.count(Example.of(tmp));
            if (count > 0) {
                log.info("订单号：{},{}已经记录，无需二次记录",detail.getOrderId(),detail.getDealDesp());
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 操作账户金额
     * @param detail
     */
    private void operatingAccount(TChannelAccountDetail detail) {
        String dealType = detail.getDealType();
        long accountId = detail.getAccountId();
        int amt = detail.getAmt();
        /**
         * 操作余额      ps:如果类型为充值，余额支付，转账，返佣,提现
         */
        if (Stream.of(PayDealType.DEAL_TYPE1, PayDealType.DEAL_TYPE2, PayDealType.DEAL_TYPE3, PayDealType.DEAL_TYPE4, PayDealType.DEAL_TYPE7).anyMatch(payDealType -> payDealType.getIndex().equals(dealType))) {
            int result = tChannelAccountRepository.updatebalanceAmt(amt,accountId);
            if (result <= 0) {
                log.info("账户id：{}--余额不足",accountId);
                throw new BizException("用户余额不足");
            }
        }
        /**
         * 操作在途金额
         */
        if (Stream.of(PayDealType.DEAL_TYPE21, PayDealType.DEAL_TYPE7, PayDealType.DEAL_TYPE11, PayDealType.DEAL_TYPE8).anyMatch(payDealType -> payDealType.getIndex().equals(dealType))) {
            if(PayDealType.DEAL_TYPE7.getIndex() == dealType){
                amt = amt *-1;
            }
            int result = tChannelAccountRepository.updateTransitAmt(amt,accountId);
            if (result <= 0) {
                log.info("账户id：{}--在途金额余额不足",accountId);
                throw new BizException("用户在途余额不足");
            }
        }
        /**
         * 操作冻结金额
         */
        //返佣，订单未生效则放到冻结账户
        if (Stream.of(PayDealType.DEAL_TYPE5,PayDealType.DEAL_TYPE4).anyMatch(payDealType -> payDealType.getIndex().equals(dealType))) {
            if (PayDealType.DEAL_TYPE4.getIndex().equals(dealType)) {
                amt = amt*-1;
            }
            int result = tChannelAccountRepository.updateFreezeAmt(amt,accountId);
            if (result <= 0) {
                log.info("账户id：{}--用户冻结金额不足",accountId);
                throw new BizException(1, "用户冻结金额不足");
            }
        }
    }

    /**
     * 记录流水
     * @param detail
     */
    public long recordBill(TChannelAccountDetail detail) {
        long accountDetailId=0;
        String dealType = detail.getDealType();
        if (dealType.equals(PayDealType.DEAL_TYPE5.getIndex())) {
            //冻结
            tChannelAccountDetailRepository.callFreeze(String.valueOf(detail.getAccountId()),detail.getDealType(),
                    detail.getDealDesp(),detail.getPayChannel(),String.valueOf(detail.getAmt()),
                    String.valueOf(detail.getOprUserId()),String.valueOf(detail.getOrderId()),
                    detail.getRateType(),detail.getRateValue());
        } else if (dealType.equals(PayDealType.DEAL_TYPE4.getIndex())) {
            //冻结，余额
            tChannelAccountDetailRepository.callFreeze2Balance(String.valueOf(detail.getAccountId()),detail.getDealType(),
                    detail.getDealDesp(),detail.getPayChannel(),String.valueOf(detail.getAmt()),
                    String.valueOf(detail.getOprUserId()),String.valueOf(detail.getOrderId()),
                    detail.getRateType(),detail.getRateValue());
        } else if (dealType.equals(PayDealType.DEAL_TYPE7.getIndex())) {
            //余额2在途
            tChannelAccountDetailRepository.callBalance2Transit(String.valueOf(detail.getAccountId()),detail.getDealType(),
                    detail.getDealDesp(),detail.getPayChannel(),String.valueOf(detail.getAmt()),
                    String.valueOf(detail.getOprUserId()),String.valueOf(detail.getOrderId()),
                    detail.getRateType(),detail.getRateValue());
        } else if (dealType.equals(PayDealType.DEAL_TYPE8.getIndex())||dealType.equals(PayDealType.DEAL_TYPE21.getIndex())||dealType.equals(PayDealType.DEAL_TYPE11.getIndex())) {
            //在途
            tChannelAccountDetailRepository.callTransit(String.valueOf(detail.getAccountId()), detail.getDealType(),
                    detail.getDealDesp(), detail.getPayChannel(), String.valueOf(detail.getAmt()),
                    String.valueOf(detail.getOprUserId()), String.valueOf(detail.getOrderId()),
                    detail.getRateType(), detail.getRateValue());
        }else {
            //余额
            tChannelAccountDetailRepository.callBalance(String.valueOf(detail.getAccountId()),detail.getDealType(),
                    detail.getDealDesp(),detail.getPayChannel(),String.valueOf(detail.getAmt()),
                    String.valueOf(detail.getOprUserId()),String.valueOf(detail.getOrderId()),
                    detail.getRateType(),detail.getRateValue());
        }
        return accountDetailId;
    }

    /**
     * 获取描述信息
     * @return
     */
    @Cacheable(keyGenerator = "myKeyGenerator", unless = "#result eq null")
    public String getdealDesp(String dealDesp,String payChannel,String dealType) {
        //用户除余额外的支付方式，需记录充值方式
        if (PayDealType.DEAL_TYPE1.getIndex().equals(dealType) && (!PayChannel.USER_TYPE1.getChannelId().equals(payChannel))) {
            TPaychannel tPaychannel = tPayChannelRepository.findByPayChannel(payChannel);
            String payChannelName = tPaychannel.getPayChannelName();
            dealDesp += PayDealType.getNameByIndex(dealType) + "-" + payChannelName;
        } else {
            dealDesp += PayDealType.getNameByIndex(dealType);
        }
        return dealDesp;
    }

    /**
     * 获取账户
     * @param channelId
     * @param accountType
     * @return
     */
    @Cacheable(keyGenerator = "myKeyGenerator", unless = "#result eq null")
    public TChannelAccount getAccount(String channelId, String accountType) {
        TChannelAccount tChannelAccount = new TChannelAccount();
        tChannelAccount.setChannelId(channelId);
        tChannelAccount.setAccountType(accountType);
        Optional<TChannelAccount> tChannelAccountOptional = tChannelAccountRepository.findOne(Example.of(tChannelAccount));
        return tChannelAccountOptional.orElseGet(()->createAccount(channelId, accountType));
    }

    /**
     * 创建账户
     * @param channelId
     * @param accountType
     * @return
     */
    private TChannelAccount createAccount(String channelId, String accountType) {
        TChannelAccount tChannelAccount = new TChannelAccount();
        tChannelAccount.setChannelId(channelId);
        tChannelAccount.setAccountType(accountType);
        tChannelAccount.setBalanceAmt(0);
        tChannelAccount.setTransitAmt(0);
        tChannelAccount.setFreezeAmt(0);
        tChannelAccount = tChannelAccountRepository.save(tChannelAccount);
        return tChannelAccount;
    }
}
