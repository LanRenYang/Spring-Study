package ys.spring.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {


    /**
     * 前置通知
     */
    @Before(value = "execution(* ys.spring.aop.aop.service.*.*(..))")
    public void testBefore(JoinPoint joinPoint) {
        System.out.println("前置通知");
    }

    /**
     * 后置通知
     */
    @After(value = "execution(* ys.spring.aop.aop.service.*.*(..))")
    public void testAfter() {
        System.out.println("后置通知");
    }


    /**
     * 正常返回通知。方法返回结果之后执行
     */
    @AfterReturning(value = "execution(* ys.spring.aop.aop.service.*.*(..))")
    public void testAfterReturning() {
        System.out.println("正常返回通知");
    }

    /**
     * 异常返回通知。方法执行过程中抛出异常时执行
     */
    @AfterThrowing(value = "execution(* ys.spring.aop.aop.service.*.*(..)))")
    public void testAfterThrowing() {
        System.out.println("异常返回通知");
    }

    /**
     * 引入点
     * value 属性传入方法： 修饰符 返回类型 具体方法名(参数)
     */
    @Pointcut(value = "execution(* ys.spring.aop.aop.service.*.*(..))")
    public void loginPointcut() {
    }

    /**
     * A环绕通知使用
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around(value = "loginPointcut()")
    public Object testAroundA(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前A");
        Object o = joinPoint.proceed();
        System.out.println("环绕通知后A");
        return o;
    }

    /**
     * B环绕通知使用
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around(value = "loginPointcut()")
    public void testAroundB(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前B");
        joinPoint.proceed();
        System.out.println("环绕通知后B");
    }
}
