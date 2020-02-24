package ys.spring.aop.sqltimetest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestSqlTimeController {

    @Resource
    private FilmService filmService;

    /**
     * 级联查询查询出 FilmType对象
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "selectFilmById", method = RequestMethod.GET)
    public FilmEntity selectFilmById(@RequestParam(value = "id") Integer id) {
        return filmService.selectFilmById(id);
    }

    /**
     * 关联查询查询出 FilmType对象
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "selectSeById", method = RequestMethod.GET)
    public FilmEntity selectSeById(Integer id) {
        return filmService.selectSeById(id);
    }


    /**
     * 查询两次 用set()
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "selectById", method = RequestMethod.GET)
    public FilmEntity selectById(@RequestParam(value = "id") Integer id) {
        return filmService.selectById(id);
    }
}
