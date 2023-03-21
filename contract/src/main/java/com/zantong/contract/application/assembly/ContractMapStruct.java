package com.zantong.contract.application.assembly;

import com.zantong.contract.application.dto.BusinessContractDto;
import com.zantong.contract.application.dto.CustomerContractDto;
import com.zantong.contract.domain.entity.BusinessContract;
import com.zantong.contract.domain.entity.CustomerContract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * @date 2023/2
 */
@Mapper
public interface ContractMapStruct {

    ContractMapStruct INSTANCE = Mappers.getMapper(ContractMapStruct.class);

    BusinessContract toEntity(BusinessContractDto contractContractDto);
    CustomerContract toEntity(CustomerContractDto contractContractDto);
//    BusinessContractAggregation toAggregation(BusinessContractDto contractContractDto);


//    CustomerContractAggregation toAggregation(CustomerContractDto contractContractDto);

    CustomerContractDto toDto(CustomerContract contractDto);

}