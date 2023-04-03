package com.agree.contract.domain.valueobject;

/**
 * @author xulingfeng
 * @date 2023/3/26
 * @description 签约模式
 */
public enum AgencyTypeEnum {
    /**
     * 本行卡
     */
    LOCAL_CARD(1),
    /**
     * 他行卡
     */
    OTHER_CARD(2);

    private Integer code;

    AgencyTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
