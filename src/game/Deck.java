package game;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private String[] valeurs = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J"};
    private String[] couleurs = {"Coeur","Pic","Carreau","Trefle"};

    ArrayList<Card> cards = new ArrayList<Card>();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void melanger(){
        Random rnd = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Card a = cards.get(index);
            cards.set(index, cards.get(i));
            cards.set(i, a);
        }
    }
    public Deck(){
        for(String couleur : couleurs){
            for(String valeur : valeurs){
            	switch (valeur){
                case "A":
                    cards.add(new Card("As_" + couleur + ".png", "A" ,  couleur)); break;
                case "2":
                    cards.add(new Card("Deux_" + couleur + ".png", "2" ,  couleur)); break;
                case "3":
                    cards.add(new Card("Trois_" + couleur + ".png", "3" ,  couleur)); break;
                case "4":
                    cards.add(new Card("Quatre_" + couleur + ".png", "4" ,  couleur)); break;
                case "5":
                    cards.add(new Card("Cinq_" + couleur + ".png", "5" ,  couleur)); break;
                case "6":
                    cards.add(new Card("Six_" + couleur + ".png", "6" ,  couleur)); break;
                case "7":
                    cards.add(new Card("Sept_" + couleur + ".png", "7" ,  couleur)); break;
                case "8":
                    cards.add(new Card("Huit_" + couleur + ".png", "8" ,  couleur)); break;
                case "9":
                    cards.add(new Card("Neuf_" + couleur + ".png", "9" ,  couleur)); break;
                case "10":
                    cards.add(new Card("Dix_" + couleur + ".png", "10" ,  couleur)); break;
                case "K":
                    cards.add(new Card("Roi_" + couleur + ".png", "K" ,  couleur)); break;
                case "Q":
                    cards.add(new Card("Dame_" + couleur + ".png", "Q" ,  couleur)); break;
                case "J":
                    cards.add(new Card("Valet_" + couleur + ".png", "J" ,  couleur)); break;
            }
            }

        }

    }
}

