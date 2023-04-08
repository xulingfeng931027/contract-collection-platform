package com.agree.collectionpay.domain.modulepay.payRecord;

import com.agree.collectionpay.domain.modulepay.payRecord.entity.PayRecord;
import com.agree.collectionpay.domain.modulepay.entity.PayableInfo;
import com.agree.collectionpay.domain.modulecollection.valueobject.PayResultEnum;

import java.util.Map;

/**
 * @author xulingfeng
 * @date 2023/3/26
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