package com.zantong.contract.infrastructure.commercialTenantContract.converter;

import com.zantong.contract.domain.customercontract.CustomerContract;
import com.zantong.contract.infrastructure.commercialTenantContract.po.CustomerContractPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author xulingfeng
 * @date 2023/3/20
 * @description
 */
@Mapper
public interface CustomerContractPoAssembler {
    CustomerContractPoAssembler INSTANCE = Mappers.getMapper(CustomerContractPoAssembler.class);

    @Mapping(target = "customerInfo", ignore = true)
    @Mapping(target = "customerAccountInfo", ignore = true)
    CustomerContractPo toPo(CustomerContract customerContract);


    @Mapping(target = "customerInfo", ignore = true)
    @Mapping(target = "customerAccountInfo", ignore = true)
    CustomerContract toEntity(CustomerContractPo customerContract);

}
