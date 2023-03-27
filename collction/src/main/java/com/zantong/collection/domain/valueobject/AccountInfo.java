package com.zantong.collection.domain.valueobject;

import com.zantong.common.api.AbstractValueObject;
import lombok.Value;

/**
 * @author xulingfeng
 * @date 2023/3/17
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

}

