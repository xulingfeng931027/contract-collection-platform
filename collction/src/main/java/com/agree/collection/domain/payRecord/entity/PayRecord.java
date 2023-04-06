package com.agree.collection.domain.payRecord.entity;

import com.agree.common.api.AbstractIdObject;
import com.agree.pay.domain.valueobject.AccountInfo;
import com.agree.pay.domain.valueobject.CommercialTenantContract;
import com.agree.pay.domain.valueobject.PayResultEnum;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 缴费记录
 */
@Getter
@SuperBuilder
public class PayRecord extends AbstractIdObject<String> {
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
    private CommercialTenantContract commercialTenantContract;

    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;
    /**
     * 账单时间
     */
    private Date billTime;


}
