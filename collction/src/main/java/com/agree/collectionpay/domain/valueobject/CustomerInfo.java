package com.agree.collectionpay.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 账户信息
 */
@Getter
@Builder
@AllArgsConstructor
public class CustomerInfo {

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
    private CustomerStatusEnum status;
    /**
     * 用户编号
     */
    private String customerCode;
    /**
     * 证件号
     */
    private String idCard;
    public void checkStatusIsNormal() {
        if(status != CustomerStatusEnum.NORMAL){
            throw new RuntimeException("客户状态不正常");
        }
    }


}

