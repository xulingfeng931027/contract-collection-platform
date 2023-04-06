package com.agree.collection.domain.payableInfo.entity;

import com.agree.collection.domain.valueobject.AccountInfo;
import com.agree.collection.domain.valueobject.CommercialTenantContract;
import com.agree.common.api.AbstractIdObject;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 应缴信息
 */
@Getter
@SuperBuilder
public class PayableInfo extends AbstractIdObject<String> {
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
     * 账单生成时间
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
