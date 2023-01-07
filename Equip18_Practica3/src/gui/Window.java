package gui;
import usuari.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import productes.*;
import peticions.*;

import java.awt.event.*;


public class Window extends JFrame {
	private JPanel botons = new JPanel();
	private JButton buscarOfertesIntercanvi= new JButton ("Buscar ofertes d'intercanvi actives");
	private JButton afegirPeticio = new JButton("Afegir peticio d'intercanvi");
	private JButton consultarIntercanvisFets = new JButton ("Consultar els intercanvis que ha fet");
	private JButton canviarUsuari = new JButton ("Canviar l'usuari");
	private static String codi;
	
	public Window(String titul) {
		super(titul);
		
		botons.setLayout(new FlowLayout());
		botons.add(buscarOfertesIntercanvi);
		botons.add(afegirPeticio);
		botons.add(consultarIntercanvisFets);
		botons.add(canviarUsuari);
		
		this.add(botons, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
		
		buscarOfertesIntercanvi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent buscarOfertes) {
				LlistaProductes Lproductes = new LlistaProductes(1);
				LlistaUsuaris Lu = new LlistaUsuaris(5);
				CarregarFitxerSer(Lu);
				try {
					CarregarLlistaFitxer("Productes.txt",Lproductes);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				new BuscarOfertes(Lproductes);
			}
			
		});
		
		afegirPeticio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent afegirPeticio) {
				setVisible(false);
				JFrame newFrame = new JFrame ("TEST");
				newFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				newFrame.setSize(300,300);
				newFrame.setVisible(true);
			}
			
		});
		
		consultarIntercanvisFets.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent consultarIntercanvis) {
				setVisible(false);
				JFrame newFrame = new JFrame ("TEST");
				newFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				newFrame.setSize(300,300);
				newFrame.setVisible(true);
			}
			
		});
		
		
		canviarUsuari.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent canviarUsuari) {
				 LlistaUsuaris LU1 = new LlistaUsuaris (5);
				  CarregarFitxerSer(LU1);
				  setVisible(false);
				  new DemanarCodi("TEST",LU1);
			}
			
		});
		
		}
	
	
	public static boolean demanarCodi(LlistaUsuaris L) {
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
		
	public static void CarregarLlistaPeticionsFitxer(LlistaPeticions LlistaPet) throws IOException {
	    String codi;
	    Usuari usuariA; 		// Usuario que HACE la petición
	    Usuari usuariB; 		// Usuario que RECIBE la petición
	    String codiProducteA;
	    String codiProducteB;
	    int estat;
	    String frase;
	    Scanner F = new Scanner (new File("Peticions.txt"));
	    Scanner particio;
	    String stringUsuari;
	    String partsUsuari[];
	    String nomusuari;
	    String correuusuari;
	    String codipostal;
	    String contrasena;
	    int intercanvis;
	    int valoracio;

	    while (F.hasNext()) {
	        frase = F.nextLine();
	        particio = new Scanner(frase);
	        particio.useDelimiter(";");
	        particio.useLocale(Locale.ENGLISH);

	        codi = particio.next();
	        nomusuari = particio.next();
	        correuusuari= particio.next();
	        codipostal= particio.next();
	        intercanvis = particio.nextInt();
	        valoracio=particio.nextInt();
	        contrasena = particio.next();
	        usuariA = new Usuari(nomusuari, correuusuari, codipostal,contrasena);
	        
	        usuariA.setIntercanvis(intercanvis);
	        
	        nomusuari = particio.next();
	        correuusuari= particio.next();
	        codipostal= particio.next();
	        intercanvis = particio.nextInt();
	        valoracio=particio.nextInt();
	        contrasena = particio.next();
	        usuariB = new Usuari(nomusuari, correuusuari, codipostal,contrasena);
	        usuariB.setIntercanvis(intercanvis);
	        codiProducteA=particio.next();
	        codiProducteB=particio.next();
	        
	        estat = particio.nextInt();

	        Peticio pet = new Peticio(codi, usuariA, usuariB, codiProducteA, codiProducteB);
	        pet.setEstat(estat);
	        LlistaPet.afegirPet(pet);
	        particio.close();
	    }

	    F.close();
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

}
