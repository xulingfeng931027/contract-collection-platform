package com.agree.contract.infrastructure.commercialTenantContract.repositoryImpl;

import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.commercialTenantContract.repository.CommercialTenantContractRepository;
import com.agree.contract.domain.valueobject.ChargeTypeEnum;
import com.agree.contract.infrastructure.commercialTenantContract.converter.BusinessContractConverter;
import com.agree.contract.infrastructure.commercialTenantContract.mapper.BusinessContractMapper;
import com.agree.contract.infrastructure.commercialTenantContract.po.CommercialTenantContractApplicationFormPo;
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
public class CommercialTenantContractRepositoryImpl implements CommercialTenantContractRepository {

    @Autowired
    private BusinessContractMapper contractMapper;

    /**
     * 保存商户合约
     *
     * @param contract
     * @return
     */
    @Override
    public String saveContract(CommercialTenantContract contract) {
        CommercialTenantContractApplicationFormPo po = BusinessContractConverter.INSTANCE.toPo(contract);
        contractMapper.insert(po);
        return po.getId();
    }


    /**
     * 查询 合约
     *
     * @param id
     * @return
     */
    @Override
    public CommercialTenantContract getById(String id) {
        CommercialTenantContractApplicationFormPo po = contractMapper.selectById(id);
        CommercialTenantContract entity = BusinessContractConverter.INSTANCE.toEntity(po);
        return entity;
    }

    /**
     * 查询商户合约
     *
     * @param legalPersonNumber
     * @param chargeType
     * @return
     */
    @Override
    public CommercialTenantContract queryContract(String legalPersonNumber, ChargeTypeEnum chargeType) {
        return null;
    }

}
