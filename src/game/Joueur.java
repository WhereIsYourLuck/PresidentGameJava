package game;

import java.util.ArrayList;

public class Joueur extends Player{
    public Joueur(ArrayList<Card> hand, String nom, int positionV, int posI) {
        super(hand, nom, positionV, posI);
    }

    public Joueur(String nom, int position, int posI) {
        super(nom, position, posI);
    }

    public void poserCarte(int indexCarte) throws Exception {
        if(this.hand.contains(this.hand.get(indexCarte))){
            System.out.println(this.nom + " pose " + this.getHand().get(indexCarte).toString());
            this.hand.set(indexCarte, null);
        } else { throw new Exception("Card isn't in the player hand"); } // On sait jamais c'est impossible normalement
    }

    @Override
    public void donnerCarte(Card c, Player p) throws Exception {
        if(this.hand.contains(c)){
            p.hand.add(c);
            System.out.println(p.nom + " donne " + c.toString());
            this.hand.remove(c);
        } else { throw new Exception("Card isn't in the player hand"); } // On sait jamais c'est impossible normalement
    }

    @Override
    public int choixCarteIA(Card c) {
        return -1;
    }

    @Override
    public boolean aFini() {
        for(Object o: this.hand)
            if(!(o == null))
                return false;
        return true;
    }
}
