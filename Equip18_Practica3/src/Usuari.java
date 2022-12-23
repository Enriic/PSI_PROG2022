public class Usuari {
    //ALIAS - CORREU ELECTRONIC - CODI POSTAL - INTERCANVIS - PRODUCTES
    private String nom;
    private String correu;
    private String codiPostal;
    private int intercanvis;
    private int valoracio;


    public Usuari(String nom, String correu, String codiPostal) {
        this.nom = nom;
        this.correu = correu;
        this.codiPostal = codiPostal;
        this.intercanvis = 0;
        this.valoracio = 0;
    }

    public String getNom() {
        return nom;
    }

    public String getCorreu() {
        return correu;
    }

    public String getCodiPostal() {
        return codiPostal;
    }

    public int getIntercanvis () {
        return intercanvis;
    }
    public void afegirIntercanvi() {
        this.intercanvis++;
    }

    public int getValoracio () {
        return valoracio;
    }

    public void setValoracio (int valoracio) {
        this.valoracio = valoracio;
    }
    public void setIntercanvis(int intercanvis) {
        this.intercanvis = intercanvis;
    }

    public Usuari copia() {
        Usuari aux = new Usuari(this.nom,this.correu,this.codiPostal);
        aux.setValoracio(this.valoracio);
        aux.setIntercanvis(this.intercanvis);

        return aux;
    }


    public String toString() {
        return "-Usuari: " + nom + "\t | \t correu: " + correu + "\t | \tcodiPostal: " + codiPostal + "\t | \tintercanvis: "
                + intercanvis + "\t | \t Valoracio: "+ valoracio +  "\n";
    }


}