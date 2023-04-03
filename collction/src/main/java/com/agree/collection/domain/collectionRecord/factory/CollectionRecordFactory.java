package com.agree.collection.domain.collectionRecord.factory;

import com.agree.collection.domain.collectionInfo.entity.CollectionInfo;
import com.agree.collection.domain.collectionRecord.entity.CollectionRecord;
import com.agree.collection.domain.valueobject.CollctionResultEnum;

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
                .createTime(new Date())
                .customerAccountInfoId(receiveAccountInfoId)
                .businessAccountInfoId(collectionInfo.getCustomerAccountInfo().getId())
                .customerContractId(collectionInfo.getCustomerContract().getId())
                .businessContractId(collectionInfo.getCommercialTenantContract().getId())
                .result(((CollctionResultEnum) result.get("result")))
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
                .createTime(new Date())
                .customerAccountInfoId(receiveAccountId)
                .businessAccountInfoId(collectionInfo.getCustomerAccountInfo().getId())
                .customerContractId(collectionInfo.getCustomerContract().getId())
                .businessContractId(collectionInfo.getCommercialTenantContract().getId())
                .result(CollctionResultEnum.PROCESSING)
                .build();

    }

}
