package com.agree.collection.domain.payRecord.po;

import com.agree.pay.domain.valueobject.AccountInfo;
import com.agree.pay.domain.valueobject.CommercialTenantContract;
import com.agree.pay.domain.valueobject.PayResultEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 缴费记录
 */
@Data
@TableName(value = "pay_record", autoResultMap = true)
public class PayRecordPo {
    /**
     * 合约id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
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
     * 商户合约
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private CommercialTenantContract commercialTenantContract;

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
