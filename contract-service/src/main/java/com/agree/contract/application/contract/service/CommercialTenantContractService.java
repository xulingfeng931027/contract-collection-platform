package com.agree.contract.application.contract.service;

import com.agree.contract.application.contract.commercialtenantcontract.assembler.CommercialTenantContractAssembler;
import com.agree.contract.application.contract.commercialtenantcontract.dto.CommercialTenantContractResDto;
import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import com.agree.contract.domain.contract.commercialtenantcontract.repository.CommercialTenantContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @description 商户合约服务
 */
@Service
public class CommercialTenantContractService {

    @Autowired
    private CommercialTenantContractRepository contractRepository;

    @Autowired
    private CommercialTenantContractRepository commercialTenantContractRepository;
    @Autowired
    CommercialTenantContractAssembler commercialTenantContractAssembler;

    public CommercialTenantContractResDto queryCommercialTenantContract(String commercialTenantContractId) {
        // 1 重构(仓储查询并转换)
        CommercialTenantContract commercialTenantContract = commercialTenantContractRepository.getById(commercialTenantContractId);
        // 2 DO => Assembler => DTO
        CommercialTenantContractResDto commercialTenantContractResDto = commercialTenantContractAssembler.toDto(commercialTenantContract);
        return commercialTenantContractResDto;
    }
}
