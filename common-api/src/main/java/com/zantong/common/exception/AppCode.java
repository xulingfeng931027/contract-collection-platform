package com.zantong.common.exception;

/**
 *
 */
/**
 * @author xulingfeng
 * @description 签约服务
 * @date 2023/2
 *
 */
public interface AppCode {

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