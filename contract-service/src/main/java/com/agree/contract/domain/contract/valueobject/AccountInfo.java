package com.agree.contract.domain.contract.valueobject;

import com.agree.common.ddd.obj.AbstractValueObject;
import com.agree.contract.domain.contract.valueobject.enumType.AccountStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * 
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

