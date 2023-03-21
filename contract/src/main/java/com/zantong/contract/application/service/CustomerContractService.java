package com.zantong.contract.application.service;

import com.zantong.contract.application.assembly.ContractMapStruct;
import com.zantong.contract.application.dto.CustomerContractDto;
import com.zantong.contract.domain.entity.BusinessContract;
import com.zantong.contract.domain.entity.enumTypes.ContractStatuaEnum;
import com.zantong.contract.domain.entity.valueobject.CustomerInfo;
import com.zantong.contract.domain.repository.BusinessContractRepository;
import com.zantong.contract.domain.repository.CustomerContractRepository;
import com.zantong.contract.domain.support.AccountInfoSupport;
import com.zantong.contract.domain.support.BusinessInfoSupport;
import com.zantong.contract.domain.support.CustomerInfoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xulingfeng
 * @description 签约服务
 * @date 2023/2
 */
@Service
public class CustomerContractService {

    private static final String ACCOUNT_RULE_CODE = "XXX";
    @Autowired
    private CustomerContractRepository contractRepository;
    @Autowired
    private BusinessContractRepository businessContractRepository;
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private BusinessInfoSupport businessInfoSupport;
    @Autowired
    private CustomerInfoSupport customerInfoSupport;

    /**
     * 客户签约
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public CustomerContractDto signContract(CustomerContractDto customerContractDto) {
        //检查签约要素
        customerContractDto.checkSignElement();
        //客户信息
        CustomerInfo customerInfo = customerInfoSupport.queryCustomerInfo(customerContractDto.getIdCard());

        customerInfo.checkStatus();
        customerInfo.checkLegalPersonId();
        if (contractRepository.queryCustomerContractByProjectCode(customerContractDto.getUserCode(), customerContractDto.getProjectCode()) != null) {
            //重复签约
        }
        //校验商户合约
        BusinessContract businessContract = businessContractRepository.queryBusinessContract(customerContractDto.getProjectCode(), customerContractDto.getChargeType());
        if (businessContract == null) {
            //商户合约不存在
        }
        //校验状态
        businessContract.checkStatus();
        //校验账户户信息
        accountInfoSupport.checkAccountInfo(customerContractDto.getAccountInfo().getAccountNumber(), ACCOUNT_RULE_CODE);
        businessContract.setStatus(ContractStatuaEnum.VALID);

        //保存合约
        contractRepository.saveContract(ContractMapStruct.INSTANCE.toEntity(customerContractDto));
        return customerContractDto;
    }

}
