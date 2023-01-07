package gui;
import usuari.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import productes.*;
import peticions.*;

public class Accions extends JDialog{
	private static String codi;
	
	  
	  public Accions(LlistaUsuaris Lu, LlistaPeticions Lp,LlistaProductes LlistaP) {
		  
		  new DemanarCodi("TEST",Lu);
		  
	  }
	  
	  public static void main(String[] args) throws IOException {
		  
		  LlistaUsuaris LU1 = new LlistaUsuaris (5);
		  LlistaPeticions Lp= new LlistaPeticions(5);
		  LlistaProductes Lproductes = new LlistaProductes(5);
		  CarregarFitxerSer(LU1);
		  //CarregarLlistaPeticionsFitxer(Lp);
		  new Accions(LU1,Lp,Lproductes);
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

		public static void CarregarLlistaProductesFitxer(String nomFitxer, LlistaProductes LlistaP ) throws IOException{
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

}
