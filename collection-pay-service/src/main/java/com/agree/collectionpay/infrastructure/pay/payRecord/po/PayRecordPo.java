package com.agree.collectionpay.infrastructure.pay.payRecord.po;

import com.agree.collectionpay.domain.pay.valueobject.PayResultEnum;
import com.agree.common.ddd.obj.AbstractPo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 *2023/3/17
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

    /**
     * 客户账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfoPo customerAccountInfo;
    /**
     * 账单时间
     */
    private Date billTime;
}
