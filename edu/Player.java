package edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Player extends Entity{
    private int score;
    private int lives;
    private Image image;
    private Position position;

    Player(int x, int y){
        this.position = new Position(x,y);
        loadImage();
    }
    public void loadImage(){
        ImageIcon i = new ImageIcon("src/edu/cat.png");
        this.image = i.getImage();
    }
    @Override
    public void jump() {

    }
    public void draw(Graphics g, Scene observer){
        g.drawImage(image, this.position.x, this.position.y, 50,50,observer );
        Toolkit.getDefaultToolkit().sync();
//        System.out.println("act perf");

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        System.out.println("works "+ key);

        if(key == KeyEvent.VK_RIGHT){
            System.out.println("works "+ key);
        }
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        System.out.println("works "+ key);

        if(key == KeyEvent.VK_RIGHT){
            System.out.println("works "+ key);
            this.run();
        }
    }
    public void run(){
    position.x = position.x+1;
    }

}
