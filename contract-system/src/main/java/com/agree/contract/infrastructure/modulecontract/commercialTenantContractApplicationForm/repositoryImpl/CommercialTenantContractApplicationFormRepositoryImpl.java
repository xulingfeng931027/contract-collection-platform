package com.agree.contract.infrastructure.modulecontract.commercialTenantContractApplicationForm.repositoryImpl;

import com.agree.contract.domain.modulecontract.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.modulecontract.commercialTenantContractApplicationForm.entity.CommercialTenantContractApplicationForm;
import com.agree.contract.domain.modulecontract.commercialTenantContractApplicationForm.repository.CommercialTenantContractApplicationFormRepository;
import com.agree.contract.infrastructure.modulecontract.commercialTenantContract.repositoryImpl.CommercialTenantContractRepositoryImpl;
import com.agree.contract.infrastructure.modulecontract.commercialTenantContractApplicationForm.converter.CommercialTenantContractApplicationFormConverter;
import com.agree.contract.infrastructure.modulecontract.commercialTenantContractApplicationForm.mapper.CommercialTenantContractApplicationFormMapper;
import com.agree.contract.infrastructure.modulecontract.commercialTenantContractApplicationForm.po.CommercialTenantContractApplicationFormPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xulingfeng
 *
 * @description 商户合约申请单仓储接口实现
 * 
 */
@Repository
@Slf4j
public class CommercialTenantContractApplicationFormRepositoryImpl implements CommercialTenantContractApplicationFormRepository {

    @Autowired
    private CommercialTenantContractApplicationFormMapper contractMapper;
    @Autowired
    private CommercialTenantContractApplicationFormConverter contractConverter;



    /**
     * 保存合约申请单
     *
     * @param applicationForm
     * @return 主键
     * @see CommercialTenantContractRepositoryImpl#saveContract(CommercialTenantContract)
     */
    @Override
    public String saveApplicationForm(CommercialTenantContractApplicationForm applicationForm) {
        CommercialTenantContractApplicationFormPo po = contractConverter.toPo(applicationForm);
        contractMapper.insert(po);
        return po.getId();
    }
}
