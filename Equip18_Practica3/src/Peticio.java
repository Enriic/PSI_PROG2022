public class Peticio {
	private String codi;
	private Usuari usuariDemana;
	private Usuari usuariRep;
	private String codiProducteDemanat;
	private String codiProducteOfert;
	private int valoracioDemanat;
	private int valoracioOfert;
	private int Estat;
	
	public Peticio(String codi, Usuari usuariDemana, Usuari usuariRep, String codiProducteDemanat, String codiProducteOfert) {
		this.codi = codi;
		this.usuariDemana = usuariDemana;
		this.usuariRep = usuariRep;
		this.codiProducteDemanat = codiProducteDemanat;
		this.codiProducteOfert = codiProducteOfert;
		this.Estat = 0;
		
	}

	public Peticio(String codi, Usuari usuariDemana, Usuari usuariRep, String codiProducteDemanat, String codiProducteOfert, int val1, int val2) {
		this.codi = codi;
		this.usuariDemana = usuariDemana;
		this.usuariRep = usuariRep;
		this.codiProducteDemanat = codiProducteDemanat;
		this.codiProducteOfert = codiProducteOfert;
		this.valoracioDemanat=val1;
		this.valoracioOfert=val2;
		this.Estat = 0;
		
	}
	
	public int getEstat() {
		return Estat;
	}

	public void setEstat(int estat) {
		Estat = estat;
	}
	

	public String getCodi() {
		return codi;
	}

	public Usuari getUsuariDemana() {
		return usuariDemana;
	}

	public Usuari getUsuariRep() {
		return usuariRep;
	}

	public String getCodiProducteDemanat() {
		return codiProducteDemanat;
	}

	public String getCodiProducteOfert() {
		return codiProducteOfert;
	}

    public void setValoracioDemanat(int val1) {
        usuariDemana.setValoracio(((usuariDemana.getValoracio()*usuariDemana.getIntercanvis())+val1)/(usuariDemana.getIntercanvis()+1));
        usuariDemana.afegirIntercanvi();
    }

    public void setValoracioOfert(int val2) {
        usuariRep.setValoracio(((usuariRep.getValoracio()*usuariRep.getIntercanvis())+val2)/(usuariRep.getIntercanvis()+1));
        usuariRep.afegirIntercanvi();
    }

}

