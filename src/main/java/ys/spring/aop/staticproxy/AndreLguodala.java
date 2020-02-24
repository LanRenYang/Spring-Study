package ys.spring.aop.staticproxy;


/**
 * 球员伊戈达拉
 */
public class AndreLguodala implements Player {

    @Override
    public void playBall() {
        System.out.println("伊戈达拉上场打球");
    }

}
