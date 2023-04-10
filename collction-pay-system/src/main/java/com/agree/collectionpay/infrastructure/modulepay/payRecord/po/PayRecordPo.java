package com.agree.collectionpay.infrastructure.modulepay.payRecord.po;

import com.agree.collectionpay.domain.modulecollection.valueobject.AccountInfo;
import com.agree.common.api.AbstractPo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 缴费记录
 */
@Data
@TableName(value = "pay_record", autoResultMap = true)
@SuperBuilder
public class PayRecordPo extends AbstractPo<String> {
    /**
     * 缴费金额
     */
    private BigDecimal amount;
    /**
     * 缴费状态
     */
    private PayResultEnum payStatus;
    /**
     * 缴费信息编号
     */
    private String payInfoCode;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 商户合约ID
     */
    private String commercialTenantContractId;
//    /**
//     * 商户合约
//     */
//    @TableField(typeHandler = FastjsonTypeHandler.class)
//    private CommercialTenantContract commercialTenantContract;

    /**
     * 客户账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfo customerAccountInfo;
    /**
     * 账单时间
     */
    private Date billTime;
}
