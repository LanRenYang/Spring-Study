package ys.spring.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ys.spring.aop.service.LoginService;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "aop/")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return loginService.login();
    }
}
