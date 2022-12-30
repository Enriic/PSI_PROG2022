package gui;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	public GUI(String titol) {
		super(titol);
		
		setLayout(new FlowLayout());
		add(new JButton("Opció 1"));
		add(new JButton("Opció 2"));
		add(new JButton("Opció 3"));
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUI("Finestra2");
		
	}

}
