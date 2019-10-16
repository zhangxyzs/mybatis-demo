package com.zhangxy.mybatisdemo.mapper;

import com.zhangxy.mybatisdemo.entity.Person;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: mybatis-demo
 * @Date: 2019/10/5 15:02
 * @Author: Zhangxy
 * @Description:
 */
@Mapper
public interface PersonMapper {
    public List<Person> getPersons();
    int savePerson(Person person);
}
