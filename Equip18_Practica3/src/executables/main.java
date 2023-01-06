package executables;

import java.util.*;
import java.io.*;
import usuari.*;
import peticions.*;
import productes.*;

public class main {

	public static void main(String[] args) throws IOException {

		Usuari user1= new Usuari("Gerard", "marinperezgeri@gmail.com", "43850","Gerard1234");			//Prueba user 1
		Usuari user2= new Usuari("Argi", "argiderirurt@gmail.com", "31001","4rg1");				//Prueba user 2
		Usuari user3= new Usuari("Albert", "alberturv@gmail.com", "54850","4tun");				//Prueba user 3
		Usuari user4= new Usuari("Ramzi", "ramziurv@gmail.com", "98775","P3scad0R");				//Prueba user 4
		//LlistaUsuaris LU1 = CarregarFitxerSer();
		LlistaUsuaris llistausuaris = new LlistaUsuaris(1);
		CarregarFitxerSer(llistausuaris);
		

		//Peticio pet1 = new Peticio(12345, llistausuaris.getUsuariFromLlista(1), llistausuaris.getUsuariFromLlista(2), "123A", "456B");		//Prueba peticion 1
		//Peticio pet2 = new Peticio(11111, llistausuaris.getUsuariFromLlista(3), llistausuaris.getUsuariFromLlista(4), "789A", "321B");		//Prueba peticion 2
		llistausuaris.afegirUsuari(user1);
		llistausuaris.afegirUsuari(user2);
		llistausuaris.afegirUsuari(user3);
		llistausuaris.afegirUsuari(user4);
		//SobreescriureFitxerSer(LU2);



		LlistaProductes LlistaProd = new LlistaProductes(1); 	//creem la llista productes
		LlistaPeticions LlistaPet = new LlistaPeticions(1);					//creem la llista peticions
		CarregarLlistaProductesFitxer("Productes.txt", LlistaProd);			
		@SuppressWarnings("resource")
		Scanner sn = new Scanner(System.in);
        boolean sortir = false;
        int opcio;
        
        while (!sortir) {
 
            System.out.println("\n\n1. Afegir be");
            System.out.println("2. Afegir servei");
            System.out.println("3. Llistar tots els productes");
            System.out.println("4. Llistar serveis actius");
            System.out.println("5. Llistar bens actius");
            System.out.println("6. Donar de baixa Be");
            System.out.println("7. Donar de baixa Servei");
            System.out.println("8. Servei amb mes intercanvis");
			System.out.println("9. Afegir Peticio");
			System.out.println("10. Gestionar peticio");
			System.out.println("11. Mostrar peticions pendents");
			System.out.println("12. Mostrar peticions acceptades");
			System.out.println("13. Mostrar peticions refusades");
            System.out.println("14. Guardar i sortir");
            System.out.println("15. Sortir sense guardar");
			
            
            try {
 
                System.out.println("Tria una opcio");
                opcio = sn.nextInt();
                
                @SuppressWarnings("resource")
				Scanner teclat = new Scanner(System.in);
                
                int estat = 0;
				switch (opcio) {
                    case 1:

                    	System.out.println("Escriu els seguents valors:");
                    	System.out.println("ID:");
                    	String id = teclat.next();
                    	System.out.println("Descripcio");
                    	String descripcio = teclat.next();
                    	System.out.println("amplada:");
                    	int amplada = teclat.nextInt();
                    	System.out.println("altura:");
                    	int altura = teclat.nextInt();
                    	System.out.println("fons:");
                    	int fons = teclat.nextInt();
                    	System.out.println("pes:");
                    	int pes = teclat.nextInt();
                    	
                    	Be B = new Be(id, "Be", descripcio, amplada, altura, fons, pes);
                    	LlistaProd.afegirProducte(B);
                        break;

                    case 2:
                    	
                    	System.out.println("Escriu els seguents valors:");
                    	System.out.println("ID:");
                    	String idServei = teclat.next();
                    	System.out.println("Descripcio");
                    	String descripcioServei = teclat.next();
                    	System.out.println("DATA DE CADUCITAT");
                    	System.out.println("dia:");
                    	int dia = teclat.nextInt();
                    	System.out.println("mes:");
                    	int mes = teclat.nextInt();
                    	System.out.println("any:");
                    	int any = teclat.nextInt();
                    	
                    	Servei S = new Servei(idServei, "Servei", descripcioServei, new Data(dia,mes,any));
                    	LlistaProd.afegirProducte(S);
                    	
                        break;

                    case 3:

                    	System.out.println("\n\n");
                		System.out.print(LlistaProd.toString());
                        break;
                        
                    case 4:
                    	LlistaProductes LS = LlistaProd.llistaServeisActius();
                		System.out.println(LS.toString());
                    	break;
                    case 5:
                    	LlistaProductes LB = LlistaProd.llistaBensActius();
                		System.out.println(LB.toString());
                    	break;
                    case 6:
                    	System.out.println("Escriu l'ID del be que vols donar de baixa:");
                    	String idB = teclat.next();
                    	LlistaProd.donarDeBaixa(idB);
                    	break;
                    case 7:
                    	System.out.println("Escriu l'ID del servei que vols donar de baixa:");
                    	String idS = teclat.next();
                    	LlistaProd.donarDeBaixa(idS);
                    	break;
                    case 8:
                    	System.out.println("Servei amb mes intercanvis:");
                    	break;

					case 9:
						/*System.out.println("Introduzca el correo del usuario creador de peticion:");
						String input = teclat.next();
						Usuari usuariA = LU1.cercaUsuari(input);
						if (usuariA == null) System.out.println("ERROR: Usuario inexistente");
						System.out.println("Introduzca el correo del usuario al que se le hace la peticion:");
						input = teclat.next();
						Usuari usuariB = LU1.cercaUsuari(input);
						if (usuariB == null) System.out.println("ERROR: Usuario inexistente");
						System.out.println("Introduzca el codigo del producto/servicio que se ofrece:");
						String codiA = teclat.next();
						System.out.println("Introduzca el codigo del producto/servicio que se espera recibir:");
						String codiB = teclat.next();*/
						
						int codiPet = -1;
						boolean ok = false;
						while (!ok) {
							codiPet++;
							ok = true;
							for (int i = 0; i < LlistaPet.getNumElem(); i++) {
								//if (LlistaPet[i].getCodi() == codiPet) ok = false;
							}
						}
						
						//LlistaPet.afegirPet(new Peticio(codiPet, usuariA, usuariB, codiA, codiB));

						break;
					
					/*case 10:
						
						System.out.println("Introduzca el codigo de peticion:");
						String codi = teclat.next();
						for (int i = 0; i < LlistaPet.getNumElem(); i++) {
							if (LlistaPet[i].getCodi() == codi) {
								int petI = i;
							}
						}
						
						// ... mostrar detalles peticion? 
						
						System.out.println("Que desea hacer?");
						System.out.println("   1 = Aceptar");
						System.out.println("   2 = Rechazar");
						System.out.println("   0 = Cancelar");
						int op = teclat.nextInt();*/
						/*if (op == 1) {
							System.out.println("Introduzca valoracion para el usuario A (creador peticion):");
							//
							System.out.println("Introduzca valoracion para el usuario B (receptor peticion):");
							//
							LlistaPet[petI].AcceptarPet(valA, valB);
						}
						else if (op == 2) {
							LlistaPet[petI].RefusarPet(valA, valB);
						}*/
						
						//break;
					
					case 11:
						//Mostrar peticiones pendientes
						
						//LlistaPeticions petPend = Peti.mostrarPetPendents(estat);
						
						
						
						break;
					case 12:
						//Mostrar peticiones aceptadas

						//LlistaPeticions petAcc = Peti.mostrarPetAcceptades(estat);
						
						
						
						break;
					
					case 13:
						//Mostrar peticiones rechazadas

						//LlistaPeticions petRef = Peti.mostrarPetRefusades(estat);



						break;

                    case 14:
                        sortir = true;
                        SobreescriureFitxer("Productes.txt",LlistaProd);
                        break;
                    case 15:
                    	sortir = true;
                    	break;


						
						


                    default:
                        System.out.println("Nomes numeros entre 1 i 10");
                }
            } catch (InputMismatchException e) {
                System.out.println("Has d'insertar un numero");
                sn.next();
            }
        }		
	}
	
	
	public static void CarregarLlistaPeticionsFitxer(String nomFitxer, LlistaPeticions LlistaPet) throws IOException {
		int codi;
		Usuari usuariA; 		// Usuario que HACE la petición
		Usuari usuariB; 		// Usuario que RECIBE la petición
		String codiProducteA;
		String codiProducteB;
		int estat;
		
		String frase;
		Scanner F = new Scanner (new File(nomFitxer));
		Scanner particio;
		String stringUsuari;
		String partsUsuari[];
		
		while (F.hasNext()) {
			frase = F.nextLine();
			particio = new Scanner(frase);
			particio.useDelimiter(";");
			particio.useLocale(Locale.ENGLISH);
			
			codi = particio.nextInt();
			stringUsuari = particio.next();
			partsUsuari = stringUsuari.split(";");
			usuariA = new Usuari(partsUsuari[0], partsUsuari[1], partsUsuari[2], partsUsuari[5]);
			usuariA.setIntercanvis(Integer.parseInt(partsUsuari[3]));
			usuariA.setIntercanvis(Integer.parseInt(partsUsuari[4]));
			stringUsuari = particio.next();
			partsUsuari = stringUsuari.split(";");
			usuariB = new Usuari(partsUsuari[0], partsUsuari[1], partsUsuari[2], partsUsuari[5]);
			usuariB.setIntercanvis(Integer.parseInt(partsUsuari[3]));
			usuariB.setIntercanvis(Integer.parseInt(partsUsuari[4]));
			codiProducteA = particio.next();
			codiProducteB = particio.next();
			estat = particio.nextInt();
			
			Peticio pet = new Peticio(codi, usuariA, usuariB, codiProducteA, codiProducteB); pet.setEstat(estat);
			LlistaPet.afegirPet(pet);
		}
		
		F.close();
	}
	
	
	
