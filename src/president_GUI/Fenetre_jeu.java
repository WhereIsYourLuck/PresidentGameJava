package president_GUI;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import carte.*;
public class Fenetre_jeu  {

	/**
	 * 
	 */

	public Fenetre_jeu() {
			//debug affichage
			Border blackline = BorderFactory.createLineBorder(Color.BLACK);
			//image.setBorder(blackline);
		
			JFrame frame = new JFrame("Pr�sident");
			//make sure it quits when x is clicked
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLayout(new BorderLayout());
			//add image 
			JPanel panel_image = new JPanel();
			ImageIcon icone = new ImageIcon("images/b1fv.png");
			JLabel image = new JLabel(icone);
			image.setSize(icone.getIconHeight(),icone.getIconHeight());
			frame.add(image, BorderLayout.NORTH);
			
			
			//add button distribute  
		    JPanel panel = new JPanel();
			JButton button = new JButton("Distribute");
			button.setSize(100,100);
			panel.add(button, BorderLayout.NORTH);
			frame.add(panel, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);
			//set default size of window
			frame.setSize(700, 550);
			frame.setVisible(true);
			
			//Action listener for distribute
			button.addActionListener(new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
				    //distribution des cartes
					clear_JFrame(frame);
					affiche_jeux(frame);
					frame.setMinimumSize(new Dimension(500,400));
					//mettre_fondMoche(frame);
					}
			});
			
			
			
			
		
	}
	
	
	public static void main(String[] args) {
		Fenetre_jeu jeu = new Fenetre_jeu();
		Carte c = new Carte("pique",3);
		image_to_cards(c);
		
		

	}
	public static void clear_JFrame(JFrame fenetre) {
		fenetre.getContentPane().removeAll();
		fenetre.repaint();
	}
	/*
	public static void mettre_fondMoche(JFrame fenetre) {
		fenetre.setContentPane(new JLabel(new ImageIcon("images/Tapis.jpg")));
	}
	*/
	public static String image_to_cards(Carte c){
	String image = null;
	
		if (c.getCouleur() == "Pic") {
			if (c.getValeur() == 3) {
				image = "Trois_Pic.png";
			}
			if (c.getValeur() == 4) {
				image = "Quatre_Pic.png";
			}
			if (c.getValeur() == 5) {
				image = "Cinq_Pic.png";
			}
			if (c.getValeur() == 6) {
				image = "Six_Pic.png";
			}
			if (c.getValeur() == 7) {
				image = "Sept_Pic.png";
			}
			if (c.getValeur() == 8) {
				image = "Huit_Pic.png";
			}
			if (c.getValeur() == 9) {
				image = "Neuf_Pic.png";
			}
			if (c.getValeur() == 10) {
				image = "Dix_Pic.png";
			}
			if (c.getValeur() == 11) {
				image = "Valet_Pic.png";
			}
			if (c.getValeur() == 12) {
				image = "Dame_Pic.png";
			}
			if (c.getValeur() == 13) {
				image = "Roi_Pic.png";
			}
			if (c.getValeur() == 1) {
				image = "As_Pic.png";
			}
			if (c.getValeur() == 2) {
				image = "Deux_Pic.png";
			}
		}
		
		if (c.getCouleur() == "Carreau") {
			if (c.getValeur() == 3) {
				image = "Trois_Carreau.png";
			}
			if (c.getValeur() == 4) {
				image = "Quatre_Carreau.png";
			}
			if (c.getValeur() == 5) {
				image = "Cinq_Carreau.png";
			}
			if (c.getValeur() == 6) {
				image = "Six_Carreau.png";
			}
			if (c.getValeur() == 7) {
				image = "Sept_Carreau.png";
			}
			if (c.getValeur() == 8) {
				image = "Huit_Carreau.png";
			}
			if (c.getValeur() == 9) {
				image = "Neuf_Carreau.png";
			}
			if (c.getValeur() == 10) {
				image = "Dix_Carreau.png";
			}
			if (c.getValeur() == 11) {
				image = "Valet_Carreau.png";
			}
			if (c.getValeur() == 12) {
				image = "Dame_Carreau.png";
			}
			if (c.getValeur() == 13) {
				image = "Roi_Carreau.png";
			}
			if (c.getValeur() == 1) {
				image = "As_Carreau.png";
			}
			if (c.getValeur() == 2) {
				image = "Deux_Carreau.png";
			}
		}
		
		if (c.getCouleur() == "Trefle") {
			if (c.getValeur() == 3) {
				image = "Trois_Trefle.png";
			}
			if (c.getValeur() == 4) {
				image = "Quatre_Trefle.png";
			}
			if (c.getValeur() == 5) {
				image = "Cinq_Trefle.png";
			}
			if (c.getValeur() == 6) {
				image = "Six_Trefle.png";
			}
			if (c.getValeur() == 7) {
				image = "Sept_Trefle.png";
			}
			if (c.getValeur() == 8) {
				image = "Huit_Trefle.png";
			}
			if (c.getValeur() == 9) {
				image = "Neuf_Trefle.png";
			}
			if (c.getValeur() == 10) {
				image = "Dix_Trefle.png";
			}
			if (c.getValeur() == 11) {
				image = "Valet_Trefle.png";
			}
			if (c.getValeur() == 12) {
				image = "Dame_Trefle.png";
			}
			if (c.getValeur() == 13) {
				image = "Roi_Trefle.png";
			}
			if (c.getValeur() == 1) {
				image = "As_Trefle.png";
			}
			if (c.getValeur() == 2) {
				image = "Deux_Trefle.png";
			}
		}
		
		if (c.getCouleur() == "Coeur") {
			if (c.getValeur() == 3) {
				image = "Trois_Coeur.png";
			}
			if (c.getValeur() == 4) {
				image = "Quatre_Coeur.png";
			}
			if (c.getValeur() == 5) {
				image = "Cinq_Coeur.png";
			}
			if (c.getValeur() == 6) {
				image = "Six_Coeur.png";
			}
			if (c.getValeur() == 7) {
				image = "Sept_Coeur.png";
			}
			if (c.getValeur() == 8) {
				image = "Huit_Coeur.png";
			}
			if (c.getValeur() == 9) {
				image = "Neuf_Coeur.png";
			}
			if (c.getValeur() == 10) {
				image = "Dix_Coeur.png";
			}
			if (c.getValeur() == 11) {
				image = "Valet_Coeur.png";
			}
			if (c.getValeur() == 12) {
				image = "Dame_Coeur.png";
			}
			if (c.getValeur() == 13) {
				image = "Roi_Coeur.png";
			}
			if (c.getValeur() == 1) {
				image = "As_Coeur.png";
			}
			if (c.getValeur() == 2) {
				image = "Deux_Coeur.png";
			}
		}
		
		
		return image;
	}
	
	public static void affiche_jeux(JFrame fenetre) {
		//debug affichage
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
		
		//variables 
		int carte_restante_joueur1 = 100;
		int carte_restante_joueur3 = 5;
		int carte_restante_joueur4 = 8;
		
		//minimum size of JFrame
		fenetre.setMinimumSize(new Dimension(100,100));
		//jeux 1
		
		JPanel panel_image1 = new JPanel();
		ImageIcon icone1 = new ImageIcon("images/b2fv.png");
		JLabel image1 = new JLabel(icone1);
		image1.setSize(icone1.getIconHeight(),icone1.getIconHeight());
		fenetre.add(image1, BorderLayout.NORTH);
		image1.setText("<html>cartes restante : <br/>" + carte_restante_joueur1 + "</html>" );
		
		//jeux 2 (Jeu du joueur)
		ImageIcon icone2 = new ImageIcon("images/Cinq_Carreau.png");
		JPanel panel_image2 = new JPanel();
		JLabel image2 = new JLabel(icone2);
		image2.setSize(icone2.getIconHeight(),icone2.getIconHeight());
		fenetre.add(image2, BorderLayout.SOUTH);
		//image2.setBorder(blackline);
		
		//jeux 3
		ImageIcon icone3 = new ImageIcon("images/b2fv.png");
		JPanel panel_image3 = new JPanel();
		JLabel image3 = new JLabel(icone3);
		image3.setSize(icone3.getIconHeight(),icone3.getIconHeight());
		fenetre.add(image3, BorderLayout.EAST);
		image3.setText("<html>cartes restante : <br/>" + carte_restante_joueur3 + "</html>" );
		//image3.setBorder(blackline);
				
		//jeux 4
		ImageIcon icone4 = new ImageIcon("images/b2fv.png");
		JPanel panel_image4 = new JPanel();
		JLabel image4 = new JLabel(icone4);
		image4.setSize(icone4.getIconHeight(),icone4.getIconHeight());
		fenetre.add(image4, BorderLayout.WEST);
		image4.setText("<html>cartes restante : <br/>" + carte_restante_joueur4 + "</html>" );
				//image4.setBorder(blackline);
		
		
	}

}
