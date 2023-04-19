package com.agree.collectionpay.application.support;

import com.agree.common.ddd.mq.DomainEvent;

/**
 * @author xulingfeng
 * @date 2023/4/14
 * @description 消息发送
 */
public interface EventPublishSupport {

    String publish(DomainEvent event);
}
