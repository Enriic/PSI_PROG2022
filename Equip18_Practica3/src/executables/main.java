package executables;

import java.util.*;

import error.DadaDuplicada;
import error.DadaInexistent;


import java.io.*;
import usuari.*;
import peticions.*;
import productes.*;

public class main {

	public static void main(String[] args) throws IOException {

		LlistaUsuaris llistausuaris = new LlistaUsuaris(1);
		CarregarFitxerSer(llistausuaris);
		LlistaProductes LlistaProd = new LlistaProductes(1); 				//creem la llista productes
		CarregarLlistaProductesFitxer("Productes.txt", LlistaProd);	
		LlistaPeticions LlistaPet = new LlistaPeticions(1);					//creem la llista peticions
		CarregarLlistaPeticionsFitxer(LlistaPet);
		System.out.println(LlistaPet.toString());
		
		/*Usuari user1= new Usuari("Gerard", "marinperezgeri@gmail.com", "43850","Gerard1234");			//Prueba user 1
		Usuari user2= new Usuari("Argi", "argiderirurt@gmail.com", "31001","4rg1");				//Prueba user 2
		Usuari user3= new Usuari("Albert", "alberturv@gmail.com", "54850","4tun");				//Prueba user 3
		Usuari user4= new Usuari("Ramzi", "ramziurv@gmail.com", "98775","P3scad0R");				//Prueba user 4

		Peticio pet1 = new Peticio(12345, llistausuaris.getUsuariFromLlista(0), llistausuaris.getUsuariFromLlista(1), "123A", "456B");		//Prueba peticion 1
		Peticio pet2 = new Peticio(11111, llistausuaris.getUsuariFromLlista(2), llistausuaris.getUsuariFromLlista(3), "789A", "321B");		//Prueba peticion 2
		
		llistapet.afegirPet(pet1);
		llistapet.afegirPet(pet2);
				
		SobreescriureFitxerPet("Peticions.txt",llistapet);
		llistausuaris.afegirUsuari(user1);
		llistausuaris.afegirUsuari(user2);
		llistausuaris.afegirUsuari(user3);
		llistausuaris.afegirUsuari(user4);
		SobreescriureFitxerSer(LU2);*/

				
		@SuppressWarnings("resource")
		Scanner sn = new Scanner(System.in);
        boolean sortir = false;
        int opcio;
        
        while (!sortir) {
        	System.out.println("\n\n ========== MENU PRINCIPAL ==========\n");
        	System.out.println("PRODUCTES");
            System.out.println("   1. Afegir be");
            System.out.println("   2. Afegir servei");
            System.out.println("   3. Mostrar tots els productes");
            System.out.println("   4. Mostrar serveis actius");
            System.out.println("   5. Mostrar bens actius");
            System.out.println("   6. Donar de baixa producte");
            System.out.println("   7. Servei amb mes intercanvis");
            System.out.println("USUARIS");
            System.out.println("   8. Afegir usuari");
            System.out.println("   9. Mostrar usuaris");
            System.out.println("   10. Cercar usuaris per valoracio"); 
            System.out.println("PETICIONS");
			System.out.println("   11. Afegir Peticio");
			System.out.println("   12. Gestionar peticio");
			System.out.println("   13. Mostrar peticions pendents");
			System.out.println("   14. Mostrar peticions acceptades");
			System.out.println("   15. Mostrar peticions refusades");
            System.out.println("\n16. Guardar i sortir");
            System.out.println("17. Sortir sense guardar");
			
            
            try {
 
                System.out.print("\n\nTRIA UNA OPCIO: ");
                opcio = sn.nextInt();
                
                @SuppressWarnings("resource")
				Scanner teclat = new Scanner(System.in);
                
				switch (opcio) {
                    case 1:
                    	afegirBe(teclat, LlistaProd);                    	
                        break;
                        
                    case 2:
                    	afegirServei(teclat, LlistaProd);                    	
                        break;

                    case 3:
                    	System.out.print("\n\n"+LlistaProd.toString());
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
                    	baixaProducte(teclat, LlistaProd);
                    	break;
                    	
                    case 7:
                    	serveiMesInterc(LlistaProd);
                    	break;

                    case 8:
                    	afegirUsuariM(teclat, llistausuaris);
                    	break;
                    	
                    case 9:
                    	System.out.println("\n\n"+llistausuaris.toString());
                    	break;
                    	
                    case 10:
                    	cercaUsuarisVal(teclat, llistausuaris);
                    	break;
                    	
					case 11:
						afegirPetM(teclat, llistausuaris, LlistaPet, LlistaProd);
						break;
					
					case 12:
						gestioPet(teclat, LlistaPet);				
						break;
					
					case 13:						
						System.out.println("\n\n"+LlistaPet.mostrarPetPendents().toString());
						break;
						
					case 14:
						System.out.println("\n\n"+LlistaPet.mostrarPetAcceptades().toString());
						break;
					
					case 15:
						System.out.println("\n\n"+LlistaPet.mostrarPetRefusades().toString());
						break;

                    case 16:
                        sortir = true;
                        SobreescriureFitxer("Productes.txt",LlistaProd);
                        SobreescriureFitxerPet("Peticions.txt",LlistaPet);
                        break;
                    case 17:
                    	sortir = true;
                    	break;
                    	
                    default:
                        System.out.println("Nomes numeros entre 1 i 18");
                }
            } catch (InputMismatchException e) {
                System.out.println("Has d'insertar un numero");
                sn.next();
            }
        }		
	}
	
	
	
