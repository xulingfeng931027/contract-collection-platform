package com.agree.collectionpay.application.pay.payRecord.dto;

import com.agree.collectionpay.domain.pay.valueobject.PayResultEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @description 应缴信息
 */
@Data
public class PayRecordResDto {
    private String id;
    /**
     * 收款金额
     */
    private BigDecimal amount;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户账户id
     */
    private String accountId;
    /**
     * 缴费信息编号
     */
    private String payInfoCode;
    /**
     * 账单时间
     */
    private Date billTime;
    /**
     * 缴费结果
     */
    private PayResultEnum result;

}
