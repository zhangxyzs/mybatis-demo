package com.zhangxy.mybatisdemo.handler.mybatis;

/**
 * 枚举公共接口
 * 其实主要目的是为了在万能枚举转换器中方便泛型的使用，而且还可以规范枚举类的实现
 * @author zhangxy
 * @date 2019/10/16
 **/
public interface BaseEnum<E extends Enum<?>, T> {
    /**
     * 获取值
     * @return
     */
    T getValue();

    /**
     * 获取描述
     * @return
     */
    String getDisplayName();
}
