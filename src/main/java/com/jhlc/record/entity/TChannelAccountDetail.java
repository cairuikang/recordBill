package com.jhlc.record.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_channel_account_detail")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "P_SEQUENCE_INSERT_ACCOUNT_DETAIL_TRANSIT", procedureName = "P_SEQUENCE_INSERT_ACCOUNT_DETAIL_TRANSIT", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "accountId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dealType", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dealDesp", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "payChannel", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "balanceAmt", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "oprUserId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "orderId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "rateType", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "rateValue", type = String.class)}
        ),
        @NamedStoredProcedureQuery(name = "P_SEQUENCE_INSERT_ACCOUNT_DETAIL_FREEZE", procedureName = "P_SEQUENCE_INSERT_ACCOUNT_DETAIL_FREEZE", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "accountId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dealType", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dealDesp", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "payChannel", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "balanceAmt", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "oprUserId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "orderId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "rateType", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "rateValue", type = String.class)}
        ),
        @NamedStoredProcedureQuery(name = "P_SEQUENCE_INSERT_ACCOUNT_DETAIL_FREEZE2BALANCE", procedureName = "P_SEQUENCE_INSERT_ACCOUNT_DETAIL_FREEZE2BALANCE", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "accountId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dealType", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dealDesp", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "payChannel", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "balanceAmt", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "oprUserId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "orderId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "rateType", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "rateValue", type = String.class)}
        ),
        @NamedStoredProcedureQuery(name = "P_SEQUENCE_INSERT_ACCOUNT_DETAIL_BALANCE", procedureName = "P_SEQUENCE_INSERT_ACCOUNT_DETAIL_BALANCE", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "accountId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dealType", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dealDesp", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "payChannel", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "balanceAmt", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "oprUserId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "orderId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "rateType", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "rateValue", type = String.class),}
        ),
        @NamedStoredProcedureQuery(name = "P_SEQUENCE_INSERT_ACCOUNT_DETAIL_BALANCE2TRANSIT", procedureName = "P_SEQUENCE_INSERT_ACCOUNT_DETAIL_BALANCE2TRANSIT", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "accountId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dealType", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dealDesp", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "payChannel", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "balanceAmt", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "oprUserId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "orderId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "rateType", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "rateValue", type = String.class),}
        )
})
public class TChannelAccountDetail {
    private Long id;
    private Long accountId;
    private Integer amt;
    private String dealType;
    private String dealDesp;
    private String status;
    private String woId;
    private Timestamp dealTime;
    private Integer preBalanceAmt;
    private Integer afterBalanceAmt;
    private Integer preTransitAmt;
    private Integer afterTransitAmt;
    private Integer preFreezeAmt;
    private Integer afterFreezeAmt;
    private Long oprUserId;
    private Long orderId;
    private Long withdrawId;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String payChannel;
    private String rateType;
    private String rateValue;


    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_id")
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "amt")
    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    @Basic
    @Column(name = "deal_type")
    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    @Basic
    @Column(name = "deal_desp")
    public String getDealDesp() {
        return dealDesp;
    }

    public void setDealDesp(String dealDesp) {
        this.dealDesp = dealDesp;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "wo_id")
    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId;
    }

    @Basic
    @Column(name = "deal_time")
    public Timestamp getDealTime() {
        return dealTime;
    }

    public void setDealTime(Timestamp dealTime) {
        this.dealTime = dealTime;
    }

    @Basic
    @Column(name = "pre_balance_amt")
    public Integer getPreBalanceAmt() {
        return preBalanceAmt;
    }

    public void setPreBalanceAmt(Integer preBalanceAmt) {
        this.preBalanceAmt = preBalanceAmt;
    }

    @Basic
    @Column(name = "after_balance_amt")
    public Integer getAfterBalanceAmt() {
        return afterBalanceAmt;
    }

    public void setAfterBalanceAmt(Integer afterBalanceAmt) {
        this.afterBalanceAmt = afterBalanceAmt;
    }

    @Basic
    @Column(name = "pre_transit_amt")
    public Integer getPreTransitAmt() {
        return preTransitAmt;
    }

    public void setPreTransitAmt(Integer preTransitAmt) {
        this.preTransitAmt = preTransitAmt;
    }

    @Basic
    @Column(name = "after_transit_amt")
    public Integer getAfterTransitAmt() {
        return afterTransitAmt;
    }

    public void setAfterTransitAmt(Integer afterTransitAmt) {
        this.afterTransitAmt = afterTransitAmt;
    }

    @Basic
    @Column(name = "pre_freeze_amt")
    public Integer getPreFreezeAmt() {
        return preFreezeAmt;
    }

    public void setPreFreezeAmt(Integer preFreezeAmt) {
        this.preFreezeAmt = preFreezeAmt;
    }

    @Basic
    @Column(name = "after_freeze_amt")
    public Integer getAfterFreezeAmt() {
        return afterFreezeAmt;
    }

    public void setAfterFreezeAmt(Integer afterFreezeAmt) {
        this.afterFreezeAmt = afterFreezeAmt;
    }

    @Basic
    @Column(name = "opr_user_id")
    public Long getOprUserId() {
        return oprUserId;
    }

    public void setOprUserId(Long oprUserId) {
        this.oprUserId = oprUserId;
    }

    @Basic
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "withdraw_id")
    public Long getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(Long withdrawId) {
        this.withdrawId = withdrawId;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_update_time")
    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Basic
    @Column(name = "pay_channel")
    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    @Basic
    @Column(name = "rate_type")
    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    @Basic
    @Column(name = "rate_value")
    public String getRateValue() {
        return rateValue;
    }

    public void setRateValue(String rateValue) {
        this.rateValue = rateValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TChannelAccountDetail that = (TChannelAccountDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(amt, that.amt) &&
                Objects.equals(dealType, that.dealType) &&
                Objects.equals(dealDesp, that.dealDesp) &&
                Objects.equals(status, that.status) &&
                Objects.equals(woId, that.woId) &&
                Objects.equals(dealTime, that.dealTime) &&
                Objects.equals(preBalanceAmt, that.preBalanceAmt) &&
                Objects.equals(afterBalanceAmt, that.afterBalanceAmt) &&
                Objects.equals(preTransitAmt, that.preTransitAmt) &&
                Objects.equals(afterTransitAmt, that.afterTransitAmt) &&
                Objects.equals(preFreezeAmt, that.preFreezeAmt) &&
                Objects.equals(afterFreezeAmt, that.afterFreezeAmt) &&
                Objects.equals(oprUserId, that.oprUserId) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(withdrawId, that.withdrawId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(lastUpdateTime, that.lastUpdateTime) &&
                Objects.equals(payChannel, that.payChannel) &&
                Objects.equals(rateType, that.rateType) &&
                Objects.equals(rateValue, that.rateValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, amt, dealType, dealDesp, status, woId, dealTime, preBalanceAmt, afterBalanceAmt, preTransitAmt, afterTransitAmt, preFreezeAmt, afterFreezeAmt, oprUserId, orderId, withdrawId, createTime, lastUpdateTime, payChannel, rateType, rateValue);
    }
}
