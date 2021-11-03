package com.spring.dao.impl;

import com.spring.dao.UserDao;
import com.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int insertOne(User user) {
        String sql="insert into user (name,age,height,banlance) " +
                    "values(?,?,?,?)";
        return jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getHeight(),user.getBanlance());

    }

    @Override
    public int updateOne(Integer id, Float money) {
        String sql = "update user set banlance = ? where id=?";
        return jdbcTemplate.update(sql,money,id);
    }

    @Override
    public User queryOne(Integer id) {
        String sql="select * from user where id=?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<User>(User.class),id);
    }



}
