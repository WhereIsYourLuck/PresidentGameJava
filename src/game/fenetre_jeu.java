import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class fenetre_jeu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public fenetre_jeu() {
		
			super("Président");
			//make sure it quits when x is clicked
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//set default size of window
			this.setSize(700, 550);
			//buttons 
			JButton distribute = new JButton("Distribuer les cartes");
			distribute.setBounds(50,150, 100, 30);
			distribute.setSize(50,150);
			this.add(distribute);
		
	}
	
	public static void main(String[] args) {
		fenetre_jeu jeu = new fenetre_jeu();
		jeu.setVisible( true );

	}

}
