package com.agree.collectionpay.domain.collection.collectionRecord.factory;

import com.agree.collectionpay.domain.collection.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.collection.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.domain.collection.valueobject.CollectionResult;
import com.agree.collectionpay.domain.collection.valueobject.enumtypes.CollectionResultEnum;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public static CollectionRecord generateCollectionRecordForSingle(CollectionInfo collectionInfo, CollectionResult result) {
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
     * @param collectionInfoList 代收信息列表
     * @return 代收记录列表
     */
    public static List<CollectionRecord> generateCollectionRecordForBatch(List<CollectionInfo> collectionInfoList) {
        List<CollectionRecord> collectionRecords = collectionInfoList.stream().map(collectionInfo ->
                CollectionRecord.builder()
                        .amount(collectionInfo.getAmount())
                        .commercialTenantContractId(collectionInfo.getCommercialTenantContract().getId())
                        .customerContractId(collectionInfo.getCustomerContract().getId())
                        .createTime(new Date())
                        // 批量代收，异步执行，默认状态为执行中
                        .status(CollectionResultEnum.PROCESSING)
                        .build()
        ).collect(Collectors.toList());
        return collectionRecords;
    }

}
