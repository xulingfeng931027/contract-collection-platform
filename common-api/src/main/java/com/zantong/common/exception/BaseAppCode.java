package com.zantong.common.exception;

import lombok.AllArgsConstructor;

/**
 * 异常码实现类
 *
 * @author xulingfeng
 * @date 2023/3
 */
@AllArgsConstructor
public enum BaseAppCode implements AppCode {

    REPEAT_AGENCY(1000, "不允许重复签约!"),
    BIZ_COMMON_EXCEPTION(-3, "通用业务异常"),
    PARAM_CHECK_FAILED(-2, "参数校验失败"),
    UNKNOWN_EXCEPTION(-1, "未知异常");
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
