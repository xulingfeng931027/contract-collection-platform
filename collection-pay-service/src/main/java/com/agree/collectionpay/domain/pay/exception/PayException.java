package com.agree.collectionpay.domain.pay.exception;

import com.agree.common.ddd.exception.BaseErrorCode;
import com.agree.common.ddd.exception.BaseException;

/**
 * @author xulingfeng
 * @description 主动缴费相关异常
 */
public class PayException extends BaseException {
    /**
     * 创建一个<code>BaseException</code>
     *
     * @param baseErrorCode 错误码
     */
    public PayException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }

    /**
     * 创建一个<code>BaseException</code>
     *
     * @param description
     */
    public PayException(String description) {
        super(description);
    }
}
