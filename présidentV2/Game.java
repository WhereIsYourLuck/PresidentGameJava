package game;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public int nombreGagnant = 0; //Quand à 3, on sait que la partie est finie
    public int nbparties = 0; // Quand partie finie incré (+1) Donc on sait qu'il y a échange de carte + Pas de Dame coeur + nouveau sens
    public Deck deck = new Deck();
    public ArrayList<Player> players = new ArrayList<>();
    public Player p1 = new Player("p1", 0, false, 1);
    public Player p2 = new Player("p2", 1, true, 2);
    public Player p3 = new Player("p3", 2, true, 3);
    public Player p4 = new Player("p4", 3, true,  4);

    public Game(){
        this.players.add(p1);
        this.players.add(p2);
        this.players.add(p3);
        this.players.add(p4);
        deck.melanger();
    }

    public void distribuer(){
        for(Player p : players){
            for(int i = 0 ; i < 13 ; i++){
                int index = (int)(Math.random() * deck.getCards().size());
                p.getHand().add(deck.getCards().get(index));
                deck.getCards().remove(index);
            }
        }
    }




}
