package com.zantong.pay.domain.payableInfo.entity;

import com.zantong.common.api.AbstractIdObject;
import com.zantong.pay.domain.valueobject.AccountInfo;
import com.zantong.pay.domain.valueobject.BusinessContract;
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
     * 账单时间
     */
    private Date billTime;
    /**
     * 商户合约
     */
    private BusinessContract businessContract;
    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;

}
