package edu;

import java.awt.*;

/**
 * Paren class of all entities
 */
public abstract class Entity extends Rectangle{



    /**
     * Draws Entity on a Scene
     * @param g
     * @param observer
     */

    public abstract void draw(Graphics g, Scene observer);

    /**
     * Loads a sprite of an entity
     */
    public abstract void loadImage();



}
