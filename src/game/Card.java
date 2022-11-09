package game;

public class Card {
    private String image;
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
        return image;
    }

    public String getValeur() {
        return valeur;
    }

    public String getType() {
        return couleurs;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getValeur(String valeur){
        if(valeur.equals("A")){
            return 14;
        }
        else if(valeur.equals("2")){
            return 15;
        }
        else if(valeur.equals("J")){
            return 11;
        }
        else if(valeur.equals("Q")){
            return 12;
        }
        else if(valeur.equals("K")){
            return 13;
        }
        else{
            return Integer.parseInt(valeur);
        }
    }
}
