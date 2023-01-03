package gui;
import usuari.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import productes.*;
import peticions.*;

public class Window extends JFrame {
	private JPanel botons = new JPanel();
	private JButton buscarOfertesIntercanvi= new JButton ("Buscar ofertes d'intercanvi actives");
	private JButton afegirPeticio = new JButton("Afegir peticio d'intercanvi");
	private JButton consultarIntercanvisFets = new JButton ("Consultar els intercanvis que ha fet");
	private JButton canviarUsuari = new JButton ("Canviar l'usuari");
	
	
	public Window(String titul) {
		super("titul");
		
		botons.setLayout(new FlowLayout());
		botons.add(buscarOfertesIntercanvi);
		botons.add(afegirPeticio);
		botons.add(consultarIntercanvisFets);
		botons.add(canviarUsuari);
		
		this.add(botons, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Forcem les mides de l'objecte contenidor, es a dir, la finestra.
		setSize(300,300);
		// Fem la finestra visible.
		setVisible(true);
	}
	
	
}
