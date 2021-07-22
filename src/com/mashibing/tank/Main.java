package com.mashibing.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //加载地图
        TankFrame tf = new TankFrame();

        //加载坦克
        Tank tank = new Tank(200, 200, true, tf);
        Tank tank2 = new Tank(500, 500, false, tf);
        tf.addTankList(tank);
        tf.addTankList(tank2);


        while (true){
            Thread.sleep(100);
            tf.repaint();
        }

    }
}
