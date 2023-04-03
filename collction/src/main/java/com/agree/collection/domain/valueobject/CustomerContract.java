package com.agree.collection.domain.valueobject;

import com.agree.common.api.AbstractValueObject;
import com.agree.common.exception.ApplicationException;
import com.agree.contract.domain.valueobject.AgencyTypeEnum;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 客户合约
 */
@SuperBuilder
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
     * 收费种类
     */
    private String chargeType;

    /**
     * 签约模式 本行/他行卡
     */
    private AgencyTypeEnum agencyType;

    /**
     * 手续费
     */
    private BigDecimal commissionCharge;

    /**
     * 状态校验
     */
    public void statusIfValid() {
        //校验合约状态
        if (status != ContractStatusEnum.VALID) {
            throw new ApplicationException("客户合约状态不正常，无法进行代收");
        }
    }

}
