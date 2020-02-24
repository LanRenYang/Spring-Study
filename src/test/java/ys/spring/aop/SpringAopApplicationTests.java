package ys.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ys.spring.aop.beans.BeanTestConfig;
import ys.spring.aop.beans.TestMyImportConfig;
import ys.spring.aop.beans.User;
import ys.spring.aop.sqltimetest.FilmEntity;

@SpringBootTest
class SpringAopApplicationTests {


    @Test
    void contextLoads() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestMyImportConfig.class);

        //bean工厂
        DefaultListableBeanFactory factory = context.getDefaultListableBeanFactory();
        //bean定义器
        RootBeanDefinition definition = new RootBeanDefinition(User.class);

        definition.getPropertyValues().add("name", "LDK");
        // 工厂根据bean定义在map中注册bean
        factory.registerBeanDefinition("userBean", definition);
        User userBean = (User) context.getBean("userBean");
        System.out.println(userBean.getName() + ":" + userBean.getId() + "!");

        // 设置bean工厂中的bean是否允许被重新定义
        factory.setAllowBeanDefinitionOverriding(false);

        definition.getPropertyValues().add("name", "ldk");
        factory.registerBeanDefinition("userBean1", definition);
        User userBean1 = (User) context.getBean("userBean1");
        System.out.println(userBean1.getName() + ":" + userBean1.getId() + "!");


//        MutablePropertyValues mutablePropertyValues = definition.getPropertyValues();
//        mutablePropertyValues.add("id", 18);
//        mutablePropertyValues.add("name", "刘");
//        PropertyValue[] propertyValues = mutablePropertyValues.getPropertyValues();
//        System.out.println(propertyValues.length);
//        for (PropertyValue value : propertyValues) {
//            System.out.println(value.getName() + ":" + value.getValue());
//        }
    }


    @Test
    void testMyImportBeanDefinitionRegistrar() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestMyImportConfig.class);
        System.out.println("-------------->" + context.getBean("user"));
    }

    @Test
    void testBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanTestConfig.class);
        FilmEntity filmEntityBean = (FilmEntity) context.getBean("filmEntityBean");
        System.out.println(filmEntityBean.getFilmName());
    }

}
