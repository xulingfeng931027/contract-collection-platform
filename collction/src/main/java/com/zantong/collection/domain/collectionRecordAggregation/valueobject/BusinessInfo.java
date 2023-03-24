package com.zantong.collection.domain.collectionRecordAggregation.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 商户信息
 */
//todo 由于值对象整个使用,不能修改单个属性,因此不提供set方法,如果需要修改,请通过构造方法或者builder重新创建一个新的值对象并覆盖.
@Getter
@Builder
@AllArgsConstructor
public class BusinessInfo {
    /**
     * 名称
     */
    private String name;
    /**
     * 电话
     */
    private String phone;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 法人证件号
     */
    private String legalPersonId;

    public boolean checkStatus() {
        return status == 1;
    }

    public boolean checkLegalPersonId() {
        return legalPersonId != null;
    }
}
