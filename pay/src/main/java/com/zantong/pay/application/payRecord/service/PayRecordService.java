package com.zantong.pay.application.payRecord.service;

import com.alibaba.fastjson2.JSONObject;
import com.zantong.common.mq.BaseMqMessage;
import com.zantong.pay.application.payRecord.assembler.PayRecordAssembler;
import com.zantong.pay.application.payRecord.dto.CollectionParamDto;
import com.zantong.pay.application.payRecord.dto.PayRecordReqDto;
import com.zantong.pay.application.payRecord.dto.PayRecordResDto;
import com.zantong.pay.application.payRecord.dto.PayableInfoDto;
import com.zantong.pay.application.payRecord.support.AccountInfoSupport;
import com.zantong.pay.application.payRecord.support.CommercialTenantContractSupport;
import com.zantong.pay.application.payableInfo.assembly.PayableInfoAssembler;
import com.zantong.pay.domain.payRecord.PayRecordFactory;
import com.zantong.pay.domain.payRecord.entity.PayRecord;
import com.zantong.pay.domain.payableInfo.entity.PayableInfo;
import com.zantong.pay.domain.payableInfo.repository.PayRecordRepository;
import com.zantong.pay.domain.valueobject.BusinessContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

/**
 * @author xulingfeng
 * @date 2023/3/23
 * @description
 */
public class PayRecordService {

    private static final String TOPIC = "PAY_SUCCESS";
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private PayRecordRepository payRecordRepository;
    @Autowired
    private CommercialTenantContractSupport contractSupport;
    @Autowired
    private KafkaTemplate<String, BaseMqMessage> kafkaTemplate;
    @Autowired
    private PayRecordAssembler payRecordAssembler;
    @Autowired
    private PayableInfoAssembler payableInfoAssembler;

    /**
     * 单笔缴费
     *
     * @return
     */
    public PayRecord singlePay(PayableInfoDto payableInfoDto) {
        PayableInfo payableInfo = payableInfoAssembler.toEntity(payableInfoDto);
        //查询商户合约
        BusinessContract businessContract = contractSupport.queryContract(payableInfoDto.getBusinessContract().getId(), payableInfoDto.getUserCode());
        businessContract.checkStatus();
        //校验商户账户信息
        accountInfoSupport.checkAccountInfo(businessContract.getAccountId());
        //校验客户账户信息
        accountInfoSupport.checkAccountInfo(payableInfoDto.getAccountId());
        //执行缴费
        JSONObject result = accountInfoSupport.executeCollection(CollectionParamDto.builder().receiveAccountInfoId(businessContract.getAccountId()).payAccountInfoId(payableInfoDto.getAccountId()).amount(payableInfoDto.getAmount()).build());
        PayRecord payRecord = PayRecordFactory.toEntity(payableInfo, result);
        payRecordRepository.saveRecord(payRecord);
        notice(payRecord, result);
        return payRecord;
    }

    private void notice(PayRecord payRecord, JSONObject result) {
        // 成功则通知商户
        if ("true".equals(result.getString("result"))) {
            PayRecordResDto dto = payRecordAssembler.toResDto(payRecord);
            BaseMqMessage message = BaseMqMessage.builder().topic(TOPIC).data(JSONObject.toJSONString(dto)).build();
            kafkaTemplate.send(TOPIC, message);
        }
        //通知客户缴费结果 调用发送sms的接口
    }


    /**
     * 查询缴费记录
     *
     * @return
     */
    public List<PayRecord> queryPageRecord(PayRecordReqDto payRecordReqDto) {
        PayRecord payRecord = payRecordAssembler.toEntity(payRecordReqDto);
        return payRecordRepository.queryRecordPage(payRecord);
    }
}
