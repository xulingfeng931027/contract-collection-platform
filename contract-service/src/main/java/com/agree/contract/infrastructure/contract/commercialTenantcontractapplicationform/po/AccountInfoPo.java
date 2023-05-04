package com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po;

import com.agree.contract.domain.contract.valueobject.enumType.AccountStatusEnum;
import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * @description 账户信息po
 */
@Getter
@Builder
public class AccountInfoPo {
    /**
     * 账户id
     */
    private String id;
    /**
     * 账户名
     */
    private String name;
    /**
     * 账号
     */
    private String number;
    /**
     * 开户行
     */
    private String bankName;
    /**
     * 账户状态
     */
    private AccountStatusEnum status;
}

