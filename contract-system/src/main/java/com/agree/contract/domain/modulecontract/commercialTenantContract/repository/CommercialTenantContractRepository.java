package com.agree.contract.domain.modulecontract.commercialTenantContract.repository;

import com.agree.contract.domain.modulecontract.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.modulecontract.valueobject.ChargeTypeEnum;
import com.agree.contract.infrastructure.modulecontract.commercialTenantContract.repositoryImpl.CommercialTenantContractRepositoryImpl;

/**
 * @author xulingfeng
 * @className BillingRecordRepository
 * @description 计费记录仓储接口
 * @date 2023/3/11
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
     * 判断商户合约是否存在
     *
     * @param legalPersonNumber 法人证件号
     * @param chargeType 收费种类
     * @return
     */
    boolean existByLegalPersonNumberAndChargeType(String legalPersonNumber, ChargeTypeEnum chargeType);

    /**
     * 根据id查合约
     *
     * @param id
     * @return
     */
    CommercialTenantContract getById(String id);
}
