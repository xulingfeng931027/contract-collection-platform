package com.agree.contract.infrastructure.customerContractApplicationForm.converter;

import com.agree.contract.domain.customerContractApplicationForm.entity.CustomerContractApplicationForm;
import com.agree.contract.infrastructure.customerContractApplicationForm.po.CustomerContractApplicationFormPo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @date 2023/3/20
 * @description
 */
@Mapper(componentModel = "spring")
public interface CustomerContractApplicationFormConverter {

    CustomerContractApplicationFormPo toPo(CustomerContractApplicationForm commercialTenantContract);


    CustomerContractApplicationForm toEntity(CustomerContractApplicationFormPo businessContract);
}
