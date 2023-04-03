package com.agree.contract.domain.valueobject;

import lombok.Getter;

/**
 * @author xulingfeng
 * @date 2023/3/26
 * @description 扣费方式
 */
@Getter
public enum ChargeMethodEnum {
    /**
     * 全额收费
     */
    FULL_CHARGE,
    /**
     * 扣至0元
     */
    DEDUCT_TO_ZERO,
    /**
     * 不足够则不扣费
     */
    NOT_ENOUGH_NOT_DEDUCT,;
}
