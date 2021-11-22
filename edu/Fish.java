package edu;

import javax.swing.*;
import java.awt.*;

/**
 * Class describes main way of getting points - Fish
 */
public class Fish extends Entity {

    private Image image;

    /**
     * Gets X coordinate of the fish
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * Gets Y coordinate of the fish
     * @return
     */
    public double getY() {
        return y;
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

    /**
     * Gets you a random number for X axis
     * @return
     */
    public int getRandomX() {
        return (int) Math.floor(Math.random() * 451);
    }
    /**
     * Gets you a random number for Y axis
     * @return
     */
    public int getRandomY() {
        return (int) Math.floor(Math.random() * (416 - 50) + 50);
    }


    public void draw(Graphics g, Scene observer) {
        g.drawImage(image, x, y, 50, 50, observer);
    }

    /**
     * Changes position of the fish according to bounds
     */
    public void changePos() {
        this.x = getRandomX();
        this.y = getRandomY();
    }
}
