package com.agree.collectionpay.domain.modulepay.exception;

import com.agree.common.exception.BaseErrorCode;
import com.agree.common.exception.BaseException;

/**
 * @author xulingfeng
 * @date 2023/4/7
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
