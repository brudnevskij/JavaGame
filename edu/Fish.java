package edu;

import javax.swing.*;
import java.awt.*;

public class Fish extends Entity {

    private Image image;

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    Fish() {
        this.x = getRandomX();
        this.y = getRandomY();
        this.width = 50;
        this.height = 50;
        loadImage();
    }

    public void loadImage() {
        ImageIcon i = new ImageIcon("src/edu/fish.png");
        this.image = i.getImage();
    }

    public int getRandomX() {
        return (int) Math.floor(Math.random() * 451);
    }

    public int getRandomY() {
        return (int) Math.floor(Math.random() * (416 - 50) + 50);
    }


    public void draw(Graphics g, Scene observer) {
        g.drawImage(image, x, y, 50, 50, observer);
    }

    public void changePos() {
        this.x = getRandomX();
        this.y = getRandomY();
    }
}
