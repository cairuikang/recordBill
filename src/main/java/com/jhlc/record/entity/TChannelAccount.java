package com.jhlc.record.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_channel_account")
public class TChannelAccount {
    private Long accountId;
    private String channelId;
    private String accountType;
    private Integer balanceAmt;
    private Integer transitAmt;
    private Integer freezeAmt;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String accountRemark;

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "channel_id")
    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Basic
    @Column(name = "account_type")
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "balance_amt")
    public Integer getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(Integer balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    @Basic
    @Column(name = "transit_amt")
    public Integer getTransitAmt() {
        return transitAmt;
    }

    public void setTransitAmt(Integer transitAmt) {
        this.transitAmt = transitAmt;
    }

    @Basic
    @Column(name = "freeze_amt")
    public Integer getFreezeAmt() {
        return freezeAmt;
    }

    public void setFreezeAmt(Integer freezeAmt) {
        this.freezeAmt = freezeAmt;
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
    @Column(name = "account_remark")
    public String getAccountRemark() {
        return accountRemark;
    }

    public void setAccountRemark(String accountRemark) {
        this.accountRemark = accountRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TChannelAccount that = (TChannelAccount) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(channelId, that.channelId) &&
                Objects.equals(accountType, that.accountType) &&
                Objects.equals(balanceAmt, that.balanceAmt) &&
                Objects.equals(transitAmt, that.transitAmt) &&
                Objects.equals(freezeAmt, that.freezeAmt) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(lastUpdateTime, that.lastUpdateTime) &&
                Objects.equals(accountRemark, that.accountRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, channelId, accountType, balanceAmt, transitAmt, freezeAmt, createTime, lastUpdateTime, accountRemark);
    }
}
