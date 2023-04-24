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
        // todo 1.按照用户故事地图的命令进行流程编排
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
        //填充商户信息到实体(见下面注释)
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
    /*
    *
    * 在使用ddd开发过程中，由于领域模型的完整性和一致性，为了强调方法的业务含义，
    * 通常实体不会暴露set方法供外部调用来直接修改其属性。所以我们在应用层进行服务编排的时候，需要将实体中的值对象进行填充的时候遇到了问题，该如何把从防腐层返回的值对象填充到实体中？
     目前有两个思路：
    1.延迟组装。通常我们在进行编排时第一步就是将入参的dto通过assembler转化为实体，再进行后续过程，这里可以考虑将这个过程推后，
    * 先通过防腐层接口获取到第三方的值对象，再将这个值对象当做入参传入到assembler里头并将实体构造出来，这样构造出的实体就是一个完整的实体，
    * 可以调用其值对象的充血方法，也可以后续入库。
缺点：有时我们需要先通过实体的充血方法或者实体本身属性进行一些校验，当校验通过后才进行后续的流程，不能先去调防腐层接口造成资源浪费。那第一种解决方案就不行了，
* 需要考虑第二种
      2.使用实体充血方法。这样不会改变原有的逻辑。
  考虑到使用值对象的充血方法进行校验以及保存值对象是一个具有明确业务含义的行为，前端传参的时候就只传了一个商户信息值对象的id（商户系统里的id），
  * 就是希望我们自己去查询商户信息并进行校验保存这个快照。所以可以通过在实体中封装充血方法的方式来将商户信息值对象填充进去！ */
}
