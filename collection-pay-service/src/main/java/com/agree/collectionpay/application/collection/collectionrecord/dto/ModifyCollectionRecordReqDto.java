package com.agree.collectionpay.application.collectionrecord.dto;

import com.agree.collectionpay.domain.collection.valueobject.enumtypes.CollectionResultEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author xulingfeng
 *2023/3/19
 * @description 核心系统回调代收服务参数
 */
@Data
public class ModifyCollectionRecordReqDto {

    /**
     * 代收流水号
     */
    @NotBlank
    private String accountSerialNumber;
    /**
     * 批次号
     */
    @NotBlank
    private String batchNumber;
    /**
     * 付款账户id
     */
    @NotBlank
    private String payAccountInfoId;
    /**
     * 收款账户id
     */
    @NotBlank
    private String receiveAccountInfoId;
    /**
     * 0 成功  1 失败
     */
    @NotNull
    private CollectionResultEnum status;
}
