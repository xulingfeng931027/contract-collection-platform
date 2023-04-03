package com.agree.collection.domain.collectionInfo.entity;

import com.agree.collection.domain.valueobject.AccountInfo;
import com.agree.collection.domain.valueobject.CommercialTenantContract;
import com.agree.collection.domain.valueobject.CustomerContract;
import com.agree.common.api.AbstractIdObject;
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
public class CollectionInfo extends AbstractIdObject<String> {

    /**
     * 收款金额
     */
    private BigDecimal amount;
    /**
     * 商户账户信息
     */
    private AccountInfo customerAccountInfo;
    /**
     * 商户账户信息
     */
    private AccountInfo commercialTenantAccountInfo;
    /**
     * 客户合约
     */
    private CustomerContract customerContract;

    /**
     * 商户合约
     */
    private CommercialTenantContract commercialTenantContract;

}
