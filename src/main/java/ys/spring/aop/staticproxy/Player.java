package ys.spring.aop.staticproxy;

/**
 * 代理模式的宗旨：1:代理对象和目标对象遵从同一个接口；2：代理对象持有目标对象的引用
 * 静态代理：在编码时已经确定代理对象
 * 球员接口
 */
public interface Player {

    void playBall();
}
