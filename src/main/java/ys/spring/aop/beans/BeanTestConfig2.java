package ys.spring.aop.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ys.spring.aop.sqltimetest.FilmTypeEntity;

@Configuration
public class BeanTestConfig2 {

    /**
     * @return
     * @Bean注解一般在使用在方法上，用于创建Bean对象，默认情况下方法名做bean名称，也可以指定bean名称 这个方法类似于XML如下形式：
     * <beans>
     * <bean id="filmTypeEntityBean",class=""FilmTypeEntity></bean>
     * </beans>
     */
    @Bean("filmTypeEntityBean")
    public FilmTypeEntity createFilm() {
        System.out.println("你过来啊");
        FilmTypeEntity filmTypeEntity = new FilmTypeEntity();
        filmTypeEntity.setId(1);
        filmTypeEntity.setFilmType("暖愈人心");
        return filmTypeEntity;





    }
}
