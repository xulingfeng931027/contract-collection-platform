package com.agree.collectionpay.application.payableInfo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 应缴信息
 */
@Data
public class PayableInfoReqDto {
    /**
     * 收款金额
     */
    @NotBlank
    private BigDecimal amount;
    /**
     * 用户编号
     */
    @NotBlank
    private String userCode;
    /**
     * 客户账户id
     */
    @NotBlank
    private String customerAccountInfoId;
    /**
     * 缴费信息编号
     */
    @NotBlank
    private String payInfoCode;
    /**
     * 账单时间
     */
    @NotBlank
    private Date billTime;
    /**
     * 商户合约id
     */
    @NotBlank
    private String commercialTenantContractId;

}
