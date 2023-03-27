package com.zantong.collection.domain.collectionRecord.service;

import cn.hutool.core.collection.CollectionUtil;
import com.zantong.collection.application.collectionInfo.dto.CollectionInfoDto;
import com.zantong.collection.application.collectionInfo.support.ContractSupport;
import com.zantong.collection.domain.valueobject.CustomerContract;
import com.zantong.contract.domain.support.AccountInfoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xulingfeng
 * @date 2023/3/22
 * @description
 */
@Service
public class CollectionDomainService {
    private static final String ACCOUNT_RULE_CODE = "XXX";

    @Autowired
    private ContractSupport contractSupport;
    @Autowired
    private AccountInfoSupport accountInfoSupport;

    /**
     * 单笔代收
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public List<CustomerContract> handleCustomer(List<CollectionInfoDto> collectionInfoDtoList) {
        if (CollectionUtil.isEmpty(collectionInfoDtoList)) {
            return null;
        }
        String projectCode = collectionInfoDtoList.get(0).getProjectCode();
        //查询客户合约
        List<String> userCodeList = collectionInfoDtoList.stream().map(CollectionInfoDto::getUserCode).collect(Collectors.toList());
        List<CustomerContract> customerContractList = contractSupport.queryCustomerContract(projectCode, userCodeList);
        //校验客户合约
        customerContractList.forEach(CustomerContract::checkStatus);
        //校验客户账户
        accountInfoSupport.checkAccountInfo(customerContractList.stream().map(CustomerContract::getAccountInfoId).collect(Collectors.toList()), ACCOUNT_RULE_CODE);
        //todo 这里应该将校验失败的合约去除掉
        return customerContractList;
    }
}
