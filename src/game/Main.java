package game;

import president_GUI.Fenetre_debut_jeu;
import president_GUI.Fenetre_fin_jeu;
import president_GUI.WindowGame;

public class Main {

    public static void main(String[] args) throws Exception {
    Game game = new Game();
    WindowGame jeu = new WindowGame();
    Fenetre_debut_jeu deb = new Fenetre_debut_jeu(game);
    //Fenetre_fin_jeu win = new Fenetre_fin_jeu(game);
    }
}
