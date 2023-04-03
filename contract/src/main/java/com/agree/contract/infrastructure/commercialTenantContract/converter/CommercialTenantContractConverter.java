package com.agree.contract.infrastructure.commercialTenantContract.converter;

import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.infrastructure.commercialTenantContract.po.CommercialTenantContractPo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @date 2023/3/20
 * @description
 */
@Mapper(componentModel = "spring")
public interface CommercialTenantContractConverter {

    CommercialTenantContractPo toPo(CommercialTenantContract commercialTenantContract);


    CommercialTenantContract toEntity(CommercialTenantContractPo businessContract);
}
