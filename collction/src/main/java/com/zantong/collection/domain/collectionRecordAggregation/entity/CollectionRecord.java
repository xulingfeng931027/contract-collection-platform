package com.zantong.collection.domain.collectionRecordAggregation.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/19
 * @description 代收信息
 */
@Data
public class CollectionRecord {

    /**
     * 收款金额
     */
    private BigDecimal amount;
    /**
     * 收款结果   0成功 1失败  2收款中
     */
    private Integer result;
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
    private String accountSerialNumber;
    /**
     * 批次号
     */
    private String batchNumber;

}
