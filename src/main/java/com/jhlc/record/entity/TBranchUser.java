package com.jhlc.record.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_branch_user")
public class TBranchUser {
    private Integer id;
    private Integer branchId;
    private Long userId;
    private String relation;
    private String status;
    private Timestamp effectiveTime;
    private Timestamp expiryTime;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "branch_id")
    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
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
    @Column(name = "relation")
    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TBranchUser that = (TBranchUser) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(branchId, that.branchId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(relation, that.relation) &&
                Objects.equals(status, that.status) &&
                Objects.equals(effectiveTime, that.effectiveTime) &&
                Objects.equals(expiryTime, that.expiryTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branchId, userId, relation, status, effectiveTime, expiryTime);
    }
}
