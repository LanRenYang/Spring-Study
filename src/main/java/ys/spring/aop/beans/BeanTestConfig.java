package ys.spring.aop.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ys.spring.aop.sqltimetest.FilmEntity;

/**
 * SpringBoot中创建bean对象的三种方式指1：@Bean注解
 */
@Configuration
public class BeanTestConfig {

    /**
     * 这个方法类似于XML如下形式：
     * <beans>
     * <bean id="filmEntityBean",class=""FilmEntity></bean>
     * </beans>
     *
     * @return
     */
    @Bean("filmEntityBean")
    public FilmEntity createFilm() {
        FilmEntity filmEntity =  new FilmEntity();
        filmEntity.setFilmName("2");
        return filmEntity;
    }


}
