package gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import peticions.LlistaPeticions;

public class BuscarOfertes {
	
	public BuscarOfertes ( LlistaPeticions Lp) {
		DefaultTableModel model = new DefaultTableModel(new String[]{"Product Name", "Price", "Quantity"}, 0);
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
