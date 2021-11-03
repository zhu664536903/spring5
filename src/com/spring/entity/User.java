package com.spring.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 88544137839706100L;
    private Integer id;
    private String name;
    private Integer age;
    private Float height;
    private Float banlance;

    public User() {
    }

    public User(Integer id, String name, Integer age, Float height,Float banlance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.banlance = banlance;
    }

    public User(String name, Integer age, Float height, Float banlance) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.banlance = banlance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getBanlance() {
        return banlance;
    }

    public void setBanlance(Float banlance) {
        this.banlance = banlance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", banlance=" + banlance +
                '}';
    }
}
