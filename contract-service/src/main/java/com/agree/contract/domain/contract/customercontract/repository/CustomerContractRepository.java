package com.agree.contract.domain.contract.customercontract.repository;

import com.agree.contract.domain.contract.customercontract.entity.CustomerContract;
import com.agree.contract.infrastructure.contract.customerContract.repositoryImpl.CustomerContractRepositoryImpl;

/**
 * @author xulingfeng
 * @className CustomerContractRepository
 * @description 客户合约仓储接口
 * 
 */
public interface CustomerContractRepository {

    /**
     * 保存合约
     *
     * @return
     * @see CustomerContractRepositoryImpl#saveContract(CustomerContract)
     */
    String saveContract(CustomerContract contract);

    /**
     * 根据id查合约
     *
     * @param id 客户合约ID
     * @return
     */
    CustomerContract getById(String id);
}
