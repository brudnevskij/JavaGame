package edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ButtonExit extends ButtonGame{
    private int x;
    private int y;
    private int width;
    private int height;
    private Image label;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    private boolean on;
    private Scene waiter;

    ButtonExit(Scene waiter) {
        this.x = 150;
        this.y = 380;
        this.width = 160;
        this.height = 80;
        this.on = true;
        this.name = "exit";
        this.waiter=waiter;
        loadImage("src/edu/assets/Exit_BTN.png");

    }

    public void loadImage(String path){
        ImageIcon i = new ImageIcon(path);
        this.label = i.getImage();
    }
    public void draw(Graphics g, Scene observer) {
        g.drawImage(label, x, y, width, height, observer);
    }

    public void keyReleased(KeyEvent e) {
        if(on == true){
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_ENTER){
                waiter.switchMenu();
            }
        }
    }

    @Override
    public void pick() {
        setOn(true);
        loadImage("src/edu/assets/Exit_BTN_act.png");

    }

    @Override
    public void unPick() {
        setOn(false);
        loadImage("src/edu/assets/Exit_BTN.png");
    }

    public void keyPressed(KeyEvent e) {
    }
}
