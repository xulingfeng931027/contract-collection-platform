package com.agree.collectionpay.domain.modulecollection.collectionRecord.entity;

import com.agree.collectionpay.domain.modulecollection.valueobject.CollctionResultEnum;
import com.agree.common.api.AbstractAggregationObject;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * 
 * @description 代收记录
 */
@Data
@SuperBuilder
public class CollectionRecord extends AbstractAggregationObject<String> {

    /**
     * 收款金额
     */
    private BigDecimal amount;
    /**
     * 批次号
     */
    private String batchNumber;
    /**
     * 代收流水号
     */
    private String accountSerialNumber;
    /**
     * 代收记录状态
     */
    private CollctionResultEnum status;
    /**
     * 客户合约ID
     */
    private String customerContractId;
    /**
     * 商户合约ID
     */
    private String commercialTenantContractId;
    /**
     * 创建时间
     */
    private Date createTime;

}
