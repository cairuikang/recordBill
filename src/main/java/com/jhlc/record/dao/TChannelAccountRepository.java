package com.jhlc.record.dao;

import com.jhlc.record.entity.TChannelAccount;
import com.jhlc.record.entity.TChannelAccountDetail;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

public interface TChannelAccountRepository extends JpaRepository<TChannelAccount, Long> {

    @Modifying
    @Query(value = "update TChannelAccount set transitAmt = transitAmt + ?1 where accountId = ?2 and transitAmt + ?1 >=0")
    int updateTransitAmt(Integer amt,Long accountId);


    @Modifying
    @Query(value = "update TChannelAccount set balanceAmt = balanceAmt + ?1 where accountId = ?2 and balanceAmt + ?1 >=0")
    int updatebalanceAmt(Integer amt,Long accountId);

    @Modifying
    @Query(value = "update TChannelAccount set freezeAmt = freezeAmt + ?1 where accountId = ?2 and freezeAmt + ?1 >=0")
    int updateFreezeAmt(Integer amt,Long accountId);




}