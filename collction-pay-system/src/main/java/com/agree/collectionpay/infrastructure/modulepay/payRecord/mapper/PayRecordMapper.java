package com.agree.collectionpay.infrastructure.modulepay.payRecord.mapper;

import com.agree.collectionpay.infrastructure.modulepay.payRecord.po.PayRecordPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xulingfeng
 * @className BillingRecordMapper
 * @description
 * @date 2023/3/11
 */
@Mapper
public interface PayRecordMapper extends BaseMapper<PayRecordPo> {

}
