package com.zantong.contract.infrastructure.commercialTenantContract.repositoryImpl;

import com.zantong.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.zantong.contract.domain.commercialTenantContract.repository.CommercialTenantContractRepository;
import com.zantong.contract.domain.valueobject.ChargeTypeEnum;
import com.zantong.contract.infrastructure.commercialTenantContract.converter.BusinessContractConverter;
import com.zantong.contract.infrastructure.commercialTenantContract.mapper.BusinessContractMapper;
import com.zantong.contract.infrastructure.commercialTenantContract.po.CommercialTenantContractApplicationFormPo;
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
    public CommercialTenantContract saveContract(CommercialTenantContract contract) {
        return contractMapper.insert(BusinessContractConverter.INSTANCE.toPo(contract));
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
     * @param legalPersonId
     * @param chargeType
     * @return
     */
    @Override
    public CommercialTenantContract queryBusinessContract(String legalPersonId, ChargeTypeEnum chargeType) {
        return null;
    }

}
