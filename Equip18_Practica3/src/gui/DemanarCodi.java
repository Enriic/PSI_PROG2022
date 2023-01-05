package gui;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

import usuari.*;

public class DemanarCodi {
	private static LlistaUsuaris L;
	private static String codi;
	
	public DemanarCodi() {
		
	}
	
	
	public  boolean demanarCodi() {
		CarregarFitxerSer(L);
		  boolean trobat= false;
		  int v = 0;
		   codi = JOptionPane.showInputDialog("Introdueix codi d'usuari: ");
		  try {
				  for (int i = 0 ;  i< L.getNumUsuaris(); i++) {
				if (L.getUsuariFromLlista(i).getCodi().equals(codi)) {
					JOptionPane.showMessageDialog(null, "BIEN", "BIEN2", JOptionPane.OK_OPTION);
					trobat = true;
				}
				
			}
		  
		  while (( codi.equals("") ||!trobat)  && (v<5) ) {
				JOptionPane.showMessageDialog(null, "Cal un codi", "ERROR", JOptionPane.ERROR_MESSAGE);
				codi = JOptionPane.showInputDialog("Introdueix codi: ");
				for (int i = 0 ;  i< L.getNumUsuaris(); i++) {
					if (L.getUsuariFromLlista(i).getCodi().equals(codi)) {
						JOptionPane.showMessageDialog(null, "BIEN", "BIEN2", JOptionPane.OK_OPTION);
						trobat = true;
					}
				}
				v++;
			}
		  }catch (NullPointerException e) {
			  System.out.println("cancelado");
		  }
		  return trobat;
	  }
	
	
	public static void CarregarFitxerSer(LlistaUsuaris X) {
		ObjectInputStream fit;
		try {
			
			fit = new ObjectInputStream(new FileInputStream("usuaris.ser"));
			
			while(true) {
				L.afegirUsuari((Usuari)fit.readObject());
				
			}
		
		}
		catch (EOFException e) {
			System.out.println("Llegit correctament");
		}
		catch (IOException e) {
			System.out.println("Error leer fitxer");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error, no es troba la classe usuari."+e);
		}
		catch (ClassCastException e){
			System.out.println("Error, el format de l'arxiu no és correcte per la definició actual de la classe usuari."+e);
		}
}
}
