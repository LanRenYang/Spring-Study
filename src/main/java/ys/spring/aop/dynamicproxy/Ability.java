package ys.spring.aop.dynamicproxy;

/**
 * 代理模式的宗旨：1:代理对象和目标对象遵从同一个接口；2：代理对象持有目标对象的引用
 * 动态代理，代理对象在运行时根据目标对象创建，
 * 本领接口
 */
public interface Ability {

     void ability(int x) throws InterruptedException;
}
