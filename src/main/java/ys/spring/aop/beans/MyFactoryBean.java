//package ys.spring.aop.beans;
//
//import org.springframework.beans.factory.FactoryBean;
//import org.springframework.stereotype.Component;
//
//
///**
// * SpringBoot中创建bean对象的三种方式指2：继承FactoryBean接口
// */
//@Component
//public class MyFactoryBean implements FactoryBean {
//
//    @Override
//    public Object getObject() throws Exception {
//        // 这里就只执行一次
//        System.out.println("888888888888888888888888");
//        return new Dog();
//    }
//
//    @Override
//    public Class<?> getObjectType() {
//        // 为什么会执行多遍？！
//        System.out.println("666666666666666666666666666");
//        return User.class;
//    }
//}
