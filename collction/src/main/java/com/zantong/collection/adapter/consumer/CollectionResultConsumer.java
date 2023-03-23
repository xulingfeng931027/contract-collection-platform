package com.zantong.collection.adapter.consumer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.zantong.collection.application.service.CollectionService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollectionResultConsumer {

    @Autowired
    private CollectionService collectionService;
    @KafkaListener(topics = {"collectionResult"})
    public void handMessage(ConsumerRecord<String, String> record) {
        String msg = record.value();
        List<JSONObject> list = JSON.parseObject(msg, new TypeReference<List<JSONObject>>() {
        });

    }
}
