package usuari;
import java.io.Serializable;

public class Usuari  implements Serializable {
	static final long serialVersionUID = 1;
    protected String nom;
    protected String correu;
    protected String codiPostal;
    protected int intercanvis;
    protected int valoracio;
    protected String codi;


    public Usuari(String nom, String correu, String codiPostal,String codi) {
        this.nom = nom;
        this.correu = correu;
        this.codiPostal = codiPostal;
        this.intercanvis = 0;
        this.valoracio = 0;
        this.codi = codi;
    }

    public String getNom() {
        return this.nom;
    }

    public String getCorreu() {
        return this.correu;
    }

    public String getCodiPostal() {
        return this.codiPostal;
    }

    public int getIntercanvis () {
        return this.intercanvis;
    }
    
    public String getCodi() {
    	return this.codi;
    }
    
    public void afegirIntercanvi() {
        this.intercanvis++;
    }

    public int getValoracio () {
        return this.valoracio;
    }

    public void setValoracio (int valoracio) {
        this.valoracio = valoracio;
    }
    public void setIntercanvis(int intercanvis) {
        this.intercanvis = intercanvis;
    }
    public void setCodi(String codi) {
    	this.codi = codi;
    }

    public Usuari copia() {
        Usuari aux = new Usuari(this.nom,this.correu,this.codiPostal,this.codi);
        aux.setValoracio(this.valoracio);
        aux.setIntercanvis(this.intercanvis);

        return aux;
    }


    public String toString() {
        return "-Usuari: " + nom + "\t | \t correu: " + correu + "\t | \tcodiPostal: " + codiPostal + "\t | \tintercanvis: "
                + intercanvis + "\t | \t Valoracio: "+ valoracio +  "\n";
    }


}