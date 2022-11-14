package game;

import president_GUI.Fenetre_debut_jeu;
import president_GUI.Fenetre_fin_jeu;

public class Main {

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Fenetre_debut_jeu Jeu = new Fenetre_debut_jeu(game);
        Fenetre_fin_jeu jeu_fin = new Fenetre_fin_jeu(game);
    }
}
