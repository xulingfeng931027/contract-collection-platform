//package com.zantong.contract.application.customerContract.service;
//
//import com.zantong.contract.application.CommercialTenantContractApplicationForm.assembler.CommercialTenantContractApplicationFormAssembler;
//import com.zantong.contract.application.customerContract.dto.CustomerContractDto;
//import com.zantong.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
//import com.zantong.contract.domain.commercialTenantContract.repository.CommercialTenantContractRepository;
//import com.zantong.contract.domain.support.AccountInfoSupport;
//import com.zantong.contract.domain.support.CommercialTenantInfoSupport;
//import com.zantong.contract.domain.support.CustomerInfoSupport;
//import com.zantong.contract.domain.valueobject.ContractStatusEnum;
//import com.zantong.contract.domain.valueobject.CustomerInfo;
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
//public class CustomerContractService {
//
//    private static final String ACCOUNT_RULE_CODE = "XXX";
//    @Autowired
//    private CustomerContractRepository contractRepository;
//    @Autowired
//    private CommercialTenantContractRepository commercialTenantContractRepository;
//    @Autowired
//    private AccountInfoSupport accountInfoSupport;
//    @Autowired
//    private CommercialTenantInfoSupport commercialTenantInfoSupport;
//    @Autowired
//    private CustomerInfoSupport customerInfoSupport;
//
//    /**
//     * 客户签约
//     *
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    public CustomerContractDto signContract(CustomerContractDto customerContractDto) {
//        //检查签约要素
//        customerContractDto.checkSignElement();
//        //客户信息
//        CustomerInfo customerInfo = customerInfoSupport.queryCustomerInfo(customerContractDto.getIdCard());
//
//        customerInfo.checkStatus();
//        customerInfo.checkLegalPersonId();
//        if (contractRepository.queryCustomerContractByProjectCode(customerContractDto.getUserCode(), customerContractDto.getProjectCode()) != null) {
//            //重复签约
//        }
//        //校验商户合约
//        CommercialTenantContract commercialTenantContract = commercialTenantContractRepository.queryBusinessContract(customerContractDto.getProjectCode(), customerContractDto.getChargeType());
//        if (commercialTenantContract == null) {
//            //商户合约不存在
//        }
//        //校验状态
//        commercialTenantContract.checkStatus();
//        //校验账户户信息
//        accountInfoSupport.checkAccountInfo(customerContractDto.getAccountInfo().getNumber(), ACCOUNT_RULE_CODE);
//        commercialTenantContract.setStatus(ContractStatusEnum.VALID);
//
//        //保存合约
//        contractRepository.saveContract(CommercialTenantContractApplicationFormAssembler.INSTANCE.toEntity(customerContractDto));
//        return customerContractDto;
//    }
//
//}
