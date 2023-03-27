package com.zantong.contract.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 账户信息
 */
@Getter
@Builder
@AllArgsConstructor
public class AccountInfo {
    /**
     * 账户id
     */
    @NotBlank
    private String id;
    /**
     * 账户名
     */
    @NotBlank
    private String name;
    /**
     * 账号
     */
    @NotBlank
    private String number;
    /**
     * 开户行
     */
    @NotBlank
    private String bankName;

}

