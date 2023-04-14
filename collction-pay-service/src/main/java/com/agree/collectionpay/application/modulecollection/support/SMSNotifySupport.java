package com.agree.collectionpay.application.modulecollection.support;

import java.util.Map;

/**
 * @author xulingfeng
 * 
 * @description 短信通知防腐层
 */
public interface SMSNotifySupport {

    /**
     * 发送短信
     * @param params
     */
    void sendSMS(Map<String, Object> params);
}
