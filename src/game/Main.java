package game;

import president_GUI.WindowGame;

public class Main {

    public static void main(String[] args) throws Exception {
    Game game = new Game();
    game.distribuer();
    System.out.println(game.p1.toString());
        WindowGame jeu = new WindowGame();
    }
}
