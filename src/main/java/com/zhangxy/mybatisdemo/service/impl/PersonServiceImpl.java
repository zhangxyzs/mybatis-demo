package com.zhangxy.mybatisdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhangxy.mybatisdemo.entity.Person;
import com.zhangxy.mybatisdemo.mapper.PersonMapper;
import com.zhangxy.mybatisdemo.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: mybatis-demo
 * @Date: 2019/10/5 15:22
 * @Author: Zhangxy
 * @Description:
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;
    @Override
    public List<Person> selectPersons(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Person> users = personMapper.getPersons();
        return users;
    }

    @Override
    public int savePerson(Person person) {
        return personMapper.savePerson(person);
    }
}
