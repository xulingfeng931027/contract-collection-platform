package com.agree.contract.application.CommercialTenantContract.service;

import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.commercialTenantContract.repository.CommercialTenantContractRepository;
import com.agree.contract.domain.valueobject.ChargeTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xulingfeng
 * @description 签约服务
 * @date 2023/2
 * todo  加统一异常处理? 异常类型定义? 统一返回结构定义? 实体值对象异常基类的定义?
 */
@Service
public class CommercialTenantContractService {

    @Autowired
    private CommercialTenantContractRepository contractRepository;


    public CommercialTenantContract queryContract(String legalPersonNumber, ChargeTypeEnum chargeType) {
        return contractRepository.queryContract(legalPersonNumber, chargeType);
    }

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
