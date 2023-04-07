package com.agree.contract.application.CommercialTenantContractApplicationForm.service;

import com.agree.common.exception.BaseException;
import com.agree.contract.application.CommercialTenantContract.service.CommercialTenantContractService;
import com.agree.contract.application.CommercialTenantContractApplicationForm.assembler.CommercialTenantContractApplicationFormAssembler;
import com.agree.contract.application.CommercialTenantContractApplicationForm.dto.CommercialTenantContractApplicationFormReqDto;
import com.agree.contract.application.CommercialTenantContractApplicationForm.support.AccountInfoSupport;
import com.agree.contract.application.CommercialTenantContractApplicationForm.support.CommercialTenantInfoSupport;
import com.agree.contract.application.CommercialTenantContractApplicationForm.support.CustomerInfoSupport;
import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.commercialTenantContractApplicationForm.entity.CommercialTenantContractApplicationForm;
import com.agree.contract.domain.commercialTenantContractApplicationForm.repository.CommercialTenantContractApplicationFormRepository;
import com.agree.contract.domain.exception.ContractErrorCode;
import com.agree.contract.domain.factory.CommercialTenantFactory;
import com.agree.contract.domain.valueobject.CommercialTenantInfo;
import com.agree.contract.domain.valueobject.FundGatherModeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author xulingfeng
 * @description 签约服务
 * @date 2023/2
 * todo  加统一异常处理? 异常类型定义? 统一返回结构定义? 实体值对象异常基类的定义?
 */
@Service
public class CommercialTenantContractApplicationFormService {

    private static final String ACCOUNT_RULE_CODE = "XXX";
    @Autowired
    private CommercialTenantContractApplicationFormRepository commercialTenantContractApplicationFormRepository;
    @Autowired
    private CommercialTenantContractService commercialTenantContractService;
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private CommercialTenantInfoSupport commercialTenantInfoSupport;
    @Autowired
    private CustomerInfoSupport customerInfoSupport;
    @Autowired
    private CommercialTenantContractApplicationFormAssembler commercialTenantContractApplicationFormAssembler;

    /**
     * 商户签约
     * todo 流程编排的一般范式:
     *  见ppt
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public CommercialTenantContractApplicationFormReqDto agencyContract(CommercialTenantContractApplicationFormReqDto commercialTenantContractApplicationFormReqDto) {
        //先将入参转为实体
        CommercialTenantContractApplicationForm applicationForm = commercialTenantContractApplicationFormAssembler.toEntity(commercialTenantContractApplicationFormReqDto);
        //校验商户合约申请单
        applicationForm.checkIfValid();
        //todo 1.按照用户故事地图的命令进行流程编排
        //校验重复签约
        if (commercialTenantContractService.queryContract(applicationForm.getCommercialTenantInfo().getLegalPersonNumber(), commercialTenantContractApplicationFormReqDto.getChargeType()) != null) {
            throw new BaseException(ContractErrorCode.REPEAT_AGENCY);
        }
        //查询商户信息
        CommercialTenantInfo commercialTenantInfo = commercialTenantInfoSupport.queryBusinessInfo(commercialTenantContractApplicationFormReqDto.getLegalPersonNumber());
        //校验商户信息
        commercialTenantInfo.checkStatusIfNormal();
        //填充商户信息到实体
        applicationForm.completeCommercialTenantInfo(commercialTenantInfo);
        //校验商户结算账户信息
        accountInfoSupport.checkAccountInfo(applicationForm.getSettlementAccountInfo().getId(), ACCOUNT_RULE_CODE);
        //如果汇总归集还要校验暂存户信息
        if (Objects.equals(commercialTenantContractApplicationFormReqDto.getFundGatherMode(), FundGatherModeEnum.SUM)) {
            accountInfoSupport.checkAccountInfo(applicationForm.getStagingAccountInfo().getId(), ACCOUNT_RULE_CODE);
        }
        //保存合约申请单
        String id = commercialTenantContractApplicationFormRepository.save(applicationForm);
        //生成并保存合约
        CommercialTenantContract commercialTenantContract = CommercialTenantFactory.generateCommercialTenantContract(applicationForm, id);
        commercialTenantContractService.saveContract(commercialTenantContract);
        return commercialTenantContractApplicationFormReqDto;
    }
}
