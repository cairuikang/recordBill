package com.jhlc.record.entity;

import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_user")
@ToString
public class TUser implements Serializable {
    private Long id;
    private String userType;
    private String userMobile;
    private String userPwd;
    private String userName;
    private String onlineSite;
    private String status;
    private String channelId;
    private String mobileCheck;
    private String origin;
    private Long recommenderId;
    private String basicId;
    private String wxOpenid;
    private String email;
    private Integer loginTimes;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String isDefaultUser;
    private String outUserId;
    private String staffBankName;
    private String staffBankCard;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "user_mobile")
    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    @Basic
    @Column(name = "user_pwd")
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "mobile_check")
    public String getMobileCheck() {
        return mobileCheck;
    }

    public void setMobileCheck(String mobileCheck) {
        this.mobileCheck = mobileCheck;
    }

    @Basic
    @Column(name = "origin")
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
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
    @Column(name = "basic_id")
    public String getBasicId() {
        return basicId;
    }

    public void setBasicId(String basicId) {
        this.basicId = basicId;
    }

    @Basic
    @Column(name = "wx_openid")
    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "login_times")
    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
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
    @Column(name = "is_default_user")
    public String getIsDefaultUser() {
        return isDefaultUser;
    }

    public void setIsDefaultUser(String isDefaultUser) {
        this.isDefaultUser = isDefaultUser;
    }

    @Basic
    @Column(name = "out_user_id")
    public String getOutUserId() {
        return outUserId;
    }

    public void setOutUserId(String outUserId) {
        this.outUserId = outUserId;
    }

    @Basic
    @Column(name = "staffBankName")
    public String getStaffBankName() {
        return staffBankName;
    }

    public void setStaffBankName(String staffBankName) {
        this.staffBankName = staffBankName;
    }

    @Basic
    @Column(name = "staffBankCard")
    public String getStaffBankCard() {
        return staffBankCard;
    }

    public void setStaffBankCard(String staffBankCard) {
        this.staffBankCard = staffBankCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TUser tUser = (TUser) o;
        return Objects.equals(id, tUser.id) &&
                Objects.equals(userType, tUser.userType) &&
                Objects.equals(userMobile, tUser.userMobile) &&
                Objects.equals(userPwd, tUser.userPwd) &&
                Objects.equals(userName, tUser.userName) &&
                Objects.equals(onlineSite, tUser.onlineSite) &&
                Objects.equals(status, tUser.status) &&
                Objects.equals(channelId, tUser.channelId) &&
                Objects.equals(mobileCheck, tUser.mobileCheck) &&
                Objects.equals(origin, tUser.origin) &&
                Objects.equals(recommenderId, tUser.recommenderId) &&
                Objects.equals(basicId, tUser.basicId) &&
                Objects.equals(wxOpenid, tUser.wxOpenid) &&
                Objects.equals(email, tUser.email) &&
                Objects.equals(loginTimes, tUser.loginTimes) &&
                Objects.equals(createTime, tUser.createTime) &&
                Objects.equals(lastUpdateTime, tUser.lastUpdateTime) &&
                Objects.equals(isDefaultUser, tUser.isDefaultUser) &&
                Objects.equals(outUserId, tUser.outUserId) &&
                Objects.equals(staffBankName, tUser.staffBankName) &&
                Objects.equals(staffBankCard, tUser.staffBankCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userType, userMobile, userPwd, userName, onlineSite, status, channelId, mobileCheck, origin, recommenderId, basicId, wxOpenid, email, loginTimes, createTime, lastUpdateTime, isDefaultUser, outUserId, staffBankName, staffBankCard);
    }
}
