package ys.spring.aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 负责完成代理对象对目标对象的代理
 */
public class ProxyClass {

    /**
     * 根据目标对象静态生成代理对象
     *
     * @param target
     * @return
     */
    public static Object newProxyInstance(Object target) {
        // 三个参数意思 1：目标对象的类加载器；2：目标对象继承的接口，代理对象也需要继承这个接口；3：代理对象的功能扩展
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new MyInvocationHandler(target));
    }

    /**
     * 静态内部类，代理对象的实现，对目标对象的方法进行扩展。
     */
    private static class MyInvocationHandler implements InvocationHandler {
        private Object target;

        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            testBefore();
            Object o = method.invoke(target, args);
            testAfter();
            return o;
        }

        /**
         * 目标对象执行前的执行方法
         */
        private void testBefore() {
            TestUtils.num++;
            System.out.println("经纪人酬劳争取");
        }

        /**
         * 目标对象执行后的执行方法
         */
        private void testAfter() {
            TestUtils.num++;
            System.out.println("经纪人善后");
        }


        /**
         * 目标对象执行后的执行方法
         */
        private void test() {
            System.out.println("一个测试方法");
        }
    }
}
