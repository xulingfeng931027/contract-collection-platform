package com.agree.common.ddd.mq;

import lombok.Data;

import java.util.Date;

/**
 * @author: xulingfeng
 * @description: 领域事件消息基类
 **/
@Data
public class DomainEvent<T> {
    /**
     * 事件id
     */
    private String id;
    /**
     * 消息时间
     */
    private Date timestamp;
    /**
     * 事件内容
     */
    private String data;
    /**
     * 发送的topic
     */
    private String topic;



}
