//package com.agree.contract.interfaces.web;
//
//import com.agree.contract.application.customerContract.assembler.CustomerContractAssembler;
//import com.agree.contract.application.customerContract.dto.CustomerContractDto;
//import com.agree.contract.application.customerContract.support.api.CustomerContractServiceApi;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author xulingfeng
// * @className BillingController
// * @description
// * 
// */
//@Api("客户签约接口")
//@RestController
//public class CustomerContractController implements CustomerContractServiceApi {
//
//    @Autowired
//    private CustomerContractAssembler customerContractAssembler;
//
//    @Override
//    public CustomerContractDto queryContract(String userCode, String projectCode) {
//        var customerContract = customerContractApplicationFormService.queryCustomerContractByProjectCode(userCode, projectCode);
//        return customerContractAssembler.toDto(customerContract);
//    }
////
////    @PostMapping("/signContract")
////    public CustomerContractDto signContract(CustomerContractDto customerContractDto) {
////        return customerContractService.signContract(customerContractDto);
////    }
////}
//}