package com.zantong.pay.domain.payRecord;

import com.alibaba.fastjson2.JSONObject;
import com.zantong.pay.domain.payRecord.entity.PayRecord;
import com.zantong.pay.domain.payableInfo.entity.PayableInfo;

/**
 * @author xulingfeng
 * @date 2023/3/26
 * @description
 */
public class PayRecordFactory {
    public static PayRecord toEntity(PayableInfo payableInfo, JSONObject result) {
        return PayRecord.builder()
                .amount(payableInfo.getAmount())
                .result(result.getInteger("result"))
                .payInfoCode(payableInfo.getPayInfoCode())
                .userCode(payableInfo.getUserCode())
                .businessContract(payableInfo.getBusinessContract())
                .customerAccountInfo(payableInfo.getCustomerAccountInfo()).build();
    }

}
