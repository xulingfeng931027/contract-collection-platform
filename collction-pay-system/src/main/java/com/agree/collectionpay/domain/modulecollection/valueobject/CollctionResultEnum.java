package com.agree.collectionpay.domain.modulecollection.valueobject;

/**
 * @author xulingfeng
 * @description 代收结果
 */
public enum CollctionResultEnum {
    SUCCESS, FAIL, PROCESSING;

    /**
     * 将三方系统返回的收款结果转换为代收结果
     * @param result
     * @return
     */
    public static CollctionResultEnum convertToResult(String result) {
        return SUCCESS;
    }
}
