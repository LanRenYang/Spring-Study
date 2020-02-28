package ys.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
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

        User user = (User) context.getBean("user");
        System.out.println(user.getName() + ":" + user.getId());

        User user3 = context.getBean(User.class);
        System.out.println(user3.getName() + ":" + user3.getId());


        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        User user1 = (User) beanFactory.getBean("user");
        System.out.println(user1.getName() + ":" + user1.getId());

        User user2 = beanFactory.getBean(User.class);
        System.out.println(user2.getName() + ":" + user2.getId());

    }


    @Test
    void testMyImportBeanDefinitionRegistrar() {

        // context：Spring环境 Spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestMyImportConfig.class);
        /*
            1,  context在创建时候会调用父类构造方法，为spring创建一个bean工厂：this.beanFactory = new DefaultListableBeanFactory();
                    beanFactory有registerBeanDefinition(String beanName, BeanDefinition beanDefinition),把beanDefinition注册到beanDefinitionMap集合中。
                    程序员可以用BeanDefinitionCustomizer接口完成对BeanDefinition的定制功能
            2,  context.scan();  context有成员变量：ClassPathBeanDefinitionScanner scanner,该对象有 scan(String basePackages)方法扫描包路径;
            3， BeanFactoryPostProcessor bean工厂后置处理器。context中有成员变量---> List<BeanFactoryPostProcessor> beanFactoryPostProcessors

         */

        context.scan();
        System.out.println("-------------->" + context.getBean("user"));
    }

    @Test
    void testBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanTestConfig.class);
        FilmEntity filmEntityBean = (FilmEntity) context.getBean("filmEntityBean");
        System.out.println(filmEntityBean.getFilmName());
    }

    @Test
    void testMy() {
        // bean工厂后置处理器？我们可以自定义类继承该接口，定义自己的bean工厂后置处理器，spring会先后执行后置处理器
        //BeanFactoryPostProcessor beanFactoryPostProcessor;
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanTestConfig.class);

        /*
            实质上context.registerBean()调用了beanFactory.registerBeanDefinition(),这个方法里面做了beanDefinitionMap.put(beanName, beanDefinition)操作。
               一下是registerBean()的重载：
         */
//         context.registerBean("ldk", A.class);
//        context.registerBean("LDK", A.class, new MyBeanDefinitionOne(), new MyBeanDefinitionTwo());
//        context.registerBean("ldk", A.class,
//                new BeanDefinitionCustomizer() {
//                    @Override
//                    public void customize(BeanDefinition bd) {
//
//                    }
//                }, new BeanDefinitionCustomizer() {
//                    @Override
//                    public void customize(BeanDefinition bd) {
//
//                    }
//                });

        System.out.println(context.getBean("filmEntityBean"));
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        beanFactory.registerBeanDefinition("user", new RootBeanDefinition());
    }
}
