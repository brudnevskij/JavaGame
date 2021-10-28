package edu;

import javax.swing.*;
import java.util.ArrayList;

public class GameWindow extends JFrame {


    GameWindow(Scene lvl){
        System.out.println("Gamewindow");
        add(lvl);
        setSize(400,200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

}
