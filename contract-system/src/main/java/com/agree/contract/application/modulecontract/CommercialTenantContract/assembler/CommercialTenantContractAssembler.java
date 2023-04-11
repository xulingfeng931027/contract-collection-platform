package com.agree.contract.application.modulecontract.CommercialTenantContract.assembler;

import com.agree.contract.application.modulecontract.CommercialTenantContract.dto.CommercialTenantContractResDto;
import com.agree.contract.domain.modulecontract.commercialTenantContract.entity.CommercialTenantContract;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 合约转换器
 * 
 */
@Mapper(componentModel = "spring")
public interface CommercialTenantContractAssembler {

    CommercialTenantContractResDto toDto(CommercialTenantContract contractContractDto);

}