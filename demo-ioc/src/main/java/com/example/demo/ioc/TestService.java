package com.example.demo.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    @Autowired
    private TestController testController;


    private String name;

    public TestService() {
        System.out.println("TestService构造方法");
    }

    public void test() {
        System.out.println("你过来啊");
    }
}
