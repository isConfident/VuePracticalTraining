package com.foreground.entity;

import java.util.List;

public class User {
    private int id;
    private String userName;
    private String userPassword;

    private Integer age;
    private String birthday;


    public User() {
    }

    public User(int id, String userName, String userPassword, Integer age, String birthday) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.age = age;
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String toString() {
        return "User{id = " + id + ", userName = " + userName + ", userPassword = " + userPassword + ", age = " + age + ", birthday = " + birthday + "}";
    }
}
