package com.agree.contract.domain.modulecontract.valueobject;

import com.agree.common.api.AbstractValueObject;
import com.agree.contract.domain.modulecontract.valueobject.enumType.AccountStatusEnum;
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
public class AccountInfo extends AbstractValueObject {
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

