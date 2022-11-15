package game;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList();
    private String nom;
    private int positionVictoire; //Sert pour les parties d'après
    private int positionInitiale; //Sert pour faire le sens du jeu = Valeur qui ne bouge pas à chaque nouvelle partie
    private boolean isBot; // Ca va surement servir

    public Player(ArrayList<Card> hand, String nom, int positionV, boolean isBot, int posI) {
        this.hand = hand;
        this.nom = nom;
        this.positionVictoire = positionV;
        this.isBot = isBot;
        this.positionInitiale = posI;
    }

    public Player(String nom, int position, boolean isBot, int posI) {
        this.nom = nom;
        this.positionVictoire = position;
        this.isBot = isBot;
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

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public void viderMain(){ this.hand.clear(); }

    public ArrayList<Card> getHand() { return hand; }

    public String getNom() { return nom; }

    public int getPosition() { return positionVictoire; }

    public boolean isBot() { return isBot; }

    public String toString(){
        String s = "";
        for(Card c : this.hand ) { s += c.toString() + "\n"; }
        return this.nom + " " + this.isBot + " " + this.positionVictoire + "\n" + s;
    }

    public void poserCarte(Card posee) throws Exception{
        if(this.hand.contains(posee)){
            this.hand.remove(posee);
            System.out.println(this.nom + " pose " + posee.toString());
        } else { throw new Exception("Card isn't in the player hand"); } // On sait jamais c'est impossible normalement
    }

    public void donnerCarte(Card c, Player p ) throws Exception {
        if(this.hand.contains(c)){
            p.hand.add(c);
            this.hand.remove(c);
            System.out.println(p.nom + " donne " + c.toString());
        } else { throw new Exception("Card isn't in the player hand"); } // On sait jamais c'est impossible normalement
    }

    public Card choixCarteIA(Card c){
        for(Card a : hand){
            if(c == null){ return a; } //Si la carte est 2
            if(c.isSmallerThan(a)){ return a; }
        }
        return null; //Si il peut rien poser
    }
}
