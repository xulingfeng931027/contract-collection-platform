package com.zantong.collection.application.collectionInfo.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/23
 * @description 调用收款接口的请求参数
 */
@Builder
@Data
public class ExecuteCollectionReqDto {

    private String payAccountInfoId;

    private String receiveAccountInfoId;

    private BigDecimal amount;
}
