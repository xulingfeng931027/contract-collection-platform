package com.zantong.contract.application.customerContractApplicationForm.service;

import com.zantong.contract.application.CommercialTenantContract.service.CommercialTenantContractService;
import com.zantong.contract.application.CommercialTenantContractApplicationForm.assembler.CommercialTenantContractApplicationFormAssembler;
import com.zantong.contract.application.customerContract.service.CustomerContractService;
import com.zantong.contract.application.customerContractApplicationForm.dto.CustomerContractApplicationFormDto;
import com.zantong.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.zantong.contract.domain.customercontract.CustomerContract;
import com.zantong.contract.domain.support.AccountInfoSupport;
import com.zantong.contract.domain.support.CommercialTenantInfoSupport;
import com.zantong.contract.domain.support.CustomerInfoSupport;
import com.zantong.contract.domain.valueobject.ContractStatusEnum;
import com.zantong.contract.domain.valueobject.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xulingfeng
 * @description 签约服务
 * @date 2023/2
 */
@Service
public class CustomerContractApplicationFormService {

    private static final String ACCOUNT_RULE_CODE = "XXX";
    @Autowired
    private CommercialTenantContractService commercialTenantContractService;
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private CommercialTenantInfoSupport commercialTenantInfoSupport;
    @Autowired
    private CustomerInfoSupport customerInfoSupport;
    @Autowired
    private CustomerContractService customerContractService;

    /**
     * 客户签约
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public CustomerContractApplicationFormDto signContract(CustomerContractApplicationFormDto customerContractApplicationFormDto) {
        //检查签约要素
        customerContractApplicationFormDto.checkAgencyElement();
        //从客户管理系统查询客户信息
        // 校验客户信息
        CustomerInfo customerInfo = customerInfoSupport.queryCustomerInfo(customerContractApplicationFormDto.getIdCard());
        customerInfo.checkStatus();
        customerInfo.checkLegalPersonId();
        if (customerContractService.queryCustomerContract(customerContractApplicationFormDto.getUserCode(), customerContractApplicationFormDto.getCommercialTenantContractId()) != null) {
            //重复签约
        }
        //校验商户合约
        CommercialTenantContract commercialTenantContract = commercialTenantContractService.queryContract(customerContractApplicationFormDto.getCommercialTenantContractId(), customerContractApplicationFormDto.getChargeType());
        if (commercialTenantContract == null) {
            //商户合约不存在
        }
        //校验状态
        commercialTenantContract.checkStatus();
        //校验账户户信息
        accountInfoSupport.checkAccountInfo(customerContractApplicationFormDto.getAccountInfo().getNumber(), ACCOUNT_RULE_CODE);
        commercialTenantContract.setStatus(ContractStatusEnum.VALID);

        //保存合约
        contractRepository.saveContract(CommercialTenantContractApplicationFormAssembler.INSTANCE.toEntity(customerContractApplicationFormDto));
        return customerContractApplicationFormDto;
    }

    public CustomerContract queryCustomerContractByProjectCode(String userCode, String contractId) {
        return null;
    }
}
