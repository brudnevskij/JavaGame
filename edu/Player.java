package edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Player extends Entity {
    private int score;
    private Image defaultImage;
    private Image actionImage;
    private int dx;
    private int dy;
    private int counter;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


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

    int speed;

    Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.score = 0;
        this.counter = 100;
        this.speed = 4;
        loadImage();
        loadImage("src/edu/evilcat.png");
    }

    public void loadImage() {
        ImageIcon i = new ImageIcon("src/edu/cat.png");
        this.defaultImage = i.getImage();
    }

    public void loadImage(String path) {
        ImageIcon i = new ImageIcon(path);
        this.actionImage = i.getImage();
    }

    public void destroyCounter() {
        this.counter = 0;
    }

    public void ateFish() {
        this.score++;
        this.width++;
        this.height++;
        this.counter = 0;
    }

    public void draw(Graphics g, Scene observer) {
        if (this.counter <= 50) {
            g.drawImage(actionImage, x, y, width, height, observer);
            this.counter++;
            speed = 6;
        } else {
            g.drawImage(defaultImage, x, y, width, height, observer);
            speed = 4;
        }
        Font sanSerifFont = new Font("SanSerif", Font.PLAIN, 20);
        g.setFont(sanSerifFont);
        g.drawString("score: " + score, 5, 15);
    }


    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if (key == KeyEvent.VK_SPACE) {
            this.score++;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


        if (key == KeyEvent.VK_RIGHT) {
            dx = speed;
        }
        if (key == KeyEvent.VK_LEFT) {
            dx = -speed;

        }
        if (key == KeyEvent.VK_UP) {
            dy = -speed;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = speed;
        }
    }

    public void move() {
        if(this.x >= 485 - width)if(dx > 0) dx = 0;

        if(this.x<=1)if(dx<0) dx = 0;

        if(this.y <= 1)if(dy < 0)dy =0;

        if(this.y >= 460-height)if(dy>0)dy=0;
        x = x + dx;
        y = y + dy;
    }


}
