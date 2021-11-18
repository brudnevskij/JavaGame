package edu;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MenuPannel {

    private ButtonStart start;
    private ButtonScores scores;
    private ButtonExit exit;
    private ArrayList<ButtonGame> buttons;
    private Scene observer;

    MenuPannel(Scene observer) {
        this.observer = observer;
        buttons = new ArrayList<ButtonGame>();
        buttons.add(new ButtonStart(observer));
        buttons.add(new ButtonScores(observer));
        buttons.add(new ButtonExit(observer));

    }

    public void draw(Graphics g, Scene observer) {
        for (ButtonGame button : buttons) {
            button.draw(g, observer);
        }
    }
    public ButtonGame getWorkingGuy(){
        for (ButtonGame button : buttons) {
            if(button.isOn())return button;
        }
        return null;
    }

    public void keyReleased(KeyEvent e) {
        ButtonGame button = getWorkingGuy();
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            if(button.getName() == "start")observer.switchMenu();
            if(button.getName() == "scores"){}
            if(button.getName() == "exit")observer.closeWindow();

        }
        if (key == KeyEvent.VK_DOWN) {
            if (button.getName()=="start"){
                buttons.get(0).unPick();
                buttons.get(1).pick();
            }
            if (button.getName() == "scores"){
                buttons.get(1).unPick();
                buttons.get(2).pick();
            }
        }
        if (key == KeyEvent.VK_UP) {
            if (button.getName()=="scores"){
                buttons.get(1).unPick();
                buttons.get(0).pick();
            }
            if (button.getName() == "exit"){
                buttons.get(2).unPick();
                buttons.get(1).pick();
            }
        }
    }

    public void keyPressed(KeyEvent e) {
    }
}
