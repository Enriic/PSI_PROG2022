package gui;
import java.awt.*;
import javax.swing.*;

public class GUI2 extends JFrame {
	private static final long serialVersionUID = 1L;

	public GUI2(String titol) {
		super(titol);
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		demanarCodi();
		setLayout(new BorderLayout());
		JLabel etiqueta2=new JLabel("Codi d'usuari: "); this.add(etiqueta2);
		JTextField nom2=new JPasswordField(10);
		nom2.setForeground(Color.BLACK); this.add(nom2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
	}
	
	public void demanarCodi() {
		//setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel etiqueta2=new JLabel("Codi d'usuari: "); this.add(etiqueta2);
		JTextField nom2=new JPasswordField(10);
		nom2.setForeground(Color.BLACK); this.add(nom2);

		
	}

	public static void main(String[] args) {
		new GUI2("TEST");
	}

}
