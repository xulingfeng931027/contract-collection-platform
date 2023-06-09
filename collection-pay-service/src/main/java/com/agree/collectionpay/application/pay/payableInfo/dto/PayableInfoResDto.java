package com.agree.collectionpay.application.pay.payableInfo.dto;

import com.agree.collectionpay.domain.collection.valueobject.AccountInfo;
import com.agree.collectionpay.domain.collection.valueobject.CommercialTenantContract;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 *
 * @description 应缴信息
 */
@Data
public class PayableInfoResDto {

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
     * 缴费信息编号
     */
    private String payInfoCode;
    /**
     * 账单时间
     */
    private Date billTime;
    /**
     * 商户合约
     */
    private CommercialTenantContract commercialTenantContract;
    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;

}
