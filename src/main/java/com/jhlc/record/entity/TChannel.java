package com.jhlc.record.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_channel")
public class TChannel {
    private String channelId;
    private String channelCode;
    private String channelPwd;
    private String channelName;
    private String channelPerson;
    private String channelMobile;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String notifyUrl;
    private String payType;
    private String type;
    private String istask;
    private String defaultChannelPerson;
    private String defaultChannelMobile;
    private String isAsync;

    @Id
    @Column(name = "channel_id")
    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Basic
    @Column(name = "channel_code")
    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    @Basic
    @Column(name = "channel_pwd")
    public String getChannelPwd() {
        return channelPwd;
    }

    public void setChannelPwd(String channelPwd) {
        this.channelPwd = channelPwd;
    }

    @Basic
    @Column(name = "channel_name")
    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @Basic
    @Column(name = "channel_person")
    public String getChannelPerson() {
        return channelPerson;
    }

    public void setChannelPerson(String channelPerson) {
        this.channelPerson = channelPerson;
    }

    @Basic
    @Column(name = "channel_mobile")
    public String getChannelMobile() {
        return channelMobile;
    }

    public void setChannelMobile(String channelMobile) {
        this.channelMobile = channelMobile;
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
    @Column(name = "notify_url")
    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Basic
    @Column(name = "pay_type")
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "istask")
    public String getIstask() {
        return istask;
    }

    public void setIstask(String istask) {
        this.istask = istask;
    }

    @Basic
    @Column(name = "default_channel_person")
    public String getDefaultChannelPerson() {
        return defaultChannelPerson;
    }

    public void setDefaultChannelPerson(String defaultChannelPerson) {
        this.defaultChannelPerson = defaultChannelPerson;
    }

    @Basic
    @Column(name = "default_channel_mobile")
    public String getDefaultChannelMobile() {
        return defaultChannelMobile;
    }

    public void setDefaultChannelMobile(String defaultChannelMobile) {
        this.defaultChannelMobile = defaultChannelMobile;
    }

    @Basic
    @Column(name = "is_async")
    public String getIsAsync() {
        return isAsync;
    }

    public void setIsAsync(String isAsync) {
        this.isAsync = isAsync;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TChannel tChannel = (TChannel) o;
        return Objects.equals(channelId, tChannel.channelId) &&
                Objects.equals(channelCode, tChannel.channelCode) &&
                Objects.equals(channelPwd, tChannel.channelPwd) &&
                Objects.equals(channelName, tChannel.channelName) &&
                Objects.equals(channelPerson, tChannel.channelPerson) &&
                Objects.equals(channelMobile, tChannel.channelMobile) &&
                Objects.equals(createTime, tChannel.createTime) &&
                Objects.equals(lastUpdateTime, tChannel.lastUpdateTime) &&
                Objects.equals(notifyUrl, tChannel.notifyUrl) &&
                Objects.equals(payType, tChannel.payType) &&
                Objects.equals(type, tChannel.type) &&
                Objects.equals(istask, tChannel.istask) &&
                Objects.equals(defaultChannelPerson, tChannel.defaultChannelPerson) &&
                Objects.equals(defaultChannelMobile, tChannel.defaultChannelMobile) &&
                Objects.equals(isAsync, tChannel.isAsync);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelId, channelCode, channelPwd, channelName, channelPerson, channelMobile, createTime, lastUpdateTime, notifyUrl, payType, type, istask, defaultChannelPerson, defaultChannelMobile, isAsync);
    }
}
