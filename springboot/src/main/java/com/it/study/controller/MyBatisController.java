package com.it.study.controller;

import com.it.study.demain.User;
import com.it.study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MyBatisController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/mybatis")
    public List<User> queryAllUser(){
        List<User> users = userMapper.queryUserList();
        return users;
    }
}
