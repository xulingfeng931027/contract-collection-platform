package com.agree.contract.infrastructure.modulecontract.supportImpl;

import com.agree.contract.application.modulecontract.support.CommercialTenantInfoSupport;
import com.agree.contract.domain.modulecontract.valueobject.CommercialTenantInfo;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 商户系统防腐层接口
 */
@Service
public class CommercialTenantInfoSupportImpl implements CommercialTenantInfoSupport {

    /**
     * 查询商户系统
     * 1.从第三方系统获取信息
     * 2.信息转换为本系统的对象
     *
     * @param legalPersonNumber 法人证件号
     * @return 商户信息
     */
    @Override
    public CommercialTenantInfo queryCommercialTenantInfo(String legalPersonNumber) {
        return convert(getCommercialTenantInfoByHttp(legalPersonNumber));
    }

    /**
     * 将第三方系统的商户信息转换为本系统的商户信息
     *
     * @param businessTenantInfo 第三方系统的商户信息
     */
    private CommercialTenantInfo convert(BusinessTenantInfo businessTenantInfo) {
        return CommercialTenantInfo.builder().build();
    }

    /**
     * 从第三方系统http协议获取商户信息
     *
     * @return 第三方系统的商户信息
     */
    private BusinessTenantInfo getCommercialTenantInfoByHttp(String legalPersonNumber) {
        return new BusinessTenantInfo();
    }

    /**
     * 模拟从第三方系统获取的商户信息
     */
    static class BusinessTenantInfo {}

}
