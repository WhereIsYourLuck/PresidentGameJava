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

    public Fenetre_debut_jeu(Game g) {
        //debug affichage
        this.game = g;
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
                //distribution des cartes
                clear_JFrame(frame);
                frame.setMinimumSize(new Dimension(500,400));
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
                    for (int i=0; i<4; i++){
                        String data = myReader.nextLine();
                        String[] data_values = data.split(" ");
                        data_values[2] = data_values[2].replaceAll(";", "");
                        Player p = new Player( data_values[0], Integer.parseInt(data_values[1]),
                                Boolean.parseBoolean(data_values[2]), Integer.parseInt(data_values[1]) + 1);
                        // MAJ des données des joeurs
                        switch (i) {
                            case 0 -> {
                                game.p1 = p;
                                game.players.set(0, game.p1);
                            }
                            case 1 -> {
                                game.p2 = p;
                                game.players.set(1, game.p2);
                            }
                            case 2 -> {
                                game.p3 = p;
                                game.players.set(2, game.p3);
                            }
                            case 3 -> {
                                game.p4 = p;
                                game.players.set(3, game.p4);
                            }
                        }
                    }
                    //Verification de l'importation des joeurs
                    System.out.println(game.players);
                    //lancer une partie
                    game.relancerPartie();
                    //Verification de la distribution des cartes
                    System.out.println(game.players);
                    JOptionPane.showMessageDialog(null,"importation réussite");
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