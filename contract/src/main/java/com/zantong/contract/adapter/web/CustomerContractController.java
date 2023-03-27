package com.zantong.contract.adapter.web;

import com.zantong.contract.application.customerContract.assembler.CustomerContractAssembler;
import com.zantong.contract.application.customerContract.dto.CustomerContractDto;
import com.zantong.contract.application.customerContract.support.api.CustomerContractServiceApi;
import com.zantong.contract.application.customerContractApplicationForm.service.CustomerContractApplicationFormService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xulingfeng
 * @className BillingController
 * @description
 * @date 2023/2
 */
@Api("客户签约接口")
@RestController
public class CustomerContractController implements CustomerContractServiceApi {

    @Autowired
    private CustomerContractApplicationFormService customerContractApplicationFormService;
    @Autowired
    private CustomerContractAssembler customerContractAssembler;

    @Override
    public CustomerContractDto queryContract(String userCode, String projectCode) {
        var customerContract = customerContractApplicationFormService.queryCustomerContractByProjectCode(userCode, projectCode);
        return customerContractAssembler.toDto(customerContract);
    }
//
//    @PostMapping("/signContract")
//    public CustomerContractDto signContract(CustomerContractDto customerContractDto) {
//        return customerContractService.signContract(customerContractDto);
//    }
//}
}