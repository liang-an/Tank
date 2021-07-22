package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x, y;
    private Dir dir = Dir.UP;
    private final static int SPEED = 10;
    private boolean moving = false;
    private boolean fire = false;
    private boolean friend = true;
    private TankFrame tf = null;

    public Tank(int x, int y, boolean friend, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.friend = friend;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (moving){
            tankMoving();
        }
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        if (fire){
            fire(g);
        }
    }

    private void tankMoving() {
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

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dir = Dir.UP;
                moving = true;
                break;
            case KeyEvent.VK_RIGHT:
                dir = Dir.RIGHT;
                moving = true;
                break;
            case KeyEvent.VK_DOWN:
                dir = Dir.DOWN;
                moving = true;
                break;
            case KeyEvent.VK_LEFT:
                dir = Dir.LEFT;
                moving = true;
                break;
            case KeyEvent.VK_SPACE:
                fire = true;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                moving = false;
                break;
            case KeyEvent.VK_RIGHT:
                moving = false;
                break;
            case KeyEvent.VK_DOWN:
                moving = false;
                break;
            case KeyEvent.VK_LEFT:
                moving = false;
                break;
            case KeyEvent.VK_SPACE:
                fire = false;
            default:
                break;
        }
    }

    private void fire(Graphics g) {
        Bullet bullet = new Bullet(x+17, y+17, dir, tf);
        tf.addBulletList(bullet);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public boolean isFriend() {
        return friend;
    }

    public void setFriend(boolean friend) {
        this.friend = friend;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }
}
