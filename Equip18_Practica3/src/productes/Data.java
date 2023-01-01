package productes;
import java.util.Calendar;

public class Data {

	private int dia;
	private int mes;
	private int any;
	
	
	public Data(int dia, int mes, int any) {			//contructor data 
		if (esDataCorrecta(dia, mes, any)) { 
			this.dia = dia;
			this.mes = mes;
			this.any = any;
		} else { 
			this.dia = 1;
			this.mes = 1;
			this.any = 2000;
		}
	}
	
	public Data() {										//constrcutor data actual
		Calendar c = Calendar.getInstance();
		dia = c.get(Calendar.DATE);
		mes = c.get(Calendar.MONTH) + 1;
		any = c.get(Calendar.YEAR);
	}
	
	public Data(boolean esNull) {						//constructor d'una data nula
		if(esNull) {
			this.DataToNull();
		}
		else {
			Calendar c = Calendar.getInstance();
			dia = c.get(Calendar.DATE);
			mes = c.get(Calendar.MONTH) + 1;			// li sumem un perque la classe calendar els mesos van del 0 al 11
			any = c.get(Calendar.YEAR);
		}
	}
	
	public boolean esDataCorrecta(int dia, int mes, int any) {
		boolean hoEs=true;
		if (dia < 1 || dia > 31) { 
			hoEs= false;
		}
		if (mes < 1 || mes > 12) { 
			hoEs= false;
		}
		if (dia > diesMes(mes, any)) { 
			hoEs= false;
		}
		return hoEs;
	}
	
	public int diesMes(int mes, int any) { 
		int diesMes;
		if (mes == 2) {
			if (esAnyTraspas(any)) {
				diesMes = 29;
			} else {
				diesMes = 28;
			}
		} else {
			if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				diesMes = 30;
			} else {
				diesMes = 31;
			}
		}
		return diesMes;
	}
	
	
	public boolean esAnyTraspas(int any) {
		if ((any % 4 == 0) && ((any % 100 != 0) || (any % 400 == 0))) {
			return true;
		} else {
			return false;
		}
	}



	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAny() {
		return any;
	}
	
	public void DataToNull(){
		dia = 0;
		mes = 0;
		any = 0;
	}
	
	public boolean esNull() {
		if(dia == 0 && mes == 0 & any == 0) {
			return true;
		}
		return false;
	}
	
	//-1 ---> no comparable perque una de les dos es NULL
	//0 ----> No ha passat
	//1 ----> JA ha passat
	//2 ---->IGUAL
	public int esMesGran(Data D) {
		int r = -1;
		if (this.esNull() || D.esNull()) {
			return -1;
		}
		
		if (this.any == D.any) {
			if (this.mes == D.mes) {
				if (this.dia == D.dia) {
					r = 2;
				}
				else if (this.dia < D.dia) {
					r = 1;
				}
				else if (this.dia > D.dia){
					r = 0;
				}
			}
			else if (this.mes < D.mes) {
				r = 1;
				
			}
			else if (this.mes > D.mes){
				r = 0;
			}
		}
		else if (this.any < D.any) {
			r = 1;
		}
		else if (this.mes > D.mes){
			r = 0;
		}
		return r;
	}
	
	public Data copia() {
		Data copia = new Data(dia, mes, any);
		return copia;
	}
	
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + any;
	}
	
	

}
