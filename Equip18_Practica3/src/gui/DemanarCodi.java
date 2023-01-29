package gui;

import javax.swing.JOptionPane;
import usuari.*;

public class DemanarCodi {
	private static LlistaUsuaris L;
	private static String codi;
	
	public DemanarCodi() {
	}
	public DemanarCodi(String t, LlistaUsuaris L) {
		if (demanarCodi(L)){
			new Window("TEST");
		}
		
	}
	
	public  boolean demanarCodi(LlistaUsuaris L) {
		  boolean trobat= false;
		  int v = 0;
		   codi = JOptionPane.showInputDialog("Introdueix codi d'usuari: ");
		  try {
				  for (int i = 0 ;  i< L.getNumUsuaris(); i++) {
				if (L.getUsuariFromLlista(i).getCodi().equals(codi)) {
					trobat = true;
				}
				
			}
		  
		  while (( codi.equals("") ||!trobat)  && (v<5) ) {
				if (codi.equals(""))JOptionPane.showMessageDialog(null, "Cal un codi", "ERROR", JOptionPane.ERROR_MESSAGE);
				else JOptionPane.showMessageDialog(null, "Codi incorrecte", "ERROR", JOptionPane.ERROR_MESSAGE);
				
				codi = JOptionPane.showInputDialog("Introdueix codi: ");
				for (int i = 0 ;  i< L.getNumUsuaris(); i++) {
					if (L.getUsuariFromLlista(i).getCodi().equals(codi)) {
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
	
}