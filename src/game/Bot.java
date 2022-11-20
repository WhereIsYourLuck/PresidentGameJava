package game;

import java.util.ArrayList;

public class Bot extends Player{
    public Bot(ArrayList<Card> hand, String nom, int positionV, int posI) {
        super(hand, nom, positionV, posI);
    }

    public Bot(String nom, int position,  int posI) {
        super(nom, position,  posI);
    }

    @Override
    public void poserCarte(Card posee) throws Exception {
        if(this.hand.contains(posee)){
            this.hand.remove(posee);
            System.out.println(this.nom + " pose " + posee.toString());
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
        for(Card a : hand){
            if(c == null){ return a; } //Si la carte est 2
            if(c.isSmallerThan(a)){ return a; }
        }
        return null; //Si il peut rien poser
    }

    @Override
    public boolean aFini() {
        if(this.hand.isEmpty()){ return true ; }
        else { return false ; }
    }

}
