package com.agree.contract.domain.contract.commercialtenantcontractapplicationform.repository;

import com.agree.contract.domain.contract.commercialtenantcontractapplicationform.entity.CommercialTenantContractApplicationForm;

/**
 * @author xulingfeng
 * @description 商户合约申请单仓储接口
 */
public interface CommercialTenantContractApplicationFormRepository {

    /**
     * 保存合约申请单
     *
     * @return 商户合约申请单id
     */
    String saveApplicationForm(CommercialTenantContractApplicationForm applicationForm);

}
