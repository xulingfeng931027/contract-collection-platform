package com.agree.contract.application.contract.commercialtenantcontract.assembler;

import com.agree.contract.application.contract.commercialtenantcontract.dto.CommercialTenantContractResDto;
import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 商户合约装配器
 * 
 */
@Mapper(componentModel = "spring")
public interface CommercialTenantContractAssembler {

    /**
     * 将实体转为响应dto
     */
    CommercialTenantContractResDto toDto(CommercialTenantContract commercialTenantContract);

}