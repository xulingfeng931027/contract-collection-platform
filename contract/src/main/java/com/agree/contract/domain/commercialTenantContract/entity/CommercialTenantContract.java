package com.agree.contract.domain.commercialTenantContract.entity;

import com.agree.common.api.AbstractIdObject;
import com.agree.common.exception.ApplicationException;
import com.agree.contract.domain.valueobject.*;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 商户合约
 */

/**
 * todo 实体类中不要使用@data注解 实体所有的充血方法都应当是他业务职责的体现.避免用户直接使用set方法来修改业务属性.
 * 如果需要修改相关属性,根据实际的业务需求来封装明确的充血方法
 * todo 定义各种数据模型的基类 ???
 * 商户合约聚合,它包含了
 *   商户合约(实体) -> @see 类名 单独的表
 *   商户信息(值对象)-> 序列化字段存储 没有单独的表
 *   结算账户信息(值对象) -> 同上
 *   暂存账户信息(值对象) -> 同上
 *   商户合约实体是他的聚合根
 */
@Getter
@SuperBuilder
public class CommercialTenantContract extends AbstractIdObject<String> {
    /**
     * 合约申请单id
     */
    private String contractApplicationFormId;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;
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

    public void checkStatusIfValid() {
        if (status != ContractStatusEnum.VALID) {
            throw new ApplicationException("合约状态不合法");
        }
    }
}
