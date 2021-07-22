package com.mashibing.tank;

import com.sun.corba.se.impl.protocol.giopmsgheaders.KeyAddr;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    public static final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = 800;


    private List<Tank> tankList = new ArrayList<>();
    private List<Bullet> bulletList = new ArrayList<>();




    Image offScreenImage = null;

    /**
     * 构造器
     * @throws HeadlessException
     */
    public TankFrame() throws HeadlessException {
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {

        for (int i = 0; i < tankList.size(); i++) {
            tankList.get(i).paint(g);
        }

        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }

        g.drawString("子弹数量：" + bulletList.size(), 10, 60);


    }

    private class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            for (int i = 0; i < tankList.size(); i++) {
                if (tankList.get(i).isFriend()){
                    tankList.get(i).keyPressed(e);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            for (int i = 0; i < tankList.size(); i++) {
                if (tankList.get(i).isFriend()){
                    tankList.get(i).keyReleased(e);
                }
            }
        }

    }


    /**
     * 双缓冲解决图形闪烁问题
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null){
            offScreenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        gOffScreen.fillRect(0, 0, SCREEN_WIDTH, SCREEN_WIDTH);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    public List<Tank> getTankList() {
        return tankList;
    }

    public void setTankList(List<Tank> tankList) {
        this.tankList = tankList;
    }

    public List<Bullet> getBulletList() {
        return bulletList;
    }

    public void setBulletList(List<Bullet> bulletList) {
        this.bulletList = bulletList;
    }

    public void addBulletList(Bullet bullet) {
        this.bulletList.add(bullet);
    }

    public void addTankList(Tank tank) {
        this.tankList.add(tank);
    }

    public boolean removeBullet(Bullet bullet){
        return this.bulletList.remove(bullet);
    }
}
