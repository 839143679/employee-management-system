package com.zjr.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("*/emp/emps").setViewName("/emp/emps");
        //registry.addViewController("emp/emps").setViewName("/emp/emps");
    }
}
