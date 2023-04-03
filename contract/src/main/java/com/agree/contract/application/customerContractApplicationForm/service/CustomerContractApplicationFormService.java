//package com.agree.contract.application.customerContractApplicationForm.service;
//
//import com.agree.common.exception.ApplicationException;
//import com.agree.contract.application.CommercialTenantContract.service.CommercialTenantContractService;
//import com.agree.contract.application.CommercialTenantContractApplicationForm.assembler.CommercialTenantContractApplicationFormAssembler;
//import com.agree.contract.application.customerContract.service.CustomerContractService;
//import com.agree.contract.application.customerContractApplicationForm.assembler.CustomerContractApplicationFormAssembler;
//import com.agree.contract.application.customerContractApplicationForm.dto.CustomerContractApplicationFormDto;
//import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
//import com.agree.contract.domain.customerContractApplicationForm.entity.CustomerContractApplicationForm;
//import com.agree.contract.domain.customercontract.entity.CustomerContract;
//import com.agree.contract.application.CommercialTenantContractApplicationForm.support.AccountInfoSupport;
//import com.agree.contract.application.CommercialTenantContractApplicationForm.support.CommercialTenantInfoSupport;
//import com.agree.contract.application.CommercialTenantContractApplicationForm.support.CustomerInfoSupport;
//import com.agree.contract.domain.valueobject.ContractStatusEnum;
//import com.agree.contract.domain.valueobject.CustomerInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * @author xulingfeng
// * @description 签约服务
// * @date 2023/2
// */
//@Service
//public class CustomerContractApplicationFormService {
//
//    private static final String ACCOUNT_RULE_CODE = "XXX";
//    @Autowired
//    private CommercialTenantContractService commercialTenantContractService;
//    @Autowired
//    private AccountInfoSupport accountInfoSupport;
//    @Autowired
//    private CommercialTenantInfoSupport commercialTenantInfoSupport;
//    @Autowired
//    private CustomerInfoSupport customerInfoSupport;
//    @Autowired
//    private CustomerContractService customerContractService;
//    @Autowired
//    private CustomerContractApplicationFormAssembler customerContractApplicationFormAssembler;
//
//    /**
//     * 客户签约
//     *
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    public CustomerContractApplicationFormDto signContract(CustomerContractApplicationFormDto customerContractApplicationFormDto) {
//        CustomerContractApplicationForm customerContractApplicationForm = customerContractApplicationFormAssembler.toEntity(customerContractApplicationFormDto);
//        //从客户管理系统查询客户信息
//        // 校验客户信息
//        CustomerInfo customerInfo = customerInfoSupport.queryCustomerInfo(customerContractApplicationForm.getCustomerInfo().getUserCode());
//        customerInfo.checkStatus();
//        //校验是否重复签约
//        if (customerContractService.queryCustomerContract(customerContractApplicationForm.getCustomerInfo().getUserCode(), customerContractApplicationFormDto.getCommercialTenantContract().getId()) != null) {
//            throw new ApplicationException("客户已签约");
//        }
//
//        //校验商户合约
//        CommercialTenantContract commercialTenantContract = commercialTenantContractService.queryContract(customerContractApplicationFormDto.getCommercialTenantContractId(), customerContractApplicationFormDto.getChargeType());
//        if (commercialTenantContract == null) {
//            //商户合约不存在
//        }
//        //校验状态
//        commercialTenantContract.checkStatus();
//        //校验账户户信息
//        accountInfoSupport.checkAccountInfo(customerContractApplicationFormDto.getAccountInfo().getNumber(), ACCOUNT_RULE_CODE);
//        commercialTenantContract.setStatus(ContractStatusEnum.VALID);
//
//        //保存合约
//        contractRepository.saveContract(CommercialTenantContractApplicationFormAssembler.INSTANCE.toEntity(customerContractApplicationFormDto));
//        return customerContractApplicationFormDto;
//    }
//
//    public CustomerContract queryCustomerContractByProjectCode(String userCode, String contractId) {
//        return null;
//    }
//}
