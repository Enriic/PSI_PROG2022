package gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class BuscarOfertes {
	
	private Accions f;
	
	public BuscarOfertes (Accions f) {
		this.f = f;
	}
	
	public void click(ActionEvent e) {
		JButton x =  (JButton) e.getSource();
		
	}
}
