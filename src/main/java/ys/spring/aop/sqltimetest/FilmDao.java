package ys.spring.aop.sqltimetest;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Mapper
@Scope("prototype")  //spring默认bean对象使用单例模式，使用@Scope("prototype")设置bean对象为多例模式，每次对象依赖这个bean,都是创建新的bean对象。
@Component
public interface FilmDao {

    /**
     * 级联查询查询出 FilmType对象
     *
     * @param id
     * @return
     */
    public FilmEntity selectFilmById(Integer id);

    /**
     * 关联查询查询Film对象
     *
     * @param id
     * @return
     */
    public FilmEntity selectSeById(Integer id);


    /**
     * 只查询Film对象
     *
     * @param id
     * @return
     */
    public FilmEntity selectById(Integer id);
}
