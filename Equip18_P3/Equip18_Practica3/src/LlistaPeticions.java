
public class LlistaPeticions {

	private Peticio[] llista;
	private int numElem;
	
	
	public LlistaPeticions(int dim) {
		llista = new Peticio[dim];
		numElem = 0;
	}
	
	public void afegirPet(Peticio pet) {
		if (numElem < llista.length) {
			llista[numElem] = pet;
			numElem++;
		}
	}
	
	public void esborrarPet(String codi) {
		// encontrar pet., borrar y reordenar lista
	}
	
	public void mostrarPetPendents() {
		// recorrido por la lista, si Estat==0 mostrar
	}
	
	public void mostrarPetAcceptades() {
		// ...si Estat==1...
	}
	
	public void mostrarPetRefusades() {
		// ...si Estat==2...
	}
	

}
