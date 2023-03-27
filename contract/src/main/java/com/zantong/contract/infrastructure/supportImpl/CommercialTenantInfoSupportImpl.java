package com.zantong.contract.infrastructure.supportImpl;

import com.zantong.contract.domain.support.CommercialTenantInfoSupport;
import com.zantong.contract.domain.valueobject.CommercialTenantInfo;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 商户系统防腐层接口
 * @date 2022/9/11
 */
@Service
public class CommercialTenantInfoSupportImpl implements CommercialTenantInfoSupport {


    /**
     * 查询商户系统
     * 1.从第三方系统获取信息
     * 2.信息转换为本系统的对象
     *
     * @param legalPersonNumber
     * @return
     */
    @Override
    public CommercialTenantInfo queryBusinessInfo(String legalPersonNumber) {
        return convert(getCommercialTenantInfoByHttp(legalPersonNumber));
    }

    /**
     * 将第三方系统的商户信息转换为本系统的商户信息
     *
     * @param businessTenantInfo
     */
    private CommercialTenantInfo convert(BusinessTenantInfo businessTenantInfo) {
        return CommercialTenantInfo.builder().build();
    }

    /**
     * 从第三方系统http协议获取商户信息
     *
     * @return
     */
    private BusinessTenantInfo getCommercialTenantInfoByHttp(String legalPersonNumber) {
        return new BusinessTenantInfo();
    }

    /**
     * 模拟从第三方系统获取的商户信
     */
    static class BusinessTenantInfo {

    }

}
