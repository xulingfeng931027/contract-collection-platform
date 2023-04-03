package com.agree.collection.domain.collectionRecord.entity;

import com.agree.collection.domain.valueobject.CollctionResultEnum;
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
     * 收款结果
     */
    private CollctionResultEnum result;
    /**
     * 商户账户信息
     */
    private String businessAccountInfoId;
    /**
     * 商户账户信息
     */
    private String customerAccountInfoId;
    /**
     * 商户账户信息
     */
    private String businessContractId;
    /**
     * 客户合约
     */
    private String customerContractId;
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
