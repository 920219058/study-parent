package com.it.study.controller;

import com.it.study.demain.User;
import com.it.study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class MyBatisController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/mybatis")
    public List<User> queryAllUser(){
        List<User> users = userMapper.queryUserList();
        return users;
    }

    @RequestMapping("/redis")
    public void testRedis(){
        redisTemplate.boundValueOps(1).setIfAbsent("abc",30, TimeUnit.SECONDS);

    }
}
