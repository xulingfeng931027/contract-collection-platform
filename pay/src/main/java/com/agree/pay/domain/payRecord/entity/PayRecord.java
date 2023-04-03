package com.agree.pay.domain.payRecord.entity;

import com.agree.common.api.AbstractIdObject;
import com.agree.pay.domain.valueobject.AccountInfo;
import com.agree.pay.domain.valueobject.BusinessContract;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 缴费记录
 */
@Getter
@SuperBuilder
public class PayRecord extends AbstractIdObject<String> {
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
