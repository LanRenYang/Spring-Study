package ys.spring.aop.sqltimetest;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FilmTypeDao {

    public FilmTypeEntity selectById(Integer id);
}
