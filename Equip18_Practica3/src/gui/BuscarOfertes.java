package gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import peticions.LlistaPeticions;
import peticions.Peticio;
import productes.LlistaProductes;
import productes.Producte;
import usuari.LlistaUsuaris;

public class BuscarOfertes {
	
	public BuscarOfertes (LlistaProductes LlistaP) {
		
		/*DefaultTableModel model = new DefaultTableModel(new String[]{"Codi Peticio", "Usuari Demana", "Usuari Rep"}, 0);
		LlistaPeticions Lpendents = Lp.mostrarPetPendents();
		for (int i = 0; i < Lp.getNumElem(); i++) {
		    model.addRow(new Object[]{Lpendents.getPeticioiFromLlista(i).getCodi()});
		}*/
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID Producte", "descripcio", "tipus"}, 0);
		LlistaProductes Lactius = LlistaP.llistaBensActius();
		for (int i = 0; i < LlistaP.getNumProductes(); i++) {
		    Producte producte = LlistaP.getProducteFromLlista(i);
		    String codi = producte.getID();
		    String descripcio = producte.getDescripcio();
		    String tipus = producte.getTipus();
		    
		    model.addRow(new Object[]{codi, descripcio, tipus});
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
