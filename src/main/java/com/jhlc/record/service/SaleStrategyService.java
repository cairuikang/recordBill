package com.jhlc.record.service;

import com.jhlc.record.conmmon.constant.IdentityType;
import com.jhlc.record.dao.SaleCommonStrategyRepository;
import com.jhlc.record.dao.SaleStrategyRepository;
import com.jhlc.record.dao.TBranchRepository;
import com.jhlc.record.dao.TBranchUserRepository;
import com.jhlc.record.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SaleStrategyService {

    @Autowired
    SaleStrategyRepository saleStrategyRepository;

    @Autowired
    SaleCommonStrategyRepository saleCommonStrategyRepository;
    @Autowired
    BranchService branchService;

    @Autowired
    TBranchRepository tBranchRepository;
    @Autowired
    TBranchUserRepository tBranchUserRepository;

    /**
     * 获取各个级别的销售政策：用户-》组织-》上级组织-》。。。-》渠道
     */
    public List<SaleStrategy> getSaleStrategyParms(TUser tuser) {
        List<SaleStrategy> tSaleStrategys = new ArrayList<>();
        //添加用户
        SaleStrategy saleStrategyUser = new SaleStrategy();
        saleStrategyUser.setConfigType(IdentityType.IDENTITY_TYPE2.getConfigType());
        saleStrategyUser.setBucId(String.valueOf(tuser.getId()));
        tSaleStrategys.add(saleStrategyUser);
        //添加组织
        Optional<TBranchUser> tBranchUserOptional = tBranchUserRepository.findByUserId(tuser.getId());
        tBranchUserOptional.ifPresent(tBranchUser -> {
            //4.1查询当前用户（或推荐人）的组织及上级组织
            long branchId = tBranchUser.getBranchId();
            List<TBranch> branchList = branchService.getParentBranchsByBranchId(branchId);
            branchList.forEach(branch -> {
                SaleStrategy saleStrategyBranch = new SaleStrategy();
                saleStrategyBranch.setConfigType(IdentityType.IDENTITY_TYPE3.getConfigType());
                saleStrategyBranch.setBucId(String.valueOf(branch.getBranchId()));
                tSaleStrategys.add(saleStrategyBranch);
            });
        });
        //添加渠道
        SaleStrategy saleStrategyChannel = new SaleStrategy();
        saleStrategyChannel.setConfigType(IdentityType.IDENTITY_TYPE1.getConfigType());
        saleStrategyChannel.setBucId(tuser.getChannelId());
        tSaleStrategys.add(saleStrategyChannel);
        return tSaleStrategys;
    }


    /**
     * 获取用户，组织，渠道的销售政策
     * 规则：1.如果用户有销售政策,则直接取用户的销售政策
     * 2.如果用户没有销售政策，则取销售子表（sale_common_strategy）中的层级销售政策，
     * 2.如果销售子表中也不具备销售政策，则说明该业务员或者该组织不具备销售该产品的权限
     *
     * @param saleStrategyPram configType
     *                         buc_id
     *                         product_code
     *                         online_site
     */
    public SaleStrategy getSaleByProduct(SaleStrategy saleStrategyPram) {
        String configType = saleStrategyPram.getConfigType();
        //1.直接或销售政策
        Optional<SaleStrategy> saleStrategy = Optional.ofNullable(getSaleStrategySpecification(saleStrategyPram));
        //2.判断是否具有销售政策
        if (!saleStrategy.isPresent()) {
            //3.如果类型为用户类型，查询组织
            if (IdentityType.IDENTITY_TYPE2.getConfigType().equals(configType)) {
                //3.1获取组织等级
                Optional<TBranch> branch = tBranchRepository.findById(Long.parseLong(saleStrategyPram.getBucId()));
                if (branch.isPresent()) {
                    //3.2从主表中获取b-u
                    saleStrategyPram.setBucId(String.valueOf(branch.get().getBranchId()));
                    saleStrategyPram.setConfigType(IdentityType.IDENTITY_TYPE4.getConfigType());
                    saleStrategy = Optional.ofNullable(getSaleStrategySpecification(saleStrategyPram));
                    ;
                    if (!saleStrategy.isPresent()) {
                        //3.3从子表中获取（用户）的销售政策
                        saleStrategy = getSaleCommoneStrategyMap(saleStrategyPram, branch.get(), IdentityType.IDENTITY_TYPE2);
                    }
                }
                //4.如果类型为组织类型，则查询组织层级佣金
            } else if (IdentityType.IDENTITY_TYPE3.getConfigType().equals(configType)) {
                //4.1获取组织等级
                Optional<TBranch> branch = tBranchRepository.findById(Long.parseLong(saleStrategy.get().getBucId()));
                if (branch.isPresent()) {
                    //4.2从子表中获取（组织）的销售政策
                    saleStrategy = getSaleCommoneStrategyMap(saleStrategyPram, branch.get(), IdentityType.IDENTITY_TYPE3);
                }
            }
        }
        return saleStrategy.orElse(null);
    }

    /**
     * 获取有效状态切符合日期的策略
     *
     * @param saleStrategyPram
     * @return
     */
    public SaleStrategy getSaleStrategySpecification(SaleStrategy saleStrategyPram) {
        saleStrategyPram.setStatus("1");
        saleStrategyPram.setStartTime(Timestamp.valueOf(LocalDateTime.now()));
        saleStrategyPram.setEndTime(Timestamp.valueOf(LocalDateTime.now()));
        Specification<SaleStrategy> specification = (Root<SaleStrategy> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("bucId").as(String.class), saleStrategyPram.getBucId()));
            predicates.add(cb.equal(root.get("configType").as(String.class), saleStrategyPram.getConfigType()));
            predicates.add(cb.equal(root.get("productCode").as(String.class), saleStrategyPram.getProductCode()));
            predicates.add(cb.equal(root.get("siteId").as(String.class), saleStrategyPram.getSiteId()));
            predicates.add(cb.equal(root.get("status").as(String.class), saleStrategyPram.getStatus()));
            predicates.add(cb.greaterThan(root.get("endTime").as(Date.class), new Date()));
            predicates.add(cb.lessThanOrEqualTo(root.get("startTime").as(Date.class), new Date()));
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return saleStrategyRepository.findOne(specification);
    }

    public Optional<SaleStrategy> getSaleCommoneStrategyMap(SaleStrategy saleStrategy, TBranch branch, IdentityType identityType) {
        SaleCommonStrategy saleCommonStrategy = new SaleCommonStrategy();
        saleCommonStrategy.setGrade(branch.getGrade());
        saleCommonStrategy.setChannelid(branch.getChannelId());
        saleCommonStrategy.setProductCode(saleStrategy.getProductCode());
        saleCommonStrategy.setGradeType(identityType.getGradeType());
        saleCommonStrategy.setSiteId(saleStrategy.getSiteId());
        Optional<SaleCommonStrategy> optional = saleCommonStrategyRepository.findOne(Example.of(saleCommonStrategy));
        if (optional.isPresent()) {
            saleStrategy.setRateValue(Integer.parseInt(optional.get().getRateValue()));
            saleStrategy.setRateType(optional.get().getRateType());
        }
        return Optional.of(saleStrategy);
    }


}
