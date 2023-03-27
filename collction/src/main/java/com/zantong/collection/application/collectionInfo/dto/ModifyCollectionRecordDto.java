package com.zantong.collection.application.collectionInfo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author xulingfeng
 * @date 2023/3/19
 * @description 代收信息
 */
@Data
public class ModifyCollectionRecordDto {

    /**
     * 批次号
     */
    private String batchNumber;
    private String payAccountInfoId;

    private String receiveAccountInfoId;
    /**
     * 0 成功  1 失败
     */
    @NotBlank
    private Integer status;
}
