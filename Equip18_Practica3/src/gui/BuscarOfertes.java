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
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID Producte", "descripcio", "tipus"}, 0);
		for (int i = 0; i < LlistaP.getNumProductes(); i++) {
		    Producte producte = LlistaP.getProducteFromLlista(i);
		    String codi = producte.getID();
		    String descripcio = producte.getDescripcio();
		    String tipus = producte.getTipus();
		    
		    model.addRow(new Object[]{codi, descripcio, tipus});
		}
		
		JTable TablaPeticions = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(TablaPeticions);

		JFrame frame = new JFrame();
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
}
