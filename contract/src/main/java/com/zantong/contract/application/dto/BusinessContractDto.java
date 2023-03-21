package com.zantong.contract.application.dto;

import com.zantong.contract.domain.entity.enumTypes.FundGatherModeEnum;
import com.zantong.contract.domain.entity.valueobject.AccountInfo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
 */
@Data
public class BusinessContractDto {

    /**
     * 商户法人证件号码
     */
    private String idCard;
    /**
     * 纳税人编码
     */
    private String taxCode;
    /**
     * 收费种类
     */
    private String chargeType;
    /**
     * 手续费
     */
    private BigDecimal fee;
    /**
     * 资金归集模式
     */
    private FundGatherModeEnum fundGatherMode;
    /**
     * 扣费方式
     */
    private String chargeMode;
    /**
     * 结算账户信息
     */
    private AccountInfo accountInfo;

    /**
     * 暂存账户信息
     */
    private AccountInfo tempAccountInfo;

    private String projectCode;

    /**
     * 校验商户签约要素
     */
    public boolean checkSignElement() {
        return true;
    }
}
