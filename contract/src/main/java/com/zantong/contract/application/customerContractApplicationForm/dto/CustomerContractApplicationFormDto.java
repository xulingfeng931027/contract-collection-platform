package com.zantong.contract.application.customerContractApplicationForm.dto;

import com.zantong.contract.domain.valueobject.AccountInfo;
import com.zantong.contract.domain.valueobject.ChargeTypeEnum;
import lombok.Data;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
 */
@Data
public class CustomerContractApplicationFormDto {

    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户编码
     */
    private String idCard;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 收费种类
     */
    private ChargeTypeEnum chargeType;
    /**
     * 客户账户信息
     */
    private AccountInfo accountInfo;
    private String commercialTenantContractId;

    private String address;

    /**
     * 校验签约要素
     */
    public boolean checkAgencyElement() {
        return true;
    }
}
