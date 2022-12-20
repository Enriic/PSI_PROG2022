import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Servei extends Producte{
	private Data dataCaducitat;
	private int numIntercanvis;
	

	public Servei(String ID, String tipus, String descripcio, Data dataCaducitat) {
		super(ID, tipus, descripcio);
		this.dataCaducitat = dataCaducitat;
		numIntercanvis = 0;
		
	}
	
	public Servei(String ID, String tipus, String descripcio,Data dataInicial, Data dataCaducitat, int numIntercanvis) {
		super(ID, tipus, descripcio, dataInicial);
		this.dataCaducitat = dataCaducitat;
		this.numIntercanvis = numIntercanvis;
		
	}

	public Data getDataCaducitat() {
		return dataCaducitat;
	}
	
	public int getNumIntercanvis() {
		return numIntercanvis;
	}
	
	public Servei copia() {
		Servei aux = new Servei(this.getID(), this.getTipus(), this.getDescripcio(), this.getDataInicial(), dataCaducitat, numIntercanvis);
		return aux;
	}
	
	public void escriureServeiFitxer() {
		BufferedWriter bw = null;
		try {
			File fitxer = new File("new.txt");

			bw = new BufferedWriter(new FileWriter(fitxer, true));
			bw.write("S;"+this.getID()+";"+this.getTipus()+";"+this.getDescripcio()+";"+this.getDataInicial().getDia()+"/"+this.getDataInicial().getMes()+"/"+this.getDataInicial().getAny()+";"+dataCaducitat.getDia()+"/"+dataCaducitat.getMes()+"/"+dataCaducitat.getAny()+";" + numIntercanvis + ";\n");
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
	
	@Override
	public String toString() {
		return "[ID = " + this.getID() + " | tipus = " + this.getTipus() + " | descripcio = " + this.getDescripcio() + " | data de publicacio = " + this.getDataInicial().toString() + " | dataCaducitat = "
				+ dataCaducitat.toString() + " | numero d'intercanvis = " + numIntercanvis + "]\n";
	}

}
