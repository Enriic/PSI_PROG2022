package error;

//Clase excepcio per indicar si no existeix la dada (Usuari/producte/peticio) que busquem
public class DadaInexistent extends Exception{
	private static final long serialVersionUID = 1L;

	public DadaInexistent(String dada) {
		super ("ERROR: El nom/codi '"+dada+"' no existeix. Assegureu-vos que esta ben escrit.");
	}
}
