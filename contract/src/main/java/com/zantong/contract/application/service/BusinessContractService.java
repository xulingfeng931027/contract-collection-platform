package com.zantong.contract.application.service;

import com.zantong.contract.application.assembly.ContractMapStruct;
import com.zantong.contract.application.dto.BusinessContractDto;
import com.zantong.contract.domain.entity.BusinessContract;
import com.zantong.contract.domain.entity.enumTypes.FundGatherModeEnum;
import com.zantong.contract.domain.entity.valueobject.BusinessInfo;
import com.zantong.contract.domain.repository.BusinessContractRepository;
import com.zantong.contract.domain.support.AccountInfoSupport;
import com.zantong.contract.domain.support.BusinessInfoSupport;
import com.zantong.contract.domain.support.CustomerInfoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

/**
 * @author xulingfeng
 * @description 签约服务
 * @date 2023/2
 */
@Service
public class BusinessContractService {

    private static final String ACCOUNT_RULE_CODE = "XXX";
    @Autowired
    private BusinessContractRepository contractRepository;
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private BusinessInfoSupport businessInfoSupport;
    @Autowired
    private CustomerInfoSupport customerInfoSupport;

    /**
     * 商户签约
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public BusinessContractDto signContract(BusinessContractDto businessContractDto) {
        //检查签约要素
        businessContractDto.checkSignElement();
        //生成项目代码
        businessContractDto.setProjectCode(UUID.randomUUID().toString());
        BusinessContract businessContract = ContractMapStruct.INSTANCE.toEntity(businessContractDto);


        //查询商户信息
        BusinessInfo businessInfo = businessInfoSupport.queryBusinessInfo(businessContractDto.getIdCard());
        businessInfo.checkStatus();
        if (contractRepository.queryBusinessContract(businessContract.getIdCard(), businessContractDto.getChargeType()) != null) {
            //重复签约
        }
        //校验结算户信息
        accountInfoSupport.checkAccountInfo(businessContractDto.getAccountInfo().getAccountNumber(), ACCOUNT_RULE_CODE);
        //如果汇总归集还要校验暂存户信息
        if (Objects.equals(businessContractDto.getFundGatherMode(), FundGatherModeEnum.SUM)) {
            accountInfoSupport.checkAccountInfo(businessContractDto.getTempAccountInfo().getAccountNumber(), ACCOUNT_RULE_CODE);
        }
        //保存合约
        contractRepository.saveContract(businessContract);
        return businessContractDto;
    }

}
