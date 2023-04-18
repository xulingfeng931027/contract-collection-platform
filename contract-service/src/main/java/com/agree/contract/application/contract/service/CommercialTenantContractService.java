package com.agree.contract.application.contract.service;

import com.agree.contract.application.contract.commercialtenantcontract.assembler.CommercialTenantContractAssembler;
import com.agree.contract.application.contract.commercialtenantcontract.dto.CommercialTenantContractResDto;
import com.agree.contract.application.contract.customercontract.dto.CustomerContractResDto;
import com.agree.contract.application.contract.support.AccountInfoSupport;
import com.agree.contract.application.contract.support.CommercialTenantInfoSupport;
import com.agree.contract.application.contract.support.CustomerInfoSupport;
import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import com.agree.contract.domain.contract.commercialtenantcontract.repository.CommercialTenantContractRepository;
import com.agree.contract.domain.contract.customercontract.entity.CustomerContract;
import com.agree.contract.domain.contract.exception.ContractException;
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

    @Autowired
    private CommercialTenantContractRepository commercialTenantContractRepository;
    @Autowired
    CommercialTenantContractAssembler commercialTenantContractAssembler;

    public CommercialTenantContractResDto queryCustomerContract(String commercialTenantContractId) {
        // 1 重构(仓储查询并转换)
        CommercialTenantContract commercialTenantContract = commercialTenantContractRepository.getById(commercialTenantContractId);
        // 2 DO => Assembler => DTO
        CommercialTenantContractResDto commercialTenantContractResDto = commercialTenantContractAssembler.toDto(commercialTenantContract);
        return commercialTenantContractResDto;
    }
}
