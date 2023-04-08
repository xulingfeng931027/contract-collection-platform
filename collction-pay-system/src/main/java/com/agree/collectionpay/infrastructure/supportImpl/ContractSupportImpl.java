package com.agree.collectionpay.infrastructure.supportImpl;

import com.agree.collectionpay.domain.modulecollection.support.ContractSupport;
import com.agree.collectionpay.domain.modulecollection.valueobject.CommercialTenantContract;
import com.agree.collectionpay.domain.modulecollection.valueobject.CustomerContract;

import java.util.List;

/**
 * @author xulingfeng
 * @date 2023/4/8
 * @description
 */
public class ContractSupportImpl implements ContractSupport {
    /**
     * 查商户合约
     *
     * @param contractId
     */
    @Override
    public CommercialTenantContract queryCommercialTenantContract(String contractId) {
        return null;
    }

    /**
     * 批量查客户合约
     *
     * @param customerContractIdList
     */
    @Override
    public List<CustomerContract> queryCustomerContract(List<String> customerContractIdList) {
        return null;
    }
}
