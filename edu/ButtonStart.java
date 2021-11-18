package edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ButtonStart extends ButtonGame {

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

    ButtonStart() {
        this.x = 150;
        this.y = 240;
        this.width = 160;
        this.height = 80;
        this.on = true;
        this.name = "start";
        loadImage("src/edu/assets/Start_BTN.png");

    }

    public void loadImage(String path){
        ImageIcon i = new ImageIcon(path);
        this.label = i.getImage();
    }
    public void draw(Graphics g, Menu observer) {
        g.drawImage(label, x, y, width, height, observer);
    }

    public void keyReleased(KeyEvent e) {
        if(on == true){
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_ENTER){

            }
        }
    }

    public void keyPressed(KeyEvent e) {
    }
}
