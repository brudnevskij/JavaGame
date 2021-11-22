package edu;

import javax.swing.*;
import java.awt.*;

/**
 * Class describes tha logic of main foe of the game
 */

public class Dog extends Entity {

    private Image image;
    private int dx;
    private int dy;


    /**
     * Sets speed of a Dog
     * @param vertSpeed
     */
    public void setVertSpeed(int vertSpeed) {
        this.vertSpeed = vertSpeed;
    }

    private int vertSpeed;

    Dog(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.vertSpeed = 1;
        this.width = 70;
        this.height = 70;
        loadImage();
    }

    public void loadImage() {
        ImageIcon i = new ImageIcon("src/edu/assets/dog.png");
        this.image = i.getImage();
    }


    public void draw(Graphics g, Scene observer) {
        g.drawImage(image, x, y, width, height, observer);
    }

    /**
     * First option of movement
     */
    public void guard1() {
        if(x >= 400){
            dx = -1*vertSpeed;
        }
        else if(x <= 20) {
            dx = vertSpeed;
        }
        x = x + dx;
        y = y + dy;
    }
    /**
     * Second option of movement
     */
    public void guard2() {
        if(y >= 400){
            dy = -1*vertSpeed;
        }
        else if(y <= 20) {
            dy = vertSpeed;
        }
        x = x + dx;
        y = y + dy;
    }

    /**
     * This methode emulates random passing
     */

    public void autoguard(){
        if(Math.random()>= 0.5){
            guard1();
        }
        else {guard2();}
    }


}
