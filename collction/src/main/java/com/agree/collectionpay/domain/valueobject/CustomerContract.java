package com.agree.collectionpay.domain.valueobject;

import com.agree.common.api.AbstractValueObject;
import com.agree.common.exception.ApplicationException;
import com.agree.contract.domain.valueobject.AgencyTypeEnum;
import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * @date 2023/3/17
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

//    /**
//     * 手续费
//     */
//    private BigDecimal commissionCharge;

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
            throw new ApplicationException("客户合约状态不正常，无法进行代收");
        }
    }

}
