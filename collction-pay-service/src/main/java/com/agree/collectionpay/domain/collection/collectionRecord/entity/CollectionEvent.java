package com.agree.collectionpay.domain.collection.collectionRecord.entity;


import com.agree.collectionpay.domain.collection.valueobject.enumtypes.CollctionResultEnum;
import com.agree.common.ddd.mq.DomainEvent;
import com.alibaba.fastjson2.JSON;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CollectionEvent extends DomainEvent {

    /**
     * 代收记录状态
     */
    private CollctionResultEnum status;

    /**
     * 生成事件
     */
    public static CollectionEvent create( String topic, CollectionRecord record, CollctionResultEnum status) {
        CollectionEvent event = new CollectionEvent();
        event.setId(UUID.randomUUID().toString());
        event.setTimestamp(new Date());
        event.setStatus(status);
        event.setData(JSON.toJSONString(record));
        event.setTopic(topic);
        return event;
    }
}
