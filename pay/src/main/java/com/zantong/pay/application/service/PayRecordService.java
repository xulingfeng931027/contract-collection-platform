package com.zantong.pay.application.service;

import com.alibaba.fastjson2.JSONObject;
import com.zantong.pay.application.assembly.PayableInfoAssembler;
import com.zantong.pay.application.dto.CollectionParamDto;
import com.zantong.pay.application.dto.PayRecordDto;
import com.zantong.pay.application.dto.PayableInfoDto;
import com.zantong.pay.application.support.AccountInfoSupport;
import com.zantong.pay.application.support.BusinessContractSupport;
import com.zantong.pay.application.support.PayableInfoSupport;
import com.zantong.pay.domain.payRecordAggregation.entity.PayRecord;
import com.zantong.pay.domain.payRecordAggregation.valueobject.BusinessContract;
import com.zantong.pay.domain.payableInfoAggregation.repository.PayRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author xulingfeng
 * @date 2023/3/23
 * @description
 */
public class PayRecordService {

    @Autowired
    private PayableInfoSupport payableInfoSupport;
    @Autowired
    private BusinessContractSupport businessContractServiceApi;
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private PayRecordRepository payRecordRepository;

    /**
     * 执行缴费
     *
     * @return
     */
    public PayRecord executePay(PayableInfoDto payableInfoDto) {
        //查询商户合约
        BusinessContract businessContract = businessContractServiceApi.queryContract(payableInfoDto.getBusinessContract().getProjectCode(), payableInfoDto.getUserCode());
        businessContract.checkStatus();
        //校验商户账户信息
        accountInfoSupport.checkAccountInfo(businessContract.getAccountId());
        //校验客户账户信息
        accountInfoSupport.checkAccountInfo(payableInfoDto.getAccountId());
        //执行缴费
        JSONObject result = accountInfoSupport.executeCollection(CollectionParamDto.builder().receiveAccountInfoId(businessContract.getAccountId()).payAccountInfoId(payableInfoDto.getAccountId()).amount(payableInfoDto.getAmount()).build());

        PayRecord payRecord = PayableInfoAssembler.INSTANCE.toEntity(payableInfoDto, result);
        payRecordRepository.saveRecord(payRecord);
        return payRecord;
    }


    /**
     * 执行缴费
     *
     * @return
     */
    public List<PayRecord> queryPageRecord(PayRecordDto payRecordDto) {
        PayRecord payRecord = PayableInfoAssembler.INSTANCE.toEntity(payRecordDto);
       return payRecordRepository.queryRecordPage(payRecord);
    }
}
