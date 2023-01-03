package peticions;
import usuari.*;

public class Peticio {
	private int codi;
	private Usuari usuariA; 		// Usuario que HACE la petición
	private Usuari usuariB; 		// Usuario que RECIBE la petición
	private String codiProducteA;
	private String codiProducteB;
	private int estat;
	
	public Peticio(int codi, Usuari usuariA, Usuari usuariB, String codiProducteA, String codiProducteB) {
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

	public int getCodi() {
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

	
	public void AcceptarPet(int valA, int valB) {
		estat = 1;
		
		if((0<valA && valA<5) && (0<valB && valB<5)){
		
			usuariA.setValoracio(((usuariA.getValoracio()*usuariA.getIntercanvis())+valA)/(usuariA.getIntercanvis()+1));
			usuariA.afegirIntercanvi();	

			usuariB.setValoracio(((usuariB.getValoracio()*usuariB.getIntercanvis())+valB)/(usuariB.getIntercanvis()+1));
			usuariB.afegirIntercanvi();
		}
		else System.out.println("Valoracion(es) fuera de limite (0-5).");
	}
	
	

	public void RefusarPet() {
		estat = 2;

	}



	public String toString(){
		return "Codi: " +getCodi()+ " Usuari que demana: "+getUsuariA()+ " Usuari al que se li fa la oferta: "+getUsuariB()+ "Codi del producte A: "+getCodiProducteA()+ "Codi del producte B: " +getCodiProducteB();
	}
}