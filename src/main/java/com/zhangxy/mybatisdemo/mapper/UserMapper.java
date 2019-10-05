package com.zhangxy.mybatisdemo.mapper;

import com.zhangxy.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: mybatis-demo
 * @Date: 2019/10/5 15:02
 * @Author: Zhangxy
 * @Description:
 */
@Mapper
public interface UserMapper {
    public List<User> getUsers();
}
