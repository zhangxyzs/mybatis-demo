package com.zhangxy.mybatisdemo.service;

import com.zhangxy.mybatisdemo.entity.User;

import java.util.List;

/**
 * @program: mybatis-demo
 * @Date: 2019/10/5 15:20
 * @Author: Zhangxy
 * @Description:
 */
public interface UserService {
    List<User> selectUsers(Integer pageNum,Integer pageSize);
}
