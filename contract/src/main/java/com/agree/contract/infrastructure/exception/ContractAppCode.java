package com.agree.contract.infrastructure.exception;

import com.agree.common.exception.AppCode;
import lombok.AllArgsConstructor;

/**
 * 签约异常码实现类
 *
 * @author xulingfeng
 * @date 2023/3
 */
@AllArgsConstructor
public enum ContractAppCode implements AppCode {

    BIZ_COMMON_EXCEPTION(-3, "通用业务异常"),
    PARAM_CHECK_FAILED(-2, "参数校验失败"),
    UNKNOWN_EXCEPTION(-1, "未知异常"),
    REPEAT_AGENCY(1001, "重复签约"),
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