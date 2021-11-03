package com.spring.dao;

import com.spring.entity.User;

import javax.jws.soap.SOAPBinding;

public interface UserDao {
    public int insertOne(User user);
    public int updateOne(Integer id,Float money);
    public User queryOne(Integer id);
}
