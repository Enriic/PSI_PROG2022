package gui;
import usuari.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Accions extends JDialog{
	
	  
	  public Accions() {
		  String codi = JOptionPane.showInputDialog("Introdueix codi d'usuari: ");
		  while (codi == null || codi.equals("")) {
				JOptionPane.showMessageDialog(null, "Cal un codi", "ERROR", JOptionPane.ERROR_MESSAGE);
				codi = JOptionPane.showInputDialog("Introdueix codi: ");
				
			}
	  }
	  
	  public static void main(String[] args) {
		  new Accions();
	  }
	  
}
