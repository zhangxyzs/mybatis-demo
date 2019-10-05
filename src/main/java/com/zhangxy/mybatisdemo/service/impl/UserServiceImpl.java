package com.zhangxy.mybatisdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhangxy.mybatisdemo.entity.User;
import com.zhangxy.mybatisdemo.mapper.UserMapper;
import com.zhangxy.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mybatis-demo
 * @Date: 2019/10/5 15:22
 * @Author: Zhangxy
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectUsers(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.getUsers();
        return users;
    }
}
