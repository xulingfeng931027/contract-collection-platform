package com.agree.collectionpay.infrastructure.supportImpl;

import com.agree.collectionpay.application.pay.support.ContractSupport;
import com.agree.collectionpay.domain.pay.valueobject.CommercialTenantContract;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @description
 */
@Service
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

}
