package com.zantong.pay.domain.payRecordAggregation.entity;

import com.zantong.pay.domain.payRecordAggregation.valueobject.AccountInfo;
import com.zantong.pay.domain.payRecordAggregation.valueobject.BusinessContract;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 缴费记录
 */
@Data
public class PayRecord {
    /**
     * 合约id
     */
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
    private BusinessContract businessContract;

    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;

}
