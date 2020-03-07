package ys.spring.aop.dynamicproxy;

public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        BasketballPlayers basketballPlayers = new BasketballPlayers();
        Ability abilityBasketballPlayers = (Ability) ProxyClass.newProxyInstance(basketballPlayers);
        abilityBasketballPlayers.ability(23);

        System.out.println(TestUtils.num);

        System.out.println("---------------------------------------------------");

//        Performer performer = new Performer();
//        Ability abilityPerformer = (Ability) ProxyClass.newProxyInstance(performer);
//        abilityPerformer.ability(2);


    }
}
