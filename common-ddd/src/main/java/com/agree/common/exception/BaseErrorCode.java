package com.agree.common.exception;

/**
 * @author xulingfeng
 * @date 2023/3/11
 * @description 基础错误码结构
 *
 */
public interface BaseErrorCode {

    /**
     * @return 错误码
     * @description
     * @author lingfeng.xu
     * @date 2020/8/27 19:43
     */
    int getCode();

    /**
     * @return 描述信息
     * @description
     * @author lingfeng.xu
     * @date 2020/8/27 19:43
     */
    String getDescription();

}