	public static void CarregarLlistaProductesFitxer(String nomFitxer, LlistaProductes LlistaP ) throws IOException{
		String type;
		String ID;
		String descripcio;
		float amplada;
		float alçada;
		float fons;
		float pes;
		String data;
		String frase;
		int dia, mes, any;
		int numIntercanvis;
		int numActiu;
		boolean actiu;
		
		Scanner F = new Scanner (new File(nomFitxer));
		Scanner particio;
		
		while (F.hasNext()) {
			
			frase = F.nextLine();
			particio=new Scanner(frase);
			particio.useDelimiter(";");
			particio.useLocale(Locale.ENGLISH);

			type = particio.next();
			
			if (type.equalsIgnoreCase("B")) {
				
				ID = particio.next();
				type = particio.next();
				descripcio = particio.next();

				data = particio.next();
				dia = Integer.parseInt(data.split("/")[0]);
				mes = Integer.parseInt(data.split("/")[1]);
				any = Integer.parseInt(data.split("/")[2]);
				Data dataInicial = new Data (dia, mes, any);
				amplada = particio.nextFloat();
				alçada = particio.nextFloat();
				fons = particio.nextFloat();
				pes = particio.nextFloat();
				data = particio.next();
				dia = Integer.parseInt(data.split("/")[0]);
				mes = Integer.parseInt(data.split("/")[1]);
				any = Integer.parseInt(data.split("/")[2]);
				Data dataIntercanvi;
				if(dia == 0 && mes == 0 && any == 0) {
					dataIntercanvi = new Data(true);
				}else {
					dataIntercanvi = new Data (dia, mes, any);
				}
				numActiu = particio.nextInt();
				if (numActiu == 1)
					actiu = true;
				else
					actiu = false;
				
				Be B = new Be(ID, type, descripcio, dataInicial, amplada, alçada, fons, pes, dataIntercanvi, actiu);
				B.esActiu(); //abans d'afegir comprovem si es veritat que encara esta actiu (pot ser que lutim cop de guardar ho estigues i ara ja no)
				LlistaP.afegirProducte(B);    
			}									
			
			else if (type.equalsIgnoreCase("S")) {
				ID = particio.next();
				type = particio.next();
				descripcio = particio.next();
				
				data = particio.next();
				dia = Integer.parseInt(data.split("/")[0]);
				mes = Integer.parseInt(data.split("/")[1]);
				any = Integer.parseInt(data.split("/")[2]);
				Data dataInicial = new Data (dia, mes, any);
				
				data = particio.next();
				dia = Integer.parseInt(data.split("/")[0]);
				mes = Integer.parseInt(data.split("/")[1]);
				any = Integer.parseInt(data.split("/")[2]);
				Data dataCaducitat = new Data (dia, mes, any);
				
				numIntercanvis = particio.nextInt();
				numActiu = particio.nextInt();
				if (numActiu == 1)
					actiu = true;
				else
					actiu = false;
				Servei S = new Servei(ID, type, descripcio, dataInicial, dataCaducitat, numIntercanvis, actiu);
				S.esActiu();
				LlistaP.afegirProducte(S);
			}
		}
		
		F.close();
		
	}
	
