package com.agree.contract.infrastructure.contract.customerContractApplicationForm.repositoryImpl;

import com.agree.contract.domain.contract.customercontractapplicationform.entity.CustomerContractApplicationForm;
import com.agree.contract.domain.contract.customercontractapplicationform.repository.CustomerContractApplicationFormRepository;
import com.agree.contract.infrastructure.contract.customerContractApplicationForm.converter.CustomerContractApplicationFormConverter;
import com.agree.contract.infrastructure.contract.customerContractApplicationForm.mapper.CustomerContractApplicationFormMapper;
import com.agree.contract.infrastructure.contract.customerContractApplicationForm.po.CustomerContractApplicationFormPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xulingfeng
 * 
 * @description 客户合约申请单仓储接口实现
 * 
 */
@Repository
@Slf4j
public class CustomerContractApplicationFormRepositoryImpl implements CustomerContractApplicationFormRepository {

    @Autowired
    private CustomerContractApplicationFormConverter contractConverter;
    @Autowired
    private CustomerContractApplicationFormMapper contractMapper;

    /**
     *
     * @param form 客户合约申请单
     * @return 主键
     */
    @Override
    public String save(CustomerContractApplicationForm form) {
        CustomerContractApplicationFormPo po = contractConverter.toPo(form);
        contractMapper.insert(po);
        return po.getId();
    }
}
