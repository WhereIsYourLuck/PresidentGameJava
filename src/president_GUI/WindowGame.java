package president_GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import game.*;


public class WindowGame{
			Game game;

		/**
		 * 
		 */

		public WindowGame(Game g) {
			this.game = g;
			
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
			
		public void affiche_jeux(JFrame fenetre) {
			//debug affichage
			Border blackline = BorderFactory.createLineBorder(Color.BLACK);
			
			//variables 
			int carte_restante_joueur1 = game.getP1().getHand().size();
			int carte_restante_joueur3 = game.getP3().getHand().size();
			int carte_restante_joueur4 = game.getP4().getHand().size();
			
			//"pile" de carte 
			JPanel panel_carte_joue = new JPanel();
			ImageIcon icone_carte_joue = new ImageIcon("images/b2fv.png");
			JLabel image_carte_joue = new JLabel(icone_carte_joue);
			image_carte_joue.setSize(icone_carte_joue.getIconHeight(),icone_carte_joue.getIconHeight());
			fenetre.add(image_carte_joue, BorderLayout.CENTER);
			//
			
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
			
			//image2.setBorder(blackline);
				
			
			ImageIcon icone100 = new ImageIcon(this.game.p1.getHand().get(1).getImage());
			JPanel panel_Jouer = new JPanel();
			panel_Jouer.setSize(icone100.getIconHeight(), icone100.getIconHeight()+30);
			JLabel image100 = new JLabel(icone100);
			image100.setSize(icone100.getIconHeight(),icone100.getIconHeight());
			panel_Jouer.add(image100);
			
			//qaund clique image
			image100.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
					if(game.carteCourante == null || game.carteCourante.isSmallerThan(game.p1.getHand().get(1))){
						try {
							game.jouer(1);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
                	panel_Jouer.remove(image100); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image100.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image100.setBorder(null);
                }

            });
			
			
			ImageIcon icone101 = new ImageIcon(this.game.p1.getHand().get(2).getImage());
			JLabel image101 = new JLabel(icone101);
			image101.setSize(icone101.getIconHeight(),icone101.getIconHeight());
			panel_Jouer.add(image101);
			
			//qaund clique image
			image101.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image101); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image101.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image101.setBorder(null);
                }

            });
			
			ImageIcon icone102 = new ImageIcon(this.game.p1.getHand().get(3).getImage());
			JLabel image102 = new JLabel(icone102);
			image102.setSize(icone102.getIconHeight(),icone102.getIconHeight());
			panel_Jouer.add(image102);
			
			//qaund clique image
			image102.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image102); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image102.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image102.setBorder(null);
                }

            });
			
			ImageIcon icone103 = new ImageIcon(this.game.p1.getHand().get(4).getImage());
			JLabel image103 = new JLabel(icone103);
			image103.setSize(icone103.getIconHeight(),icone103.getIconHeight());
			panel_Jouer.add(image103);
			
			//qaund clique image
			image103.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image103); 
                	panel_Jouer.repaint();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                	image103.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image103.setBorder(null);
                }
                
            });
			
			ImageIcon icone104 = new ImageIcon(this.game.p1.getHand().get(5).getImage());
			JLabel image104 = new JLabel(icone104);
			image104.setSize(icone104.getIconHeight(),icone104.getIconHeight());
			panel_Jouer.add(image104);
			
			//qaund clique image
			image104.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image104); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image104.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image104.setBorder(null);
                }

            });
			
			ImageIcon icone105 = new ImageIcon(this.game.p1.getHand().get(6).getImage());
			JLabel image105 = new JLabel(icone105);
			image105.setSize(icone105.getIconHeight(),icone105.getIconHeight());
			panel_Jouer.add(image105);
			
			//qaund clique image
			image105.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image105); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image105.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image105.setBorder(null);
                }

            });
			
			ImageIcon icone106 = new ImageIcon(this.game.p1.getHand().get(7).getImage());
			JLabel image106 = new JLabel(icone106);
			image106.setSize(icone106.getIconHeight(),icone106.getIconHeight());
			panel_Jouer.add(image106);
			
			//qaund clique image
			image106.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image106); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image106.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image106.setBorder(null);
                }

            });
			
			ImageIcon icone107 = new ImageIcon(this.game.p1.getHand().get(8).getImage());
			JLabel image107 = new JLabel(icone107);
			image107.setSize(icone107.getIconHeight(),icone107.getIconHeight());
			panel_Jouer.add(image107);
			
			//qaund clique image
			image107.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image107); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image107.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image107.setBorder(null);
                }

            });
			
			ImageIcon icone108 = new ImageIcon(this.game.p1.getHand().get(9).getImage());
			JLabel image108 = new JLabel(icone108);
			image108.setSize(icone108.getIconHeight(),icone108.getIconHeight());
			panel_Jouer.add(image108);
			
			//qaund clique image
			image108.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image108); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image108.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image108.setBorder(null);
                }

            });
			
			ImageIcon icone109 = new ImageIcon(this.game.p1.getHand().get(10).getImage());
			JLabel image109 = new JLabel(icone109);
			image109.setSize(icone109.getIconHeight(),icone109.getIconHeight());
			panel_Jouer.add(image109);
			
			//qaund clique image
			image109.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image109); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image109.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image109.setBorder(null);
                }

            });
			
			ImageIcon icone110 = new ImageIcon(this.game.p1.getHand().get(11).getImage());
			JLabel image110 = new JLabel(icone110);
			image110.setSize(icone110.getIconHeight(),icone110.getIconHeight());
			panel_Jouer.add(image110);
			
			//qaund clique image
			image110.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image110); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image110.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image110.setBorder(null);
                }

            });
			
			ImageIcon icone111 = new ImageIcon(this.game.p1.getHand().get(12).getImage());
			JLabel image111 = new JLabel(icone111);
			image111.setSize(icone111.getIconHeight(),icone111.getIconHeight());
			panel_Jouer.add(image111);
			
			//qaund clique image
			image111.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image111); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image111.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image111.setBorder(null);
                }

            });
			
			ImageIcon icone112 = new ImageIcon(this.game.p1.getHand().get(0).getImage());
			JLabel image112 = new JLabel(icone112);
			image112.setSize(icone112.getIconHeight(),icone112.getIconHeight());
			panel_Jouer.add(image112);
			
			//qaund clique image
			image112.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	panel_Jouer.remove(image112); 
                	panel_Jouer.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                	image112.setBorder(blackline);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                	image112.setBorder(null);
                }

            });
			
			fenetre.add(panel_Jouer, BorderLayout.SOUTH);
			//image19.setBorder(blackline);
			
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


