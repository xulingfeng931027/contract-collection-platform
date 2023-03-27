package com.zantong.contract.domain.customerContractApplicationForm.entity;

import com.zantong.common.api.AbstractIdObject;
import com.zantong.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.zantong.contract.domain.valueobject.AccountInfo;
import com.zantong.contract.domain.valueobject.AgencyTypeEnum;
import com.zantong.contract.domain.valueobject.ChargeTypeEnum;
import com.zantong.contract.domain.valueobject.ContractApplicationFormStatusEnum;
import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 客户合约申请单
 */

@Getter
@Builder
public class CustomerContractApplicationForm extends AbstractIdObject<String> {
    /**
     * 合约名称
     */
    private String name;

    /**
     * 合约申请单状态
     */
    private ContractApplicationFormStatusEnum status;
    /**
     * 收费种类  todo 具有明显的业务意义，应该用枚举
     */
    private ChargeTypeEnum chargeType;
    /**
     * 签约模式
     */
    private AgencyTypeEnum agencyTypeEnum;
    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;

    /**
     * 商户合约
     */
    private CommercialTenantContract commercialTenantContract;

    /**
     * 校验商户合约申请单
     */
    public void checkIfValid() {
        // todo 对于某一类数据的校验 如申请单相关数据的校验 可以写在一个充血方法里
        //  而对于每一个细项的校验 可以封装private方法 便于后续维护
        checkCommissionChargeIfValid();
        checkChargeTypeIfValid();
    }

    /**
     * 校验商户合约收费类型
     */
    private void checkChargeTypeIfValid() {
        // todo 校验逻辑
        //1.场景1 如果仅校验参数是否合法  可以在dto的参数校验中实现
        //  场景2 如果校验具有业务含义 例如某类商户只能使用某些收费类型 那可以封装在充血方法中
    }

    /**
     * 校验商户合约手续费
     */
    private void checkCommissionChargeIfValid() {
        // todo 校验逻辑
    }
}
