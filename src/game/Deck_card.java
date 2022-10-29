package carte;

import java.util.List;

public class Deck_card{
	private Carte[] cartes;
	
	public Deck_card() {
		this.cartes = new Carte[52];
		for (int i =0; i< cartes.length; i++) {
			Carte carte = new Carte("Pic",1);
			this.cartes[i] = carte;
		
		}
	}
	

}
