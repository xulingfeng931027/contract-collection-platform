package com.agree.collectionpay.infrastructure.pay.payRecord.po;

import com.agree.collectionpay.domain.collection.valueobject.enumtypes.AccountStatusEnum;
import lombok.Data;

/**
 * @author xulingfeng
 * @description 账户信息
 */
@Data
public class AccountInfoPo {
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

