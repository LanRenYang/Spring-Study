package ys.spring.aop.staticproxy;


/**
 * 经纪人类
 */
public class Agent implements Player {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Agent(Player player) {
        this.player = player;
    }

    @Override
    public void playBall() {
        contactTalks();
        player.playBall();
        complete();
    }

    private void contactTalks() {
        System.out.println("经纪人酬劳争取");
    }

    private void complete() {
        System.out.println("经纪人事后善尾");
    }
}
