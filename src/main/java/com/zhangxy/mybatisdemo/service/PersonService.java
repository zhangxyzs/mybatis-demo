package com.zhangxy.mybatisdemo.service;

import com.zhangxy.mybatisdemo.entity.Person;
import java.util.List;

/**
 * @program: mybatis-demo
 * @Date: 2019/10/5 15:20
 * @Author: Zhangxy
 * @Description:
 */
public interface PersonService {
    List<Person> selectPersons(Integer pageNum, Integer pageSize);
    int savePerson(Person person);
}
