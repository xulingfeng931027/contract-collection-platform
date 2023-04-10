package com.agree.common.exception;


import lombok.Data;

/**
 * @author lingfeng.xu
 * @description 基础异常类结构
 */
@Data
public class BaseException extends RuntimeException {

    /**
     * 错误码 必填
     */
    private Integer code;

    private String description;

    private static final Integer DEFAULT_CODE = -1;


    /**
     * 创建一个异常
     *
     * @param baseErrorCode 错误码
     */
    public BaseException(BaseErrorCode baseErrorCode) {
        this.code = baseErrorCode.getCode();
        this.description = baseErrorCode.getDescription();
    }

    /**
     * 创建一个异常
     */
    public BaseException(String description) {
        this.description = description;
        this.code = DEFAULT_CODE;
    }

}
