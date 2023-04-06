package com.agree.contract.infrastructure.customerContractApplicationForm.repositoryImpl;

import com.agree.contract.domain.customerContractApplicationForm.entity.CustomerContractApplicationForm;
import com.agree.contract.domain.customerContractApplicationForm.repository.CustomerContractApplicationFormRepository;
import com.agree.contract.infrastructure.customerContractApplicationForm.converter.CustomerContractApplicationFormConverter;
import com.agree.contract.infrastructure.customerContractApplicationForm.mapper.CustomerContractApplicationFormMapper;
import com.agree.contract.infrastructure.customerContractApplicationForm.po.CustomerContractApplicationFormPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xulingfeng
 * @className BillingRecordRepositoryImpl
 * @description 客户合约申请单仓储接口实现
 * @date 2023/2
 */
@Repository
@Slf4j
public class CustomerContractApplicationFormRepositoryImpl implements CustomerContractApplicationFormRepository {

    @Autowired
    private CustomerContractApplicationFormConverter contractConverter;
    @Autowired
    private CustomerContractApplicationFormMapper contractMapper;


    /**
     * 保存客户合约申请单
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