	public static void CarregarLlistaPeticionsFitxer(LlistaPeticions LlistaPet) throws IOException {
	    int codi;
	    Usuari usuariA; 		// Usuario que HACE la petición
	    Usuari usuariB; 		// Usuario que RECIBE la petición
	    String codiProducteA;
	    String codiProducteB;
	    int estat;
	    String frase;
	    Scanner F = new Scanner (new File("Peticions.txt"));
	    Scanner particio;
	    String stringUsuari;
	    String partsUsuari[];
	    String nomusuari;
	    String correuusuari;
	    String codipostal;
	    String contrasena;
	    int intercanvis;
	    int valoracio;

	    while (F.hasNext()) {
	        frase = F.nextLine();
	        particio = new Scanner(frase);
	        particio.useDelimiter(";");
	        particio.useLocale(Locale.ENGLISH);

	        codi = particio.nextInt();
	        nomusuari = particio.next();
	        correuusuari= particio.next();
	        codipostal= particio.next();
	        intercanvis = particio.nextInt();
	        valoracio=particio.nextInt();
	        contrasena = particio.next();
	        usuariA = new Usuari(nomusuari, correuusuari, codipostal, contrasena);
	        
	        usuariA.setIntercanvis(intercanvis);
	        
	        nomusuari = particio.next();
	        correuusuari= particio.next();
	        codipostal= particio.next();
	        intercanvis = particio.nextInt();
	        valoracio=particio.nextInt();
	        contrasena = particio.next();
	        usuariB = new Usuari(nomusuari, correuusuari, codipostal,contrasena);
	        usuariB.setIntercanvis(intercanvis);
	        codiProducteA=particio.next();
	        codiProducteB=particio.next();
	        
	        estat = particio.nextInt();

	        Peticio pet = new Peticio(codi, usuariA, usuariB, codiProducteA, codiProducteB);
	        pet.setEstat(estat);
	        LlistaPet.afegirPet(pet);
	        particio.close();
	    }

	    F.close();
	}

	
	
