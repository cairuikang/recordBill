package com.jhlc.record.service;

import com.jhlc.record.conmmon.constant.IdentityType;
import com.jhlc.record.conmmon.constant.PayDealType;
import com.jhlc.record.controller.resp.Result;
import com.jhlc.record.controller.resp.ResultEnum;
import com.jhlc.record.controller.resp.ResultUtils;
import com.jhlc.record.core.annotation.ControlAccess;
import com.jhlc.record.core.exception.BizException;
import com.jhlc.record.core.service.BaseService;
import com.jhlc.record.dao.TOrderRepository;
import com.jhlc.record.dao.TUserRepository;
import com.jhlc.record.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.Optional;

/**
 * 支记账service
 */
@Service
@Slf4j
public class PayService extends BaseService {
    @Autowired
    SaleStrategyService saleStrategyService;
    @Autowired
    AccountService accountService;
    @Autowired
    BranchService branchService;



    @Autowired
    TOrderRepository tOrderRepository;
    @Autowired
    TUserRepository userRepository;
    /**
     * 异步请求记账
     *
     * @param orderId
     * @param type3PackageAmt
     * @return
     */
    @ControlAccess("pay")
    public void asyncBookkeeping(Long orderId, Integer type3PackageAmt, DeferredResult<Result> result) {
        bookkeeping(orderId, type3PackageAmt);
        result.setResult(ResultUtils.success());
    }

    /**
     * 记账
     *
     * @param orderId
     * @param type3PackageAmt
     * @return
     */
    @ControlAccess("pay")
    public void bookkeeping(Long orderId, Integer type3PackageAmt) {
        log.info("进入联创云服记账方法入参:订单id" + orderId);
        //支付订单
        TOrder order = pay(orderId);
        //返佣
        commission(order);
        log.info("订单：{}，返佣流水成功", orderId);
    }

    /**
     * 订单支付记账
     * @param orderId
     * @return
     */
    public TOrder pay(Long orderId) {
        Optional<TOrder> orderOptional = tOrderRepository.findById(orderId);
        TOrder order = orderOptional.orElseThrow(() -> new BizException(ResultEnum.ORDER_MISS_CODE));
        //支付扣款
        TChannelAccountDetail tChannelAccountDetail = TChannelAccountDetail.builder()
                .amt((-1) * order.getRealPremiumAmt())
                .rateType("")
                .rateValue("")
                .orderId(order.getId())
                .oprUserId(order.getUserId())
                .payChannel(order.getPayMethod())
                .dealDesp(accountService.getdealDesp("", order.getPayMethod(), PayDealType.DEAL_TYPE21.getIndex()))
                .dealType(PayDealType.DEAL_TYPE21.getIndex())
                .accountId(accountService.getAccount(String.valueOf(order.getUserId()), IdentityType.IDENTITY_TYPE2.getAccountType()).getAccountId())
                .build();
        accountService.operateTheAccountAndRecord(tChannelAccountDetail);
        return order;
    }

    /**
     * 用户返佣记账
     *
     * @param order
     * @return
     */
    public void commission(TOrder order) {
        log.info("返佣方法入参:订单" + order);

        //获取用户
        TUser tuser = getCommissionUser(order);

        //拼装记账策略（根据用户） user->branch>channel
        List<SaleStrategy> tSaleStrategys = saleStrategyService.getSaleStrategyParms(tuser);

        //计算各级佣金并记账
        calculateCommission(order, tSaleStrategys);

    }

    /**
     * 计算各级佣金
     *
     * @param order
     * @param tSaleStrategys
     */
    private void calculateCommission(TOrder order, List<SaleStrategy> tSaleStrategys) {
        //4.3查询记录各级组织的返佣
        int commission = 0;
        String rateType = "0";
        int rateValue = 0;
        for (SaleStrategy saleStrategy : tSaleStrategys) {
            saleStrategy.setProductCode(order.getProductCode());
            saleStrategy.setSiteId(order.getOnlineSite());
            saleStrategy = saleStrategyService.getSaleByProduct(saleStrategy);
            String rateTypeTmp;
            int rateValueTmp;
            if ((saleStrategy == null) || Integer.valueOf(0).equals(saleStrategy.getRateValue())) {
                continue;
            } else {
                rateTypeTmp = saleStrategy.getRateType();
                rateValueTmp = saleStrategy.getRateValue();
            }
            if (String.valueOf(11).equals(rateTypeTmp)) {
                commission = order.getRealPremiumAmt() * (rateValueTmp - rateValue) / 100;
                rateType = rateTypeTmp;
                rateValue = rateValueTmp;
            } else if (String.valueOf(21).equals(rateTypeTmp)) {
                commission = rateValueTmp - rateValue;
                rateType = rateTypeTmp;
                rateValue = rateValueTmp;
            }

            TChannelAccountDetail tChannelAccountDetail = TChannelAccountDetail.builder()
                    .amt(commission)
                    .rateType(rateType)
                    .rateValue(String.valueOf(rateValue))
                    .orderId(order.getId())
                    .oprUserId(order.getUserId())
                    .payChannel(order.getPayMethod())
                    .dealDesp(accountService.getdealDesp("", order.getPayMethod(), PayDealType.DEAL_TYPE5.getIndex()))
                    .dealType(PayDealType.DEAL_TYPE5.getIndex())
                    .accountId(accountService.getAccount(saleStrategy.getBucId(), IdentityType.getAccountTypeByConfigType(saleStrategy.getConfigType())).getAccountId())
                    .build();
            accountService.operateTheAccountAndRecord(tChannelAccountDetail);
        }
    }

    /**
     * 获取佣金计算的用户
     *
     * @param order
     * @return
     */
    private TUser getCommissionUser(TOrder order) {
        Long userId = order.getUserId();
        Long recommenderId = order.getRecommenderId();
        TUser tuser;
        if (recommenderId != null) {
            tuser = userRepository.findById(recommenderId).orElseThrow(() -> new BizException(ResultEnum.USER_MISS_CODE));
        } else {
            tuser = userRepository.findById(userId).orElseThrow(() -> new BizException(ResultEnum.USER_MISS_CODE));
        }
        return tuser;
    }


}
