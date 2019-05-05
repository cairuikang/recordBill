package com.jhlc.record.dao;

import com.jhlc.record.entity.TBranch;
import com.jhlc.record.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TBranchRepository extends JpaRepository<TBranch, Long> {

}