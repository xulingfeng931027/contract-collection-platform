package com.agree.contract.infrastructure.contract.customerContractApplicationForm.converter;

import com.agree.contract.domain.contract.customercontractapplicationform.entity.CustomerContractApplicationForm;
import com.agree.contract.infrastructure.contract.customerContractApplicationForm.po.CustomerContractApplicationFormPo;
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
