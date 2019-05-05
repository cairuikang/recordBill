package com.jhlc.record.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_branch")
public class TBranch {
    private Long branchId;
    private String branchName;
    private Long parentId;
    private String grade;
    private String channelId;
    private String banchType;
    private Long createPersonId;
    private Timestamp createTime;
    private Long updatePersonId;
    private Timestamp updateTime;
    private String uniqueIdentifier;

    @Id
    @Column(name = "branch_id")
    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    @Basic
    @Column(name = "branchName")
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Basic
    @Column(name = "parentId")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
    @Column(name = "channel_id")
    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Basic
    @Column(name = "banchType")
    public String getBanchType() {
        return banchType;
    }

    public void setBanchType(String banchType) {
        this.banchType = banchType;
    }

    @Basic
    @Column(name = "createPersonId")
    public Long getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Long createPersonId) {
        this.createPersonId = createPersonId;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updatePersonId")
    public Long getUpdatePersonId() {
        return updatePersonId;
    }

    public void setUpdatePersonId(Long updatePersonId) {
        this.updatePersonId = updatePersonId;
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
    @Column(name = "unique_identifier")
    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TBranch tBranch = (TBranch) o;
        return Objects.equals(branchId, tBranch.branchId) &&
                Objects.equals(branchName, tBranch.branchName) &&
                Objects.equals(parentId, tBranch.parentId) &&
                Objects.equals(grade, tBranch.grade) &&
                Objects.equals(channelId, tBranch.channelId) &&
                Objects.equals(banchType, tBranch.banchType) &&
                Objects.equals(createPersonId, tBranch.createPersonId) &&
                Objects.equals(createTime, tBranch.createTime) &&
                Objects.equals(updatePersonId, tBranch.updatePersonId) &&
                Objects.equals(updateTime, tBranch.updateTime) &&
                Objects.equals(uniqueIdentifier, tBranch.uniqueIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, branchName, parentId, grade, channelId, banchType, createPersonId, createTime, updatePersonId, updateTime, uniqueIdentifier);
    }
}
