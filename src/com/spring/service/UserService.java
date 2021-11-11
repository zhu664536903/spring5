package com.spring.service;

import com.spring.entity.User;

public interface UserService {
    public int insertOne(User user);
    public void updateMoney(Integer from,Integer to,Integer money);
    public  void testPropagation();
}
