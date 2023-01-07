package peticions;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import usuari.*;

public class Peticio {
	private String codi;
	private Usuari usuariA; 		// Usuario que HACE la petición
	private Usuari usuariB; 		// Usuario que RECIBE la petición
	private String codiProducteA;
	private String codiProducteB;
	private int estat;
	
	public Peticio(String codi, Usuari usuariA, Usuari usuariB, String codiProducteA, String codiProducteB) {
		this.codi = codi;
		this.usuariA = usuariA;
		this.usuariB = usuariB;
		this.codiProducteA = codiProducteA;
		this.codiProducteB = codiProducteB;
		this.estat = 0;
		
	}
	
	public int getEstat() {
		return estat;
	}

	public String getCodi() {
		return codi;
	}

	public Usuari getUsuariA() {
		return usuariA;
	}

	public Usuari getUsuariB() {
		return usuariB;
	}

	public String getCodiProducteA() {
		return codiProducteA;
	}

	public String getCodiProducteB() {
		return codiProducteB;
	}
	
	public Peticio copia() {
		Peticio aux = new Peticio(this.codi,this.usuariA,this.usuariB,this.codiProducteA,this.codiProducteB);
		aux.estat = this.getEstat();
		
		return aux;
	}

	public void setEstat(int n) {
		estat = n;
	}
	
	public void AcceptarPet(int valA, int valB) {
		setEstat(1);
		
		if((0<valA && valA<5) && (0<valB && valB<5)){
		
			usuariA.setValoracio(((usuariA.getValoracio()*usuariA.getIntercanvis())+valA)/(usuariA.getIntercanvis()+1));
			usuariA.afegirIntercanvi();	

			usuariB.setValoracio(((usuariB.getValoracio()*usuariB.getIntercanvis())+valB)/(usuariB.getIntercanvis()+1));
			usuariB.afegirIntercanvi();
		}
		else System.out.println("Valoracion(es) fuera de limite (0-5).");
	}
	
	

	public void RefusarPet() {
		setEstat(2);

	}


	public void escriureFitxer() {
		BufferedWriter bw = null;
		try {
			File fitxer = new File("Peticions.txt");

			bw = new BufferedWriter(new FileWriter(fitxer, true));
			bw.write(this.getCodi()+";"+this.getUsuariA().getNom()+";"+this.getUsuariA().getCorreu()+";"+this.getUsuariA().getCodiPostal()+
					";"+this.getUsuariA().getIntercanvis()+";"+this.getUsuariA().getValoracio()+";"+this.getUsuariA().getCodi()+";"+
					this.getUsuariB().getNom()+";"+this.getUsuariB().getCorreu()+";"+this.getUsuariB().getCodiPostal()+";"+
					this.getUsuariB().getIntercanvis()+";"+this.getUsuariB().getValoracio()+";"+this.getUsuariB().getCodi()+";"
					+this.getCodiProducteA()+";"+this.getCodiProducteB()+";"+this.getEstat()+";\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (Exception e) {
			}
		}
	}
	

	public String toString(){
		return "Codi: " +getCodi()+ " Usuari que demana: "+getUsuariA()+ " Usuari al que se li fa la oferta: "+getUsuariB()+ "Codi del producte A: "+getCodiProducteA()+ "Codi del producte B: " +getCodiProducteB();
	}
}