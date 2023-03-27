package com.zantong.common.exception;


import lombok.Data;

/**
 * ApplicationException 自定义异常
 *
 * @author lingfeng.xu
 * @version $Id: ApplicationException.java,v 0.1 2018年01月10日 下午 16:35 $Exp
 */
@Data
public class ApplicationException extends RuntimeException {

    /**
     * 错误码 必填
     */
    private Integer code;

    private String description;


    /**
     * 创建一个<code>BasePromotionException</code>
     *
     * @param appCode 错误码
     */
    public ApplicationException(AppCode appCode) {
        this.code = appCode.getCode();
        this.description = appCode.getDescription();
    }

    /**
     * 创建一个<code>BasePromotionException</code>
     */
    public ApplicationException(String description) {
        this.description = description;
        this.code = BaseAppCode.BIZ_COMMON_EXCEPTION.getCode();
    }

}
