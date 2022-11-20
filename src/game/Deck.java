package game;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private final static String[] valeurs = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J"};
    private final static String[] couleurs = {"Coeur","Pic","Carreau","Trefle"};

    ArrayList<Card> cards = new ArrayList<Card>();

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Retire une carte dans la main du joueur
     * Utilisée lorsque qu'ils va jouer une carte pour la poser
     * @param c Card
     */
    public void retirerCarte(Card c){ this.cards.remove(c); }

    public void viderDeck(){ cards.clear(); }

    /**
     * Mélange aléatoirement le jeu de 52 cartes.
     */
    public void melanger(){
        Random rnd = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Card a = cards.get(index);
            cards.set(index, cards.get(i));
            cards.set(i, a);
        }
    }

    /**
     * Constructeur initialisation : Créer un jeu de carte + le mélange.
     */
    public Deck(){
        this.creerDeck();
        this.melanger();
    }

    /**
     * Crée un paquet de cartes avec 52 cartes
     */
    public void creerDeck(){
        for(String couleur : couleurs)
            for(String valeur : valeurs)
                switch(couleur){
                    case "Coeur":
                        switch (valeur){
                            case "A":
                                cards.add(new Card("As_Coeur.png", "A" ,  "Coeur")); break;
                            case "2":
                                cards.add(new Card("Deux_Coeur.png", "2" ,  "Coeur")); break;
                            case "3":
                                cards.add(new Card("Trois_Coeur.png", "3" ,  "Coeur")); break;
                            case "4":
                                cards.add(new Card("Quatre_Coeur.png", "4" ,  "Coeur")); break;
                            case "5":
                                cards.add(new Card("Cinq_Coeur.png", "5" ,  "Coeur")); break;
                            case "6":
                                cards.add(new Card("Six_Coeur.png", "6" ,  "Coeur")); break;
                            case "7":
                                cards.add(new Card("Sept_Coeur.png", "7" ,  "Coeur")); break;
                            case "8":
                                cards.add(new Card("Huit_Coeur.png", "8" ,  "Coeur")); break;
                            case "9":
                                cards.add(new Card("Neuf_Coeur.png", "9" ,  "Coeur")); break;
                            case "10":
                                cards.add(new Card("Dix_Coeur.png", "10" ,  "Coeur")); break;
                            case "K":
                                cards.add(new Card("Roi_Coeur.png", "K" ,  "Coeur")); break;
                            case "Q":
                                cards.add(new Card("Dame_Coeur.png", "Q" ,  "Coeur")); break;
                            case "J":
                                cards.add(new Card("Valet_Coeur.png", "J" ,  "Coeur")); break;
                        }
                        break;
                    case "Pic":
                        switch (valeur){
                            case "A":
                                cards.add(new Card("As_Coeur.png", "A" ,  "Pic")); break;
                            case "2":
                                cards.add(new Card("Deux_Coeur.png", "2" ,  "Pic")); break;
                            case "3":
                                cards.add(new Card("Trois_Pic.png", "3" ,  "Pic")); break;
                            case "4":
                                cards.add(new Card("Quatre_Pic.png", "4" ,  "Pic")); break;
                            case "5":
                                cards.add(new Card("Cinq_Pic.png", "5" ,  "Pic")); break;
                            case "6":
                                cards.add(new Card("Six_Pic.png", "6" ,  "Pic")); break;
                            case "7":
                                cards.add(new Card("Sept_Pic.png", "7" ,  "Pic")); break;
                            case "8":
                                cards.add(new Card("Huit_Pic.png", "8" ,  "Pic")); break;
                            case "9":
                                cards.add(new Card("Neuf_Pic.png", "9" ,  "Pic")); break;
                            case "10":
                                cards.add(new Card("Dix_Pic.png", "10" ,  "Pic")); break;
                            case "K":
                                cards.add(new Card("Roi_Pic.png", "K" ,  "Pic")); break;
                            case "Q":
                                cards.add(new Card("Dame_Pic.png", "Q" ,  "Pic")); break;
                            case "J":
                                cards.add(new Card("Valet_Pic.png", "J" ,  "Pic")); break;
                        }
                        break;
                    case "Trefle":
                        switch (valeur){
                            case "A":
                                cards.add(new Card("As_Trefle.png", "A" ,  "Trefle")); break;
                            case "2":
                                cards.add(new Card("Deux_Trefle.png", "2" ,  "Trefle")); break;
                            case "3":
                                cards.add(new Card("Trois_Trefle.png", "3" ,  "Trefle")); break;
                            case "4":
                                cards.add(new Card("Quatre_Trefle.png", "4" ,  "Trefle")); break;
                            case "5":
                                cards.add(new Card("Cinq_Trefle.png", "5" ,  "Trefle")); break;
                            case "6":
                                cards.add(new Card("Six_Trefle.png", "6" ,  "Trefle")); break;
                            case "7":
                                cards.add(new Card("Sept_Trefle.png", "7" ,  "Trefle")); break;
                            case "8":
                                cards.add(new Card("Huit_Trefle.png", "8" ,  "Trefle")); break;
                            case "9":
                                cards.add(new Card("Neuf_Trefle.png", "9" ,  "Trefle")); break;
                            case "10":
                                cards.add(new Card("Dix_Trefle.png", "10" ,  "Trefle")); break;
                            case "K":
                                cards.add(new Card("Roi_Trefle.png", "K" ,  "Trefle")); break;
                            case "Q":
                                cards.add(new Card("Dame_Trefle.png", "Q" ,  "Trefle")); break;
                            case "J":
                                cards.add(new Card("Valet_Trefle.png", "J" ,  "Trefle")); break;
                        }
                        break;
                    case "Carreau":
                        switch (valeur){
                            case "A":
                                cards.add(new Card("As_Carreau.png", "A" ,  "Carreau")); break;
                            case "2":
                                cards.add(new Card("Deux_Carreau.png", "2" ,  "Carreau")); break;
                            case "3":
                                cards.add(new Card("Trois_Carreau.png", "3" ,  "Carreau")); break;
                            case "4":
                                cards.add(new Card("Quatre_Carreau.png", "4" ,  "Carreau")); break;
                            case "5":
                                cards.add(new Card("Cinq_Carreau.png", "5" ,  "Carreau")); break;
                            case "6":
                                cards.add(new Card("Six_Carreau.png", "6" ,  "Carreau")); break;
                            case "7":
                                cards.add(new Card("Sept_Carreau.png", "7" ,  "Carreau")); break;
                            case "8":
                                cards.add(new Card("Huit_Carreau.png", "8" ,  "Carreau")); break;
                            case "9":
                                cards.add(new Card("Neuf_Carreau.png", "9" ,  "Carreau")); break;
                            case "10":
                                cards.add(new Card("Dix_Carreau.png", "10" ,  "Carreau")); break;
                            case "K":
                                cards.add(new Card("Roi_Carreau.png", "K" ,  "Trefle")); break;
                            case "Q":
                                cards.add(new Card("Dame_Carreau.png", "Q" ,  "Trefle")); break;
                            case "J":
                                cards.add(new Card("Valet_Carreau.png", "J" ,  "Trefle")); break;
                        }
                        break;
                }
    }
}

