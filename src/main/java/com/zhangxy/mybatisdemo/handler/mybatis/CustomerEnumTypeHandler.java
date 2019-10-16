package com.zhangxy.mybatisdemo.handler.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

/**
 * 自定义枚举类型Handler
 *
 * @author zhangxy
 * @date 2019/10/16
 **/
@MappedTypes(value = {PersonTypeEnum.class})
public class CustomerEnumTypeHandler<E extends BaseEnum> extends BaseTypeHandler<E> {

    private Class<E> type;

    private E [] enums;

    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     * @param type 配置文件中设置的转换类
     */
    public CustomerEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName()
                    + " does not represent an enum type.");
        }
    }

    /**
     * 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
     * @param preparedStatement
     * @param i
     * @param e
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(i,e.getValue(),jdbcType.TYPE_CODE);
    }

    /**
     * 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String i = resultSet.getString(s);
        if (resultSet.wasNull()) {
            return null;
        } else {
            // 根据数据库中的value值，定位PersonType子类
            return locateEnumStatus(i);
        }
    }
    // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String s = resultSet.getString(i);
        if (resultSet.wasNull()) {
            return null;
        } else {
            // 根据数据库中的value值，定位PersonType子类
            return locateEnumStatus(s);
        }
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {

        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        String s = callableStatement.getString(i);
        if (callableStatement.wasNull()) {
            return null;
        } else {
            // 根据数据库中的value值，定位PersonType子类
            return locateEnumStatus(s);
        }
    }

    /**
     * 枚举类型转换，由于构造函数获取了枚举的子类enums，让遍历更加高效快捷
     * @param value 数据库中存储的自定义value属性
     * @return value对应的枚举类
     */
    private E locateEnumStatus(String value) {
        for(E e : enums) {
            if(e.getValue().equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + value + ",请核对" + type.getSimpleName());
    }
}
