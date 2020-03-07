package ys.spring.aop.dynamicproxy;

/**
 * 篮球运动员类
 */
public class BasketballPlayers implements Ability {
    @Override
    public void ability(int x) throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("我是篮球运动员，我上场打球,得" + x + "分数");
        Thread.sleep(2000);
    }
}
