package com.zantong.contract.infrastructure.repositoryImpl;

import com.zantong.contract.domain.entity.CustomerContract;
import com.zantong.contract.domain.repository.CustomerContractRepository;
import com.zantong.contract.infrastructure.mapper.CustomerContractMapper;
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
public class CustomerContractRepositoryImpl implements CustomerContractRepository {

    @Autowired
    private CustomerContractMapper contractMapper;


    /**
     * /**
     * 保存客户合约
     *
     * @param contract
     * @return
     */
    @Override
    public Integer saveContract(CustomerContract contract) {
        return null;
    }

    /**
     * 查询 合约
     *
     * @param id
     * @return
     */
    @Override
    public CustomerContract getById(String id) {
        return null;
    }

    /**
     * 查询客户合约
     *
     * @param projectCode
     * @param chargeType
     * @return
     */
    @Override
    public CustomerContract queryCustomerContractByProjectCode(String projectCode, String chargeType) {
        return null;
    }
}
