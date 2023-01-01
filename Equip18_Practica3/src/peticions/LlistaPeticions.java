package peticions;


public class LlistaPeticions {

	private Peticio[] llista;
	private int numElem;

	
	public int getNumElem() {
		return numElem;
	}
	
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
	
	public void mostrarPetPendents() {								//FASE DE PRUEBA DE MOSTRAR PETICIONS PENDENTS
		for(int i = 0; i<numElem; i++){
			if(llista[i].getEstat() == 0) System.out.print(llista[i]);
		}
	}
	
	public void mostrarPetAcceptades() {							//FASE DE PRUEBA DE MOSTRAR PETICIONS PENDENTS
		for(int i = 0; i<numElem; i++){
			if(llista[i].getEstat() == 1) System.out.print(llista[i]);
		}
	}
	
	public void mostrarPetRefusades() {							//FASE DE PRUEBA DE MOSTRAR PETICIONS PENDENTS
		for(int i = 0; i<numElem; i++){
			if(llista[i].getEstat() == 2) System.out.print(llista[i]);
		}
	}
	
	
}