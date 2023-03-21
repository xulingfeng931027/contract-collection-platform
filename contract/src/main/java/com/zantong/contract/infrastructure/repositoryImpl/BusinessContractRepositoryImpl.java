package com.zantong.contract.infrastructure.repositoryImpl;

import com.zantong.contract.domain.entity.BusinessContract;
import com.zantong.contract.domain.repository.BusinessContractRepository;
import com.zantong.contract.infrastructure.assembly.BusinessContractPoAssembler;
import com.zantong.contract.infrastructure.mapper.BusinessContractMapper;
import com.zantong.contract.infrastructure.po.BusinessContractPo;
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
public class BusinessContractRepositoryImpl implements BusinessContractRepository {

    @Autowired
    private BusinessContractMapper contractMapper;

    /**
     * 保存商户合约
     *
     * @param contract
     * @return
     */
    @Override
    public Integer saveContract(BusinessContract contract) {
        return contractMapper.insert(BusinessContractPoAssembler.INSTANCE.toPo(contract));
    }


    /**
     * 查询 合约
     *
     * @param id
     * @return
     */
    @Override
    public BusinessContract getById(String id) {
        BusinessContractPo po = contractMapper.selectById(id);
        BusinessContract entity = BusinessContractPoAssembler.INSTANCE.toEntity(po);
        return entity;
    }

    /**
     * 查询商户合约
     *
     * @param idCard
     * @param chargeType
     * @return
     */
    @Override
    public BusinessContract queryBusinessContract(String idCard, String chargeType) {
        return null;
    }

}
