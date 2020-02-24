package ys.spring.aop.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ys.spring.aop.sqltimetest.FilmTypeEntity;

@Configuration
public class BeanTestConfig2 {

    /**
     * @Bean注解一般在使用在方法上，用于创建Bean对象，默认情况下方法名做bean名称，也可以指定bean名称
     * 这个方法类似于XML如下形式：
     *  <beans>
     *      <bean id="filmTypeEntityBean",class=""FilmTypeEntity></bean>
     *  </beans>
     * @return
     */
    @Bean("filmTypeEntityBean")
    public FilmTypeEntity createFilm() {
        return new FilmTypeEntity();
    }
}
