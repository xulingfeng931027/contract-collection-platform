package com.agree.collection.application.payableInfo.service;

import com.agree.collection.application.payRecord.assembler.PayRecordAssembler;
import com.agree.collection.application.payRecord.dto.PayRecordResDto;
import com.agree.collection.application.payRecord.dto.PayableInfoDto;
import com.agree.collection.application.payRecord.support.AccountInfoSupport;
import com.agree.collection.application.payRecord.support.CommercialTenantContractSupport;
import com.agree.collection.application.payableInfo.assembly.PayableInfoAssembler;
import com.agree.collection.application.payableInfo.dto.ExecutePayReqDto;
import com.agree.collection.application.payableInfo.support.PayableInfoSupport;
import com.agree.common.mq.BaseMqMessage;
import com.agree.pay.domain.payRecord.PayRecordFactory;
import com.agree.pay.domain.payRecord.entity.PayRecord;
import com.agree.pay.domain.payRecord.repository.PayRecordRepository;
import com.agree.pay.domain.payableInfo.entity.PayableInfo;
import com.agree.pay.domain.valueobject.CommercialTenantContract;
import com.agree.pay.domain.valueobject.PayResultEnum;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Map;

/**
 * @author xulingfeng
 * @date 2023/3/23
 * @description 缴费信息
 */
public class PayableInfoService {

    @Autowired
    private CommercialTenantContractSupport contractSupport;
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    private static final String TOPIC = "PAY_SUCCESS";
    private static final String CHECK_ROLE_CODE = "CODE";
    @Autowired
    private PayableInfoSupport payableInfoSupport;
    @Autowired
    private PayRecordRepository payRecordRepository;
    @Autowired
    private KafkaTemplate<String, BaseMqMessage> kafkaTemplate;
    @Autowired
    private PayRecordAssembler payRecordAssembler;
    @Autowired
    private PayableInfoAssembler payableInfoAssembler;

    /**
     * 在三方商户查询应缴信息
     *
     * @return
     */
    public PayableInfo queryPayableInfo(String userCode, String commercialTenantContractId) {
        //查询商户合约
        return payableInfoSupport.queryPayableInfo(userCode, commercialTenantContractId);
    }


    /**
     * 单笔缴费
     *
     * @return
     */
    public PayRecord singlePay(PayableInfoDto payableInfoDto) {
        PayableInfo payableInfo = payableInfoAssembler.toEntity(payableInfoDto);
        //查询商户合约
        CommercialTenantContract commercialTenantContract = contractSupport.queryContract(payableInfoDto.getCommercialTenantContract().getId(), payableInfoDto.getUserCode());
        commercialTenantContract.checkStatusIfNormal();
        //校验商户账户信息
        accountInfoSupport.checkAccountInfo(commercialTenantContract.getSettleAccountInfo().getId(), CHECK_ROLE_CODE);
        //校验客户账户信息
        accountInfoSupport.checkAccountInfo(payableInfo.getCustomerAccountInfo().getId(), CHECK_ROLE_CODE);
        //执行缴费
        Map<String, Object> result = accountInfoSupport.executeCollection(ExecutePayReqDto.builder().receiveAccountInfoId(commercialTenantContract.getSettleAccountInfo().getId()).payAccountInfoId(payableInfoDto.getCustomerAccountInfo().getId()).amount(payableInfoDto.getAmount()).build());
        //生成缴费记录
        PayRecord payRecord = PayRecordFactory.toEntity(payableInfo, result);
        //保存记录
        payRecordRepository.saveRecord(payRecord);
        //发送通知
        notice(payRecord, result);
        return payRecord;
    }

    private void notice(PayRecord payRecord, Map<String, Object> result) {
        // 成功则通知商户
        if (PayResultEnum.SUCCESS==result.get("result")) {
            PayRecordResDto dto = payRecordAssembler.toResDto(payRecord);
            BaseMqMessage message = BaseMqMessage.builder().topic(TOPIC).data(JSONObject.toJSONString(dto)).build();
            kafkaTemplate.send(TOPIC, message);
        }
        //通知客户缴费结果 调用发送sms的接口
    }
}
