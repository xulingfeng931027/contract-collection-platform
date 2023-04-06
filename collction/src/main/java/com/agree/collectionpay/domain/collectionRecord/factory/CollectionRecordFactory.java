package com.agree.collectionpay.domain.collectionRecord.factory;

import com.agree.collectionpay.domain.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.domain.valueobject.CollctionResultEnum;

import java.util.Date;
import java.util.Map;

/**
 * @author xulingfeng
 * @date 2023/4/3
 * @description 代收记录工厂类
 */
public class CollectionRecordFactory {
    /**
     * 单笔代收生成记录
     *
     * @param collectionInfo       代收信息
     * @param receiveAccountInfoId 收款账户id
     * @param result               代收结果
     * @return
     */
    public static CollectionRecord generateCollectionRecordForBatch(CollectionInfo collectionInfo, String receiveAccountInfoId, Map<String, Object> result) {
        return CollectionRecord.builder()
                .amount(collectionInfo.getAmount())
                .commercialTenantContractId(collectionInfo.getCommercialTenantContract().getId())
                .customerContractId(collectionInfo.getCustomerContract().getId())
                .createTime(new Date())
                .status(((CollctionResultEnum) result.get("result")))
                .accountSerialNumber(result.get("accountSerialNumber").toString())
                .build();
    }

    /**
     * 批量代收生成记录
     *
     * @param collectionInfo   代收信息
     * @param receiveAccountId 收款账户id
     */
    public static CollectionRecord generateCollectionRecordForBatch(CollectionInfo collectionInfo, String receiveAccountId) {
        return CollectionRecord.builder()
                .amount(collectionInfo.getAmount())
                .commercialTenantContractId(collectionInfo.getCommercialTenantContract().getId())
                .customerContractId(collectionInfo.getCustomerContract().getId())
                .createTime(new Date())
                .status(CollctionResultEnum.PROCESSING)
                .build();

    }

}
