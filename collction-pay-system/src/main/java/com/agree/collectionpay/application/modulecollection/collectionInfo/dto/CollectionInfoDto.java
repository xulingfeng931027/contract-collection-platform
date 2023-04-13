package com.agree.collectionpay.application.collectionInfo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author xulingfeng
 *2023/3/19
 * @description 代收信息
 */
@Data
public class CollectionInfoDto {

    /**
     * 收款金额
     */
    @NotNull
    private BigDecimal amount;
    /**
     * 客户合约
     */
    @NotBlank
    private String customerContractId;

    /**
     * 商户合约
     */
    @NotBlank
    private String commercialTenantContractId;
}
