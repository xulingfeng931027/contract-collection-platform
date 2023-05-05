package com.agree.contract.application.contract.service;

import com.agree.contract.application.contract.commercialtenantcontractapplicationform.assembler.CommercialTenantContractApplicationFormAssembler;
import com.agree.contract.application.contract.commercialtenantcontractapplicationform.dto.CommercialTenantContractApplicationFormReqDto;
import com.agree.contract.application.contract.commercialtenantcontractapplicationform.dto.CommercialTenantContractApplicationFormResDto;
import com.agree.contract.application.contract.support.AccountInfoSupport;
import com.agree.contract.application.contract.support.CommercialTenantInfoSupport;
import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import com.agree.contract.domain.contract.commercialtenantcontract.repository.CommercialTenantContractRepository;
import com.agree.contract.domain.contract.commercialtenantcontractapplicationform.entity.CommercialTenantContractApplicationForm;
import com.agree.contract.domain.contract.commercialtenantcontractapplicationform.repository.CommercialTenantContractApplicationFormRepository;
import com.agree.contract.domain.contract.exception.ContractErrorCode;
import com.agree.contract.domain.contract.exception.ContractException;
import com.agree.contract.domain.contract.factory.CommercialTenantFactory;
import com.agree.contract.domain.contract.valueobject.CommercialTenantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xulingfeng
 * @description 商户签约服务
 */
@Service
public class CommercialTenantContractApplicationFormService {

    @Autowired
    private CommercialTenantContractApplicationFormRepository commercialTenantContractApplicationFormRepository;
    @Autowired
    private CommercialTenantContractRepository commercialTenantContractRepository;
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private CommercialTenantInfoSupport commercialTenantInfoSupport;
    @Autowired
    private CommercialTenantContractApplicationFormAssembler commercialTenantContractApplicationFormAssembler;

    /**
     * 商户签约
     */
    @Transactional(rollbackFor = ContractException.class)
    public CommercialTenantContractApplicationFormResDto commercialTenantSignContract(CommercialTenantContractApplicationFormReqDto dto) {
        //先将入参转为实体
        CommercialTenantContractApplicationForm applicationForm = commercialTenantContractApplicationFormAssembler.
                toEntity(dto);
        //校验商户合约申请单
        applicationForm.checkIfValid();
        //获取法人证件号
        String legalPersonNumber = applicationForm.getCommercialTenantInfo().getLegalPersonNumber();
        //校验重复签约
        if (commercialTenantContractRepository.existByLegalPersonNumberAndChargeType(legalPersonNumber,
                applicationForm.getChargeType())) {
            // 抛出签约异常（商户重复签约），业务流程终止
            throw new ContractException(ContractErrorCode.REPEAT_SIGNING);
        }
        //查询商户信息 此处防腐层调用
        CommercialTenantInfo commercialTenantInfo = commercialTenantInfoSupport.queryCommercialTenantInfo(legalPersonNumber);
        //校验商户信息
        commercialTenantInfo.checkStatusIfNormal();
        //填充商户信息到实体
        applicationForm.completeCommercialTenantInfo(commercialTenantInfo);
        //校验商户结算账户信息
        accountInfoSupport.checkAccountInfo(applicationForm.getSettlementAccountInfo().getId());
        //如果归集模式为汇总归集，需要校验暂存账户信息
        if (applicationForm.fundGatherModeIsSum()) {
            // 校验暂存账户信息
            accountInfoSupport.checkAccountInfo(applicationForm.getStagingAccountInfo().getId());
        }
        //保存合约申请单
        String applicationFormId = commercialTenantContractApplicationFormRepository.saveApplicationForm(applicationForm);
        //生成并保存合约
        CommercialTenantContract commercialTenantContract = CommercialTenantFactory.generateCommercialTenantContract(applicationForm,
                applicationFormId);
        commercialTenantContractRepository.saveContract(commercialTenantContract);
        return commercialTenantContractApplicationFormAssembler.toDto(applicationForm);
    }

}
