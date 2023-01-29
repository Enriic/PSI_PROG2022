package error;

// clase Excepcio per indicar a l'usuari si la dada (usuari / producte / peticio existeix)
public class DadaDuplicada extends Exception{
	private static final long serialVersionUID = 1L;

	public DadaDuplicada(String dada) {
		super ("ERROR: "+dada+" ja existeix.");
	}
}
