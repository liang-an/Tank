package com.mashibing.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 5;
    private static int WIDTH = 15, HEIGHT = 15;
    private int x, y;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
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
}
