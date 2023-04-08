package com.agree.contract.application.modulecontract.customerContractApplicationForm.assembler;

import com.agree.contract.application.modulecontract.customerContractApplicationForm.dto.CustomerContractApplicationFormReqDto;
import com.agree.contract.domain.modulecontract.customerContractApplicationForm.entity.CustomerContractApplicationForm;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 客户合约申请单转换器
 * @date 2023/3/11
 */
@Mapper(componentModel = "spring")
public interface CustomerContractApplicationFormAssembler {


    CustomerContractApplicationForm toEntity(CustomerContractApplicationFormReqDto dto);

}