package com.agree.collectionpay.domain.pay.payableinfo.entity;

import com.agree.collectionpay.domain.pay.valueobject.AccountInfo;
import com.agree.collectionpay.domain.pay.valueobject.CommercialTenantContract;
import com.agree.common.ddd.obj.AbstractAggregationObject;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 *
 * @description 应缴信息
 */
@Getter
@SuperBuilder
public class PayableInfo extends AbstractAggregationObject<String> {

    /**
     * 应缴信息编号
     */
    private String payInfoCode;
    /**
     * 缴费金额
     */
    private BigDecimal amount;
    /**
     * 账单时间
     */
    private Date billTime;
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
     * 补全缴费信息
     * @param commercialTenantContract
     * @param customerAccountInfo
     */
    public void completePayableInfo(CommercialTenantContract commercialTenantContract, AccountInfo customerAccountInfo) {
        this.commercialTenantContract = commercialTenantContract;
        this.customerAccountInfo = customerAccountInfo;
    }

}
