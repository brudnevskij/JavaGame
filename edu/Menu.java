package edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Menu extends JPanel implements ActionListener {
    private Timer timer;
    private ButtonStart start;
    private GameWindow listener;
    private ArrayList<ButtonGame>buttons;
    Menu(GameWindow window){
        System.out.println("Gamewindow");
        listener =window;
        addKeyListener(new TAdapter());
        start = new ButtonStart();
        buttons = new ArrayList<ButtonGame>();
//        buttons.add(start);
        timer = new Timer(10, this);
        setFocusable(true);
        setVisible(true);
//        timer.start();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        start.draw(g,this);
        Toolkit.getDefaultToolkit().sync();
    }
    public void step(){
        repaint();
    }
    public void pause(){
//        setVisible(false);
//        setFocusable(false);
        timer.stop();
    }
    public void unPause() {
//        setVisible(true);
//        setFocusable(true);
        timer.start();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }
    public String checkOn(){
        for(ButtonGame button : buttons){
           if(button.isOn()==true)return button.getName();
        }
        return null;
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_ENTER){
                System.out.println("faedqaef");
//                listener.toLvl();
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }
    }

}
