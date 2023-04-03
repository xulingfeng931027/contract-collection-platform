package com.agree.common.api;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author chenrui
 * @className AbstractIdObject
 * @description 实体唯一标识类
 * @date 2022/9/10
 */
@Getter
@SuperBuilder
public abstract class AbstractIdObject<T> implements DomainObject {
    protected T id;
}
