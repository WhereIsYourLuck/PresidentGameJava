package game;

import president_GUI.WindowGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Game {
    public int nombreGagnant = 0; //Quand à 3, on sait que la partie est finie
    public int firstGame = 0; // Quand partie finie incré (+1) Donc on sait qu'il y a échange de carte + Pas de Dame coeur + nouveau sens
    public int tourPasse = 0;
    private Deck deck = new Deck();
    public ArrayList<Player> players = new ArrayList<>();
    public Card carteCourante;
    public Player p1, p2, p3, p4;

    public Card getCarteCourante() {
        return carteCourante;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public Player getP3() {
        return p3;
    }

    public Player getP4() {
        return p4;
    }

    /**
     * Constructeur quand on débute une nouvelle partie
     * @throws Exception
     */
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
        System.out.println("----DEBUT PARTIE-----");
        debugCarteCourante();
        System.out.println("----DEBUT PARTIE-----");
        for(Player p : players){
           if(p instanceof Joueur){ break; }
            Card bot = jouerBotTour(p);
           if(bot.getValeur() == 15){
               jouerBotTour(p);
           }
        }
        System.out.println("----APRES TOUR DAME DE COEUR-----");
        debugCarteCourante();
        System.out.println("----APRES TOUR DAME DE COEUR-----");
    }

    public Game(Player joueur, Player b2, Player b3, Player b4){
        p1 = joueur;
        p2 = b2;
        p3 = b3;
        p4 = b4;
    }

    /**
     * Print dans la console la valeur de la carteCourante
     */
    public void debugCarteCourante(){
        if(this.carteCourante == null ){
            System.out.println("La carte est à nulle");
        } else {
            System.out.println("La carte courante est\n" + this.carteCourante.toString());
        }
    }

    /**
     * Fait jouer un bot pour lui simuler le fait de choisir une carte
     * Reste d'un tour de bot est géré dans WindowGame méthode jouer()
     * @param p bot qui doit jouer
     * @return
     * @throws Exception
     */
    public Card jouerBotTour(Player p) throws Exception {
        int indexInHand = p.choixCarteIA(this.carteCourante);
        System.out.println("Index de la carte " + indexInHand + " " + p.getNom());
        debugCarteCourante();
        if(indexInHand == -1){
            System.out.println("Il sait pas quelle carte poser ce hmar");
            return null;
        } else {
            Card bot = p.getHand().get(indexInHand);
            if(bot.getValeur() == 15){
                this.carteCourante = null;
            } else {
                carteCourante = bot;
            }
            System.out.println("-------------");
            p.poserCarte(indexInHand);
            debugCarteCourante();
            System.out.println("-------------");
            return bot;
        }
    }

    /**
     * Savoir si le joueur p a terminé la partie
     * @param p
     * @return true / false
     *
     */
    public boolean testerFinJoueur(Player p){
        if (p.getHand().size() == 0) {
            this.players.get(this.players.indexOf(p)).setNom(this.nomPlaceGagnant());
            this.players.get(this.players.indexOf(p)).setPositionVictoire(this.placeGagnant(p.getNom()));
            this.players.remove(this.players.indexOf(p));
            return true;
        }
        return false;
    }

    /**
     * En fonction du nombre de joueurs ayant déjà fini la partie
     * On peut choisir le nom du prochain joueur en fonction de son classement
     * @return String nom de la place
     */
    public String nomPlaceGagnant(){
            switch(nombreGagnant){
                case 0:  nombreGagnant++; return "President";
                case 1:  nombreGagnant++; return "Vice-President";
                case 2:  nombreGagnant++; return "Vice-trou du cul";
                case 3:  nombreGagnant++; return "Trou du cul";
                default: return "Trou du cul";
            }
    }

    /**
     * En fonction de la place, on peut connaître le sens du jeu
     * Sens du jeu définie par la place dans l'arraylist players
     * Valeur de retour définie sa place dans un tour de jeu
     * @param nomPlace
     * @return
     */
    public int placeGagnant(String nomPlace){
        switch(nomPlace){
            case "President": return 0;
            case "Vice-President": return 1;
            case "Vice-trou du cul": return 2;
            case "Trou du cul": return 3;
            default: return 3;
        }
    }

    /**
     * Remettre un jeu à zéro pour pourvoir commencer une nouvelle partie avec les données de la précédente
     * @throws Exception
     */
    public void relancerPartie() throws Exception {
        this.firstGame = 1;
        this.carteCourante = null;
        this.nombreGagnant = 0;
        this.deck.viderDeck();
        this.deck.creerDeck();
        this.deck.melanger();
        trouverPositionRelance();
        for(Player p : players){ p.viderMain(); }
        distribuer();
        this.p1.getHand().sort(Comparator.comparing(Card::getValeur));
        this.p2.getHand().sort(Comparator.comparing(Card::getValeur));
        this.p3.getHand().sort(Comparator.comparing(Card::getValeur));
        this.p4.getHand().sort(Comparator.comparing(Card::getValeur));

        joueurDonneCartePosition();
        for(Player p : players){
            if(p instanceof Joueur){ break; }
            jouerBotTour(p);
        }
        this.p1.setPositionVictoire(-1);
        this.p2.setPositionVictoire(-1);
        this.p3.setPositionVictoire(-1);
        this.p4.setPositionVictoire(-1);
        System.out.println("----DEBUT PARTIE-----");
        debugCarteCourante();
        System.out.println("----DEBUT PARTIE-----");
        System.out.println("----APRES TOUR DU PRESIDENT-----");
        debugCarteCourante();
        System.out.println("----APRES TOUR DU DPRESIDENT-----");


    }

    public void joueurDonneCartePosition() throws Exception {
        System.out.println("-----PRESIDENT------");
        players.get(0).donnerCarte(players.get(0).getHand().get(1), players.get(3));
        players.get(0).donnerCarte(players.get(0).getHand().get(0), players.get(3));
        System.out.println("-----PRESIDENT------");

        System.out.println("-----TROU DUC------");
        players.get(3).donnerCarte(players.get(3).getHand().get(12), players.get(0));
        players.get(3).donnerCarte(players.get(3).getHand().get(11), players.get(0));
        System.out.println("-----TROU DUC------");

        System.out.println("-----VICE PRESIDENT------");
        players.get(1).donnerCarte(players.get(1).getHand().get(0), players.get(2));
        System.out.println("-----VICE PRESIDENT------");

        System.out.println("-----VICE TROU DUC------");
        players.get(2).donnerCarte(players.get(2).getHand().get(12), players.get(1));
        System.out.println("-----VICE TROU DUC------");
    }

    /**
     * Relance partie, met en place les joueurs dans le bon index de l'arraylist
     * pour mettre en place le sens d'un tour de jeu
     */
    public void trouverPositionRelance(){
        this.players.clear();
        players.add(null);
        players.add(null);
        players.add(null);
        players.add(null);

        players.set(p1.positionVictoire, p1);
        players.set(p2.positionVictoire, p2);
        players.set(p3.positionVictoire, p3);
        players.set(p4.positionVictoire, p4);
    }

    /**
     * Distribue 13 cartes au hasard à chaque joueur, joueur par joueur
     */
    public void distribuer(){
        for(Player p : players){
            for(int i = 0 ; i < 13 ; i++){
                int index = (int)(Math.random() * deck.getCards().size());
                p.getHand().add(deck.getCards().get(index));
                deck.getCards().remove(index);
            }
        }
    }


    /**
     * Défini le sens de jeu de la première partie en fonction de qui possède la Dame de coeur
     */
    public void commencerPartie(){
        int startPlayer = -1;
        for(Player p : players)
            for(Card c : p.getHand())
                if(c.getValeur() == 12 && c.getType().equals("Coeur")){
                    startPlayer = players.indexOf(p);
                }
         System.out.println("Start player index " +startPlayer+ "\n");
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
