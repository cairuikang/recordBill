package com.jhlc.record.dao;

import com.jhlc.record.entity.TUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@CacheConfig(cacheNames = "tUserDao")
public interface TUserRepository extends JpaRepository<TUser, Long> {
    @Override
    @Cacheable(keyGenerator = "myKeyGenerator", unless = "#result eq null")
    Optional<TUser> findById(Long userId);
}