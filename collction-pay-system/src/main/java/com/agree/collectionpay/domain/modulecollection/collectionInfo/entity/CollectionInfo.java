package com.agree.collectionpay.domain.modulecollection.collectionInfo.entity;

import com.agree.collectionpay.domain.modulecollection.valueobject.CommercialTenantContract;
import com.agree.collectionpay.domain.modulecollection.valueobject.CustomerContract;
import com.agree.common.api.AbstractAggregationObject;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/19
 * @description 代收信息
 */
@SuperBuilder
@Getter
public class CollectionInfo extends AbstractAggregationObject<String> {

    /**
     * 收款金额
     */
    private BigDecimal amount;
    /**
     * 客户合约
     */
    private CustomerContract customerContract;

    /**
     * 商户合约
     */
    private CommercialTenantContract commercialTenantContract;

    /**
     * 补全客户合约
     *
     * @param customerContract
     */
    public void completeCustomerContract(CustomerContract customerContract) {
        this.customerContract = customerContract;
    }

    /**
     * 补全商户合约
     *
     * @param commercialTenantContract
     */
    public void completeCommercialTenantContract(CommercialTenantContract commercialTenantContract) {
        this.commercialTenantContract = commercialTenantContract;
    }

}
