package com.agree.contract.application.modulecontract.CommercialTenantContractApplicationForm.assembler;

import com.agree.contract.application.modulecontract.CommercialTenantContractApplicationForm.dto.CommercialTenantContractApplicationFormReqDto;
import com.agree.contract.domain.modulecontract.commercialTenantContractApplicationForm.entity.CommercialTenantContractApplicationForm;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 合约转换器
 * @date 2023/3/11
 * //todo
 * 1.装配器负责dto到领域对象之间的相互转化
 * 2.不包含业务逻辑
 * 3.包含业务逻辑相关的实体值对象的构建应该由领域层的factory来完成
 */
@Mapper(componentModel = "spring")//todo 此处使用spring模式 后续使用可以直接注入
public interface CommercialTenantContractApplicationFormAssembler {

    CommercialTenantContractApplicationForm toEntity(CommercialTenantContractApplicationFormReqDto contractContractDto);

    CommercialTenantContractApplicationFormReqDto toDto(CommercialTenantContractApplicationForm contractDto);

}