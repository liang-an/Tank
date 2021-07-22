package com.mashibing.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 4;
    private static int WIDTH = 16, HEIGHT = 16;
    private int x, y;
    private Dir dir;
    TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if (bulletDied()){
            return;
        }
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HEIGHT);
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
    }

    //子弹消亡
    private boolean bulletDied(){
        if (x < 0 || y < 0 || x > TankFrame.SCREEN_WIDTH || y > TankFrame.SCREEN_HEIGHT){
            return tf.removeBullet(this);
        }
        return false;
    }
}
