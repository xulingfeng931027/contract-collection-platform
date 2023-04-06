package com.agree.collectionpay.domain.collectionRecord.entity;

import com.agree.collectionpay.domain.valueobject.CollctionResultEnum;
import com.agree.collectionpay.domain.valueobject.CommercialTenantContract;
import com.agree.collectionpay.domain.valueobject.CustomerContract;
import com.agree.common.api.AbstractIdObject;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/19
 * @description 代收信息
 */
@Data
@SuperBuilder
public class CollectionRecord extends AbstractIdObject<String> {

    /**
     * 收款金额
     */
    private BigDecimal amount;
    /**
     * 代收记录状态
     */
    private CollctionResultEnum status;
    /**
     * 客户合约
     */
    private CustomerContract customerContract;

    /**
     * 商户合约
     */
    private CommercialTenantContract commercialTenantContract;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 代收流水号
     */
    private String accountSerialNumber;
    /**
     * 批次号
     */
    private String batchNumber;

}
