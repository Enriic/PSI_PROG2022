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

	

	public Be(String ID, String tipus, String descripcio, float amplada, float altura, float fons, float pes) {
		super(ID, tipus, descripcio);
		this.dataIntercanvi = new Data (01,01,3000);
		this.amplada = amplada;
		this.altura = altura;
		this.fons = fons;
		this.pes = pes;
	}
	
	public Be(String ID, String tipus, String descripcio, Data dataInicial, float amplada, float altura, float fons, float pes, Data dataIntercanvi) {
		super(ID, tipus, descripcio, dataInicial);
		this.amplada = amplada;
		this.altura = altura;
		this.fons = fons;
		this.pes = pes;
		this.dataIntercanvi = dataIntercanvi;
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
	
	public void canviarDataIntercanvi(Data data) {
		this.dataIntercanvi = data;
	}
	
	public Be copia() {
		Be aux = new Be(this.getID(),this.getTipus(),this.getDescripcio(), this.getDataInicial(), amplada, altura, fons, pes, dataIntercanvi);
		aux.dataIntercanvi = this.getDataIntercanvi();
		return aux;
	}
	
	public void escriureBeFitxer() {
		BufferedWriter bw = null;
		try {
			File fitxer = new File("new.txt");

			bw = new BufferedWriter(new FileWriter(fitxer, true));
			bw.write("B;"+this.getID()+";"+this.getTipus()+";"+this.getDescripcio()+";"+this.getDataInicial().getDia()+"/"+this.getDataInicial().getMes()+"/"+this.getDataInicial().getAny()+";" + this.getAmplada() + ";" + this.getAltura() + ";" + this.getFons() + ";" + this.getPes() + ";" +this.getDataIntercanvi().getDia()+"/"+this.getDataIntercanvi().getMes()+"/"+this.getDataIntercanvi().getAny() + ";\n");
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
				+ dataIntercanvi.toString() +"]\n";
	}
	 

}
