package com.agree.contract.infrastructure.contract.customerContract.converter;

import com.agree.contract.domain.contract.customercontract.entity.CustomerContract;
import com.agree.contract.infrastructure.contract.customerContract.po.CustomerContractPo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 客户合约转换器
 */
@Mapper(componentModel = "spring")
public interface CustomerContractConverter {
    /**
     * 将客户合约实体转换为po
     */
    CustomerContractPo toPo(CustomerContract customerContract);

    /**
     * 将客户合约po转换为实体
     */
    CustomerContract toEntity(CustomerContractPo customerContractPo);
}
