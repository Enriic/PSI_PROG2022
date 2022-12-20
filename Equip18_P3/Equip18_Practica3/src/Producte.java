

public class Producte {
	private String ID;
	private String descripcio;
	private String tipus;
	private Data dataInicial;
	

	public Producte (String ID, String tipus, String descripcio) {
		this.ID = ID;
		this.tipus = tipus;
		this.descripcio = descripcio;
		dataInicial = new Data();
		
	}
	
	public Producte (String ID, String tipus, String descripcio, Data dataInicial) { //construcotr per quan carreguem el producte del fitxer i la data inicial no es la del moment
		this.ID = ID;
		this.tipus = tipus;
		this.descripcio = descripcio;
		this.dataInicial = dataInicial;
	}
	
	public  String getID() {
		return ID;
	}
	
	public String getTipus() {
	 	return tipus;
	}
	
	public String getDescripcio() {
		return descripcio;
	}
	
	public Data getDataInicial() {
		return dataInicial;
	}
	
	public Producte copia() {
		Producte aux = new Producte(ID, tipus, descripcio);
		return aux;
	}
	
	public void canviarDataInicial(Data D) {
		dataInicial = D;
	}

	@Override
	public String toString() {
		return "[ID = " + ID + " | tipus = " + tipus + " | descripcio = " + descripcio + " | data de publicacio = " + dataInicial.toString() + "]\n";
	}
	
}
