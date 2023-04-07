package com.agree.common.exception;


import lombok.Data;

/**
 * ApplicationException 自定义异常
 *
 * @author lingfeng.xu
 * @version $Id: ApplicationException.java,v 0.1 2018年01月10日 下午 16:35 $Exp
 */
@Data
//public class ApplicationException extends Exception {
public class BaseException extends RuntimeException {

    /**
     * 错误码 必填
     */
    private Integer code;

    private String description;

    private static final Integer DEFAULT_CODE = -1;


    /**
     * 创建一个<code>BaseException</code>
     *
     * @param baseErrorCode 错误码
     */
    public BaseException(BaseErrorCode baseErrorCode) {
        this.code = baseErrorCode.getCode();
        this.description = baseErrorCode.getDescription();
    }

    /**
     * 创建一个<code>BaseException</code>
     */
    public BaseException(String description) {
        this.description = description;
        this.code = DEFAULT_CODE;
    }

}
