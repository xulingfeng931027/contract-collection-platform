package com.zantong.contract.infrastructure.commercialTenantContractApplicationForm.converter;

import com.zantong.contract.domain.commercialTenantContractApplicationForm.entity.CommercialTenantContractApplicationForm;
import com.zantong.contract.infrastructure.commercialTenantContractApplicationForm.po.CommercialTenantContractApplicationFormPo;
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
