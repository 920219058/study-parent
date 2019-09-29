package com.it.study;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.study.demain.User;
import com.it.study.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class RedisTest {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void redisTest() throws Exception{
        String usersListJson = redisTemplate.boundValueOps("user.findAll").get();
        if(usersListJson == null){
            List<User> all = userMapper.queryUserList();
            ObjectMapper objectMapper = new ObjectMapper();
            usersListJson = objectMapper.writeValueAsString(all);
            redisTemplate.boundValueOps("user.findAll").set(usersListJson);
            redisTemplate.expire("user.findAll",600, TimeUnit.SECONDS);
            System.out.println("mysql 的数据："  + usersListJson);
        }else{
            System.out.println("redis 的数据："  + usersListJson);
        }
    }
}