	public static void SobreescriureFitxer(String fitxer, LlistaProductes L) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fitxer));
		bw.write("");
		bw.close();
		L.escriureLlistaAlFitxer();
	}
	
	public static void SobreescriureFitxerSer(LlistaUsuaris L) {
		ObjectOutputStream fit;
		try {
			fit = new ObjectOutputStream (new FileOutputStream("usuaris.ser"));
			for (int i = 0 ; i<L.getNumUsuaris(); i++) {
				fit.writeObject(L.getUsuariFromLlista(i));
			}
			fit.close();
		}
		catch (IOException e) {
			System.out.println("Error");
		}
		
	}
	
	public static void CarregarFitxerSer(LlistaUsuaris L) {
		ObjectInputStream fit;
		try {
			
			fit = new ObjectInputStream(new FileInputStream("usuaris.ser"));
			
			while(true) {
				L.afegirUsuari((Usuari)fit.readObject());
				
			}
		
		}
		catch (EOFException e) {
			System.out.println("Llegit correctament");
		}
		catch (IOException e) {
			System.out.println("Error leer fitxer");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error, no es troba la classe usuari."+e);
		}
		catch (ClassCastException e){
			System.out.println("Error, el format de l'arxiu no és correcte per la definició actual de la classe usuari."+e);
		}
}
}