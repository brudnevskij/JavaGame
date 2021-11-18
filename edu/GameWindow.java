package edu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameWindow extends JFrame {
    private Scene lvl;


    GameWindow(){
        lvl = new Scene();
        add(lvl);
        setSize(500,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
