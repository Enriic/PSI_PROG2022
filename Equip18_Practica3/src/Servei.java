import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Servei extends Producte{
	private Data dataCaducitat;
	private int numIntercanvis;
	private boolean actiu;
	

	public Servei(String ID, String tipus, String descripcio, Data dataCaducitat) {
		super(ID, tipus, descripcio);
		this.dataCaducitat = dataCaducitat;
		numIntercanvis = 0;
		actiu = true;
		
	}
	
	public Servei(String ID, String tipus, String descripcio,Data dataInicial, Data dataCaducitat, int numIntercanvis, boolean actiu) {
		super(ID, tipus, descripcio, dataInicial);
		this.dataCaducitat = dataCaducitat;
		this.numIntercanvis = numIntercanvis;
		this.actiu = actiu;
		
	}

	public Data getDataCaducitat() {
		return dataCaducitat;
	}
	
	public int getNumIntercanvis() {
		return numIntercanvis;
	}
	
	public void setActiu(boolean actiu) {
		this.actiu = actiu;
	}
	
	public Servei copia() {
		Servei aux = new Servei(this.getID(), this.getTipus(), this.getDescripcio(), this.getDataInicial(), dataCaducitat, numIntercanvis, actiu);
		return aux;
	}
	
	public void escriureFitxer() {
		BufferedWriter bw = null;
		try {
			File fitxer = new File("old.txt");

			bw = new BufferedWriter(new FileWriter(fitxer, true));
			int numActiu;
			if (actiu) 
				numActiu = 1;
			else 
				numActiu = 0;
			bw.write("S;"+this.getID()+";"+this.getTipus()+";"+this.getDescripcio()+";"+this.getDataInicial().getDia()+"/"+this.getDataInicial().getMes()+"/"+this.getDataInicial().getAny()+";"+dataCaducitat.getDia()+"/"+dataCaducitat.getMes()+"/"+dataCaducitat.getAny()+";" + numIntercanvis + ";"+ numActiu +";\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (Exception e) {
			}
		}
	}
	
	public void afegirIntercanvi() {
		numIntercanvis ++;
	}
	
	public boolean esActiu() {
		if(this.dataCaducitat.esMesGran(new Data()) == 1) {
			actiu = false;
		}
		return actiu;
	}
	
	public void desactivarServei() {
		this.actiu=false;
	}
	
	@Override
	public String toString() {
		return "[ID = " + this.getID() + " | tipus = " + this.getTipus() + " | descripcio = " + this.getDescripcio() + " | data de publicacio = " + this.getDataInicial().toString() + " | dataCaducitat = "
				+ dataCaducitat.toString() + " | numero d'intercanvis = " + numIntercanvis + " | actiu: "+actiu+ "]\n";
	}
}
