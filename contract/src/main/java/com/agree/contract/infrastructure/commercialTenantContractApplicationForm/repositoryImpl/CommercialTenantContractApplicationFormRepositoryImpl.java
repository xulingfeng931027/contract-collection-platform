package com.agree.contract.infrastructure.commercialTenantContractApplicationForm.repositoryImpl;

import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.commercialTenantContractApplicationForm.entity.CommercialTenantContractApplicationForm;
import com.agree.contract.domain.commercialTenantContractApplicationForm.repository.CommercialTenantContractApplicationFormRepository;
import com.agree.contract.infrastructure.commercialTenantContract.repositoryImpl.CommercialTenantContractRepositoryImpl;
import com.agree.contract.infrastructure.commercialTenantContractApplicationForm.converter.CommercialTenantContractApplicationFormConverter;
import com.agree.contract.infrastructure.commercialTenantContractApplicationForm.mapper.CommercialTenantContractApplicationFormMapper;
import com.agree.contract.infrastructure.commercialTenantContractApplicationForm.po.CommercialTenantContractApplicationFormPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xulingfeng
 * @className BillingRecordRepositoryImpl
 * @description 计费记录仓储接口实现
 * @date 2023/2
 */
@Repository
@Slf4j
public class CommercialTenantContractApplicationFormRepositoryImpl implements CommercialTenantContractApplicationFormRepository {

    @Autowired
    private CommercialTenantContractApplicationFormMapper contractMapper;
    @Autowired
    private CommercialTenantContractApplicationFormConverter contractConverter;



    /**
     * 保存合约
     *
     * @param form
     * @return 主键
     * @see CommercialTenantContractRepositoryImpl#saveContract(CommercialTenantContract)
     */
    @Override
    public String save(CommercialTenantContractApplicationForm form) {
        CommercialTenantContractApplicationFormPo po = contractConverter.toPo(form);
        contractMapper.insert(po);
        return po.getId();
    }
}
