package com.agree.contract.application.contract.service;

import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import com.agree.contract.domain.contract.commercialtenantcontract.repository.CommercialTenantContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xulingfeng
 * @description 签约服务
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
