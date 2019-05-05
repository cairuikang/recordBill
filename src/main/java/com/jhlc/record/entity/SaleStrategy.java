package com.jhlc.record.entity;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sale_strategy")
@ToString
public class SaleStrategy {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String siteId;
    private String productCode;
    private String status;
    private String configType;
    private String bucId;
    private String rateType;
    private Integer rateValue;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer seq;
    private Timestamp updateTime;
    private String createUser;
    private String updateUser;
    private String parentChannelId;
    private Integer seqNum;
    private Integer saleForm;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "site_id")
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @Basic
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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
    @Column(name = "config_type")
    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    @Basic
    @Column(name = "buc_id")
    public String getBucId() {
        return bucId;
    }

    public void setBucId(String bucId) {
        this.bucId = bucId;
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
    public Integer getRateValue() {
        return rateValue;
    }

    public void setRateValue(Integer rateValue) {
        this.rateValue = rateValue;
    }

    @Basic
    @Column(name = "startTime")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "seq")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "parent_channel_id")
    public String getParentChannelId() {
        return parentChannelId;
    }

    public void setParentChannelId(String parentChannelId) {
        this.parentChannelId = parentChannelId;
    }

    @Basic
    @Column(name = "seq_num")
    public Integer getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
    }

    @Basic
    @Column(name = "sale_form")
    public Integer getSaleForm() {
        return saleForm;
    }

    public void setSaleForm(Integer saleForm) {
        this.saleForm = saleForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleStrategy that = (SaleStrategy) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(siteId, that.siteId) &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(status, that.status) &&
                Objects.equals(configType, that.configType) &&
                Objects.equals(bucId, that.bucId) &&
                Objects.equals(rateType, that.rateType) &&
                Objects.equals(rateValue, that.rateValue) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(seq, that.seq) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateUser, that.updateUser) &&
                Objects.equals(parentChannelId, that.parentChannelId) &&
                Objects.equals(seqNum, that.seqNum) &&
                Objects.equals(saleForm, that.saleForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, siteId, productCode, status, configType, bucId, rateType, rateValue, startTime, endTime, seq, updateTime, createUser, updateUser, parentChannelId, seqNum, saleForm);
    }
}
