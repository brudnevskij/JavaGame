package edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Scene extends JPanel implements ActionListener {

    public void setPlayer(Player player) {
        this.player = player;
    }


    private Player player;
    private Timer timer;
    private Fish fish;
    private Dog warden1;
    Scene() {
        System.out.println("Scene");
        addKeyListener(new TAdapter());
        setFocusable(true);
        fish = new Fish();
        warden1 = new Dog(20,20);
        timer = new Timer(10, this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (player.intersects(fish)) {
            fish.changePos();
            player.ateFish();
        }
        if(player.intersects(warden1)){
            this.player = new Player(250,250);
        }
        player.draw(g, this);
        fish.draw(g, this);
        warden1.draw(g, this);
        Toolkit.getDefaultToolkit().sync();
    }

    public void step() {
        player.move();
        warden1.autoguard();
        repaint();
        System.out.println(Math.random());
    }

    public void destr() {
//        this.setVisible(false);
        timer.stop();
    }
    public void undestr() {
//        this.setVisible(false);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        step();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
            int key = e.getKeyCode();

            if(key == KeyEvent.VK_SPACE){
                undestr();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            int key = e.getKeyCode();

            if(key == KeyEvent.VK_SPACE){
                destr();
            }
        }
    }


}
