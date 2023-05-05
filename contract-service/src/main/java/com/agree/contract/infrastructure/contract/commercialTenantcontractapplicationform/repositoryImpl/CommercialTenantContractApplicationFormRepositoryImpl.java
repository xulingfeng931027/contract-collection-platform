package com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.repositoryImpl;

import com.agree.contract.domain.contract.commercialtenantcontractapplicationform.entity.CommercialTenantContractApplicationForm;
import com.agree.contract.domain.contract.commercialtenantcontractapplicationform.repository.CommercialTenantContractApplicationFormRepository;
import com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.converter.CommercialTenantContractApplicationFormConverter;
import com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.mapper.CommercialTenantContractApplicationFormMapper;
import com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po.CommercialTenantContractApplicationFormPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
     * 保存商户合约申请单
     *
     * @param applicationForm
     * @return 主键
     */
    @Override
    @Transactional
    public String saveApplicationForm(CommercialTenantContractApplicationForm applicationForm) {
        CommercialTenantContractApplicationFormPo po = contractConverter.toPo(applicationForm);
        contractMapper.insert(po);
        return po.getId();
    }
}
