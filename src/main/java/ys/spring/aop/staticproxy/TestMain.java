package ys.spring.aop.staticproxy;

public class TestMain {

    public static void main(String[] args) {
        Player player = new AndreLguodala();
        //创建代理对象，
        Player proxy = new Agent(player);
        HostParty hostParty = new HostParty();
        hostParty.holdCompetition(proxy);
    }
}
