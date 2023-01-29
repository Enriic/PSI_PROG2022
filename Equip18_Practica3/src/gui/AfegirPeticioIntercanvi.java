package gui;
import usuari.*;
import peticions.*;
import productes.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AfegirPeticioIntercanvi extends JDialog {
	  private static final long serialVersionUID = 1L;
	  private JLabel nomCreador, nomRep, codiProducteCreador,codiProducteRep;
	  private JTextField nomCreadorF, nomRepF, codiProducteCreadorF,codiProducteRepF;

	  private boolean ok;

	  public AfegirPeticioIntercanvi(JFrame titul, LlistaPeticions LPet, LlistaUsuaris LU,LlistaProductes LProd) {
	    super(titul, "Dades");
	    ok = false;
	    nomCreador = new JLabel("Nom Creador: ");
	    nomRep = new JLabel("Nom usuari que rep: ");
	    codiProducteCreador = new JLabel("Codi producte 1: ");
	    codiProducteRep = new JLabel("Codi producte 2: ");
	    nomCreadorF = new JTextField(15);
	    nomRepF = new JTextField(15);
	    codiProducteCreadorF = new JTextField(15);
	    codiProducteRepF = new JTextField(15);
	    

	    JPanel controls = new JPanel(new GridLayout(4,2));
	    controls.add(nomCreador);
	    controls.add(nomCreadorF);
	    controls.add(nomRep);
	    controls.add(nomRepF);
	    controls.add(codiProducteCreador);
	    controls.add(codiProducteCreadorF);
	    controls.add(codiProducteRep);
	    controls.add(codiProducteRepF);

	    JButton acceptar = new JButton("Acceptar");
	    JButton cancelar = new JButton("Cancelar");
	    acceptar.addActionListener( new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	               ok = true;
	               setVisible(false);
	           }
	        });
	    cancelar.addActionListener( new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	               ok = false;
	               setVisible(false);
	           }
	        });

	    JPanel botons = new JPanel(new FlowLayout());
	    botons.add(acceptar);
	    botons.add(cancelar);

	    Container c = getContentPane();
	    c.add(controls, BorderLayout.CENTER);
	    c.add(botons, BorderLayout.SOUTH);

	    pack();
	    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    setModal(true);
	    setVisible(true);
	  }

	  public boolean dadesEntrades() {
	    return ok;
	  }

	  public String getNom1() {
	    return nomCreadorF.getText();
	  }

	  public String getNom2() {
	    return nomRepF.getText();
	  }
	  
	  public String getCodi1() {
		  return codiProducteCreadorF.getText();
	  }
	  
	  public String getCodi2() {
		  return codiProducteRepF.getText();
	  }
	  
	  
	  
	}
