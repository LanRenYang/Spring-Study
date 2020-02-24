package ys.spring.aop.beans;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // Definition定义
        RootBeanDefinition definition = new RootBeanDefinition(User.class);
        definition.getPropertyValues().add("name","刘").add("id",18);
        // Registrar注册
        registry.registerBeanDefinition("user", definition);

    }
}
