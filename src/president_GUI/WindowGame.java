package president_GUI;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;
import game.*;


public class WindowGame {
	Game game;
	public ImageIcon img = new ImageIcon("images/b2fv.png");

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

	public void setImagePile() {
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
		//P1 est le joueur qui n'est pas bot (d'apres axel)
		String nomJouer1 = game.p3.getNom();
		//String nomJouer2 = "Player 2";
		String nomJouer3 = game.p4.getNom();
		String nomJouer4 = game.p2.getNom();

		int carte_restante_joueur1 = game.getP3().getHand().size();
		int carte_restante_joueur3 = game.getP4().getHand().size();
		int carte_restante_joueur4 = game.getP2().getHand().size();


		//"pile" de carte

		JPanel panel_carte_joue = new JPanel();
		JLabel image_carte_joue = new JLabel();
		image_carte_joue.setSize(img.getIconHeight(), img.getIconHeight());
		panel_carte_joue.setBorder(blackline);
		panel_carte_joue.add(image_carte_joue);
		fenetre.add(panel_carte_joue, BorderLayout.CENTER);


		//
			
			/*//bouton passer au tour suivant 
			JButton tour_suivant = new JButton("Tour suivant ");
			tour_suivant.setSize(100,100);
			fenetre.add(tour_suivant, BorderLayout.NORTH);
			
			tour_suivant.addActionListener(new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
				img = new ImageIcon("images/b1fv.png");
				fenetre.repaint();
					}
			});
			//
			 */


		//jeux 1

		JPanel panel_image1 = new JPanel();
		ImageIcon icone1 = new ImageIcon("images/b2fv.png");
		JLabel image1 = new JLabel(icone1);
		image1.setSize(icone1.getIconHeight(), icone1.getIconHeight());
		fenetre.add(image1, BorderLayout.NORTH);
		image1.setText("<html>cartes restante : <br/>" + carte_restante_joueur1 + "</html>");

		//jeux 3
		ImageIcon icone3 = new ImageIcon("images/b2fv.png");
		JPanel panel_image3 = new JPanel();
		JLabel image3 = new JLabel(icone3);
		image3.setSize(icone3.getIconHeight(), icone3.getIconHeight());
		fenetre.add(image3, BorderLayout.EAST);
		image3.setText("<html>cartes restante : <br/>" + carte_restante_joueur3 + "</html>");
		//image3.setBorder(blackline);

		//jeux 4
		ImageIcon icone4 = new ImageIcon("images/b2fv.png");
		JPanel panel_image4 = new JPanel();
		JLabel image4 = new JLabel(icone4);
		image4.setSize(icone4.getIconHeight(), icone4.getIconHeight());
		fenetre.add(image4, BorderLayout.WEST);
		image4.setText("<html>cartes restante : <br/>" + carte_restante_joueur4 + "</html>");
		//image4.setBorder(blackline);

		image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
		image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
		image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");


		/*
		 * Jeu du joueur utile
		 */

		//jeux 2
		JPanel panel_Jouer = new JPanel();
		JButton passe_tour = new JButton("passer son tour");
		panel_Jouer.add(passe_tour, BorderLayout.NORTH);
		
		ImageIcon icone112 = new ImageIcon(this.game.p1.getHand().get(0).getImage());
		JLabel image112 = new JLabel(icone112);
		image112.setSize(icone112.getIconHeight(), icone112.getIconHeight());
		panel_Jouer.add(image112);

		//qaund clique image
		image112.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(0).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image112);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image112);
					image112.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");
					try {
						Card g = game.p1.getHand().get(0);
						joueurJoue(0, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		
		//image2.setBorder(blackline);
		if (this.game.getCarteCourante() != null) {
			ImageIcon carteCouranteDebut = new ImageIcon(this.game.getCarteCourante().getImage());
			JLabel imagecarteCouranteDebut = new JLabel(carteCouranteDebut);
			imagecarteCouranteDebut.setSize(carteCouranteDebut.getIconHeight(), carteCouranteDebut.getIconHeight());
			panel_carte_joue.removeAll();
			panel_carte_joue.add(imagecarteCouranteDebut);
		}
		ImageIcon icone100 = new ImageIcon(this.game.p1.getHand().get(1).getImage());
		
		passe_tour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(game.p1.getPositionVictoire() == -1){
						game.tourPasse++;
					}

					System.out.println("Joueurs ayant pass�s un tour " + game.tourPasse);
					System.out.println("----------------------P1----------------");
					if (game.tourPasse == game.players.size() - 1) {
						game.tourPasse = 0;
						game.carteCourante = null;
					}
					jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


		panel_Jouer.setSize(icone100.getIconHeight(), icone100.getIconHeight() + 30);
		JLabel image100 = new JLabel(icone100);
		image100.setSize(icone100.getIconHeight(), icone100.getIconHeight());
		
		panel_Jouer.add(image100);


		//qaund clique image
		image100.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//si besoin
				//image100.removeMouseListener(this);

				if (game.carteCourante == null || game.p1.getHand().get(1).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image100);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image100);
					image100.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");


					try {
						Card g = game.p1.getHand().get(1);
						joueurJoue(1, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		image101.setSize(icone101.getIconHeight(), icone101.getIconHeight());
		panel_Jouer.add(image101);

		//qaund clique image
		image101.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(2).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image101);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image101);
					image101.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");


					try {
						Card g = game.p1.getHand().get(2);
						joueurJoue(2, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		image102.setSize(icone102.getIconHeight(), icone102.getIconHeight());
		panel_Jouer.add(image102);

		//qaund clique image
		image102.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(3).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image102);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image102);
					image102.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");


					try {
						Card g = game.p1.getHand().get(3);
						joueurJoue(3, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}


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
		image103.setSize(icone103.getIconHeight(), icone103.getIconHeight());
		panel_Jouer.add(image103);

		//qaund clique image
		image103.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(4).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image103);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image103);
					image103.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");


					try {
						Card g = game.p1.getHand().get(4);
						joueurJoue(4, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		image104.setSize(icone104.getIconHeight(), icone104.getIconHeight());
		panel_Jouer.add(image104);

		//qaund clique image
		image104.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(5).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image104);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image104);
					image104.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");
					try {
						Card g = game.p1.getHand().get(5);
						joueurJoue(5, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		image105.setSize(icone105.getIconHeight(), icone105.getIconHeight());
		panel_Jouer.add(image105);

		//qaund clique image
		image105.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(6).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image105);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image105);
					image105.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");
					try {
						Card g = game.p1.getHand().get(6);
						joueurJoue(6, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		image106.setSize(icone106.getIconHeight(), icone106.getIconHeight());
		panel_Jouer.add(image106);

		//qaund clique image
		image106.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(7).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image106);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image106);
					image106.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");
					try {
						Card g = game.p1.getHand().get(7);
						joueurJoue(7, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		image107.setSize(icone107.getIconHeight(), icone107.getIconHeight());
		panel_Jouer.add(image107);

		//qaund clique image
		image107.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(8).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image107);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image107);
					image107.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");
					try {
						Card g = game.p1.getHand().get(8);
						joueurJoue(8, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		image108.setSize(icone108.getIconHeight(), icone108.getIconHeight());
		panel_Jouer.add(image108);

		//qaund clique image
		image108.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(9).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image108);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image108);
					image108.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");
					try {
						Card g = game.p1.getHand().get(9);
						joueurJoue(9, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		image109.setSize(icone109.getIconHeight(), icone109.getIconHeight());
		panel_Jouer.add(image109);

		//qaund clique image
		image109.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(10).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image109);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image109);
					image109.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");
					try {
						Card g = game.p1.getHand().get(10);
						joueurJoue(10, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		image110.setSize(icone110.getIconHeight(), icone110.getIconHeight());
		panel_Jouer.add(image110);

		//qaund clique image
		image110.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(11).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image110);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image110);
					image110.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");
					try {
						Card g = game.p1.getHand().get(11);
						joueurJoue(11, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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
		image111.setSize(icone111.getIconHeight(), icone111.getIconHeight());
		panel_Jouer.add(image111);

		//qaund clique image
		image111.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (game.carteCourante == null || game.p1.getHand().get(12).carteAPoseEstPlusGrandeQue(game.carteCourante)) {
					panel_Jouer.remove(image111);
					panel_carte_joue.removeAll();
					panel_carte_joue.add(image111);
					image111.removeMouseListener(this);
					image1.setText("<html>" + nomJouer1 + "<br/>" + "cartes restante : <br/>" + game.getP3().getHand().size() + "</html>");
					image3.setText("<html>" + nomJouer3 + "<br/>" + "cartes restante : <br/>" + game.getP4().getHand().size() + "</html>");
					image4.setText("<html>" + nomJouer4 + "<br/>" + "cartes restante : <br/>" + game.getP2().getHand().size() + "</html>");
					try {
						Card g = game.p1.getHand().get(12);
						joueurJoue(12, panel_carte_joue, fenetre);
						if (g.getValeur() != 15) {
							jouer(game.players.indexOf(game.p1), panel_carte_joue, fenetre);
						}
						SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

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

		

		fenetre.add(panel_Jouer, BorderLayout.SOUTH);
		//image19.setBorder(blackline);

		/*
		 * Fin Jeu du joueur utile
		 */


	}

	public void joueurJoue(int indexCarte, JPanel panel_carte_joue, JFrame fenetre) throws Exception {
		panel_carte_joue = panel_carte_joue;
		game.carteCourante = game.p1.getHand().get(indexCarte);
		if (game.carteCourante.getValeur() == 15) {
			game.carteCourante = null;
		}
		game.debugCarteCourante();
		game.p1.poserCarte(indexCarte);
		int indexJoueur = game.players.indexOf(game.p1);
		if (game.p1.aFini()) {
			game.p1.setNom(game.nomPlaceGagnant());
			game.p1.setPositionVictoire(game.placeGagnant(game.p1.getNom()));
			game.players.remove(game.p1);
		}
		if(game.nombreGagnant == 3){
			game.players.get(0).getHand().clear();
			game.testerFinJoueur(game.players.get(0));
			Fenetre_fin_jeu aaa = new Fenetre_fin_jeu(game);
			game.firstGame = 1;
			WindowGame.clear_JFrame(fenetre);
			fenetre.dispose();
		}
	}

	public void jouer(int indexJoueur, JPanel panel_carte_joue, JFrame fenetre) throws Exception {
		game.tourPasse = 0;
		for (int i = indexJoueur + 1; i < game.players.size(); i++) {
			Card result = game.jouerBotTour(game.players.get(i));
			if (result == null) {
				game.tourPasse++;
				if (game.tourPasse == game.players.size() - 1) {
					game.carteCourante = null;
					panel_carte_joue.removeAll();
					System.out.println(game.players.get(i).getNom() + " passe son tour");
					System.out.println("Joueurs ayant pass�s un tour " + game.tourPasse);
					game.tourPasse = 0;
				} else {
					System.out.println(game.players.get(i).getNom() + " passe son tour");
					System.out.println("Joueurs ayant pass�s un tour " + game.tourPasse);
				}
			} else {
				game.tourPasse = 0;
				if (result.getValeur() == 15) {
					System.out.println("Mon bot a pos� un deux");
					game.carteCourante = null;
					ImageIcon iconeBot = new ImageIcon(result.getImage());
					JLabel imageBot = new JLabel(iconeBot);
					imageBot.setSize(iconeBot.getIconHeight(), iconeBot.getIconHeight());
					//panel_carte_joue.removeAll();
					panel_carte_joue.add(imageBot);
					SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					boolean continuerPoser = true;
					if (!game.testerFinJoueur(game.players.get(i))) {
						while (continuerPoser) {
							System.out.println("Je suis dans la boucle");
							if (game.testerFinJoueur(game.players.get(i))) {
								continuerPoser = false;
								System.out.println("Je suis sorti de la boucle par testerFin");
								break;
							}
							result = game.jouerBotTour(game.players.get(i));

							iconeBot = new ImageIcon(result.getImage());
							imageBot = new JLabel(iconeBot);
							imageBot.setSize(iconeBot.getIconHeight(), iconeBot.getIconHeight());
							//panel_carte_joue.removeAll();
							panel_carte_joue.add(imageBot);
							SwingUtilities.updateComponentTreeUI(panel_carte_joue);


							if ((result.getValeur() == 15)) {
								game.carteCourante = null;
								iconeBot = new ImageIcon(result.getImage());
								imageBot = new JLabel(iconeBot);
								imageBot.setSize(iconeBot.getIconHeight(), iconeBot.getIconHeight());
								//panel_carte_joue.removeAll();
								panel_carte_joue.add(imageBot);
								SwingUtilities.updateComponentTreeUI(panel_carte_joue);
							} else {
								game.carteCourante = result;
								continuerPoser = false;
								System.out.println("Je suis dans la boucle");
								break;
							}

						}
						;
					}
				} else {

					game.carteCourante = result;
					ImageIcon iconeBot = new ImageIcon(result.getImage());
					JLabel imageBot = new JLabel(iconeBot);
					imageBot.setSize(iconeBot.getIconHeight(), iconeBot.getIconHeight());
					//panel_carte_joue.removeAll();
					panel_carte_joue.add(imageBot);
					SwingUtilities.updateComponentTreeUI(panel_carte_joue);
				}
				game.testerFinJoueur(game.players.get(i));
			}

		}
		for (int i = 0; i < indexJoueur; i++) {
			Card result = game.jouerBotTour(game.players.get(i));
			if (result == null) {
				game.tourPasse++;
				if (game.tourPasse == game.players.size() - 1) {
					game.carteCourante = null;
					panel_carte_joue.removeAll();
					System.out.println(game.players.get(i).getNom() + " passe son tour");
					System.out.println("Joueurs ayant pass�s un tour " + game.tourPasse);
					game.tourPasse = 0;
				} else {
					System.out.println(game.players.get(i).getNom() + " passe son tour");
					System.out.println("Joueurs ayant pass�s un tour " + game.tourPasse);

				}
			} else {
				game.tourPasse = 0;
				if (result.getValeur() == 15) {
					game.carteCourante = null;
					ImageIcon iconeBot = new ImageIcon(result.getImage());
					JLabel imageBot = new JLabel(iconeBot);
					imageBot.setSize(iconeBot.getIconHeight(), iconeBot.getIconHeight());
					//panel_carte_joue.removeAll();
					panel_carte_joue.add(imageBot);
					SwingUtilities.updateComponentTreeUI(panel_carte_joue);
					boolean continuerPoser = true;
					if (!game.testerFinJoueur(game.players.get(i))) {
						while (continuerPoser) {
							System.out.println("Je suis dans la boucle");
							if (game.testerFinJoueur(game.players.get(i))) {
								continuerPoser = false;
								System.out.println("Je suis sorti de la boucle par testerFin");
								break;
							}
							result = game.jouerBotTour(game.players.get(i));

							iconeBot = new ImageIcon(result.getImage());
							imageBot = new JLabel(iconeBot);
							imageBot.setSize(iconeBot.getIconHeight(), iconeBot.getIconHeight());
							//panel_carte_joue.removeAll();
							panel_carte_joue.add(imageBot);
							SwingUtilities.updateComponentTreeUI(panel_carte_joue);


							if ((result.getValeur() == 15)) {
								game.carteCourante = null;
								iconeBot = new ImageIcon(result.getImage());
								imageBot = new JLabel(iconeBot);
								imageBot.setSize(iconeBot.getIconHeight(), iconeBot.getIconHeight());
								//panel_carte_joue.removeAll();
								panel_carte_joue.add(imageBot);
								SwingUtilities.updateComponentTreeUI(panel_carte_joue);
							} else {
								game.carteCourante = result;
								continuerPoser = false;
								System.out.println("Je suis dans la boucle");
								break;
							}

						}
						;
					}
				} else {

					game.carteCourante = result;
					ImageIcon iconeBot = new ImageIcon(result.getImage());
					JLabel imageBot = new JLabel(iconeBot);
					imageBot.setSize(iconeBot.getIconHeight(), iconeBot.getIconHeight());
					//panel_carte_joue.removeAll();
					panel_carte_joue.add(imageBot);
					SwingUtilities.updateComponentTreeUI(panel_carte_joue);
				}
				game.testerFinJoueur(game.players.get(i));
			}
		}

		if(game.nombreGagnant == 3) {
			game.players.get(0).getHand().clear();
			game.testerFinJoueur(game.players.get(0));
			Fenetre_fin_jeu aaa = new Fenetre_fin_jeu(game);
			game.firstGame = 1;
			WindowGame.clear_JFrame(fenetre);
			fenetre.dispose();
		}
		System.out.println(game.p1.getNom());
		System.out.println(game.p2.getNom());
		System.out.println(game.p3.getNom());
		System.out.println(game.p4.getNom());
		System.out.println("Joueur ayant gagn� : " + game.nombreGagnant);
		System.out.println(game.p1.aFini());
		System.out.println(game.players.size());
	}

}


