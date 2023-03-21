package com.zantong.contract.infrastructure.assembly;

import com.zantong.contract.domain.entity.BusinessContract;
import com.zantong.contract.infrastructure.po.BusinessContractPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xulingfeng
 * @date 2023/3/20
 * @description
 */
@Mapper
public interface BusinessContractPoAssembler {
    BusinessContractPoAssembler INSTANCE = Mappers.getMapper(BusinessContractPoAssembler.class);

//    @Mapping(target = "accountInfo", ignore = true)
//    @Mapping(target = "tempAccountInfo", ignore = true)
//    @Mapping(target = "businessInfo", ignore = true)
    BusinessContractPo toPo(BusinessContract businessContract);


//    @Mapping(target = "accountInfo", ignore = true)
//    @Mapping(target = "tempAccountInfo", ignore = true)
//    @Mapping(target = "businessInfo", ignore = true)
    BusinessContract toEntity(BusinessContractPo businessContract);
}
