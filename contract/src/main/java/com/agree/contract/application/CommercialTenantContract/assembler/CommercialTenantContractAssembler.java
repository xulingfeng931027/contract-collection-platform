package com.agree.contract.application.CommercialTenantContract.assembler;

import com.agree.contract.application.CommercialTenantContract.dto.CommercialTenantContractResDto;
import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 合约转换器
 * @date 2023/2
 */
@Mapper(componentModel = "spring")
public interface CommercialTenantContractAssembler {

    CommercialTenantContractResDto toDto(CommercialTenantContract contractContractDto);

}