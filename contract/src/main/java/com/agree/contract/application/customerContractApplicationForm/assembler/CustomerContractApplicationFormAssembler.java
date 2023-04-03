package com.agree.contract.application.customerContractApplicationForm.assembler;

import com.agree.contract.application.customerContractApplicationForm.dto.CustomerContractApplicationFormDto;
import com.agree.contract.domain.customerContractApplicationForm.entity.CustomerContractApplicationForm;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 客户合约申请单转换器
 * @date 2023/2
 */
@Mapper(componentModel = "spring")
public interface CustomerContractApplicationFormAssembler {


    CustomerContractApplicationForm toEntity(CustomerContractApplicationFormDto dto);

}