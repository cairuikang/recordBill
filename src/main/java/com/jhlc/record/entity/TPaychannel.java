package com.jhlc.record.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_paychannel", schema = "jhlc_local", catalog = "")
public class TPaychannel {
    private Long id;
    private String payChannel;
    private String payChannelName;
    private String picUrl;
    private String paySource;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "payChannel")
    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    @Basic
    @Column(name = "payChannelName")
    public String getPayChannelName() {
        return payChannelName;
    }

    public void setPayChannelName(String payChannelName) {
        this.payChannelName = payChannelName;
    }

    @Basic
    @Column(name = "pic_url")
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Basic
    @Column(name = "pay_source")
    public String getPaySource() {
        return paySource;
    }

    public void setPaySource(String paySource) {
        this.paySource = paySource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TPaychannel that = (TPaychannel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(payChannel, that.payChannel) &&
                Objects.equals(payChannelName, that.payChannelName) &&
                Objects.equals(picUrl, that.picUrl) &&
                Objects.equals(paySource, that.paySource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payChannel, payChannelName, picUrl, paySource);
    }
}
