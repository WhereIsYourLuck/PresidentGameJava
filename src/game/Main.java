package game;

import president_GUI.WindowGame;

public class Main {

    public static void main(String[] args) {
    Game game = new Game();


    System.out.println(game.deck.getCards());
    game.distribuer();
    System.out.println(game.p1.getHand());
    System.out.println(game.p2.getHand());
        System.out.println(game.p3.getHand());
        System.out.println(game.p4.getHand());

        WindowGame jeu = new WindowGame();
    }
}
