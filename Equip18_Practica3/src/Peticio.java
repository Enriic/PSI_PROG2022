public class Peticio {
	private int codi;
	private Usuari usuariA; 		// Usuario que HACE la petición
	private Usuari usuariB; 		// Usuario que RECIBE la petición
	private String codiProducteA;
	private String codiProducteB;
	private int valoracioA;
	private int valoracioB;
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


	
	public void AcceptarPet(int valA, int valB) {
		estat = 1;

		usuariA.setValoracio(((usuariA.getValoracio()*usuariA.getIntercanvis())+valA)/(usuariA.getIntercanvis()+1));
		System.out.println(usuariA.getValoracio());
		usuariA.afegirIntercanvi();
		
		usuariB.setValoracio(((usuariB.getValoracio()*usuariB.getIntercanvis())+valB)/(usuariB.getIntercanvis()+1));
		System.out.println(usuariB.getValoracio());
		usuariB.afegirIntercanvi();	
	}
	
	

	public void RefusarPet(int estat) {
		estat = 2;
	}



}

