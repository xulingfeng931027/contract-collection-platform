package com.agree.contract.infrastructure.contract.customerContract.repositoryImpl;

import com.agree.contract.domain.contract.customercontract.entity.CustomerContract;
import com.agree.contract.domain.contract.customercontract.repository.CustomerContractRepository;
import com.agree.contract.infrastructure.contract.customerContract.converter.CustomerContractConverter;
import com.agree.contract.infrastructure.contract.customerContract.mapper.CustomerContractMapper;
import com.agree.contract.infrastructure.contract.customerContract.po.CustomerContractPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xulingfeng
 * 
 * @description 客户合约仓储接口实现
 * 
 */
@Repository
@Slf4j
public class CustomerContractRepositoryImpl implements CustomerContractRepository {

    @Autowired
    private CustomerContractMapper contractMapper;
    @Autowired
    private CustomerContractConverter customerContractConverter;

    /**
     * 保存客户合约
     *
     * @param contract 客户合约
     * @return
     */
    @Override
    public String saveContract(CustomerContract contract) {
        CustomerContractPo po = customerContractConverter.toPo(contract);
        contractMapper.insert(po);
        return po.getId();
    }

    /**
     * 查询客户合约
     *
     * @param id 客户合约ID
     * @return
     */
    @Override
    public CustomerContract getById(String id) {
        CustomerContractPo po = contractMapper.selectById(id);
        return customerContractConverter.toEntity(po);
    }

}
