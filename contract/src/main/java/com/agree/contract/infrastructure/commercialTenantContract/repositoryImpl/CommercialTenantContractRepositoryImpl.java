package com.agree.contract.infrastructure.commercialTenantContract.repositoryImpl;

import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.commercialTenantContract.repository.CommercialTenantContractRepository;
import com.agree.contract.domain.valueobject.ChargeTypeEnum;
import com.agree.contract.infrastructure.commercialTenantContract.converter.CommercialTenantContractConverter;
import com.agree.contract.infrastructure.commercialTenantContract.mapper.CommercialTenantContractMapper;
import com.agree.contract.infrastructure.commercialTenantContract.po.CommercialTenantContractPo;
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
    private CommercialTenantContractMapper contractMapper;
    @Autowired
    private CommercialTenantContractConverter commercialTenantContractConverter;

    /**
     * 保存商户合约
     *
     * @param contract
     * @return
     */
    @Override
    public String saveContract(CommercialTenantContract contract) {
        CommercialTenantContractPo po = commercialTenantContractConverter.toPo(contract);
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
        CommercialTenantContractPo po = contractMapper.selectById(id);
        return commercialTenantContractConverter.toEntity(po);
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
