package com.jhlc.record.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sale_common_strategy")
public class SaleCommonStrategy {
    private Integer id;
    private String productCode;
    private String gradeType;
    private String grade;
    private String rateType;
    private String rateValue;
    private String status;
    private Timestamp effectiveTime;
    private Timestamp expiryTime;
    private String channelid;
    private String siteId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "gradeType")
    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }

    @Basic
    @Column(name = "grade")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "effectiveTime")
    public Timestamp getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Timestamp effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    @Basic
    @Column(name = "expiryTime")
    public Timestamp getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Timestamp expiryTime) {
        this.expiryTime = expiryTime;
    }

    @Basic
    @Column(name = "channelid")
    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    @Basic
    @Column(name = "site_id")
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleCommonStrategy that = (SaleCommonStrategy) o;
        return  Objects.equals(id, that.id) &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(gradeType, that.gradeType) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(rateType, that.rateType) &&
                Objects.equals(rateValue, that.rateValue) &&
                Objects.equals(status, that.status) &&
                Objects.equals(effectiveTime, that.effectiveTime) &&
                Objects.equals(expiryTime, that.expiryTime) &&
                Objects.equals(channelid, that.channelid) &&
                Objects.equals(siteId, that.siteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productCode, gradeType, grade, rateType, rateValue, status, effectiveTime, expiryTime, channelid, siteId);
    }
}
