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
				LlistaPeticions Lp = new LlistaPeticions(1);
				LlistaUsuaris Lu = new LlistaUsuaris(5);
				CarregarFitxerSer(Lu);
				/*try {
					CarregarLlistaPeticionsFitxer(Lp);
					
				} catch (IOException e) {
					e.printStackTrace();
				}*/
				new BuscarOfertes(Lp,Lu);
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
		int codi;
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
		
		while (F.hasNext()) {
			frase = F.nextLine();
			particio = new Scanner(frase);
			particio.useDelimiter(";");
			particio.useLocale(Locale.ENGLISH);
			
			codi = particio.nextInt();
			stringUsuari = particio.next();
			partsUsuari = stringUsuari.split(";");
			usuariA = new Usuari(partsUsuari[0], partsUsuari[1], partsUsuari[2], partsUsuari[5]);
			usuariA.setIntercanvis(Integer.parseInt(partsUsuari[3]));
			usuariA.setIntercanvis(Integer.parseInt(partsUsuari[4]));
			stringUsuari = particio.next();
			partsUsuari = stringUsuari.split(";");
			usuariB = new Usuari(partsUsuari[0], partsUsuari[1], partsUsuari[2], partsUsuari[5]);
			usuariB.setIntercanvis(Integer.parseInt(partsUsuari[3]));
			usuariB.setIntercanvis(Integer.parseInt(partsUsuari[4]));
			codiProducteA = particio.next();
			codiProducteB = particio.next();
			estat = particio.nextInt();
			
			Peticio pet = new Peticio(codi, usuariA, usuariB, codiProducteA, codiProducteB); pet.setEstat(estat);
			LlistaPet.afegirPet(pet);
		}
		
		F.close();
	}

}
