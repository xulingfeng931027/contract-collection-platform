package com.agree.contract.application.contract.customercontractapplicationform.assembler;

import com.agree.contract.application.contract.customercontractapplicationform.dto.CustomerContractApplicationFormReqDto;
import com.agree.contract.domain.contract.customercontractapplicationform.entity.CustomerContractApplicationForm;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 客户合约申请单转换器
 * 
 */
@Mapper(componentModel = "spring")
public interface CustomerContractApplicationFormAssembler {

    /**
     * 将请求dto转为实体
     */
    CustomerContractApplicationForm toEntity(CustomerContractApplicationFormReqDto dto);

}