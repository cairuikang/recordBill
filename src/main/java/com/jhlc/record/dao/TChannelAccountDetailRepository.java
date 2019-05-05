package com.jhlc.record.dao;

import com.jhlc.record.entity.TChannelAccountDetail;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface TChannelAccountDetailRepository extends JpaRepository<TChannelAccountDetail, Long> {

    @Procedure(name="P_SEQUENCE_INSERT_ACCOUNT_DETAIL_TRANSIT")
    void callTransit(@Param("accountId")String accountId,
                     @Param("dealType")String dealType,
                     @Param("dealDesp")String dealDesp,
                     @Param("payChannel")String payChannel,
                     @Param("balanceAmt")String balanceAmt,
                     @Param("oprUserId")String oprUserId,
                     @Param("orderId")String orderId,
                     @Param("rateType")String rateType,
                     @Param("rateValue")String rateValue);

    @Procedure(name="P_SEQUENCE_INSERT_ACCOUNT_DETAIL_FREEZE")
    void callFreeze(@Param("accountId")String accountId,
                     @Param("dealType")String dealType,
                     @Param("dealDesp")String dealDesp,
                     @Param("payChannel")String payChannel,
                     @Param("balanceAmt")String balanceAmt,
                     @Param("oprUserId")String oprUserId,
                     @Param("orderId")String orderId,
                     @Param("rateType")String rateType,
                     @Param("rateValue")String rateValue);
    @Procedure(name="P_SEQUENCE_INSERT_ACCOUNT_DETAIL_FREEZE2BALANCE")
    void callFreeze2Balance(@Param("accountId")String accountId,
                    @Param("dealType")String dealType,
                    @Param("dealDesp")String dealDesp,
                    @Param("payChannel")String payChannel,
                    @Param("balanceAmt")String balanceAmt,
                    @Param("oprUserId")String oprUserId,
                    @Param("orderId")String orderId,
                    @Param("rateType")String rateType,
                    @Param("rateValue")String rateValue);
    @Procedure(name="P_SEQUENCE_INSERT_ACCOUNT_DETAIL_BALANCE")
    void callBalance(@Param("accountId")String accountId,
                            @Param("dealType")String dealType,
                            @Param("dealDesp")String dealDesp,
                            @Param("payChannel")String payChannel,
                            @Param("balanceAmt")String balanceAmt,
                            @Param("oprUserId")String oprUserId,
                            @Param("orderId")String orderId,
                            @Param("rateType")String rateType,
                            @Param("rateValue")String rateValue);
    @Procedure(name="P_SEQUENCE_INSERT_ACCOUNT_DETAIL_BALANCE2TRANSIT")
    void callBalance2Transit(@Param("accountId")String accountId,
                     @Param("dealType")String dealType,
                     @Param("dealDesp")String dealDesp,
                     @Param("payChannel")String payChannel,
                     @Param("balanceAmt")String balanceAmt,
                     @Param("oprUserId")String oprUserId,
                     @Param("orderId")String orderId,
                     @Param("rateType")String rateType,
                     @Param("rateValue")String rateValue);


}