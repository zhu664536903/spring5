package com.spring.test;

import com.spring.entity.User;

import com.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTest {
    ApplicationContext applicationContext = null;
    @Before
    public void init(){

        //applicationContext = new ClassPathXmlApplicationContext("beans1.xml");
        applicationContext  = new AnnotationConfigApplicationContext("com.spring.config");
    }

    @Test
    public void testTrx(){

        UserService userServiceImpl = applicationContext.getBean("userServiceImpl", UserService.class);
        User user = new User("杜秋艳", 22, 177F, 100F);
        //int i = userServiceImpl.insertOne(user);
        //userServiceImpl.updateMoney(2,3,50);
        userServiceImpl.testPropagation();
    }

}
