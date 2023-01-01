package productes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Be extends Producte{
	private float amplada;
	private float altura;
	private float fons;
	private float pes;
	private Data dataIntercanvi;
	private boolean actiu;
	

	public Be(String ID, String tipus, String descripcio, float amplada, float altura, float fons, float pes) {
		super(ID, tipus, descripcio);
		this.amplada = amplada;
		this.altura = altura;
		this.fons = fons;
		this.pes = pes;
		dataIntercanvi = new Data(true);
		actiu = true;
	}
	
	public Be(String ID, String tipus, String descripcio, Data dataInicial, float amplada, float altura, float fons, float pes, Data dataIntercanvi, boolean actiu) {
		super(ID, tipus, descripcio, dataInicial);
		this.amplada = amplada;
		this.altura = altura;
		this.fons = fons;
		this.pes = pes;
		this.dataIntercanvi = dataIntercanvi;
		this.actiu = actiu;
	}
	
	
	public float getAmplada() {
		return amplada;
	}

	public float getAltura() {
		return altura;
	}

	public float getFons() {
		return fons;
	}

	public float getPes() {
		return pes;
	}
	
	public Data getDataIntercanvi() {
 		return dataIntercanvi;
	}
	
	public void setActiu(boolean actiu) {
		this.actiu = actiu;
	}
	
	public void canviarDataIntercanvi(Data data) {
		this.dataIntercanvi = data;
	}
	
	public boolean esActiu() {
		if(this.dataIntercanvi.esMesGran(new Data()) == 1) {
			this.setActiu(false);
		}
		return actiu;
	}
	
	public Be copia() {
		Be aux = new Be(this.getID(),this.getTipus(),this.getDescripcio(), this.getDataInicial(), amplada, altura, fons, pes, dataIntercanvi, actiu);
		aux.dataIntercanvi = this.getDataIntercanvi();
		return aux;
	}
	
	public void escriureFitxer() {
		BufferedWriter bw = null;
		try {
			File fitxer = new File("old.txt");

			bw = new BufferedWriter(new FileWriter(fitxer));
			int numActiu;
			if (actiu) 
				numActiu = 1;
			else 
				numActiu = 0;
			
			bw.write("B;"+this.getID()+";"+this.getTipus()+";"+this.getDescripcio()+";"+this.getDataInicial().getDia()+"/"+this.getDataInicial().getMes()+"/"+this.getDataInicial().getAny()+";" + amplada + ";" + altura + ";" + fons + ";" + pes + ";" + dataIntercanvi.getDia()+"/"+dataIntercanvi.getMes()+"/"+dataIntercanvi.getAny() + ";" + numActiu + ";\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (Exception e) {
			}
		}
	}
	
	@Override
	public String toString() {
		return "[ID = " + this.getID() + " | tipus = " + this.getTipus() + " | descripcio = " + this.getDescripcio() + " | data de publicacio = " + this.getDataInicial().toString() + " | amplada = " + amplada + " | altura = " + altura + " | fons = " + fons + " | pes = " + pes + " | dataIntercanvi = "
				+ dataIntercanvi.toString() + " | actiu = " + actiu + "]\n";
	}
	 

}
