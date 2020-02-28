package ys.spring.aop.beans;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;


/**
 * SpringBoot中创建bean对象的三种方式指2：继承FactoryBean接口,FactoryBean的beanName用 & 开头
 * 在根据beanName获取 bean时。如果用myFactoryBean获取，则是获取该FactoryBean创建的对象；
 * 如果用&myFactoryBean获取，则是获取该FactoryBean；
 * 原因：
 * org.springframework.beans.factory.support.DefaultListableBeanFactory#preInstantiateSingletons()方法中有如下判断：
 * if (isFactoryBean(beanName)) {
 * Object bean = getBean(FACTORY_BEAN_PREFIX + beanName)
 * ......
 * }
 * org.springframework.beans.factory.BeanFactory中有定义：string FACTORY_BEAN_PREFIX = &
 */
//@ComponentScan // 该注解修饰在配置类上，spring默认会扫描该类包下的所有配置类，当然也可以通过value属性设置要扫描的类


@Component
public class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        // 这里就只执行一次
        //System.out.println("888888888888888888888888");
        return new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        // 为什么会执行多遍？！
        // System.out.println("666666666666666666666666666");
        return User.class;
    }
}
