package com.agree.pay.application.payRecord.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/23
 * @description
 */
@Builder
@Data
public class CollectionParamDto {

    private String payAccountInfoId;

    private String receiveAccountInfoId;

    private BigDecimal amount;
}
