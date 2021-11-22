package edu;

import javax.swing.*;
import java.awt.*;

/**
 * Parent class of all buttons
 *
 */

public abstract class  ButtonGame {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image label;

    /**
     * gets name of a button
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of a button
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    private String name;


    /**
     * gets state of on field
     * @return
     */
    public boolean isOn() {
        return on;
    }

    /**
     * sets state of field on
     * @param on
     */
    public void setOn(boolean on) {
        this.on = on;
    }

    private boolean on;

    /**
     * Loads sprite from image
     * @param path
     */
    public void loadImage(String path){
        ImageIcon i = new ImageIcon(path);
        this.label = i.getImage();
    }

    /**
     * Draws a button on a Scene
     * @param g
     * @param observer
     */
    public void draw(Graphics g, Scene observer) {
        g.drawImage(label, x, y, width, height, observer);
    }

    /**
     * This methode changes sprite of a button to selected one
     */
    public abstract void pick();
    /**
     * This methode changes sprite of a selected button to regular one
     */
    public abstract void unPick();

}
