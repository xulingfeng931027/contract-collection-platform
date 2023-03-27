package com.zantong.contract.application.customerContract.dto;

import com.zantong.contract.domain.valueobject.AccountInfo;
import lombok.Data;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
 */
@Data
public class CustomerContractDto {

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
    private String chargeType;
    /**
     * 客户账户信息
     */
    private AccountInfo accountInfo;
    private String projectCode;

    private String address;

    /**
     * 校验签约要素
     */
    public boolean checkSignElement() {
        return true;
    }
}
