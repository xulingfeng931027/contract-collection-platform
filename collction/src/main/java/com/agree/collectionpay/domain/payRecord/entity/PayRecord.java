package com.agree.collectionpay.domain.payRecord.entity;

import com.agree.collectionpay.domain.valueobject.AccountInfo;
import com.agree.collectionpay.domain.valueobject.PayResultEnum;
import com.agree.common.api.AbstractIdObject;
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
     * 商户合约id
     */
    private String commercialTenantContractId;

    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;
    /**
     * 账单时间
     */
    private Date billTime;


}
