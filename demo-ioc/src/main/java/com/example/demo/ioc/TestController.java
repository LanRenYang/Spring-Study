package com.example.demo.ioc;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * spring 怎么解决bean依赖？ 一个对象从对象被保存在容器中成为bean,必须要经历从singletonFactories到singletonObjects的过程，
 * 不管他是不是需要依赖其他的bean。比如conroller有成员变量service,首先走：
 * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#createBean(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition, java.lang.Object[])方法
 * 它调用构造方法，并把改对象代理成为ObjectFactory对象，以便用于将来创建自己需要的bean对象——> getObjec()——>createBean()——>1),resolveBeforeInstantiation();2),doCreateBean()方法。
 */
@Component
@ComponentScan(value = "com.example.demo.ioc")
public class TestController {

//    @Autowired
//    private TestService testService;

    public TestController() {
        System.out.println("TestController构造方法");
    }

    public void test() {
       // testService.test();
    }

}
