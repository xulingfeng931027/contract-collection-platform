package com.agree.contract.application.customerContract.assembler;

import com.agree.contract.application.customerContract.dto.CustomerContractDto;
import com.agree.contract.domain.customercontract.CustomerContract;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 合约转换器
 * @date 2023/2
 */
@Mapper(componentModel = "spring")
public interface CustomerContractAssembler {

    CustomerContractDto toDto(CustomerContract entity);
}