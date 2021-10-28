package edu;

public class Main {
    public static void main(String[] args) {


        Player pl = new Player(20,20);
        Scene lvl1 = new Scene();
        lvl1.setPlayer(pl);
        GameWindow game = new GameWindow(lvl1);

    }
}
