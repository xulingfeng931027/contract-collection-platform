package com.agree.pay.application.payableInfo.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/23
 * @description 调用收款接口的请求参数
 */
@Builder
@Data
public class ExecutePayReqDto {
    /**
     * 付款账户信息id
     */
    private String payAccountInfoId;

    /**
     * 收款账户信息id
     */
    private String receiveAccountInfoId;

    /**
     * 金额
     */
    private BigDecimal amount;
}
