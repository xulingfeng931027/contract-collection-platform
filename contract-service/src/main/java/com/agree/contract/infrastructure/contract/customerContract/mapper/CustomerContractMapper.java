package com.agree.contract.infrastructure.contract.customerContract.mapper;

import com.agree.contract.infrastructure.contract.customerContract.po.CustomerContractPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xulingfeng
 * @className BillingRecordMapper
 * @description
 * 
 */
@Mapper
public interface CustomerContractMapper extends BaseMapper<CustomerContractPo> {

}
