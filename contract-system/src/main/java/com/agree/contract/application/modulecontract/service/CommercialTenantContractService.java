package com.agree.contract.application.modulecontract.service;

import com.agree.contract.domain.modulecontract.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.modulecontract.commercialTenantContract.repository.CommercialTenantContractRepository;
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
