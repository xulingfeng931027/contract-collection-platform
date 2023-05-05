package com.agree.contract.application.contract.service;

import com.agree.contract.application.contract.customercontract.assembler.CustomerContractAssembler;
import com.agree.contract.application.contract.customercontract.dto.CustomerContractResDto;
import com.agree.contract.domain.contract.customercontract.entity.CustomerContract;
import com.agree.contract.domain.contract.customercontract.repository.CustomerContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @description 客户合约服务
 * 
 */
@Service
public class CustomerContractService {

    @Autowired
    private CustomerContractRepository customerContractRepository;

    @Autowired
    private CustomerContractAssembler customerContractAssembler;

    public CustomerContractResDto queryCustomerContract(String customerContractId) {
        // 1 重构(仓储查询并转换)
        CustomerContract customerContract = customerContractRepository.getById(customerContractId);
        // 2 DO => Assembler => DTO
        CustomerContractResDto customerContractResDto = customerContractAssembler.toDto(customerContract);
        return customerContractResDto;
    }
}
