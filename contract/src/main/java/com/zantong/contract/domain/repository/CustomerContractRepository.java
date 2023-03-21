package com.zantong.contract.domain.repository;

import com.zantong.contract.domain.entity.CustomerContract;

/**
 * @author xulingfeng
 * @className BillingRecordRepository
 * @description 计费记录仓储接口
 * @date 2023/2
 */
public interface CustomerContractRepository {

    /**

    /**
     * 保存客户合约
     *
     * @return
     */
    Integer saveContract(CustomerContract contract);

    /**
     * 查询 合约
     *
     * @return
     */
    CustomerContract getById(String id);


    /**
     * 查询客户合约
     *
     * @param chargeType
     * @return
     */
    CustomerContract queryCustomerContractByProjectCode(String projectCode, String chargeType);
}
