package edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
/**
*   This is main window that contains scene where
*  everything is happening.
 */


public class GameWindow extends JFrame {

    private Scene lvl;


    GameWindow(){
        lvl = new Scene(this);
        add(lvl);
        setSize(500,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
