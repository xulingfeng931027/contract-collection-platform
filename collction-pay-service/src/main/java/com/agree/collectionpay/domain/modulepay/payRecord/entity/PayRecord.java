package com.agree.collectionpay.domain.modulepay.payRecord.entity;

import com.agree.collectionpay.domain.modulepay.valueobject.AccountInfo;
import com.agree.collectionpay.domain.modulepay.valueobject.PayResultEnum;
import com.agree.common.ddd.obj.AbstractAggregationObject;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @description 缴费记录
 */
@Getter
@SuperBuilder
public class PayRecord extends AbstractAggregationObject<String> {
    /**
     * 缴费金额
     */
    private BigDecimal amount;
    /**
     * 缴费记录状态
     */
    private PayResultEnum payStatus;
    /**
     * 账单时间
     */
    private Date billTime;
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
    private AccountInfo customerAccountInfo;


}
