package com.zantong.common.exception;


import lombok.Getter;
import lombok.Setter;

/**
 * ApplicationException 自定义异常
 *
 * @author lingfeng.xu
 * @version $Id: ApplicationException.java,v 0.1 2018年01月10日 下午 16:35 $Exp
 */
@Getter
@Setter
public class ApplicationException extends RuntimeException {

    /**
     * 错误码 必填
     */
    private AppCode appCode;


    /**
     * 创建一个<code>BasePromotionException</code>
     *
     * @param appCode 错误码
     */
    public ApplicationException(AppCode appCode) {
        this.appCode = appCode;
    }


    /**
     * @see Throwable#toString()
     */
    @Override
    public final String toString() {
        String s = getClass().getName();
        String description = getAppCode().getDescription();
        return s + ": " + appCode.getCode() + "[" + description + "]。";
    }
}
