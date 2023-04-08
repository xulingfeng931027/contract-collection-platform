package com.agree.contract.domain.modulecontract.exception;

import com.agree.common.exception.BaseException;

/**
 * @author xulingfeng
 * @date 2023/4/7
 * @description 签约相关异常类
 */
public class ContractException extends BaseException {
    /**
     * 创建异常类
     */
    public ContractException(ContractErrorCode contractErrorCode) {
        super(contractErrorCode);
    }

    /**
     * 创建异常类
     *
     * @param description 错误描述
     */
    public ContractException(String description) {
        super(description);
    }
}
