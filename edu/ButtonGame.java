package edu;

import javax.swing.*;
import java.awt.*;

public class ButtonGame {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image label;

    public String getName() {
        return name;
    }

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

    public void loadImage(String path){
        ImageIcon i = new ImageIcon(path);
        this.label = i.getImage();
    }
    public void draw(Graphics g, Menu observer) {
        g.drawImage(label, x, y, width, height, observer);
    }


}
