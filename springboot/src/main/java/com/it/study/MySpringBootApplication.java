package com.it.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 声明该类是一个SpringBoot引用类
public class MySpringBootApplication {
    // main 是java 程序的进口
    public static void main(String[] args) {
        // run方法表示运行SpringBoot的引导类  run参数就是SpringBoot引导类的字节码对象
        SpringApplication.run(MySpringBootApplication.class);
    }
}
