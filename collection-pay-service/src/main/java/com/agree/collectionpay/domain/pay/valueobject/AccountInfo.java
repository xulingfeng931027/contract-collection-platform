package com.agree.collectionpay.domain.pay.valueobject;

import com.agree.common.ddd.obj.AbstractValueObject;
import lombok.Value;

/**
 * @author xulingfeng
 * 
 * @description 账户信息
 */
@Value
public class AccountInfo extends AbstractValueObject {
    /**
     * 账户id
     */
    private String id;
    /**
     * 账户名
     */
    private String accountName;
    /**
     * 账号
     */
    private String accountNumber;
    /**
     * 开户行
     */
    private String bankName;
    /**
     * 账户状态
     */
    private AccountStatusEnum status;

}

