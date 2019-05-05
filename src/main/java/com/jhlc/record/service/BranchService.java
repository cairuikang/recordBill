package com.jhlc.record.service;

import com.jhlc.record.dao.TBranchRepository;
import com.jhlc.record.dao.TBranchUserRepository;
import com.jhlc.record.entity.TBranch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 10096
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "branchService")
public class BranchService {

    @Autowired
    TBranchRepository tBranchRepository;

    @Autowired
    TBranchUserRepository tBranchUserRepository;

    @Cacheable(keyGenerator = "myKeyGenerator")
    public List<TBranch> getParentBranchsByBranchId(Long branchId){
        List<TBranch> list = new ArrayList();
        Optional<TBranch> tBranchOptional = tBranchRepository.findById(branchId);
        if(tBranchOptional.isPresent()){
            list.add(tBranchOptional.get());
            list.addAll(getParentBranchsByBranchId(tBranchOptional.get().getParentId()));
        }
        return list;
    }
}
