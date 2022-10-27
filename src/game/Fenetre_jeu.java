package fenetres;

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

import carte.*;
public class Fenetre_jeu  {

	/**
	 * 
	 */

	public Fenetre_jeu() {
			Border blackline = BorderFactory.createLineBorder(Color.BLACK);
		
		
			JFrame frame = new JFrame("Président");
			//make sure it quits when x is clicked
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLayout(new BorderLayout());
			//add image 
			JPanel panel_image = new JPanel();
			ImageIcon icone = new ImageIcon("images/b1fv.png");
			JLabel image = new JLabel(icone);
			image.setSize(icone.getIconHeight(),icone.getIconHeight());
			frame.add(image, BorderLayout.NORTH);
			
			//image.setBorder(blackline);
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
					frame.getContentPane().removeAll();
					frame.repaint();
					}
			});
			
			
			
			
		
	}
	
	
	public static void main(String[] args) {
		Fenetre_jeu jeu = new Fenetre_jeu();
		
		
		

	}

}
