package com.agree.contract.infrastructure.contract.commercialtenantcontract.repositoryImpl;

import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import com.agree.contract.domain.contract.commercialtenantcontract.repository.CommercialTenantContractRepository;
import com.agree.contract.domain.contract.valueobject.enumType.ChargeTypeEnum;
import com.agree.contract.infrastructure.contract.commercialtenantcontract.converter.CommercialTenantContractConverter;
import com.agree.contract.infrastructure.contract.commercialtenantcontract.mapper.CommercialTenantContractMapper;
import com.agree.contract.infrastructure.contract.commercialtenantcontract.po.CommercialTenantContractPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xulingfeng
 * 
 * @description 计费记录仓储接口实现
 * 
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
     * 判断商户合约是否存在
     *
     * @param legalPersonNumber 法人证件号
     * @param chargeType 收费种类
     * @return
     */
    @Override
    public boolean existByLegalPersonNumberAndChargeType(String legalPersonNumber, ChargeTypeEnum chargeType) {
        return false;
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

}
