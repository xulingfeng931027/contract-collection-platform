package com.agree.collectionpay.infrastructure.common.mq;

import com.agree.collectionpay.application.support.EventPublishSupport;
import com.agree.common.ddd.mq.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xulingfeng
 * @date 2023/4/14
 * @description 消息
 */
@Component
public class EventPublishSupportImpl implements EventPublishSupport {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public String publish(DomainEvent event) {
        return kafkaProducer.sendMessage(event.getTopic(), event);
    }
}
