package com.it.study;

import org.apache.ibatis.annotations.CacheNamespace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
@CacheNamespace(blocking = true) // 开启二级缓存的使用
public class SeconLevelCacheTest {

    @Test
    public void test(){

    }
}
