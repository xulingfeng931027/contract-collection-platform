package com.agree.contract.domain.contract.exception;

import com.agree.common.ddd.exception.BaseErrorCode;
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
    REPEAT_SIGNING(1001, "重复签约"),
    COMMERCIAL_TENANT_STATUS_NOT_NORMAL(1002, "商户状态不正常"),
    CUSTOMER_STATUS_NOT_NORMAL(1003, "客户状态不正常"),
    COMMERCIAL_TENANT_CONTRACT_STATUS_INVALID(2001, "商户合约状态无效"),
    CUSTOMER_CONTRACT_STATUS_INVALID(2002, "客户合约状态无效"),

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
