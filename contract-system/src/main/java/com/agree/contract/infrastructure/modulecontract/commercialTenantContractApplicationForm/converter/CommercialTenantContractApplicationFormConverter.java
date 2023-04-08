package com.agree.contract.infrastructure.modulecontract.commercialTenantContractApplicationForm.converter;

import com.agree.contract.domain.modulecontract.commercialTenantContractApplicationForm.entity.CommercialTenantContractApplicationForm;
import com.agree.contract.infrastructure.modulecontract.commercialTenantContractApplicationForm.po.CommercialTenantContractApplicationFormPo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @date 2023/3/20
 * @description
 */
@Mapper(componentModel = "spring")
public interface CommercialTenantContractApplicationFormConverter {

    CommercialTenantContractApplicationFormPo toPo(CommercialTenantContractApplicationForm commercialTenantContract);


    CommercialTenantContractApplicationForm toEntity(CommercialTenantContractApplicationFormPo businessContract);
}
