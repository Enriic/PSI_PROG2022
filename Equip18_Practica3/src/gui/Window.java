package gui;
import usuari.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import error.DadaInexistent;
import productes.*;
import peticions.*;


public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel botons = new JPanel();
	private JButton buscarOfertesIntercanvi= new JButton ("Buscar ofertes d'intercanvi actives");
	private JButton afegirPeticio = new JButton("Afegir peticio d'intercanvi");
	private JButton consultarIntercanvisFets = new JButton ("Consultar els intercanvis que ha fet");
	private JButton canviarUsuari = new JButton ("Canviar l'usuari");
	private static String codi;
	private JFrame Dades;
	
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
		
		LlistaProductes Lproductes = new LlistaProductes(1);
		LlistaUsuaris Lu = new LlistaUsuaris(1);
		LlistaPeticions LPet = new LlistaPeticions(1);
		
		try {
			CarregarLlistaFitxer("Productes.txt",Lproductes);
			CarregarFitxerSer(Lu);
			CarregarLlistaPeticionsFitxer(LPet);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		buscarOfertesIntercanvi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent buscarOfertes) {
				new BuscarOfertes(Lproductes);
			}
			
		});
		
		afegirPeticio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent afegirPeticio) {
				
				AfegirPeticioIntercanvi a = new AfegirPeticioIntercanvi(Dades,LPet,Lu,Lproductes);
				if (a.dadesEntrades()) {
					String nom1= a.getNom1();
					String nom2= a.getNom2();
					String codi1= a.getCodi1();
					String codi2= a.getCodi2();
					afegirPeticio(Lu,Lproductes,LPet, nom1, nom2, codi1,codi2);
					
				}
				
			}
			
		});
		
		consultarIntercanvisFets.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent consultarIntercanvis) {
				setVisible(false);
			}
			
		});
		
		
		canviarUsuari.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent canviarUsuari) {
				setVisible(false);
				new DemanarCodi("Identificacio",Lu);
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
	    int codi;
	    Usuari usuariA; 		// Usuario que HACE la petición
	    Usuari usuariB; 		// Usuario que RECIBE la petición
	    String codiProducteA;
	    String codiProducteB;
	    int estat;
	    String frase;
	    Scanner F = new Scanner (new File("Peticions.txt"));
	    Scanner particio;
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

	        codi = particio.nextInt();
	        nomusuari = particio.next();
	        correuusuari= particio.next();
	        codipostal= particio.next();
	        intercanvis = particio.nextInt();
	        valoracio=particio.nextInt();
	        contrasena = particio.next();
	        usuariA = new Usuari(nomusuari, correuusuari, codipostal,contrasena);
	        
	        usuariA.setIntercanvis(intercanvis);
	        usuariA.setValoracio(valoracio);
	        
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

	  public static void afegirPeticio(LlistaUsuaris LU,LlistaProductes LProd,LlistaPeticions LPet,String nom1,String nom2,String codi1, String codi2) {
			
			Usuari U1 = null;
			Usuari U2 = null;
			do {
				try {
	    		U1 = LU.cercaUsuari(nom1);
	    		U2 = LU.cercaUsuari(nom2);
	    		} catch (DadaInexistent e) {System.out.println(e);}
		} while (U1 == null || U2 == null);
		
		boolean codiOK = false;
		do {
			try {
				codiOK = existeixProducte(codi1, LProd);
				if (codiOK) codiOK = existeixProducte(codi2, LProd);
			} catch (DadaInexistent e) { System.out.println(e);}
		} while (!codiOK);
		
		
		int codiPet = LPet.getNumElem();
		Peticio p = new Peticio(codiPet, U1, U2, codi1, codi2);
		LPet.afegirPet(p);
		}

	  private static boolean existeixProducte(String codi, LlistaProductes L) throws DadaInexistent{
			boolean trobat = false;
			int i = 0;
			while (!trobat && i < L.getNumProductes()) {
				if (L.getProducteFromLlista(i).getID().equals(codi)) trobat = true;
				i++;
			}
			if (!trobat) throw new DadaInexistent(codi);
			return trobat;
		}

	
	
}
