package com.agree.collection.infrastructure.payRecord.mapper;

import com.agree.collection.infrastructure.payRecord.po.PayRecordPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xulingfeng
 * @className BillingRecordMapper
 * @description
 * @date 2023/2
 */
@Mapper
public interface PayRecordMapper extends BaseMapper<PayRecordPo> {

}
