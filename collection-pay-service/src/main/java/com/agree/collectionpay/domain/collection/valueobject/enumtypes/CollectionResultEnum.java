package com.agree.collectionpay.domain.collection.valueobject.enumtypes;

/**
 * @author xulingfeng
 * @description 代收结果
 */
public enum CollectionResultEnum {
    SUCCESS, FAIL, PROCESSING;

    /**
     * 将三方系统返回的收款结果转换为代收结果
     * @param result
     * @return
     */
    public static CollectionResultEnum convertToResult(String result) {
        return SUCCESS;
    }
}
