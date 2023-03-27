package com.zantong.contract.infrastructure.commercialTenantContract.converter;

import com.zantong.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.zantong.contract.infrastructure.commercialTenantContract.po.CommercialTenantContractApplicationFormPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xulingfeng
 * @date 2023/3/20
 * @description
 */
@Mapper
public interface BusinessContractConverter {
    BusinessContractConverter INSTANCE = Mappers.getMapper(BusinessContractConverter.class);

    CommercialTenantContractApplicationFormPo toPo(CommercialTenantContract commercialTenantContract);


    CommercialTenantContract toEntity(CommercialTenantContractApplicationFormPo businessContract);
}
