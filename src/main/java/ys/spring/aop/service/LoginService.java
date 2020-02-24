package ys.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String login() {
        System.out.println("登录成功,欢迎你");
        try {
            int a = 8 / 0;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return "登录成功,欢迎你";
    }
}
