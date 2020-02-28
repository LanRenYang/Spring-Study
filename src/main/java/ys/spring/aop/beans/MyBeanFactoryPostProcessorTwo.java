package ys.spring.aop.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义beanFactry后置处理器
 */
@Component
public class MyBeanFactoryPostProcessorTwo implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // map中以beanName为key,BeanDefinition为value
//        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("filmEntityBean");
        System.out.println("又一个后置处理器");
    }
}
