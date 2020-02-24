package ys.spring.aop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy  // 开启aop
@MapperScan(value = "ys.spring.aop.aop.sqltimetest")
public class SpringAopApplication {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext=
//                new AnnotationConfigApplicationContext();
//        LoginService loginService = annotationConfigApplicationContext.getBean(LoginService.class);
//        loginService.login();
        SpringApplication.run(SpringAopApplication.class, args);
    }

}
