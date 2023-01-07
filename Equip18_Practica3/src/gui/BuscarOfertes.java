package gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import peticions.LlistaPeticions;
import peticions.Peticio;
import usuari.LlistaUsuaris;

public class BuscarOfertes {
	
	public BuscarOfertes ( LlistaPeticions Lp, LlistaUsuaris Lu) {
		Peticio pet1 = new Peticio(12345, Lu.getUsuariFromLlista(0), Lu.getUsuariFromLlista(1), "123A", "456B");		//Prueba peticion 1
		Peticio pet2 = new Peticio(11111, Lu.getUsuariFromLlista(2), Lu.getUsuariFromLlista(3), "789A", "321B");		//Prueba peticion 2
		
		LlistaPeticions llistapet = new LlistaPeticions(5);					//creem la llista peticions
		llistapet.afegirPet(pet1);
		llistapet.afegirPet(pet2);
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"Oferta", "Usuari 1", "Usuari 2"}, 0);
		for (int i = 0; i < Lp.getNumElem(); i++) {
		    model.addRow(new Object[]{Lp.mostrarPetPendents()});
		}
		// Create the table
		JTable TablaPeticions = new JTable(model);

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(TablaPeticions);

		// Add the scroll pane to the GUI
		JFrame frame = new JFrame();
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
}
