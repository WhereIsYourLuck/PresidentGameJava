package game;

import java.util.ArrayList;

public class Game {
    public int nombreGagnant = 0; //Quand à 3, on sait que la partie est finie
    public int nbparties = 0; // Quand partie finie incré (+1) Donc on sait qu'il y a échange de carte + Pas de Dame coeur + nouveau sens
    public Deck deck = new Deck();
    public ArrayList<Player> players = new ArrayList<>();
    public Card carteJouee;
    public Player p1;
    public Player p2;
    public Player p3;
    public Player p4;

    public Game(){
        p1 = new Player("p1", -1, false, -1);
        p2 = new Player("p2", -1, true, -1);
        p3 = new Player("p3", -1, true, -1);
        p4 = new Player("p4", -1, true,  -1);
        this.players.add(p1);
        this.players.add(p2);
        this.players.add(p3);
        this.players.add(p4);
        deck.melanger();
        distribuer();
        commencerPartie();

    }

    public String nomPlaceGagnant(){
            switch(nombreGagnant){
                case 0:
                    nombreGagnant++;
                    return "Président";
                case 1:
                    nombreGagnant++;
                    return "Vice-Président";
                case 2:
                    nombreGagnant++;
                    return "Vice-trou du cul";
                case 3:
                    nombreGagnant++;
                    return "Trou du cul";
                default:
                    return "Trou du cul";
            }
    }

    public int placeGagnant(String nomPlace){
        switch(nomPlace){
            case "Président":
                return 0;
            case "Vice-Président":
                return 1;
            case "Vice-trou du cul":
                return 2;
            case "Trou du cul":
                return 3;
            default:
                return 3;
        }
    }

    public void jouer(int indexCarte) throws Exception {
        p1.poserCarte(p1.getHand().get(indexCarte), carteJouee);
        int indexJoueur = players.indexOf(p1);
        if(p1.getHand().size() == 0){
            p1.setNom(nomPlaceGagnant());
            p1.setPositionVictoire(placeGagnant(p1.getNom()));
            players.remove(p1);
        }
        for(int i = indexJoueur ; i < players.size(); i++) {
            if (players.get(i).choixCarteIA(carteJouee) != null) {
                players.get(i).poserCarte(players.get(i).getHand().get(indexCarte), carteJouee);
                if (players.get(i).getHand().size() == 0) {
                    players.get(i).setNom(nomPlaceGagnant());
                    players.get(i).setPositionVictoire(placeGagnant(players.get(i).getNom()));
                    players.remove(players.get(i));

                }
            }
        }

        for(int i = 0 ; i < indexJoueur; i++){
            if(players.get(i).choixCarteIA(carteJouee) != null){
                players.get(i).poserCarte(players.get(i).getHand().get(indexCarte), carteJouee);
                if(players.get(i).getHand().size() == 0){
                    players.get(i).setNom(nomPlaceGagnant());
                    players.get(i).setPositionVictoire(placeGagnant(players.get(i).getNom()));
                    players.remove(players.get(i));
                }
            }
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
        players.clear();
        switch(startPlayer){
            case 2:
                p1.setPositionInitiale(4);
                p2.setPositionInitiale(1);
                p3.setPositionInitiale(2);
                p4.setPositionInitiale(3);
                players.add(p2);
                players.add(p3);
                players.add(p4);
                players.add(p1);
                break;
            case 3:
                p1.setPositionInitiale(3);
                p2.setPositionInitiale(4);
                p3.setPositionInitiale(1);
                p4.setPositionInitiale(2);
                players.add(p3);
                players.add(p4);
                players.add(p1);
                players.add(p2);
                break;
            case 4:
                p1.setPositionInitiale(2);
                p2.setPositionInitiale(3);
                p3.setPositionInitiale(4);
                p4.setPositionInitiale(1);
                players.add(p4);
                players.add(p1);
                players.add(p2);
                players.add(p3);
                break;
            default:
                p1.setPositionInitiale(1);
                p2.setPositionInitiale(2);
                p3.setPositionInitiale(3);
                p4.setPositionInitiale(4);
                players.add(p1);
                players.add(p2);
                players.add(p3);
                players.add(p4);
                break;
        }
    }

    public void relancerPartie(){
        this.deck.viderDeck();
        this.deck.creerDeck();
        for(Player p : players){ p.viderMain(); }
        distribuer();
    }
}