	public static void SobreescriureFitxerPet(String fitxer, LlistaPeticions L) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fitxer));
		bw.write("");
		bw.close();
		L.escriureLlistaAlFitxer();
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
	
	
	
	
	
	public static void afegirBe(Scanner teclat, LlistaProductes L) {
		
		System.out.println("AFEGIR BE - Escriu els seguents valors:");
		String id;
		boolean idOK = false;
		do {
			System.out.print("ID: ");
	    	id = teclat.next();
	    	try { idOK = !producteDuplicat(id, L);}
	    	catch (DadaDuplicada e) { System.out.println(e);}
		} while (!idOK);
    	
    	System.out.print("Descripcio: ");
    	String descripcio = teclat.next();
    	System.out.print("Amplada: ");
    	int amplada = teclat.nextInt();
    	System.out.print("Altura: ");
    	int altura = teclat.nextInt();
    	System.out.print("Fons: ");
    	int fons = teclat.nextInt();
    	System.out.print("Pes: ");
    	int pes = teclat.nextInt();
    	
    	Be B = new Be(id, "Be", descripcio, amplada, altura, fons, pes);
    	L.afegirProducte(B);
    	
    	System.out.println("\nEl be s'ha afegit correctament.\n");
	}
	
	public static void afegirServei(Scanner teclat, LlistaProductes L) {
		System.out.println("AFEGIR SERVEI - Escriu els seguents valors:");
		String id;
		boolean idOK = false;
		do {
			System.out.print("ID: ");
	    	id = teclat.next();
	    	try { idOK = !producteDuplicat(id, L);}
	    	catch (DadaDuplicada e) { System.out.println(e);}
		} while (!idOK);
    	System.out.print("Descripcio: ");
    	String descripcioServei = teclat.next();
    	System.out.println("DATA DE CADUCITAT");
    	System.out.print("Dia: ");
    	int dia = teclat.nextInt();
    	System.out.print("Mes: ");
    	int mes = teclat.nextInt();
    	System.out.print("Any: ");
    	int any = teclat.nextInt();
    	
    	Servei S = new Servei(id, "Servei", descripcioServei, new Data(dia,mes,any));
    	L.afegirProducte(S);
    	
    	System.out.println("\nEl servei s'ha afegit correctament.\n");
	}
		
	public static void baixaProducte(Scanner teclat, LlistaProductes L) {
		String id;
		boolean idOK = false;
		do {
			System.out.print("Escriu l'ID del be que vols donar de baixa: ");
			id = teclat.next();
			try { idOK = L.donarDeBaixa(id);}
			catch (DadaInexistent e) {System.out.println(e);}
		} while (!idOK);
    	System.out.println("\nEl producte s'ha donat de baixa.\n");
	}
	
	
	
	public static void serveiMesInterc(LlistaProductes L) {
		System.out.println("SERVEI AMB MES INTERCANVIS:");
		Producte P = L.mostrarServeiMesIntercanvis();
		System.out.println(P.toString());
	}
	
	public static void afegirUsuariM(Scanner teclat, LlistaUsuaris L) {
		System.out.println("AFEGIR USUARI - Escriu els seguents valors:");
		String nom;
		boolean nomOK = false;
		do {
			System.out.print("Nom/alias: ");
	    	nom = teclat.next();
	    	try { nomOK = !usuariDuplicat(nom, L);}
	    	catch (DadaDuplicada e) { System.out.println(e);}
		} while (!nomOK);
		System.out.print("Correu: ");
		String correu = teclat.next();
		System.out.print("Codi postal: ");
		String codiPost = teclat.next();
		System.out.print("Codi: ");
		String codi = teclat.next();
		Usuari u = new Usuari(nom, correu, codiPost, codi);
		L.afegirUsuari(u);
		
		System.out.println("\nEl usuari s'ha afegit correctament.\n");
	}
	
	public static void cercaUsuarisVal(Scanner teclat, LlistaUsuaris L) {
		int max = 5;
		System.out.println("Cercar usuaris per llindar de valoracions:");
		System.out.print("MIN (0-5): ");
		int min = teclat.nextInt();
		if (min < 5) {
			System.out.print("MAX ("+min+"-5): ");
			max = teclat.nextInt();
		}
		(L.mostrarUsuarisLlindar(min, max)).toString();
	}
	
	
	public static void afegirPetM(Scanner teclat, LlistaUsuaris llistausuaris, LlistaPeticions LlistaPet, LlistaProductes LlistaProd)  {
		System.out.println("NOVA PETICIO");
		Usuari usuariA = null;
		Usuari usuariB = null;
		String nomA, nomB;
		do {
			System.out.print("Nom usuari creador de peticio: ");
	    	nomA = teclat.next();
	    	System.out.print("Nom usuari a qui es fa peticio: ");
			nomB = teclat.next();
	    	try { 
	    		usuariA = llistausuaris.cercaUsuari(nomA);
	    		usuariB = llistausuaris.cercaUsuari(nomB);
	    		} catch (DadaInexistent e) { System.out.println(e);}
		} while (usuariA == null || usuariB == null);
		
		boolean codiOK = false;
		String codiA, codiB;
		do {
			System.out.print("Codi producte que s'ofereix: ");
			codiA = teclat.next();
			System.out.print("Codi producte que s'espera rebre: ");
			codiB = teclat.next();
			try {
				codiOK = existeixProducte(codiA, LlistaProd);
				if (codiOK) codiOK = existeixProducte(codiB, LlistaProd);
			} catch (DadaInexistent e) { System.out.println(e);}
		} while (!codiOK);
		
		
		int codiPet = LlistaPet.getNumElem();
		Peticio p = new Peticio(codiPet, usuariA, usuariB, codiA, codiB);
		LlistaPet.afegirPet(p);

	}
	
	
	public static void gestioPet(Scanner teclat, LlistaPeticions L) {
		System.out.println("GESTIONAR PETICIO");
		System.out.print("Codi peticio: ");
		int codi = teclat.nextInt();
		Peticio petG = L.getPeticioiFromLlista(codi);
		System.out.println(L.toString());
		System.out.println("Que voleu fer?");
		System.out.println("   1 = Acceptar");
		System.out.println("   2 = Refusar");
		System.out.println("   0 = Cancelar");
		int op = teclat.nextInt();
		if (op == 1) {
			System.out.print("Valoracio usuari A ("+petG.getUsuariA()+"): ");
			int valA = teclat.nextInt();
			System.out.print("Valoracio usuari B ("+petG.getUsuariB()+"): ");
			int valB = teclat.nextInt();
			L.AcceptarPetLlista(codi, valA, valB);
		}
		else if (op == 2) L.RefusarPetLlista(codi);
		
	}
	
	
	
	private static boolean producteDuplicat(String id, LlistaProductes L) throws DadaDuplicada{
		boolean dupli = false;
		int i = 0;
		while (!dupli && i < L.getNumProductes()) {
			if (L.getProducteFromLlista(i).getID().equals(id)) dupli = true;
			i++;
		}
		if (dupli) throw new DadaDuplicada(id);
		return dupli;
	}
	
	private static boolean usuariDuplicat(String nom, LlistaUsuaris L) throws DadaDuplicada{
		boolean dupli = false;
		int i = 0;
		while (!dupli && i < L.getNumUsuaris()) {
			if (L.getUsuariFromLlista(i).getNom().equalsIgnoreCase(nom)) dupli = true;
			i++;
		}
		if (dupli) throw new DadaDuplicada(nom);
		return dupli;
	}
	
	
	private static boolean existeixProducte(String codi, LlistaProductes L) throws DadaInexistent{
		boolean trobat = false;
		int i = 0;
		while (!trobat && i < L.getNumProductes()) {
			if (L.getProducteFromLlista(i).getID().equals(codi)) trobat = true;
			i++;
		}
		if (!trobat) throw new DadaInexistent(codi);
		return trobat;
	}
	
}