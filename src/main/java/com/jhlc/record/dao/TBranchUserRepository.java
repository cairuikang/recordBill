package com.jhlc.record.dao;

import com.jhlc.record.entity.TBranchUser;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@CacheConfig(cacheNames = "tBranchUserDao")
public interface TBranchUserRepository extends JpaRepository<TBranchUser, Long> {

    @Cacheable(keyGenerator = "myKeyGenerator", unless = "#result eq null")
    Optional<TBranchUser> findByUserId(Long userId);
}