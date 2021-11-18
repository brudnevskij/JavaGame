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

    private Image bg;
    private Player player;
    private Timer timer;
    private Fish fish;
    private Dog warden1;
    private boolean menu;
//    private GameWindow upListener;
    Scene() {
        addKeyListener(new TAdapter());
        player = new Player(240, 250);
        fish = new Fish();
        warden1 = new Dog(20, 20);
        timer = new Timer(10, this);
//        upListener = window;
        loadImage();
        timer.start();
        setFocusable(true);
        setVisible(true);
        System.out.println("scene started");
    }

    public void loadImage() {
        ImageIcon i = new ImageIcon("src/edu/assets/notel.png");
        this.bg = i.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, 500, 600, this);
        if (player.intersects(fish)) {
            fish.changePos();
            player.ateFish();
        }
        if (player.intersects(warden1)) {
            this.player = new Player(250, 250);
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
    }

    public void pause() {
        setVisible(false);
        setFocusable(false);
        timer.stop();
    }

    public void unPause() {
        setVisible(true);
        setFocusable(true);
        timer.start();
        System.out.println("afsaf");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);

        }
    }


}
