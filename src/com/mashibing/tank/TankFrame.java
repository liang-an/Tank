package com.mashibing.tank;

import com.sun.corba.se.impl.protocol.giopmsgheaders.KeyAddr;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank tank = new Tank(200, 200);
    private static final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;

    Image offScreenImage = null;

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
        tank.paint(g);

    }

    private class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            tank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            tank.keyReleased(e);
        }

    }
}
