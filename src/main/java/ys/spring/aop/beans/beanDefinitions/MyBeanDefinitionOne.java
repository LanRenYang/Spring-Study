package ys.spring.aop.beans.beanDefinitions;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;

public class MyBeanDefinitionOne implements BeanDefinitionCustomizer {

    @Override
    public void customize(BeanDefinition bd) {
        // 这里完成对BeanDefinition的改变或者说是定制。
    }
}
