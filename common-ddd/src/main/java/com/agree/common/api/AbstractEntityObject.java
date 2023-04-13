package com.agree.common.api;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * @description 实体对象基类
 * @date 2023/3/1
 */
@Getter
@SuperBuilder
public abstract class AbstractEntityObject<T> implements DomainObject {

    protected T id;
}
