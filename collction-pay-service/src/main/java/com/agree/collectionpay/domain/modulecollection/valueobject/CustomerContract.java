package com.agree.collectionpay.domain.modulecollection.valueobject;

import com.agree.collectionpay.domain.modulecollection.exception.CollectionException;
import com.agree.common.ddd.obj.AbstractValueObject;
import com.agree.contract.domain.contract.valueobject.enumType.AgencyTypeEnum;
import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * 
 * @description 客户合约
 */
@Builder
@Getter
public class CustomerContract extends AbstractValueObject {
    /**
     * 合约id
     */
    private String id;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;

    /**
     * 签约模式 本行/他行卡
     */
    private AgencyTypeEnum agencyType;

    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;

    /**
     * 状态校验
     */
    public void statusIfValid() {
        //校验合约状态
        if (status != ContractStatusEnum.VALID) {
            throw new CollectionException("客户合约状态不正常，无法进行代收");
        }
    }

}