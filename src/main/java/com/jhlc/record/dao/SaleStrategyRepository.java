package com.jhlc.record.dao;

import com.jhlc.record.entity.SaleStrategy;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@CacheConfig(cacheNames = "saleStrategyDao")
public interface SaleStrategyRepository extends JpaRepository<SaleStrategy, Long> {

    @Cacheable(keyGenerator = "myKeyGenerator", unless = "#result eq null")
    SaleStrategy findOne(Specification<SaleStrategy> specification);
}