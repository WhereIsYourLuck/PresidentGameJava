package game;

public class Card {
    //Mis en string au cas où si besoin dans l'affichage
    private static String image;
    private String valeur;
    private String couleurs;

    public Card(String image, String valeur, String type) {
        this.image = image;
        this.valeur = valeur;
        this.couleurs = type;
    }

    public Card(String valeur, String type) {
        this.valeur = valeur;
        this.couleurs = type;
    }

    public static String getImage() {
        String dir = "images/";
    	return dir + image;
    }

    public String getVal() {
        return valeur;
    }

    public String getType() {
        return couleurs;
    }

    public String toString(){ return this.image + "\n" + this.valeur + "\n" + this.couleurs + "\n"; }

    public void setImage(String image) {
        this.image = image;
    }

    public int getValeur(){
        if(this.valeur.equals("A")){ return 14; }
        else if(this.valeur.equals("2")){ return 15; }
        else if(this.valeur.equals("J")){ return 11; }
        else if(this.valeur.equals("Q")){ return 12; }
        else if(this.valeur.equals("K")){ return 13; }
        else { return Integer.parseInt(valeur); }
    }

    public boolean isSmallerThan(Card c){
        return this.getValeur() <= c.getValeur(); //Savoir Si la nouvelle carte posée est bien sup ou égal à l'ancienne.
    }
}
