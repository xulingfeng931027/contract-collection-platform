package com.zantong.contract.common.exception;

/**
 * @author xulingfeng
 * @description 计费异常
 * @date 2023/2
 */
public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }
}
