package edu;

import java.awt.*;

public abstract class Entity {

    private int Health;
    private int Modes;
    private Position position;
    public abstract void jump();
    public abstract void run();
    public abstract void draw(Graphics g, Scene observer);
    public void damage(){

    }

}
