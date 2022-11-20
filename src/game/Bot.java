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
    public void poserCarte(int indexCarte) throws Exception {
        if(this.hand.contains(this.getHand().get(indexCarte))){
            System.out.println(this.nom + " pose " + this.getHand().get(indexCarte).toString());
            this.hand.remove(this.getHand().get(indexCarte));
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
        for(Card a : hand){
            if(c == null){ return this.hand.indexOf(a); } //Si la carte est 2
            if(a.carteAPoseEstPlusGrandeQue(c)){ return this.hand.indexOf(a); }
        }
        return -1; //Si il peut rien poser
    }

    @Override
    public boolean aFini() {
        if(this.hand.isEmpty()){ return true ; }
        else { return false ; }
    }
}
