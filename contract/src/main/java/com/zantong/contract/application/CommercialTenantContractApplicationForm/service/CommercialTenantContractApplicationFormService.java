package com.zantong.contract.application.CommercialTenantContractApplicationForm.service;

import com.zantong.common.exception.ApplicationException;
import com.zantong.common.exception.BaseAppCode;
import com.zantong.contract.application.CommercialTenantContract.service.CommercialTenantContractService;
import com.zantong.contract.application.CommercialTenantContractApplicationForm.assembler.CommercialTenantContractApplicationFormAssembler;
import com.zantong.contract.application.CommercialTenantContractApplicationForm.dto.CommercialTenantContractApplicationFormDto;
import com.zantong.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.zantong.contract.domain.commercialTenantContract.factory.CommercialTenantFactory;
import com.zantong.contract.domain.commercialTenantContractApplicationForm.entity.CommercialTenantContractApplicationForm;
import com.zantong.contract.domain.commercialTenantContractApplicationForm.repository.CommercialTenantContractApplicationFormRepository;
import com.zantong.contract.domain.support.AccountInfoSupport;
import com.zantong.contract.domain.support.CommercialTenantInfoSupport;
import com.zantong.contract.domain.support.CustomerInfoSupport;
import com.zantong.contract.domain.valueobject.CommercialTenantInfo;
import com.zantong.contract.domain.valueobject.FundGatherModeEnum;
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
    public CommercialTenantContractApplicationFormDto agencyContract(CommercialTenantContractApplicationFormDto commercialTenantContractApplicationFormDto) {
        //先将入参转为实体
        CommercialTenantContractApplicationForm applicationForm = commercialTenantContractApplicationFormAssembler.toEntity(commercialTenantContractApplicationFormDto);
        //todo 1.按照用户故事地图的命令进行流程编排
        //校验商户信息合法
        applicationForm.getCommercialTenantInfo().checkLegalPersonNumberIfValid();
        //查询商户信息
        CommercialTenantInfo commercialTenantInfo = commercialTenantInfoSupport.queryBusinessInfo(commercialTenantContractApplicationFormDto.getCommercialTenantInfo().getLegalPersonNumber());
        commercialTenantInfo.checkStatusIfNormal();
        if (commercialTenantContractService.queryContract(applicationForm.getCommercialTenantInfo().getLegalPersonNumber(), commercialTenantContractApplicationFormDto.getChargeType()) != null) {
            //todo 重复签约
            throw new ApplicationException(BaseAppCode.REPEAT_AGENCY);
        }
        //校验商户结算账户信息
        accountInfoSupport.checkAccountInfo(applicationForm.getSettlementAccountInfo().getId(), ACCOUNT_RULE_CODE);
        //如果汇总归集还要校验暂存户信息
        if (Objects.equals(commercialTenantContractApplicationFormDto.getFundGatherMode(), FundGatherModeEnum.SUM)) {
            accountInfoSupport.checkAccountInfo(applicationForm.getStagingAccountInfo().getId(), ACCOUNT_RULE_CODE);
        }
        //保存合约申请单
        String id = commercialTenantContractApplicationFormRepository.save(applicationForm);
        //生成并保存合约
        CommercialTenantContract commercialTenantContract = CommercialTenantFactory.convertToCommercialTenantContract(applicationForm, id);
        commercialTenantContractService.saveContract(commercialTenantContract);
        return commercialTenantContractApplicationFormDto;
    }

}
