package com.agree.contract.infrastructure.modulecontract.customerContractApplicationForm.converter;

import com.agree.contract.domain.modulecontract.customerContractApplicationForm.entity.CustomerContractApplicationForm;
import com.agree.contract.infrastructure.modulecontract.customerContractApplicationForm.po.CustomerContractApplicationFormPo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * 
 * @description
 */
@Mapper(componentModel = "spring")
public interface CustomerContractApplicationFormConverter {

    CustomerContractApplicationFormPo toPo(CustomerContractApplicationForm commercialTenantContract);


    CustomerContractApplicationForm toEntity(CustomerContractApplicationFormPo businessContract);
}
