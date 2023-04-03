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
     * todo 领域层仓储接口
     *  1.仓储接口的入参是聚合根,不能是值对象/实体 为了保证数据的一致性
     *  2.在一个聚合内,所有的仓储都是通过聚合根来进行操作的
     *  3.如果入参采用了实体或值对象 相当于外界可以越过聚合根来操作聚合内的数据,就打破了数据一致性的约束
     *  4.领域层仓储接口负责对领域层的模型进行持久化操作 不关心底层数据模型的结构和操作过程
     *  5.领域层接口的实现在基础设施层 他封装了从领域对象到po并存储的过程.
     *
     * @return
     * @see CommercialTenantContractRepositoryImpl#saveContract(CommercialTenantContract)
     * todo    基础设施层仓储接口即mapper
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
