import java.util.*;
import java.io.*;
public class MAIN {

	public static void main(String[] args) throws IOException {

		Usuari user1= new Usuari("Gerard", "marinperezgeri@gmail.com", "43850");			//Prueba user 1
		Usuari user2= new Usuari("Argi", "argiderirurt@gmail.com", "31001");				//Prueba user 2
		Usuari user3= new Usuari("Albert", "alberturv@gmail.com", "54850");				//Prueba user 3
		Usuari user4= new Usuari("Ramzi", "ramziurv@gmail.com", "98775");					//Prueba user 4


		Peticio pet1 = new Peticio(12345, user1, user2, "123A", "456B");		//Prueba peticion 1
		Peticio pet2 = new Peticio(11111, user3, user4, "789A", "321B");		//Prueba peticion 2
		




		LlistaProductes LlistaP = new LlistaProductes(1); 	//creem la llista
		LlistaPeticions Peti = new LlistaPeticions(1);					//creem la llista peticions
		CarregarLlistaFitxer("old.txt", LlistaP);			
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
            System.out.println("10. Guardar i sortir");
            System.out.println("11. Sortir sense guardar");
			
            
            try {
 
                System.out.println("Tria una opcio");
                opcio = sn.nextInt();
                
                @SuppressWarnings("resource")
				Scanner teclat = new Scanner(System.in);
                
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
                    	LlistaP.afegirProducte(B);
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
                    	LlistaP.afegirProducte(S);
                    	
                        break;

                    case 3:

                    	System.out.println("\n\n");
                		System.out.print(LlistaP.toString());
                        break;
                        
                    case 4:
                    	LlistaProductes LS = LlistaP.llistaServeisActius();
                		System.out.println(LS.toString());
                    	break;
                    case 5:
                    	LlistaProductes LB = LlistaP.llistaBensActius();
                		System.out.println(LB.toString());
                    	break;
                    case 6:
                    	System.out.println("Escriu l'ID del be que vols donar de baixa:");
                    	String idB = teclat.next();
                    	LlistaP.donarDeBaixa(idB);
                    	break;
                    case 7:
                    	System.out.println("Escriu l'ID del servei que vols donar de baixa:");
                    	String idS = teclat.next();
                    	LlistaP.donarDeBaixa(idS);
                    	break;
                    case 8:
                    	System.out.println("Servei amb mes intercanvis:");
                    	break;

					case 9:
						System.out.println("A quin usuari li vols fer la peticio?");
						Usuari UsuariB = teclat.next();	//Mirar error
						System.out.println("Inserti el codi del producte que li interesa: ");
						String codiProducteB =teclat.next();
						System.out.println("Indica el teu nom d'usuari:");
						Usuari UsuariA =teclat.next();	//Mirar error
						System.out.println("Inserti el codi del producte per fer l'intercanvi: ");
						String codiProducteA =teclat.next();

						int codi=0;


						if (codi <= 99999) {
							codi++;
						}

						Peticio pet = new Peticio(codi, UsuariA, UsuariB, codiProducteA, codiProducteB);
						Peti.afegirPet(pet);

						break;

                    case 10:
                        sortir = true;
                        SobreescriureFitxer("old.txt",LlistaP);
                        break;
                    case 11:
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
	
	
	
	public static void CarregarLlistaFitxer(String nomFitxer, LlistaProductes LlistaP ) throws IOException{
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
}