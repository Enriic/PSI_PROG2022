package gui;
import usuari.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.*;

import productes.Be;
import productes.Data;
import productes.LlistaProductes;
import productes.Servei;

public class Accions extends JDialog{
	
	  
	  public Accions(LlistaUsuaris L) {
		  String codi = JOptionPane.showInputDialog("Introdueix codi d'usuari: ");
		  boolean incorrecte = false;
		  while (codi == null || codi.equals("") || !incorrecte) {
				JOptionPane.showMessageDialog(null, "Cal un codi", "ERROR", JOptionPane.ERROR_MESSAGE);
				codi = JOptionPane.showInputDialog("Introdueix codi: ");
				for (int i = 0 ;  i< L.getNumUsuaris(); i++) {
					if (L.getClass().equals(codi)) {
						incorrecte = false;
					}
					
				}
			}
	  }
	  
	  public static void main(String[] args) {
		  
		  Usuari user1= new Usuari("Gerard", "marinperezgeri@gmail.com", "43850","Gerard1234");			//Prueba user 1
		  Usuari user2= new Usuari("Argi", "argiderirurt@gmail.com", "31001","4rg1");				//Prueba user 2
		  Usuari user3= new Usuari("Albert", "alberturv@gmail.com", "54850","4tun");				//Prueba user 3
		  Usuari user4= new Usuari("Ramzi", "ramziurv@gmail.com", "98775","P3scad0R");				//Prueba user 4
		  LlistaUsuaris LU1 = new LlistaUsuaris (5);
		  LU1.afegirUsuari(user1);
		  LU1.afegirUsuari(user2);
		  LU1.afegirUsuari(user3);
		  LU1.afegirUsuari(user4);
		  new Accions(LU1);
	  }
	  
	  
	  
	  

		public static void CarregarLlistaFitxer(String nomFitxer, LlistaProductes LlistaP ) throws IOException{
			String type;
			String ID;
			String descripcio;
			float amplada;
			float alçada;
			float fons;
			float pes;
			String data;
			String frase;
			int dia, mes, any;
			int numIntercanvis;
			int numActiu;
			boolean actiu;
			
			Scanner F = new Scanner (new File(nomFitxer));
			Scanner particio;
			
			while (F.hasNext()) {
				
				frase = F.nextLine();
				particio=new Scanner(frase);
				particio.useDelimiter(";");
				particio.useLocale(Locale.ENGLISH);

				type = particio.next();
				
				if (type.equalsIgnoreCase("B")) {
					
					ID = particio.next();
					type = particio.next();
					descripcio = particio.next();

					data = particio.next();
					dia = Integer.parseInt(data.split("/")[0]);
					mes = Integer.parseInt(data.split("/")[1]);
					any = Integer.parseInt(data.split("/")[2]);
					Data dataInicial = new Data (dia, mes, any);
					amplada = particio.nextFloat();
					alçada = particio.nextFloat();
					fons = particio.nextFloat();
					pes = particio.nextFloat();
					data = particio.next();
					dia = Integer.parseInt(data.split("/")[0]);
					mes = Integer.parseInt(data.split("/")[1]);
					any = Integer.parseInt(data.split("/")[2]);
					Data dataIntercanvi;
					if(dia == 0 && mes == 0 && any == 0) {
						dataIntercanvi = new Data(true);
					}else {
						dataIntercanvi = new Data (dia, mes, any);
					}
					numActiu = particio.nextInt();
					if (numActiu == 1)
						actiu = true;
					else
						actiu = false;
					
					Be B = new Be(ID, type, descripcio, dataInicial, amplada, alçada, fons, pes, dataIntercanvi, actiu);
					B.esActiu(); //abans d'afegir comprovem si es veritat que encara esta actiu (pot ser que lutim cop de guardar ho estigues i ara ja no)
					LlistaP.afegirProducte(B);    
				}									
				
				else if (type.equalsIgnoreCase("S")) {
					ID = particio.next();
					type = particio.next();
					descripcio = particio.next();
					
					data = particio.next();
					dia = Integer.parseInt(data.split("/")[0]);
					mes = Integer.parseInt(data.split("/")[1]);
					any = Integer.parseInt(data.split("/")[2]);
					Data dataInicial = new Data (dia, mes, any);
					
					data = particio.next();
					dia = Integer.parseInt(data.split("/")[0]);
					mes = Integer.parseInt(data.split("/")[1]);
					any = Integer.parseInt(data.split("/")[2]);
					Data dataCaducitat = new Data (dia, mes, any);
					
					numIntercanvis = particio.nextInt();
					numActiu = particio.nextInt();
					if (numActiu == 1)
						actiu = true;
					else
						actiu = false;
					Servei S = new Servei(ID, type, descripcio, dataInicial, dataCaducitat, numIntercanvis, actiu);
					S.esActiu();
					LlistaP.afegirProducte(S);
				}
			}
			
			F.close();
			
		}
		
		public static void SobreescriureFitxer(String fitxer, LlistaProductes L) throws IOException {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(fitxer));
			bw.write("");
			bw.close();
			L.escriureLlistaAlFitxer();
		}
		
		public static void SobreescriureFitxerSer(LlistaUsuaris L) {
			ObjectOutputStream fit;
			try {
				fit = new ObjectOutputStream (new FileOutputStream("usuaris.ser"));
				for (int i = 0 ; i<L.getNumUsuaris(); i++) {
					fit.writeObject(L.getUsuariFromLlista(i));
				}
				fit.close();
			}
			catch (IOException e) {
				System.out.println("Error");
			}
			
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
