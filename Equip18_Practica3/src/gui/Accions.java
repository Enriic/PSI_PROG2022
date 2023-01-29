package gui;
import usuari.*;
import java.io.*;
import javax.swing.*;
public class Accions extends JDialog{
	
	private static final long serialVersionUID = 1L;	
	  
	  public Accions(LlistaUsuaris Lu) {
		  
		  new DemanarCodi("TEST",Lu);
		  
	  }
	  
	  public static void main(String[] args) throws IOException {
		  
		  LlistaUsuaris LU1 = new LlistaUsuaris (5);
		  CarregarFitxerSer(LU1);
		  new Accions(LU1);
	  }
		
		
		
		public static void CarregarFitxerSer(LlistaUsuaris L) {
			ObjectInputStream fit;
			try {
				
				fit = new ObjectInputStream(new FileInputStream("usuaris.ser"));
				
				while(true) {
					L.afegirUsuari((Usuari)fit.readObject());
					
				}
			
			}
			catch (EOFException e) {
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
