package game;

import java.util.ArrayList;

public abstract class Player {
    ArrayList<Card> hand = new ArrayList();
    String nom;
    int positionVictoire; //Sert pour les parties d'après
    int positionInitiale; //Sert pour faire le sens du jeu = Valeur qui ne bouge pas à chaque nouvelle partie

    public Player(ArrayList<Card> hand, String nom, int positionV, int posI) {
        this.hand = hand;
        this.nom = nom;
        this.positionVictoire = positionV;
        this.positionInitiale = posI;
    }

    public Player(String nom, int position, int posI) {
        this.nom = nom;
        this.positionVictoire = position;
        this.positionInitiale = posI;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPositionVictoire(int position) {
        this.positionVictoire = position;
    }

    public void setPositionInitiale(int position) {
        this.positionInitiale = position;
    }

    public void viderMain(){ this.hand.clear(); }

    public ArrayList<Card> getHand() { return hand; }

    public String getNom() { return nom; }

    public int getPosition() { return positionVictoire; }

    public String toString(){
        String s = "";
        for(Card c : this.hand ) { s += c.toString() + "\n"; }
        return this.nom + " " + this.positionVictoire + "\n" + s;
    }

    public abstract void poserCarte(int indexCarte) throws Exception;

    public abstract void donnerCarte(Card c, Player p ) throws Exception;

    public abstract int choixCarteIA(Card c);

    public abstract boolean aFini();
}
