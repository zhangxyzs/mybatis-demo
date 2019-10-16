package com.zhangxy.mybatisdemo.handler.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * @author zhangxy
 * @date 2019/10/16
 **/
//@MappedTypes({PersonTypeEnum.class})
public class PersonTypeHandler implements TypeHandler<PersonTypeEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, PersonTypeEnum status, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, status.getValue());
    }

    @Override
    public PersonTypeEnum getResult(ResultSet resultSet, String s) throws SQLException {
        String code = resultSet.getString(s);
        return PersonTypeEnum.getEnum(code);
    }

    @Override
    public PersonTypeEnum getResult(ResultSet resultSet, int i) throws SQLException {
        String code = resultSet.getString(i);
        return PersonTypeEnum.getEnum(code);
    }

    @Override
    public PersonTypeEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        String code = callableStatement.getString(i);
        return PersonTypeEnum.getEnum(code);
    }
}
