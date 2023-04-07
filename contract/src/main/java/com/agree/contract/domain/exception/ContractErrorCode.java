package com.agree.contract.domain.exception;

import com.agree.common.exception.BaseErrorCode;
import lombok.AllArgsConstructor;

/**
 * 签约异常码实现类
 *
 * @author xulingfeng
 * @date 2023/3
 */
@AllArgsConstructor
public enum ContractErrorCode implements BaseErrorCode {

    BIZ_COMMON_EXCEPTION(-3, "通用业务异常"),
    UNKNOWN_EXCEPTION(-1, ""),
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
