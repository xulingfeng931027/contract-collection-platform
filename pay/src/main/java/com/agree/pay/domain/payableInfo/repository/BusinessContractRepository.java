package com.agree.pay.domain.payableInfo.repository;

import com.agree.pay.domain.payableInfo.entity.BusinessContract;

/**
 * @author xulingfeng
 * @className BillingRecordRepository
 * @description 计费记录仓储接口
 * @date 2023/2
 */
public interface BusinessContractRepository {

    /**
     * 保存合约
     *
     * @return
     */
    Integer saveContract(BusinessContract contract);

    /**
     * 查询 合约
     *
     * @return
     */
    BusinessContract getById(String id);


    /**
     * 查询商户合约
     *
     * @param idCard
     * @param chargeType
     * @return
     */
    BusinessContract queryBusinessContract(String idCard, String chargeType);

}
