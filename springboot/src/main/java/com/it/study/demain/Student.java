package com.it.study.demain;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer userId;
    private String userName;
    private String userAddr;
    private Integer userAge;
    // 一对多的关系映射：一个用户多个用户
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAddr='" + userAddr + '\'' +
                ", userAge=" + userAge +
                ", account=" + account +
                '}';
    }
}
