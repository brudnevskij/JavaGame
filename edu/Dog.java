package edu;

import javax.swing.*;
import java.awt.*;

public class Dog extends Entity {

    private Image image;
    private int dx;
    private int dy;
    private int vertSpeed;
    private boolean shooting;

    Dog(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.vertSpeed = 5;
        this.width = 70;
        this.height = 70;
        this.shooting = false;
        loadImage();
    }

    public void loadImage() {
        ImageIcon i = new ImageIcon("src/edu/assets/dog.png");
        this.image = i.getImage();
    }


    public void draw(Graphics g, Scene observer) {
        g.drawImage(image, x, y, width, height, observer);
    }

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
    public void autoguard(){
        if(Math.random()>= 0.5){
            guard1();
        }
        else {guard2();}
    }


}
