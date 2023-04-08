package com.agree.collectionpay.application.modulepay.support;

import java.util.Map;

/**
 * @author xulingfeng
 * @date 2023/4/1
 * @description 短信通知防腐层
 */
public interface SMSNotifySupport {

    /**
     * 发送短信
     * @param params
     */
    void sendSMS(Map<String, Object> params);
}
