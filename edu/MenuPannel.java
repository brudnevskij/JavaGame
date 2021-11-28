package edu;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Panel that contains all the buttons
 */

public class MenuPannel {

    private ArrayList<ButtonGame> buttons;
    private Scene observer;
    private Font sanSerifFont;


    MenuPannel(Scene observer) {
        this.observer = observer;
        buttons = new ArrayList<ButtonGame>();
        buttons.add(new ButtonStart());
        buttons.add(new ButtonScores());
        buttons.add(new ButtonExit());
        sanSerifFont = new Font("SanSerif", Font.PLAIN, 20);

    }

    /**
     * draws a panel on the scene
     * @param g
     * @param observer
     */
    public void draw(Graphics g, Scene observer) {
        for (ButtonGame button : buttons) {
            button.draw(g, observer);
        }
        g.setFont(sanSerifFont);
        g.drawString("Game have been played: " + observer.howManySessions(), 5, 15);
    }

    /**
     * check an arraylist for the Button which field on = true and returns it
     * @return
     */
    public ButtonGame getWorkingGuy(){
        for (ButtonGame button : buttons) {
            if(button.isOn())return button;
        }
        return null;
    }

    /**
     * Methode called when Scene hear that button is pressed, while menu field is true;
     * @param e
     */
    public void keyReleased(KeyEvent e) {
        ButtonGame button = getWorkingGuy();
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            if(button.getName() == "start")observer.switchMenu();
            if(button.getName() == "scores"){}
            if(button.getName() == "exit") {
                observer.saveSession();
                observer.closeWindow();
            }

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


}
