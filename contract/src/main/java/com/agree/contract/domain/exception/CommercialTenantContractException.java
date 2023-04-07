package com.agree.contract.domain.exception;

import com.agree.common.exception.BaseErrorCode;
import com.agree.common.exception.BaseException;

/**
 * @author xulingfeng
 * @date 2023/4/7
 * @description 商户签约相关异常
 */
public class CommercialTenantContractException extends BaseException {
    /**
     * 创建一个<code>BaseException</code>
     *
     * @param baseErrorCode 错误码
     */
    public CommercialTenantContractException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }

    /**
     * 创建一个<code>BaseException</code>
     *
     * @param description
     */
    public CommercialTenantContractException(String description) {
        super(description);
    }
}
