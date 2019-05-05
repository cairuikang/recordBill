package com.jhlc.record.dao;

import com.jhlc.record.entity.TOrder;
import com.jhlc.record.entity.TUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@CacheConfig(cacheNames = "tOrderDao")
public interface TOrderRepository extends JpaRepository<TOrder, Long> {

    @Override
    @Cacheable(keyGenerator = "myKeyGenerator", unless = "#result eq null")
    Optional<TOrder> findById(Long userId);
}