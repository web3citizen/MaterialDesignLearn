package com.example.lwp.design.bean;

public class UserBuilder {
    private String name;
    private String pwd;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    public User createUser() {
        return new User(name, pwd);
    }
}