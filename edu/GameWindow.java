package edu;

import javax.swing.*;
import java.util.ArrayList;

public class GameWindow extends JFrame {


    GameWindow(Scene lvl){
        System.out.println("Gamewindow");
        add(lvl);
        setSize(500,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

}
