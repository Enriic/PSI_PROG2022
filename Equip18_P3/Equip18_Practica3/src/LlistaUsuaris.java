

public class LlistaUsuaris {
	private Usuari [] Llista;
	private int numUsuaris;
	
	public LlistaUsuaris(int numUsuaris) {
		if (numUsuaris >0) {
			Llista = new Usuari [numUsuaris];
			numUsuaris = 0;
		}
	}
	
	
	public void afegirUsuari(Usuari X) {
		if (numUsuaris >= Llista.length) {
			Usuari [] aux = new Usuari [numUsuaris*2];
			for (int i = 0; i < numUsuaris; i++)
				aux[i]=Llista[i];
			
			Llista = aux;
			}
		
		Llista[numUsuaris] = X;
		numUsuaris ++;
		}
		
	public int getNumUsuaris() {
		return numUsuaris;
	}
}
