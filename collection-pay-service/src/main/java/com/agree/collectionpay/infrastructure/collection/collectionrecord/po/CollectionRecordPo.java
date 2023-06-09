package com.agree.collectionpay.infrastructure.collection.collectionrecord.po;

import com.agree.collectionpay.domain.collection.valueobject.enumtypes.CollectionResultEnum;
import com.agree.common.ddd.obj.AbstractPo;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * 
 * @description 代收记录
 */
@TableName(value = "collection_record", autoResultMap = true)
@Data
@SuperBuilder
public class CollectionRecordPo  extends AbstractPo<String> {
    /**
     * 收款金额
     */
    private BigDecimal amount;
    /**
     * 代收记录状态
     */
    private CollectionResultEnum status;
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
