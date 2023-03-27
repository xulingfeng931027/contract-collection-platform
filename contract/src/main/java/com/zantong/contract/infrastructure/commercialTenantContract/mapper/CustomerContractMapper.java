package com.zantong.contract.infrastructure.commercialTenantContract.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zantong.contract.infrastructure.commercialTenantContract.po.CustomerContractPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xulingfeng
 * @className BillingRecordMapper
 * @description
 * @date 2023/2
 */
@Mapper
public interface CustomerContractMapper extends BaseMapper<CustomerContractPo> {

}
