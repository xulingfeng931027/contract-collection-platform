package com.agree.collectionpay.interfaces.consumer;

import com.agree.collectionpay.application.collectionrecord.dto.ModifyCollectionRecordReqDto;
import com.agree.collectionpay.application.modulecollection.collectionrecord.service.CollectionRecordService;
import com.alibaba.fastjson2.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xulingfeng
 * @description 接收代收结果事件消息
 * 
 */
@Component
public class CollectionResultConsumer {

    @Autowired
    private CollectionRecordService collectionRecordService;

    @KafkaListener(topics = {"BATCH_COLLECTION_RESULT"})
    public void handMessage(ConsumerRecord<String, String> record) {
        String msg = record.value();
        List<ModifyCollectionRecordReqDto> list = JSON.parseArray(msg, ModifyCollectionRecordReqDto.class);
        collectionRecordService.updateCollectionRecordStatus(list);
    }
}
