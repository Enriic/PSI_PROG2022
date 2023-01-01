package gui;
import usuari.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Accions extends JDialog{
	
	  
	  public Accions(LlistaUsuaris L) {
		  String codi = JOptionPane.showInputDialog("Introdueix codi d'usuari: ");
		  boolean incorrecte = true;
		  while (codi == null || codi.equals("") || !incorrecte) {
				JOptionPane.showMessageDialog(null, "Cal un codi", "ERROR", JOptionPane.ERROR_MESSAGE);
				codi = JOptionPane.showInputDialog("Introdueix codi: ");
				for (int i = 0 ;  i< L.getNumUsuaris(); i++) {
					if (L.getNom().equals(codi)) {
						incorrecte = false;
					}
					
				}
			}
	  }
	  
	  public static void main(String[] args) {
		  
		  Usuari user1= new Usuari("Gerard", "marinperezgeri@gmail.com", "43850");			//Prueba user 1
			Usuari user2= new Usuari("Argi", "argiderirurt@gmail.com", "31001");				//Prueba user 2
			Usuari user3= new Usuari("Albert", "alberturv@gmail.com", "54850");				//Prueba user 3
			Usuari user4= new Usuari("Ramzi", "ramziurv@gmail.com", "98775");					//Prueba user 4
			LlistaUsuaris LU1 = new LlistaUsuaris (5);
			LU1.afegirUsuari(user1);
			LU1.afegirUsuari(user2);
			LU1.afegirUsuari(user3);
			LU1.afegirUsuari(user4);
		  new Accions(LU1);
	  }
	  
}
