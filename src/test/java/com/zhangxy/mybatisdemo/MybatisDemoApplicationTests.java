package com.zhangxy.mybatisdemo;

import com.zhangxy.mybatisdemo.entity.Person;
import com.zhangxy.mybatisdemo.entity.User;
import com.zhangxy.mybatisdemo.handler.mybatis.PersonTypeEnum;
import com.zhangxy.mybatisdemo.service.PersonService;
import com.zhangxy.mybatisdemo.service.UserService;
import com.zhangxy.mybatisdemo.utils.CommonResult;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;
    @Test
    public void contextLoads() {
        List<User> users = userService.selectUsers(1, 10);
        CommonResult commonResult = new CommonResult().pageSuccess(users);
        System.out.println(commonResult);
    }
    @Test
    public void savePerson(){
        Person person=new Person();
        person.setUsername(new Random().nextInt(1000)+"");
        person.setPassword("sasdasasd");
        person.setType(PersonTypeEnum.STUDENT);
        personService.savePerson(person);
    }

}
