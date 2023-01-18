package peticions;

import java.util.Arrays;

import usuari.Usuari;

public class LlistaPeticions {

	private Peticio[] llista;
	private int numElem;

	
	public LlistaPeticions(int dim) {
		llista = new Peticio[dim];
		numElem = 0;
	}
	
	
	public void afegirPet(Peticio X) {
		if (this.numElem >= this.llista.length) {
			Peticio [] aux = new Peticio [this.numElem+1];
			for (int i = 0; i < this.numElem; i++)
                aux[i]=llista[i];

            this.llista = aux;
            }
		this.llista[numElem] = X.copia();
        this.numElem ++;
        }
	
	public void AcceptarPetLlista(int codi, int valA, int valB) {
		llista[codi].AcceptarPet(valA, valA);
	}
	
	

	public void RefusarPetLlista(int codi) {
		llista[codi].RefusarPet();

	}
	
	public LlistaPeticions mostrarPetPendents() {
		LlistaPeticions aux = new LlistaPeticions(numElem);
		
		for(int i = 0; i<numElem; i++){
			if(llista[i].getEstat() == 0) {
				aux.afegirPet(llista[i].copia());
			}
		}
		return aux;
	}
	
	
	public LlistaPeticions mostrarPetAcceptades() {
		LlistaPeticions aux = new LlistaPeticions(numElem);
		
		for(int i = 0; i<numElem; i++){
			if(llista[i].getEstat() == 1) {
				aux.afegirPet(llista[i].copia());
			}
		}
		return aux;
	}
	
	public LlistaPeticions mostrarPetRefusades() {
		LlistaPeticions aux = new LlistaPeticions(numElem);
		
		for(int i = 0; i<numElem; i++){
			if(llista[i].getEstat() == 2) {
				aux.afegirPet(llista[i].copia());
			}
		}
		return aux;
	}
	
	
	public int getNumElem() {
		return numElem;
	}

	
	
	@Override
	public String toString() {
		return "[llista=" + Arrays.toString(llista) + " numElem=" + numElem + "]";
	}


	public void escriureLlistaAlFitxer() {
		for (int i = 0; i < numElem; i++) {
			llista[i].escriureFitxer();
		}
	}
	
	public Peticio getPeticioiFromLlista(int posicio) {
        return this.llista[posicio].copia();
    }
}

