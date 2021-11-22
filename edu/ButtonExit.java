package edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
/**
Button that provides exit from the game


 */

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

    ButtonExit() {
        this.x = 150;
        this.y = 380;
        this.width = 160;
        this.height = 80;
        this.on = true;
        this.name = "exit";
        loadImage("src/edu/assets/Exit_BTN.png");

    }

    /**
     * Methode that loads  sprite from image
     *
     * @param path
     */
    public void loadImage(String path){
        ImageIcon i = new ImageIcon(path);
        this.label = i.getImage();
    }

    /**
     * Methode that draws button on Scene
     *
     * @param g
     * @param observer
     */
    public void draw(Graphics g, Scene observer) {
        g.drawImage(label, x, y, width, height, observer);
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
}
