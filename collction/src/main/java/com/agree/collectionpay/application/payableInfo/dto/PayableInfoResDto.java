package com.agree.collectionpay.application.payableInfo.dto;

import com.agree.collectionpay.domain.valueobject.AccountInfo;
import com.agree.collectionpay.domain.valueobject.CommercialTenantContract;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/17
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

    /**
     * 补全缴费信息
     *
     * @param commercialTenantContract
     * @param customerAccountInfo
     */
    public void completePayableInfo(CommercialTenantContract commercialTenantContract, AccountInfo customerAccountInfo) {
        this.commercialTenantContract = commercialTenantContract;
        this.customerAccountInfo = customerAccountInfo;
    }

}
