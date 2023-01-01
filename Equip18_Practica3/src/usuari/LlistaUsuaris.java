package usuari;
import java.util.*;
import java.io.*;


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

    public Usuari[] mostrarUsuarisLlindar(int llindar) {
        Usuari [] L = new Usuari[numUsuaris];
        for (int i = 0; i< this.numUsuaris; i++) {
            if (this.Llista[i].getValoracio() >= llindar)
                L[i] = this.Llista[i].copia();
        }
        return L;

    }
    
    public Usuari cercaUsuari(String email) {
    	for (int i = 0; i < numUsuaris; i++) {
    		if (Llista[i].getCorreu() == email) return Llista[i];
    	}
    	return null;
    }
    
    public LlistaUsuaris carregarFitxer() {				// A MIRAR
    	LlistaUsuaris L = new LlistaUsuaris(5);
    	return L;
    }
    
    
 
}
