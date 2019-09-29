package com.it.study.springboot_quick2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickController {

    @RequestMapping("/test")
    public String test(){
        return "hello SpringBoot quick2";
    }
}
