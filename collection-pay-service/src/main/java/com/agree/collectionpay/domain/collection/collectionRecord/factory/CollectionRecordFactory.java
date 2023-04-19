package com.agree.collectionpay.domain.collection.collectionRecord.factory;

import com.agree.collectionpay.domain.collection.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.collection.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.domain.collection.valueobject.CollectionResult;
import com.agree.collectionpay.domain.collection.valueobject.enumtypes.CollectionResultEnum;

import java.util.Date;

/**
 * @author xulingfeng
 * @description 代收记录工厂类
 */
public class CollectionRecordFactory {
    /**
     * 单笔代收生成记录
     *
     * @param collectionInfo 代收信息
     * @param result         代收结果
     * @return
     */
    public static CollectionRecord generateCollectionRecordForBatch(CollectionInfo collectionInfo, CollectionResult result) {
        return CollectionRecord.builder()
                .amount(collectionInfo.getAmount())
                .commercialTenantContractId(collectionInfo.getCommercialTenantContract().getId())
                .customerContractId(collectionInfo.getCustomerContract().getId())
                .createTime(new Date())
                .status(result.getCollectionResultEnum())
                .accountSerialNumber(result.getAccountSerialNumber())
                .build();
    }

    /**
     * 批量代收生成记录
     *
     * @param collectionInfo 代收信息
     */
    public static CollectionRecord generateCollectionRecordForBatch(CollectionInfo collectionInfo) {
        return CollectionRecord.builder()
                .amount(collectionInfo.getAmount())
                .commercialTenantContractId(collectionInfo.getCommercialTenantContract().getId())
                .customerContractId(collectionInfo.getCustomerContract().getId())
                .createTime(new Date())
                .status(CollectionResultEnum.PROCESSING)
                .build();

    }

}
