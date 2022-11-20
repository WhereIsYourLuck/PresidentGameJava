package game;

import java.util.ArrayList;

public class Joueur extends Player{
    public Joueur(ArrayList<Card> hand, String nom, int positionV, int posI) {
        super(hand, nom, positionV, posI);
    }

    public Joueur(String nom, int position, int posI) {
        super(nom, position, posI);
    }

    @Override
    public void poserCarte(Card posee) throws Exception {

    }

    public void poserCarte(int indexCarte) throws Exception {
        if(this.hand.contains(this.hand.get(indexCarte))){
            this.hand.set(indexCarte, null);
        } else { throw new Exception("Card isn't in the player hand"); } // On sait jamais c'est impossible normalement
    }

    @Override
    public void donnerCarte(Card c, Player p) throws Exception {
        if(this.hand.contains(c)){
            p.hand.add(c);
            this.hand.remove(c);
            System.out.println(p.nom + " donne " + c.toString());
        } else { throw new Exception("Card isn't in the player hand"); } // On sait jamais c'est impossible normalement
    }

    @Override
    public Card choixCarteIA(Card c) {
        return null;
    }

    @Override
    public boolean aFini() {
        for(Object o: this.hand)
            if(!(o == null))
                return false;
        return true;
    }
}
