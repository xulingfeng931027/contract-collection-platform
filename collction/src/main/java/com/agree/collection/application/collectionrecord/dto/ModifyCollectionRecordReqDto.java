package com.agree.collection.application.collectionrecord.dto;

import com.agree.collection.domain.valueobject.CollctionResultEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author xulingfeng
 * @date 2023/3/19
 * @description 代收信息
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
    @NotBlank
    private CollctionResultEnum status;
}
