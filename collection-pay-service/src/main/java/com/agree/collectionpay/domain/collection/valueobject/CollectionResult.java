package com.agree.collectionpay.domain.collection.valueobject;

import com.agree.collectionpay.domain.collection.valueobject.enumtypes.CollectionResultEnum;
import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * @date 2023/4/19
 * @description
 */
@Getter
@Builder
public class CollectionResult {
    /**
     * 代收结果
     */
    private CollectionResultEnum collectionResultEnum;

    /**
     * 流水号
     */
    private String accountSerialNumber;


    public boolean isSuccess() {
        return collectionResultEnum == CollectionResultEnum.SUCCESS;
    }
}
