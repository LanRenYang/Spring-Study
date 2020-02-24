package ys.spring.aop.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = MyImportBeanDefinitionRegistrar.class)
public class TestMyImportConfig {



}
