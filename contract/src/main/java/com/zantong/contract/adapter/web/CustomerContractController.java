package com.zantong.contract.adapter.web;

import com.zantong.contract.adapter.api.CustomerContractServiceApi;
import com.zantong.contract.application.assembly.ContractMapStruct;
import com.zantong.contract.application.dto.CustomerContractDto;
import com.zantong.contract.application.service.CustomerContractService;
import com.zantong.contract.domain.repository.CustomerContractRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xulingfeng
 * @className BillingController
 * @description
 * @date 2023/2
 */
@Api("签约接口")
@RestController
public class CustomerContractController implements CustomerContractServiceApi {

    @Autowired
    private CustomerContractService customerContractService;
    @Autowired
    private CustomerContractRepository contractRepository;


    @Override
    public CustomerContractDto queryContract(String userCode, String projectCode) {
        var customerContract = contractRepository.queryCustomerContractByProjectCode(userCode, projectCode);
        return ContractMapStruct.INSTANCE.toDto(customerContract);
    }

    @PostMapping("/signContract")
    public CustomerContractDto signContract(CustomerContractDto customerContractDto) {
        return customerContractService.signContract(customerContractDto);
    }
}
