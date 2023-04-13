package com.agree.contract.domain.modulecontract.exception;

import com.agree.common.exception.BaseErrorCode;
import lombok.AllArgsConstructor;

/**
 * 签约异常码实现类
 *
 * @author xulingfeng
 */
@AllArgsConstructor
public enum ContractErrorCode implements BaseErrorCode {

    BIZ_COMMON_EXCEPTION(-3, "通用业务异常"),
    UNKNOWN_EXCEPTION(-1, "未知异常"),
    REPEAT_AGENCY(1001, "重复签约"),
    COMMERCIAL_TENANT_STATUS_NOT_NORMAL(1002, "商户状态不正常"),

    ;
    private final int code;
    private final String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return message;
    }
}
