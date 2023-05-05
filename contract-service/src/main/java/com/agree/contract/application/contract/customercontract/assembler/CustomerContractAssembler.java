package com.agree.contract.application.contract.customercontract.assembler;

import com.agree.contract.application.contract.customercontract.dto.CustomerContractResDto;
import com.agree.contract.domain.contract.customercontract.entity.CustomerContract;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 客户合约转换器
 * 
 */
@Mapper(componentModel = "spring")
public interface CustomerContractAssembler {

    /**
     * 将实体转为响应dto
     */
    CustomerContractResDto toDto(CustomerContract customerContract);

}