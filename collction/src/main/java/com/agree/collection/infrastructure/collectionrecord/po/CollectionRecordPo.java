package com.agree.collection.infrastructure.collectionrecord.po;

import com.agree.collection.domain.valueobject.CollctionResultEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/19
 * @description 代收信息
 */
@TableName(value = "collection_record", autoResultMap = true)
public class CollectionRecordPo {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 收款金额
     */
    private BigDecimal amount;
    /**
     * 代收记录状态
     */
    private CollctionResultEnum result;
    /**
     * 客户合约id
     */
    private String customerContractId;

    /**
     * 商户合约id
     */
    private String commercialTenantContractId;
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
