package game;

import java.util.ArrayList;

public class Game {
    public int nombreGagnant = 0; //Quand à 3, on sait que la partie est finie
    public int nbparties = 0; // Quand partie finie incré (+1) Donc on sait qu'il y a échange de carte + Pas de Dame coeur + nouveau sens
    public Deck deck = new Deck();
    public ArrayList<Player> players = new ArrayList<>();
    public Card carteJouee;
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
        distribuer();
        if(nbparties == 0){
            commencerPartie();
        }
    }
 // While dans le constructeur joueur est bot il joue
    //Puis quand c'est le vrai joueur fonction demandée par action listener
    //Fonction jouer qui vérifie si joueur a encore des cartes sinon : Il fait jouer les bots jusqu'a la fin
    // A vérifier : Pose de la carte
    // Si c'est sa dernière carte = fini de jouer ++ incnbjoueurGagnant
    // Si joueur gagnant = 3 fin partie
    public void distribuer(){
        for(Player p : players){
            for(int i = 0 ; i < 13 ; i++){
                int index = (int)(Math.random() * deck.getCards().size());
                p.getHand().add(deck.getCards().get(index));
                deck.getCards().remove(index);
            }
        }
    }

    public void commencerPartie(){
        int startPlayer = -1;
        for(Player p : players){
            for(Card c : p.getHand()){
                if(c.getValeur() == 12 && c.getType().equals("Coeur")){
                    startPlayer =  players.indexOf(p);
                }
            }
        }
        switch(startPlayer){
            case 2:
                p1.setPositionInitiale(4);
                p2.setPositionInitiale(1);
                p3.setPositionInitiale(2);
                p4.setPositionInitiale(3);
            case 3:
                p1.setPositionInitiale(3);
                p2.setPositionInitiale(4);
                p3.setPositionInitiale(1);
                p4.setPositionInitiale(2);
            case 4:
                p1.setPositionInitiale(2);
                p2.setPositionInitiale(3);
                p3.setPositionInitiale(4);
                p4.setPositionInitiale(1);
            default:
                p1.setPositionInitiale(1);
                p2.setPositionInitiale(2);
                p3.setPositionInitiale(3);
                p4.setPositionInitiale(4);
        }
    }

    public void relancerPartie(){
        this.deck.viderDeck();
        this.deck.creerDeck();
        for(Player p : players){ p.viderMain(); }
        distribuer();
    }
}
