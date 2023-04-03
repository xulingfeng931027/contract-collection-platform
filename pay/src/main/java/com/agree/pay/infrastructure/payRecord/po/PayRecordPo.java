package com.agree.pay.infrastructure.payRecord.po;

import com.agree.pay.domain.valueobject.AccountInfo;
import com.agree.pay.domain.valueobject.BusinessContract;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

import java.math.BigDecimal;

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
     * 收款金额
     */
    private BigDecimal amount;
    /**
     * 合约类型
     */
    private Integer result;
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
    private BusinessContract businessContract;

    /**
     * 客户账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfo customerAccountInfo;

}
