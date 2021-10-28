package edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Scene extends JPanel implements ActionListener {
    private ArrayList<Entity> guys;

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Player player;
    private Timer timer;

    Scene(){
        System.out.println("Scene");
        addKeyListener(new TAdapter());
        guys = new ArrayList<Entity>();
        timer = new Timer(50, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        guys.forEach(guy -> guy.draw(g, this));
        player.draw(g, this);
    }


    public void addEntity(Entity e){
        guys.add(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("test");
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }



}
