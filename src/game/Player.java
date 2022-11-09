package game;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList();
    private String nom;
    private int position;
    private boolean isBot;

    public Player(ArrayList<Card> hand, String nom, int position, boolean isBot) {
        this.hand = hand;
        this.nom = nom;
        this.position = position;
        this.isBot = isBot;
    }

    public Player(String nom, int position, boolean isBot) {
        this.nom = nom;
        this.position = position;
        this.isBot = isBot;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getNom() {
        return nom;
    }

    public int getPosition() {
        return position;
    }

    public boolean isBot() {
        return isBot;
    }
}
