package com.jhlc.record.entity;

import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_order")
@ToString
public class TOrder {
    private Long id;
    private String orderNo;
    private String productCode;
    private String productName;
    private String packageCodes;
    private String holderAttr;
    private Long holderId;
    private Timestamp insuredBgnTime;
    private Timestamp insuredEndTime;
    private Integer insuredNum;
    private Integer eachInsuredQuantity;
    private Integer unitRealPremiumAmt;
    private Integer realPremiumAmt;
    private String discount;
    private Timestamp insuredTime;
    private String orderStatus;
    private String payType;
    private String payStatus;
    private Timestamp payTime;
    private Timestamp confirmTime;
    private String channelParam;
    private String channelId;
    private Long userId;
    private String userType;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String orderForm;
    private String payMethod;
    private Long recommenderId;
    private Integer orderAmount;
    private String isReturn;
    private Timestamp returnTime;
    private String insurancePeriod;
    private String invoiceHeader;
    private String remark;
    private String selfCardId;
    private String orderGroup;
    private String isInvoice;
    private String operator;
    private String productPriceId;
    private String onlineSite;
    private String rateType;
    private String rateValue;
    private String payCallbackUrl;
    private String payYears;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_no")
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "package_codes")
    public String getPackageCodes() {
        return packageCodes;
    }

    public void setPackageCodes(String packageCodes) {
        this.packageCodes = packageCodes;
    }

    @Basic
    @Column(name = "holder_attr")
    public String getHolderAttr() {
        return holderAttr;
    }

    public void setHolderAttr(String holderAttr) {
        this.holderAttr = holderAttr;
    }

    @Basic
    @Column(name = "holder_id")
    public Long getHolderId() {
        return holderId;
    }

    public void setHolderId(Long holderId) {
        this.holderId = holderId;
    }

    @Basic
    @Column(name = "insured_bgn_time")
    public Timestamp getInsuredBgnTime() {
        return insuredBgnTime;
    }

    public void setInsuredBgnTime(Timestamp insuredBgnTime) {
        this.insuredBgnTime = insuredBgnTime;
    }

    @Basic
    @Column(name = "insured_end_time")
    public Timestamp getInsuredEndTime() {
        return insuredEndTime;
    }

    public void setInsuredEndTime(Timestamp insuredEndTime) {
        this.insuredEndTime = insuredEndTime;
    }

    @Basic
    @Column(name = "insured_num")
    public Integer getInsuredNum() {
        return insuredNum;
    }

    public void setInsuredNum(Integer insuredNum) {
        this.insuredNum = insuredNum;
    }

    @Basic
    @Column(name = "each_insured_quantity")
    public Integer getEachInsuredQuantity() {
        return eachInsuredQuantity;
    }

    public void setEachInsuredQuantity(Integer eachInsuredQuantity) {
        this.eachInsuredQuantity = eachInsuredQuantity;
    }

    @Basic
    @Column(name = "unit_real_premium_amt")
    public Integer getUnitRealPremiumAmt() {
        return unitRealPremiumAmt;
    }

    public void setUnitRealPremiumAmt(Integer unitRealPremiumAmt) {
        this.unitRealPremiumAmt = unitRealPremiumAmt;
    }

    @Basic
    @Column(name = "real_premium_amt")
    public Integer getRealPremiumAmt() {
        return realPremiumAmt;
    }

    public void setRealPremiumAmt(Integer realPremiumAmt) {
        this.realPremiumAmt = realPremiumAmt;
    }

    @Basic
    @Column(name = "discount")
    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "insured_time")
    public Timestamp getInsuredTime() {
        return insuredTime;
    }

    public void setInsuredTime(Timestamp insuredTime) {
        this.insuredTime = insuredTime;
    }

    @Basic
    @Column(name = "order_status")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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
    @Column(name = "pay_status")
    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    @Basic
    @Column(name = "pay_time")
    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "confirm_time")
    public Timestamp getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Timestamp confirmTime) {
        this.confirmTime = confirmTime;
    }

    @Basic
    @Column(name = "channel_param")
    public String getChannelParam() {
        return channelParam;
    }

    public void setChannelParam(String channelParam) {
        this.channelParam = channelParam;
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
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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
    @Column(name = "order_form")
    public String getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(String orderForm) {
        this.orderForm = orderForm;
    }

    @Basic
    @Column(name = "pay_method")
    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Basic
    @Column(name = "recommenderId")
    public Long getRecommenderId() {
        return recommenderId;
    }

    public void setRecommenderId(Long recommenderId) {
        this.recommenderId = recommenderId;
    }

    @Basic
    @Column(name = "order_amount")
    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Basic
    @Column(name = "is_return")
    public String getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(String isReturn) {
        this.isReturn = isReturn;
    }

    @Basic
    @Column(name = "returnTime")
    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    @Basic
    @Column(name = "insurance_period")
    public String getInsurancePeriod() {
        return insurancePeriod;
    }

    public void setInsurancePeriod(String insurancePeriod) {
        this.insurancePeriod = insurancePeriod;
    }

    @Basic
    @Column(name = "invoice_header")
    public String getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(String invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "selfCardId")
    public String getSelfCardId() {
        return selfCardId;
    }

    public void setSelfCardId(String selfCardId) {
        this.selfCardId = selfCardId;
    }

    @Basic
    @Column(name = "order_group")
    public String getOrderGroup() {
        return orderGroup;
    }

    public void setOrderGroup(String orderGroup) {
        this.orderGroup = orderGroup;
    }

    @Basic
    @Column(name = "is_invoice")
    public String getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(String isInvoice) {
        this.isInvoice = isInvoice;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "product_price_id")
    public String getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(String productPriceId) {
        this.productPriceId = productPriceId;
    }

    @Basic
    @Column(name = "online_site")
    public String getOnlineSite() {
        return onlineSite;
    }

    public void setOnlineSite(String onlineSite) {
        this.onlineSite = onlineSite;
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
    @Column(name = "payCallbackUrl")
    public String getPayCallbackUrl() {
        return payCallbackUrl;
    }

    public void setPayCallbackUrl(String payCallbackUrl) {
        this.payCallbackUrl = payCallbackUrl;
    }

    @Basic
    @Column(name = "pay_years")
    public String getPayYears() {
        return payYears;
    }

    public void setPayYears(String payYears) {
        this.payYears = payYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TOrder tOrder = (TOrder) o;
        return Objects.equals(id, tOrder.id) &&
                Objects.equals(orderNo, tOrder.orderNo) &&
                Objects.equals(productCode, tOrder.productCode) &&
                Objects.equals(productName, tOrder.productName) &&
                Objects.equals(packageCodes, tOrder.packageCodes) &&
                Objects.equals(holderAttr, tOrder.holderAttr) &&
                Objects.equals(holderId, tOrder.holderId) &&
                Objects.equals(insuredBgnTime, tOrder.insuredBgnTime) &&
                Objects.equals(insuredEndTime, tOrder.insuredEndTime) &&
                Objects.equals(insuredNum, tOrder.insuredNum) &&
                Objects.equals(eachInsuredQuantity, tOrder.eachInsuredQuantity) &&
                Objects.equals(unitRealPremiumAmt, tOrder.unitRealPremiumAmt) &&
                Objects.equals(realPremiumAmt, tOrder.realPremiumAmt) &&
                Objects.equals(discount, tOrder.discount) &&
                Objects.equals(insuredTime, tOrder.insuredTime) &&
                Objects.equals(orderStatus, tOrder.orderStatus) &&
                Objects.equals(payType, tOrder.payType) &&
                Objects.equals(payStatus, tOrder.payStatus) &&
                Objects.equals(payTime, tOrder.payTime) &&
                Objects.equals(confirmTime, tOrder.confirmTime) &&
                Objects.equals(channelParam, tOrder.channelParam) &&
                Objects.equals(channelId, tOrder.channelId) &&
                Objects.equals(userId, tOrder.userId) &&
                Objects.equals(userType, tOrder.userType) &&
                Objects.equals(createTime, tOrder.createTime) &&
                Objects.equals(lastUpdateTime, tOrder.lastUpdateTime) &&
                Objects.equals(orderForm, tOrder.orderForm) &&
                Objects.equals(payMethod, tOrder.payMethod) &&
                Objects.equals(recommenderId, tOrder.recommenderId) &&
                Objects.equals(orderAmount, tOrder.orderAmount) &&
                Objects.equals(isReturn, tOrder.isReturn) &&
                Objects.equals(returnTime, tOrder.returnTime) &&
                Objects.equals(insurancePeriod, tOrder.insurancePeriod) &&
                Objects.equals(invoiceHeader, tOrder.invoiceHeader) &&
                Objects.equals(remark, tOrder.remark) &&
                Objects.equals(selfCardId, tOrder.selfCardId) &&
                Objects.equals(orderGroup, tOrder.orderGroup) &&
                Objects.equals(isInvoice, tOrder.isInvoice) &&
                Objects.equals(operator, tOrder.operator) &&
                Objects.equals(productPriceId, tOrder.productPriceId) &&
                Objects.equals(onlineSite, tOrder.onlineSite) &&
                Objects.equals(rateType, tOrder.rateType) &&
                Objects.equals(rateValue, tOrder.rateValue) &&
                Objects.equals(payCallbackUrl, tOrder.payCallbackUrl) &&
                Objects.equals(payYears, tOrder.payYears);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNo, productCode, productName, packageCodes, holderAttr, holderId, insuredBgnTime, insuredEndTime, insuredNum, eachInsuredQuantity, unitRealPremiumAmt, realPremiumAmt, discount, insuredTime, orderStatus, payType, payStatus, payTime, confirmTime, channelParam, channelId, userId, userType, createTime, lastUpdateTime, orderForm, payMethod, recommenderId, orderAmount, isReturn, returnTime, insurancePeriod, invoiceHeader, remark, selfCardId, orderGroup, isInvoice, operator, productPriceId, onlineSite, rateType, rateValue, payCallbackUrl, payYears);
    }
}
