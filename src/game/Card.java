package game;

public class Card {
    //Mis en string au cas où si besoin dans l'affichage
    private String image; //Lien vers l'image pour l'interface graphique
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

    public String getImage() {
        String path = "images/";
        return  (path + image);
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

    /**
     * Permet de traduire un niveau de carte en une valeur numérique pour aider à la comparaison entre cartes.
     * @return int valeur de la carte
     */
    public int getValeur(){
        if(this.valeur.equals("A")){ return 14; }
        else if(this.valeur.equals("2")){ return 15; }
        else if(this.valeur.equals("J")){ return 11; }
        else if(this.valeur.equals("Q")){ return 12; }
        else if(this.valeur.equals("K")){ return 13; }
        else { return Integer.parseInt(valeur); }
    }

    /**
     * Savoir si une carte est plus grande qu'une
     * @param c Card
     * @return true or false
     */
    public boolean isSmallerThan(Card c){
        return this.getValeur() <= c.getValeur(); //Savoir Si la nouvelle carte posée est bien sup ou égal à l'ancienne.
    }
}
