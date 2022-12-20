import java.util.*;
import java.io.*;
public class MAIN {

	public static void main(String[] args) throws IOException {
		
		LlistaProductes LlistaP = new LlistaProductes(10); 	//creem la llista
		ActualitzarLlistaFitxer("old.txt", LlistaP);		//carreguem els productes del fitxer a la llista (fitxer de la opcio no guardar)
		copiarFitxer("old.txt", "new.txt");					//copiem el contingut del fitxer que no modificarem al que si que modificarem
		
		@SuppressWarnings("resource")
		Scanner sn = new Scanner(System.in);
        boolean sortir = false;
        int opcio;
        
        
        while (!sortir) {
 
            System.out.println("\n\n1. Afegir be");
            System.out.println("2. Afegir servei");
            System.out.println("3. Llistar tots els productes");
            System.out.println("4. Guardar i sortir");
            System.out.println("5. Sortir sense guardar");
            
 
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
                    	LlistaP.afegirBe(B);  	//afegim el be al fitxer
                    	B.escriureBeFitxer();	//i a la llista
                    	
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
                    	LlistaP.afegirServei(S);
                    	S.escriureServeiFitxer();
                    	
                        break;
                    case 3:
                    	System.out.println("\n\n");
                		System.out.print(LlistaP.toString());
                        break;
                    case 4:
                        sortir = true;
                        copiarFitxer("new.txt", "old.txt");   //si guardem, copiem el fitxer que hem estat utilitzant tambe al vell que no hem editat
                        break;
                    case 5:
                    	sortir = true;
                    	copiarFitxer("old.txt", "new.txt");		//si no guardem, tornem a sobreescriure el fitxer en el qual hem estat treballant pel del principi sense editar
                    	break;
                    default:
                        System.out.println("Nomes numeros entre 1 i 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Has d'insertar un numero");
                sn.next();
            }
        }		
	}
	
	
	
	public static void ActualitzarLlistaFitxer(String nomFitxer, LlistaProductes LlistaP ) throws IOException{
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
				Be B = new Be(ID, type, descripcio, dataInicial, amplada, alçada, fons, pes, dataIntercanvi);
				LlistaP.afegirBe(B);    
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
				Servei S = new Servei(ID, type, descripcio, dataInicial, dataCaducitat, numIntercanvis);		
				LlistaP.afegirServei(S);
			}
		}
		
		F.close();
		
	}
	
	public static void copiarFitxer(String fitxerOrigen, String fitxerDesti) {
		File origen = new File(fitxerOrigen);
	    File desti = new File(fitxerDesti);
	
	    try {
	        InputStream in = new FileInputStream(origen);
	        OutputStream out = new FileOutputStream(desti);
	        byte[] buf = new byte[1024];
	        int len;
	        while ((len = in.read(buf)) > 0) {
	             out.write(buf, 0, len);
	        }
	        in.close();
	        out.close();
	        
	     } catch (IOException ioe) {
	         ioe.printStackTrace();
	     }
	 }
}



