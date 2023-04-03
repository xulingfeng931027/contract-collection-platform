package com.agree.contract.domain.commercialTenantContract.repository;

import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.valueobject.ChargeTypeEnum;
import com.agree.contract.infrastructure.commercialTenantContract.repositoryImpl.CommercialTenantContractRepositoryImpl;

/**
 * @author xulingfeng
 * @className BillingRecordRepository
 * @description 计费记录仓储接口
 * @date 2023/2
 */
public interface CommercialTenantContractRepository {

    /**
     * 保存合约
     *
     * @return
     * @see CommercialTenantContractRepositoryImpl#saveContract(CommercialTenantContract)
     */
    String saveContract(CommercialTenantContract contract);

    /**
     * 查询 合约
     *
     * @return
     */
    CommercialTenantContract getById(String id);


    /**
     * 查询商户合约
     *
     * @param chargeType
     * @return
     */
    CommercialTenantContract queryContract(String legalPersonNumber, ChargeTypeEnum chargeType);

}
