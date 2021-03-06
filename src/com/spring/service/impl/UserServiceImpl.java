package com.spring.service.impl;

import com.spring.dao.UserDao;
import com.spring.entity.User;
import com.spring.service.UserService;
import com.sun.javafx.util.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.logging.Logger;

@Service

public class UserServiceImpl implements UserService {
    Logger log = Logger.getLogger("com.spring.service.impl.UserServiceImpl");

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    //插入一条记录
    @Override
    @Transactional
    public int insertOne(User user) {
        return userDao.insertOne(user);
    }

    //给指定用户转帐
    @Override
    @Transactional()
    public void updateMoney(Integer from, Integer to, Integer money) {
        User fromUser = userDao.queryOne(from);
        User toUser = userDao.queryOne(to);
        if (StringUtils.isEmpty(fromUser) || StringUtils.isEmpty(toUser)) {
            throw new RuntimeException("用户不存在！");
        }
        if (fromUser.getBanlance() < money) {
            throw new RuntimeException("余额不足！");
        }
        //转出
        userDao.updateOne(fromUser.getId(), fromUser.getBanlance() - money);
        log.info(String.format("帐户%s转出%s元！",fromUser.getName(),money));
        //int i=1/0;
        //转入
        userDao.updateOne(toUser.getId(), toUser.getBanlance() + money);
        log.info(String.format("帐户%s转入%s元！",toUser.getName(),money));

    }

    @Transactional
    public  void testPropagation(){
        userDao.updateOne(2, 110.0F);

        try {
            userService.updateMoney(3,4,10);
        } catch (Exception e) {
            System.out.println("转帐异常");
        }
        //int i=1/0;
        System.out.println("测试完成");

    }


}
