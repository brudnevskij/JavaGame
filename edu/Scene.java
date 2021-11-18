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
    private MenuPannel menuPannel;
    private boolean menu;
    private GameWindow parent;

    public boolean isMenu() {
        return menu;
    }

    public void switchMenu() {
        if (isMenu() == true) {
            warden1.setVertSpeed(5);
            menu = false;
        } else {
            warden1.setVertSpeed(0);
            menu = true;
        }



    }

    Scene(GameWindow window) {
        addKeyListener(new TAdapter());
        player = new Player(240, 250);
        fish = new Fish();
        warden1 = new Dog(20, 20);
        timer = new Timer(10, this);
        parent = window;
        menuPannel = new MenuPannel(this);
        loadImage();
        timer.start();
        setFocusable(true);
        setVisible(true);
        menu = true;
    }

    public void loadImage() {
        ImageIcon i = new ImageIcon("src/edu/assets/notel.png");
        this.bg = i.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, 500, 600, this);
        if(menu == false) {
            if (player.intersects(fish)) {
                fish.changePos();
                player.ateFish();
            }
            if (player.intersects(warden1)) {
                this.player = new Player(250, 250);
                switchMenu();

            }
            player.draw(g, this);
            fish.draw(g, this);
            warden1.draw(g, this);
            Toolkit.getDefaultToolkit().sync();
        }
        else {
            drawMenu(g);
        }
    }
    public void drawMenu(Graphics g){
        menuPannel.draw(g,this);

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
    public void closeWindow(){
        parent.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            if(menu == false)player.keyReleased(e);
            else {
                menuPannel.keyReleased(e);
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(menu == false)player.keyPressed(e);
            else {
            }

        }
    }


}
