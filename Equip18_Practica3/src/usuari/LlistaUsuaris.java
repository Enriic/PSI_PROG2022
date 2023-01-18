package usuari;
import java.util.Arrays;


public class LlistaUsuaris {
    private Usuari [] llista;
    private int numUsuaris;

    public LlistaUsuaris(int numUsuaris) {
        if (numUsuaris >0) {
        	this.llista = new Usuari [numUsuaris];
            numUsuaris = 0;
        }
    }


    public void afegirUsuari(Usuari X) {
        if (this.numUsuaris >= this.llista.length) {
            Usuari [] aux = new Usuari [this.numUsuaris+1];
            for (int i = 0; i < this.numUsuaris; i++)
                aux[i]=llista[i];

            this.llista = aux;
            }

        this.llista[numUsuaris] = X.copia();
        this.numUsuaris ++;
        }


    public int getNumUsuaris() {
        return numUsuaris;
    }

    public LlistaUsuaris mostrarUsuarisLlindar(int min, int max) {
    	LlistaUsuaris L = new LlistaUsuaris(1);
        for (int i = 0; i< this.numUsuaris; i++) {
            if ((this.llista[i].getValoracio() >= min) && (this.llista[i].getValoracio() <= max))
                L.afegirUsuari(this.llista[i]);
        }
        return L;

    }
    
    
    
	public String toString() {
		return Arrays.toString(llista) + ", numUsuaris=" + numUsuaris + "]";
	}


	public Usuari cercaUsuari(String nom){
    	for (int i = 0; i < numUsuaris; i++) {
    		if (this.llista[i].getNom() == nom) {
    			return llista[i];
    		}	
    	}
    	
    	return null;
    }
    
    public LlistaUsuaris carregarFitxer() {				// A MIRAR
    	LlistaUsuaris L = new LlistaUsuaris(5);
    	return L;
    }
    

    public Usuari getUsuariFromLlista(int posicio) {
        return this.llista[posicio].copia();
    }
    
 
}
