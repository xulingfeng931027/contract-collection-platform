package com.agree.contract.domain.commercialTenantContractApplicationForm.entity;

import com.agree.common.api.AbstractIdObject;
import com.agree.contract.domain.valueobject.*;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 商户合约申请单
 */
/**
 * todo 实体类中不要使用@data注解 实体所有的充血方法都应当是他业务职责的体现.避免用户直接使用set方法来修改业务属性.
 * 如果需要修改相关属性,根据实际的业务需求来封装明确的充血方法
 * todo 定义各种数据模型的基类 ???
 */
@Getter
@Builder
public class CommercialTenantContractApplicationForm extends AbstractIdObject<String> {

    /**
     * 合约申请单状态
     */
    private ContractApplicationFormStatusEnum status;
    /**
     * 收费种类  todo 具有明显的业务意义，应该用枚举
     */
    private ChargeTypeEnum chargeType;

    /**
     * 资金归集模式
     */
    private FundGatherModeEnum fundGatherMode;
    /**
     * 手续费
     */
    private BigDecimal commissionCharge;
    /**
     * 扣费方式
     */
    private ChargeMethodEnum chargeMethod;
    /**
     * 结算账户信息
     */
    private AccountInfo settlementAccountInfo;

    /**
     * 暂存账户信息
     */
    private AccountInfo stagingAccountInfo;
    /**
     * 商户信息
     */
    private CommercialTenantInfo commercialTenantInfo;

    /**
     * 校验商户合约申请单
     */
    public void checkIfValid() {
        // todo 对于某一类数据的校验 如申请单相关数据的校验 可以写在一个充血方法里
        //  而对于每一个细项的校验 可以封装private方法 便于后续维护
        checkChargeTypeIfValid();
        checkChargeMethodIfValid();
    }

    /**
     * 校验扣费方式合法
     */
    private void checkChargeMethodIfValid() {
        // todo 校验逻辑
        //1.场景1 如果仅校验参数是否合法  可以在dto的参数校验中实现
        //  场景2 如果校验具有业务含义 例如某类商户只能使用某些收费类型 那可以封装在充血方法中
    }

    /**
     * 校验扣费类型合法
     */
    private void checkChargeTypeIfValid() {
        // todo 校验逻辑
        //1.场景1 如果仅校验参数是否合法  可以在dto的参数校验中实现
        //  场景2 如果校验具有业务含义 例如某类商户只能使用某些收费类型 那可以封装在充血方法中
    }


    /**
     * 填充商户信息到实体
     *
     * @param commercialTenantInfo
     */
    public void completeCommercialTenantInfo(CommercialTenantInfo commercialTenantInfo) {
        this.commercialTenantInfo = commercialTenantInfo;
    }
}
