package com.agree.common.exception;

/**
 * @author xulingfeng
 * 
 * @description 基础错误码结构
 *
 */
public interface BaseErrorCode {

    /**
     * @return 错误码
     */
    int getCode();

    /**
     * @return 描述信息
     */
    String getDescription();

}