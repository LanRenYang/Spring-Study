package ys.spring.aop.dynamicproxy;

public class TestMain {

    public static void main(String[] args){
        BasketballPlayers basketballPlayers = new BasketballPlayers();
        Ability abilityBasketballPlayers = (Ability) ProxyClass.newProxyInstance(basketballPlayers);
        abilityBasketballPlayers.ability(23);

        System.out.println("---------------------------------------------------");

        Performer performer = new Performer();
        Ability abilityPerformer = (Ability) ProxyClass.newProxyInstance(performer);
        abilityPerformer.ability(2);


    }
}
