package game;

import java.util.ArrayList;

public class Joueur extends Player{

    /**
     * Constructeur
     * @param nom
     * @param position
     * @param posI
     */
    public Joueur(String nom, int position, int posI) {
        super(nom, position, posI);
    }

    /**
     *
     * @param indexCarte
     * @throws Exception
     */
    public void poserCarte(int indexCarte) throws Exception {
        if(this.hand.contains(this.hand.get(indexCarte))){
            System.out.println(this.nom + " pose " + this.getHand().get(indexCarte).toString());
            this.hand.set(indexCarte, null);
        } else { throw new Exception("Card isn't in the player hand"); } // On sait jamais c'est impossible normalement
    }

    /**
     * Ajoute la carte qu'il donne au joueur p
     * Retire la carte qu'il a donné de sa main
     * @param c Carte a donner quand on recommence une partie
     * @param p Quel joueur va recevoir nos cartes
     * @throws Exception Si la carte n'est pas dans la main du Bot
     */
    @Override
    public void donnerCarte(Card c, Player p) throws Exception {
        if(this.hand.contains(c)){
            p.hand.add(c);
            System.out.println(p.nom + " donne " + c.toString());
            this.hand.remove(c);
        } else { throw new Exception("Card isn't in the player hand"); } // On sait jamais c'est impossible normalement
    }

    /**
     * Rédéfinition de méthode
     * @param c
     * @return toujours -1 Joueur n'est pas un bot
     */
    @Override
    public int choixCarteIA(Card c) {
        return -1;
    }

    /**
     * Vérifie si toutes les cartes sont à null
     * Eviter les problèmes d'affichage
     * @return true Si sa main est vide
     * @return false si sa main n'est pas vide
     */
    @Override
    public boolean aFini() {
        for(Object o: this.hand)
            if(!(o == null))
                return false;
        return true;
    }
}
