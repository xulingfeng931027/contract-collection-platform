package com.agree.contract.application.contract.commercialtenantcontract.assembler;

import com.agree.contract.application.contract.commercialtenantcontract.dto.CommercialTenantContractResDto;
import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
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