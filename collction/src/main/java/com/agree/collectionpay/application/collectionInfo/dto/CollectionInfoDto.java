package com.agree.collectionpay.application.collectionInfo.dto;

import com.agree.collectionpay.domain.valueobject.CommercialTenantContract;
import com.agree.collectionpay.domain.valueobject.CustomerContract;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/19
 * @description 代收信息
 */
@Data
public class CollectionInfoDto {

    /**
     * 收款金额
     */
    private BigDecimal amount;
    /**
     * 客户合约
     */
    @NotNull
    @Valid
    private CustomerContract customerContract;

    /**
     * 商户合约
     */
    @NotNull
    @Valid
    private CommercialTenantContract commercialTenantContract;
}
