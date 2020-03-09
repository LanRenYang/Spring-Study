package ys.spring.aop.dynamicproxy;


/**
 * 演员类
 */
public class Performer implements Ability {

    @Override
    public void ability(int x) throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("我是演员，开机表演,第" + x + "集");
        Thread.sleep(2000);
    }
}
