package com.agree.contract.domain.contract.customercontractapplicationform.repository;


import com.agree.contract.domain.contract.customercontractapplicationform.entity.CustomerContractApplicationForm;
import com.agree.contract.infrastructure.contract.customerContractApplicationForm.repositoryImpl.CustomerContractApplicationFormRepositoryImpl;

/**
 * @author xulingfeng
 * @description  客户合约申请单仓储接口
 *
 */
public interface CustomerContractApplicationFormRepository {

    /**
     * 保存客户合约申请单
     * @see CustomerContractApplicationFormRepositoryImpl#save(CustomerContractApplicationForm)
     * @return 客户合约申请单ID
     */
    String save(CustomerContractApplicationForm form);

}
