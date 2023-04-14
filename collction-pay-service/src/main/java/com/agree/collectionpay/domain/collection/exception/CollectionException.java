package com.agree.collectionpay.domain.collection.exception;

import com.agree.common.ddd.exception.BaseErrorCode;
import com.agree.common.ddd.exception.BaseException;

/**
 * @author xulingfeng
 * 
 * @description 代收相关异常
 */
public class CollectionException extends BaseException {
    /**
     * 创建一个<code>BaseException</code>
     *
     * @param baseErrorCode 错误码
     */
    public CollectionException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }

    /**
     * 创建一个<code>BaseException</code>
     *
     * @param description
     */
    public CollectionException(String description) {
        super(description);
    }
}
