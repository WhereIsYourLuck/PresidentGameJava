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
				frame.setSize(1200, 550);
				frame.setVisible(true);
				
				// regles du jeu 
				
				JLabel regles = new JLabel("<html>" + "Regles du jeu :" + "<br>" + "- Le joueur qui commence la partie est celui qui à la damme de coeur. (damme de coeur à toi l'honneur)" + "<br>" + "- Pour poser une carte il faux que sa valeur soit supérieur à celle déjà en jeu." + "<br>" + "- le 2 est la carte la plus puissante du jeu, elle est considéré comme supérieur à un as et permet de fermer le jeu actuel. Le joueur ayant posé un 2 devra donc rejouer la carte de son choix." + "<br>" + "- Lorsque un joueur fini sont paquet de carte il devient président, les autres joueurs poursuivent leurs partie pour déterminer la suite du classement." + "<br>" + "<br>" + "Le président donne ses deux pires cartes au trou du cul." + "<br>" + "Le vice président donne sa pire carte au vice trou du cul." + "<br>" + "Le vice trou du cul donne sa meilleur carte au vice président." + "<br>" + "Le trou du cul donne ses deux meilleur cartes au président." + "<br>" + "<br>" + "Le trou du cul commence la partie." +"</html>");
				panel.add(regles, BorderLayout.SOUTH);
				
				
				//Action listener for distribute
				button_distribute.addActionListener(new ActionListener() {
					@Override 
					public void actionPerformed(ActionEvent e) {
						clear_JFrame(frame);
						Game partie = null;
						try {
							partie = new Game();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						WindowGame jeu = new WindowGame(partie);
						jeu.affiche_jeux(frame);
						frame.setMinimumSize(new Dimension(1200,400));
						
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
						      JOptionPane affiche_save = new JOptionPane();
						      String data = "";
						      while (myReader.hasNextLine()) {
						    	  //lit la save ligne par ligne
						         data = data += myReader.nextLine() + "\n";
						         
						      }
						      affiche_save.showMessageDialog(null,"importer depuis la sauvegarde : " + data);
						      myReader.close();
						      Scanner assign_value = new Scanner(data);
						      //sauter ligne vide 
						      assign_value.nextLine();
						      
						      String P1_role = assign_value.nextLine();
						      int P1_position = assign_value.nextInt();
						      assign_value.nextLine();
						      int P1_position_victoire = assign_value.nextInt();
						      assign_value.nextLine();
						      System.out.println(P1_role);
						      System.out.println(P1_position);
						      System.out.println(P1_position_victoire);
						      
						    //sauter ligne vide 
						      assign_value.nextLine();
						      String P2_role = assign_value.nextLine();
						      int P2_position = assign_value.nextInt();
						      assign_value.nextLine();
						      int P2_position_victoire = assign_value.nextInt();
						      assign_value.nextLine();
						      System.out.println(P2_role);
						      System.out.println(P2_position);
						      System.out.println(P2_position_victoire);
						      
						    //sauter ligne vide 
						      assign_value.nextLine();
						      String P3_role = assign_value.nextLine();
						      int P3_position = assign_value.nextInt();
						      assign_value.nextLine();
						      int P3_position_victoire = assign_value.nextInt();
						      assign_value.nextLine();
						      System.out.println(P3_role);
						      System.out.println(P3_position);
						      System.out.println(P3_position_victoire);
						      
						    //sauter ligne vide 
						      assign_value.nextLine();
						      String P4_role = assign_value.nextLine();
						      int P4_position = assign_value.nextInt();
						      assign_value.nextLine();
						      int P4_position_victoire = assign_value.nextInt();
						      assign_value.nextLine();
						      System.out.println(P4_role);
						      System.out.println(P4_position);
						      System.out.println(P4_position_victoire);
						      
						     Player P1 = new Joueur(P1_role, P1_position_victoire,P1_position);
						     Player P2 = new Bot(P2_role, P2_position_victoire,P2_position);
						     Player P3 = new Bot(P3_role, P3_position_victoire,P3_position);
						     Player P4 = new Bot(P4_role, P4_position_victoire,P4_position);
						     Game partie_saved = new Game(P1,P2,P3,P4);
						     clear_JFrame(frame);
								//make sure it quits when x is clicked
								WindowGame jeu = new WindowGame(partie_saved);
								jeu.affiche_jeux(frame);
								frame.setMinimumSize(new Dimension(1000,800));
						      
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