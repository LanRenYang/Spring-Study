package ys.spring.aop.sqltimetest;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FilmService {

    @Resource
    private FilmDao filmDao;
    @Resource
    private FilmTypeDao filmTypeDao;

    /**
     * 级联查询查询出 FilmType对象 （查询效率最快）
     *
     * @param id
     * @return
     */
    public FilmEntity selectFilmById(Integer id) {
        System.out.println("你过来啊------》" + filmDao);
        return filmDao.selectFilmById(id);
    }


    /**
     * 关联查询查询出 FilmType对象 （查询效率居中）
     *
     * @param id
     * @return
     */
    public FilmEntity selectSeById(Integer id) {
        System.out.println("你过来啊------》" + filmDao);
        return filmDao.selectSeById(id);
    }

    /**
     * 查询两次，用set() （查询效率最慢）
     *
     * @param id
     * @return
     */
    public FilmEntity selectById(Integer id) {
        FilmEntity filmEntity = filmDao.selectById(id);
        filmEntity.setFilmType(filmTypeDao.selectById(filmEntity.getFilmTypeId()));
        return filmEntity;
    }
}
