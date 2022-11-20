package game;

import java.util.ArrayList;

public class Game {
    public int nombreGagnant = 0; //Quand à 3, on sait que la partie est finie
    public int nbparties = 0; // Quand partie finie incré (+1) Donc on sait qu'il y a échange de carte + Pas de Dame coeur + nouveau sens
    public int tourPasse = 0;
    private Deck deck = new Deck();
    public ArrayList<Player> players = new ArrayList<>();
    public Card carteCourante;
    public Player p1, p2, p3, p4;

    public Card getCarteCourante() { return carteCourante; }

    public Player getP1() { return p1; }

    public Player getP2() { return p2; }

    public Player getP3() { return p3; }

    public Player getP4() { return p4; }

    public Game() throws Exception {

        p1 = new Joueur("p1", -1, 1);
        p2 = new Bot("p2", -1, 2);
        p3 = new Bot("p3", -1, 3);
        p4 = new Bot("p4", -1, 4);
        carteCourante = null;
        this.players.add(p1);
        this.players.add(p2);
        this.players.add(p3);
        this.players.add(p4);
        deck.melanger();
        distribuer();
        commencerPartie();
        for(Player p : players){
            if(p instanceof Joueur){ break; }
            p.poserCarte(p.choixCarteIA(carteCourante));
        }
    }
    // While dans le constructeur joueur est bot il joue
    //Puis quand c'est le vrai joueur fonction demandée par action listener
    //Fonction jouer qui vérifie si joueur a encore des cartes sinon : Il fait jouer les bots jusqu'a la fin
    // A vérifier : Pose de la carte
    // Si c'est sa dernière carte = fini de jouer ++ incnbjoueurGagnant
    // Si joueur gagnant = 3 fin partie

    public String nomPlaceGagnant(){
            switch(nombreGagnant){
                case 0:  nombreGagnant++; return "Président";
                case 1:  nombreGagnant++; return "Vice-Président";
                case 2:  nombreGagnant++; return "Vice-trou du cul";
                case 3:  nombreGagnant++; return "Trou du cul";
                default: return "Trou du cul";
            }
    }

    public int placeGagnant(String nomPlace){
        switch(nomPlace){
            case "Président": return 0;
            case "Vice-Président": return 1;
            case "Vice-trou du cul": return 2;
            case "Trou du cul": return 3;
            default: return 3;
        }
    }

    public void abandonnerTour(){

    }

    public void jouer(int indexCarte) throws Exception {
        carteCourante = p1.getHand().get(indexCarte);
        p1.poserCarte(p1.getHand().get(indexCarte));
        int indexJoueur = players.indexOf(p1);
        if(p1.getHand().size() == 0){
            p1.setNom(nomPlaceGagnant());
            p1.setPositionVictoire(placeGagnant(p1.getNom()));
            players.remove(p1);
        }
        for(int i = indexJoueur + 1 ; i < players.size(); i++) {
            Card choixCarteBot = players.get(i).choixCarteIA(carteCourante);
            if (choixCarteBot != null) {
                players.get(i).poserCarte(choixCarteBot); // manque le rejouer
                carteCourante = choixCarteBot;
                System.out.println("-----------");
                System.out.println("Carte courante = " + carteCourante.toString());
                System.out.println("-----------");
                if (players.get(i).getHand().size() == 0) {
                    players.get(i).setNom(nomPlaceGagnant());
                    players.get(i).setPositionVictoire(placeGagnant(players.get(i).getNom()));
                    players.remove(players.get(i));
                }
            }
        }

        for(int i = 0 ; i < indexJoueur; i++){
            Card choixCarteBot = players.get(i).choixCarteIA(carteCourante);
            if (choixCarteBot != null) {
                players.get(i).poserCarte(choixCarteBot); // manque le rejouer
                carteCourante = choixCarteBot;
                System.out.println("-----------");
                System.out.println("Carte courante = " + carteCourante.toString());
                System.out.println("-----------");
                if (players.get(i).getHand().size() == 0) {
                    players.get(i).setNom(nomPlaceGagnant());
                    players.get(i).setPositionVictoire(placeGagnant(players.get(i).getNom()));
                    players.remove(players.get(i));
                }
            }
        }
    }

    public void relancerPartie(){
        this.deck.viderDeck();
        this.deck.creerDeck();
        for(Player p : players){ p.viderMain(); }
        distribuer();
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

    public void commencerPartie(){
        int startPlayer = -1;
        for(Player p : players)
            for(Card c : p.getHand())
                if(c.getValeur() == 12 && c.getType().equals("Coeur"))
                    startPlayer =  players.indexOf(p);
        players.clear();
        switch(startPlayer){
            case 1: //Joueur 2 Queen Coeur
                p1.setPositionInitiale(4);
                p2.setPositionInitiale(1);
                p3.setPositionInitiale(2);
                p4.setPositionInitiale(3);
                players.add(p2);
                players.add(p3);
                players.add(p4);
                players.add(p1);
                break;
            case 2: //Joueur 3 Queen Coeur
                p1.setPositionInitiale(3);
                p2.setPositionInitiale(4);
                p3.setPositionInitiale(1);
                p4.setPositionInitiale(2);
                players.add(p3);
                players.add(p4);
                players.add(p1);
                players.add(p2);
                break;
            case 3: //Joueur 4 Queen Coeur
                p1.setPositionInitiale(2);
                p2.setPositionInitiale(3);
                p3.setPositionInitiale(4);
                p4.setPositionInitiale(1);
                players.add(p4);
                players.add(p1);
                players.add(p2);
                players.add(p3);
                break;
            default: //Joueur 1 Queen Coeur
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
}
