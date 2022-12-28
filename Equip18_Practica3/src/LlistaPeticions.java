

public class LlistaPeticions {

	private Peticio[] llista;
	private int numElem;
	private int val2;
	private int val1;
	
	
	
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

	public void AcceptarPet(int estat, int valA, int valB) {
		estat = 1;

		Usuari usuariA.setValoracio(((usuariA.getValoracio()*usuariA.getIntercanvis())+valA)/(usuariA.getIntercanvis()+1));
		System.out.println(usuariA.getValoracio());
		usuariA.afegirIntercanvi();
		
		Usuari usuariB.setValoracio(((usuariB.getValoracio()*usuariB.getIntercanvis())+valB)/(usuariB.getIntercanvis()+1));
		System.out.println(usuariB.getValoracio());
		usuariB.afegirIntercanvi();	
	}
	
	

	public void RefusarPet(int estat) {
		estat = 2;
	}


/* 
	public void acepta_peticio(int val1, int val2){

		if(0<val1 && val1<5){

			this.val1=val1;

		}

		if(0<val2 && val2<5){

			this.val2 = val2;

		}
		
	}

	public void AcceptaORefusa(int estat){
		
		if(estat==1){

			acepta_peticio(val1, val2);

		}

		if(estat == 2){				//rachaza petición

		}

	}

*/
	
/* 
	//No esta pedido en la practica, esta bien como bonus
	public void esborrarPet(String codi) {
		// encontrar pet., borrar y reordenar lista
	}
*/
	
	public void mostrarPetPendents(int estat) {								//FASE DE PRUEBA DE MOSTRAR PETICIONS PENDENTS
		for(int i = 0; i<numElem; i++){
			if(estat == 0){
			
				System.out.println(llista[i]);

			}
		}						
	}
	
	public void mostrarPetAcceptades(int estat) {							//FASE DE PRUEBA DE MOSTRAR PETICIONS PENDENTS
		for(int i = 0; i<numElem; i++){
			if(estat == 1){
			
				System.out.println(llista[i]);

			}
		}
	}
	
	public void mostrarPetRefusades(int estat) {							//FASE DE PRUEBA DE MOSTRAR PETICIONS PENDENTS
		for(int i = 0; i<numElem; i++){
			if(estat == 2){
			
				System.out.println(llista[i]);

			}
		}
	}
}