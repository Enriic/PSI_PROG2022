import java.util.Scanner;

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




	public void acceptaorefusa(int estat){

		System.out.println("Quina peticio vols acceptar o refusar?");

		Scanner LlegirPet =new Scanner(System.in);

		Peticion =LlegirPet.nextLine();


		System.out.println("Vols acceptar o refusar?");

		Scanner estatLlegir = new Scanner(System.in);
		estat = estatLlegir.nextInt();
		
		if(estat==1){

			getUsuariDemana().setValoracioOfert(valoracioDemanat);

			getUsuariRep().setValoracioDemanat(valoracioOfert);


		}

		if(estat == 0){

			System.out.println("Pendent");

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