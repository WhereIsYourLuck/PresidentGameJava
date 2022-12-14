package president_GUI;



import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Container;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import game.Card;
import game.*;


public class Fenetre_fin_jeu{
			Game game;

		/**
		 * 
		 */

		public Fenetre_fin_jeu(Game g) {
				//debug affichage
			this.game = g;
				Border blackline = BorderFactory.createLineBorder(Color.BLACK);
				//image.setBorder(blackline);
			
				JFrame frame = new JFrame("Fin de la partie");
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
			    
			    
			    JLabel label = new JLabel("<html>"+"Joueur 1 : " + game.getP1().getNom() + "<br>" + "Joueur 2 : " + game.getP2().getNom() + "<br>" + "Joueur 3 : " + game.getP3().getNom() + "<br>" + "Joueur 4 : " + game.getP4().getNom() + "</html>" );
				panel.add(label, BorderLayout.SOUTH);
				
				JButton button_quit = new JButton("quitter");
				button_quit.setSize(100,100);
				panel.add(button_quit, BorderLayout.NORTH);
				
				JButton button_reload = new JButton("relancer une partie");
				button_reload.setSize(100,100);
				panel.add(button_reload, BorderLayout.NORTH);
				
				JButton button_save = new JButton("sauvegarder");
				button_quit.setSize(100,100);
				panel.add(button_save, BorderLayout.NORTH);
				
				frame.add(panel, BorderLayout.CENTER);
				frame.pack();
				frame.setVisible(true);
				//set default size of window
				frame.setSize(700, 550);
				frame.setVisible(true);
				
				//Action listener for distribute
				button_quit.addActionListener(new ActionListener() {
					@Override 
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						}
				});
				
				button_save.addActionListener(new ActionListener() {
					@Override 
					public void actionPerformed(ActionEvent e) {
						try (Writer writer = new BufferedWriter(new OutputStreamWriter(
					              new FileOutputStream("save.txt"), "utf-8"))) {
							//chose a ??crire
							//ligne vide pour faciliter lecture
							 writer.write(System.getProperty( "line.separator" ));
							//P1
					   writer.write(game.p1.getNom());
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(String.valueOf(game.p1.getPosition()));
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(String.valueOf(game.p1.getPositionVictoire()));
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(System.getProperty( "line.separator" ));
					   
					   //P2
					   writer.write(game.p2.getNom());
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(String.valueOf(game.p2.getPosition()));
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(String.valueOf(game.p2.getPositionVictoire()));
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(System.getProperty( "line.separator" ));
					   
					   //P3
					   writer.write(game.p3.getNom());
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(String.valueOf(game.p3.getPosition()));
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(String.valueOf(game.p3.getPositionVictoire()));
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(System.getProperty( "line.separator" ));
					   
					   //P4
					   writer.write(game.p4.getNom());
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(String.valueOf(game.p4.getPosition()));
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(String.valueOf(game.p4.getPositionVictoire()));
					   writer.write(System.getProperty( "line.separator" ));
					   writer.write(System.getProperty( "line.separator" ));
					   
					   JOptionPane.showMessageDialog(null,"L'??tat de la partie a ??t?? sauvegard??e");
					   
					   ///////////////////
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					   
						}
				});

			button_reload.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						game.relancerPartie();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					clear_JFrame(frame);
					//make sure it quits when x is clicked
					WindowGame jeu = new WindowGame(game);
					jeu.affiche_jeux(frame);
					frame.setMinimumSize(new Dimension(1000,800));
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
			
			
		}

	}