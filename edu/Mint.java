package edu;

import javax.swing.*;
import java.awt.*;

/**
 * Class describes bonus entity Mint
 */

public class Mint extends Entity{
    private Image image;

    /**
     * gets X coordinate
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * gets Y coordinate
     * @return
     */
    public double getY() {
        return y;
    }



    Mint() {
        this.x = 600;
        this.y = 600;
        this.width = 50;
        this.height = 50;
        loadImage();
    }

    public void loadImage() {
        ImageIcon i = new ImageIcon("src/edu/assets/mint.png");
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

    /**
     * Hides Mint away from map
     */
    public void vanish(){
        x = 600;
        y = 600;
    }

    /**
     * Spawns a mint on the map
     */
    public void spawn() {
        x = getRandomX();
        y = getRandomY();
    }
}
