package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x, y;
    private Dir dir = Dir.UP;
    private final static int SPEED = 10;
    private boolean moving = false;
    private boolean shoot = false;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        if (moving){
            tankMoving();
        }
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        if (shoot){
            shootBullet(g);
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
                shoot = true;
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
//                shoot = false;
            default:
                break;
        }
    }

    private void shootBullet(Graphics g) {
        Bullet bullet = new Bullet(x, y, dir);
        bullet.paint(g);
    }
}
