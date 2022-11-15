package president_GUI;



import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Container;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

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


public class Fenetre_debut_jeu{
			Game game;

		/**
		 * 
		 */

		public Fenetre_debut_jeu() {
				//debug affichage
			//this.game = g;
				Border blackline = BorderFactory.createLineBorder(Color.BLACK);
				//image.setBorder(blackline);
			
				JFrame frame = new JFrame("President");
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
				JButton button_distribute = new JButton("distribuer");
				button_distribute.setSize(100,100);
				panel.add(button_distribute, BorderLayout.NORTH);
				
				JButton button_import = new JButton("importer une sauvegarde");
				button_import.setSize(100,100);
				panel.add(button_import, BorderLayout.NORTH);
				
				frame.add(panel, BorderLayout.CENTER);
				frame.pack();
				frame.setVisible(true);
				//set default size of window
				frame.setSize(700, 550);
				frame.setVisible(true);
				
				
				//Action listener for distribute
				button_distribute.addActionListener(new ActionListener() {
					@Override 
					public void actionPerformed(ActionEvent e) {
						clear_JFrame(frame);
						Game partie = new Game();
						WindowGame jeu = new WindowGame(partie);
						jeu.affiche_jeux(frame);
						frame.setMinimumSize(new Dimension(1000,400));
						
						//mettre_fondMoche(frame);
						}
				});
				
				button_import.addActionListener(new ActionListener() {
					@Override 
					public void actionPerformed(ActionEvent e) {
					    //distribution des cartes
						 try {
						      File myObj = new File("save.txt");
						      Scanner myReader = new Scanner(myObj);
						      while (myReader.hasNextLine()) {
						        String data = myReader.nextLine();
						        JOptionPane.showMessageDialog(null,"importer depuis la sauvegarde : " + data);
						      }
						      myReader.close();
						    } catch (FileNotFoundException e2) {
						      System.out.println("An error occurred.");
						      e2.printStackTrace();
						    }
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

	}