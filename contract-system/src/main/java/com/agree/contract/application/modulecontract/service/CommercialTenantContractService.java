package com.agree.contract.application.modulecontract.service;

import com.agree.contract.domain.modulecontract.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.modulecontract.commercialTenantContract.repository.CommercialTenantContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xulingfeng
 * @description 签约服务
 * @date 2023/3/11
 * todo  加统一异常处理? 异常类型定义? 统一返回结构定义? 实体值对象异常基类的定义?
 */
@Service
public class CommercialTenantContractService {

    @Autowired
    private CommercialTenantContractRepository contractRepository;

    /**
     * 保存合约
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String saveContract(CommercialTenantContract commercialTenantContract) {
        return contractRepository.saveContract(commercialTenantContract);
    }
}
