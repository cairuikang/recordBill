package com.jhlc.record.dao;

import com.jhlc.record.entity.TPaychannel;
import com.jhlc.record.entity.TUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
@CacheConfig(cacheNames = "tPayChannelDao")
public interface TPayChannelRepository extends JpaRepository<TPaychannel, Long> {

    @Cacheable(keyGenerator = "myKeyGenerator", unless = "#result eq null")
    TPaychannel findByPayChannel(String payChannel);
}