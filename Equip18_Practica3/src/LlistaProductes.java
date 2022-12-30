
import java.util.*;


public class LlistaProductes {
	
	Producte [] llista;
	private int numProductes;
	
	
	public LlistaProductes (int maxProductes) {
		if (maxProductes>=0) {
			llista = new Producte [maxProductes];
			numProductes = 0;
		}
		else {
			llista = new Producte [5];
			numProductes = 0;
		}
	}
	
	public int getNumProductes() {
		return numProductes;
	}
	
	public void afegirProducte(Producte A) {
		if (numProductes >= llista.length) {
			Producte [] aux = new Producte[numProductes+1];
			for (int i = 0 ; i<numProductes ; i++) {
				aux [i] = llista[i];
			}
			llista = aux;
		}
		llista[numProductes] = A.copia();
		numProductes ++;	
	}
	
	public LlistaProductes llistaServeisActius() {
		LlistaProductes aux = new LlistaProductes(1);
		for (int i = 0 ; i<numProductes ; i++) {
			if(this.llista[i] instanceof Servei && llista[i].esActiu()) {
				aux.afegirProducte(llista[i]);
			}
		}
		return aux;
	}
	
	public void donarDeBaixa(String id) {
		int i = 0;
		boolean trobat = false;
		while (i < numProductes && trobat == false) {
    		if (llista[i].getID().equals(id)) {
    			llista[i].setActiu(false);
    			trobat = true;
    		}
    		i++;
    	}
	}
	
	public LlistaProductes llistaBensActius() {
		LlistaProductes aux = new LlistaProductes(1);
		for (int i = 0 ; i<numProductes ; i++) {
			if(this.llista[i] instanceof Servei && llista[i].esActiu()) {
				aux.afegirProducte(llista[i]);
			}
		}
		return aux;
	}
	
	public void escriureLlistaAlFitxer() {
		for (int i = 0; i < numProductes; i++) {
			llista[i].escriureFitxer();
		}
	}
	
	public Producte mostrarServeiMesIntercanvis() {
		Producte aux =null;
		int numMax=0;
		
		for (int i = 0; i < this.numProductes ; i++ ) {
			if (this.llista[i] instanceof Servei) {
					if(((Servei)this.llista[i]).getNumIntercanvis()>numMax){
						aux = llista[i].copia();
						numMax=((Servei)this.llista[i]).getNumIntercanvis();
				}
			}
		}
		return aux;
	}
	
	@Override
	public String toString() {
		return "Numero de productes = " + numProductes + "\nLlista de productes:\n" + Arrays.toString(llista);
	}
	
	
	
	
	
}
