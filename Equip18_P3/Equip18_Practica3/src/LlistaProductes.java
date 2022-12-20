import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
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
	
	public void afegirProducte(Producte A) {
		if (numProductes >= llista.length) {
			Producte [] aux = new Producte[numProductes * 2];
			for (int i = 0 ; i<numProductes ; i++) {
				aux [i] = llista[i];
			}
			llista = aux;
		}
		llista[numProductes] = A.copia();
		numProductes ++;	
	}
	
	public void afegirServei(Servei A) {
		if (numProductes >= llista.length) {
			Producte [] aux = new Producte[numProductes * 2];
			for (int i = 0 ; i<numProductes ; i++) {
				aux [i] = llista[i];
			}
			llista = aux;
		}
		llista[numProductes] = A.copia();
		numProductes ++;
	}
	
	
	
	public void afegirBe(Be B) {
		if (numProductes >= llista.length) {
			Producte [] aux = new Producte[numProductes * 2];
			for (int i = 0 ; i<numProductes ; i++) {
				aux[i] = llista[i];
			}
			llista = aux;
		}
		llista[numProductes] = B.copia();
		numProductes ++;
	}
	
	
	@Override
	public String toString() {
		return "Numero de productes = " + numProductes + "\nLlista de productes:\n" + Arrays.toString(llista);
	}
	
	
	
	
	
}
