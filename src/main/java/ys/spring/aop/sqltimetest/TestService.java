package ys.spring.aop.sqltimetest;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {
    @Resource
    private FilmDao filmDao;

    public void test() throws NoSuchMethodException {

        System.out.println(filmDao);
    }
}
