package ys.spring.aop.sqltimetest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SqlTestAOP {



    /**
     * 引入点
     * value 属性传入方法： 修饰符 返回类型 具体方法名(参数)
     */
    @Pointcut(value = "execution(* ys.spring.aop.sqltimetest.FilmService.*(..))")
    public void sqlTime() {
    }


    @Around(value = "sqlTime()")
    public Object time(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object o = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("查询耗时：" + (end - start) + "毫秒");
        return o;
    }
}
