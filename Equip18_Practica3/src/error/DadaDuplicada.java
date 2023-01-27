package error;

public class DadaDuplicada extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DadaDuplicada(String dada) {
		super ("ERROR: "+dada+" ja existeix.");
	}
}
