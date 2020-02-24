package ys.spring.aop.dynamicproxy;


/**
 * 演员类
 */
public class Performer implements Ability {

    @Override
    public void ability(int x) {
        System.out.println("我是演员，开机表演,第" + x + "集");
    }
}
