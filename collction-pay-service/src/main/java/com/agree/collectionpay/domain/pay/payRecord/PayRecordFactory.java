package com.agree.collectionpay.domain.pay.payRecord;

import com.agree.collectionpay.domain.pay.payRecord.entity.PayRecord;
import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;
import com.agree.collectionpay.domain.pay.valueobject.PayResultEnum;

import java.util.Map;

/**
 * @author xulingfeng
 * 
 * @description
 */
public class PayRecordFactory {
    public static PayRecord toEntity(PayableInfo payableInfo, Map<String, Object> result) {
        return PayRecord.builder()
                .amount(payableInfo.getAmount())
                .payStatus((PayResultEnum) result.get("payStatus"))
                .payInfoCode(payableInfo.getPayInfoCode())
                .userCode(payableInfo.getUserCode())
                .commercialTenantContractId(payableInfo.getCommercialTenantContract().getId())
                .customerAccountInfo(payableInfo.getCustomerAccountInfo()).build();
    }

}
