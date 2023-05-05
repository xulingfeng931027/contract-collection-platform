package com.agree.contract.application.contract.commercialtenantcontractapplicationform.assembler;

import com.agree.contract.application.contract.commercialtenantcontractapplicationform.dto.CommercialTenantContractApplicationFormReqDto;
import com.agree.contract.application.contract.commercialtenantcontractapplicationform.dto.CommercialTenantContractApplicationFormResDto;
import com.agree.contract.domain.contract.commercialtenantcontractapplicationform.entity.CommercialTenantContractApplicationForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author xulingfeng
 * @description 商户合约申请单装配器
 * 
 */
@Mapper(componentModel = "spring")
public interface CommercialTenantContractApplicationFormAssembler {
    /**
     * 将请求dto转为实体
     */
    @Mapping(source = "legalPersonNumber",target ="commercialTenantInfo.legalPersonNumber" )
    CommercialTenantContractApplicationForm toEntity(CommercialTenantContractApplicationFormReqDto contractContractDto);
    /**
     * 将实体转为响应dto
     */
    CommercialTenantContractApplicationFormResDto toDto(CommercialTenantContractApplicationForm applicationForm);

}