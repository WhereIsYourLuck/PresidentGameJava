package president_GUI;



import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Container;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import game.Card;
import game.*;


public class WindowGame{
			Game game;

		/**
		 * 
		 */

		public WindowGame(Game g) {
				//debug affichage
			this.game = g;
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
		
		
		
		public static void clear_JFrame(JFrame fenetre) {
			fenetre.getContentPane().removeAll();
			fenetre.repaint();
		}
		/*
		public static void mettre_fondMoche(JFrame fenetre) {
			fenetre.setContentPane(new JLabel(new ImageIcon("images/Tapis.jpg")));
		}
		*/
		public static void setImage_toCard(Player jouer) {
		
		}
		
		
		
		public void affiche_jeux(JFrame fenetre) {
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
			
			/*
			 * Jeu du joueur utile
			 */
			
			//jeux 2
			System.out.println(this.game.p1.getHand().get(0).getImage());
			ImageIcon icone2 = new ImageIcon(this.game.p1.getHand().get(0).getImage());
			JPanel panel_image2 = new JPanel();
			JLabel image2 = new JLabel(icone2);
			image2.setSize(icone2.getIconHeight(),icone2.getIconHeight());
			fenetre.add(image2, BorderLayout.SOUTH);
			//image2.setBorder(blackline);
			
			System.out.println(this.game.p1.getHand().get(1).getImage());
			ImageIcon icone19 = new ImageIcon(this.game.p1.getHand().get(1).getImage());
			JPanel panel_image19 = new JPanel();
			JLabel image19 = new JLabel(icone19);
			image2.setSize(icone19.getIconHeight(),icone19.getIconHeight());
			fenetre.add(image19, BorderLayout.SOUTH);
			//image2.setBorder(blackline);
			
			/*
			 * Fin Jeu du joueur utile
			 */
			
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


