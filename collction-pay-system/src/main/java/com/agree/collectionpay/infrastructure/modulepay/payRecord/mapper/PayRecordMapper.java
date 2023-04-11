package com.agree.collectionpay.infrastructure.modulepay.payRecord.mapper;

import com.agree.collectionpay.infrastructure.modulepay.payRecord.po.PayRecordPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xulingfeng
 * @className BillingRecordMapper
 * @description
 * 
 */
@Mapper
public interface PayRecordMapper extends BaseMapper<PayRecordPo> {

}
