package carte;

public class Carte {
	 private String couleur;
	    private int valeur;
	    
	    
	    public Carte(String s, int v) {
	        couleur = s;
	        valeur = v;
	    }
	    public String getCouleur() {
			return this.couleur;
		}
	    public int getValeur() {
			return this.valeur;
		}
	    
	    
	}
