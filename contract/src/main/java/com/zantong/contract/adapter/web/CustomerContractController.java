package com.zantong.contract.adapter.web;

import com.zantong.contract.application.CommercialTenantContract.assembler.CommercialTenantContractAssembler;
import com.zantong.contract.application.customerContract.dto.CustomerContractDto;
import com.zantong.contract.application.customerContract.service.CustomerContractService;
import com.zantong.contract.application.customerContract.support.api.CustomerContractServiceApi;
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
    private CommercialTenantContractAssembler assembler;

    @Override
    public CustomerContractDto queryContract(String userCode, String projectCode) {
        var customerContract = customerContractService.queryCustomerContractByProjectCode(userCode, projectCode);
        return assembler.toDto(customerContract);
    }

    @PostMapping("/signContract")
    public CustomerContractDto signContract(CustomerContractDto customerContractDto) {
        return customerContractService.signContract(customerContractDto);
    }
}
