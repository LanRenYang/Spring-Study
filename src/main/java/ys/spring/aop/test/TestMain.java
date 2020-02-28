package ys.spring.aop.test;

public class TestMain {
    public static void main(String[] args) {

        //  子类的创建一定需要依赖父类的构造方法。默认调用父类无参构造放法，只是默认super()省略。这也是java继承关系上单继承的原因。
        C c = new C();

        System.out.println(A.class.getName());
    }
}
