package com.agree.contract.infrastructure.modulecontract.commercialTenantContract.converter;

import com.agree.contract.domain.modulecontract.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.infrastructure.modulecontract.commercialTenantContract.po.CommercialTenantContractPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author xulingfeng
 * @date 2023/3/20
 * @description
 */
@Mapper(componentModel = "spring")
public interface CommercialTenantContractConverter {

    @Mapping(source = "commercialTenantContract.commercialTenantInfo.legalPersonNumber", target = "legalPersonNumber")
    CommercialTenantContractPo toPo(CommercialTenantContract commercialTenantContract);


    CommercialTenantContract toEntity(CommercialTenantContractPo businessContract);
}
