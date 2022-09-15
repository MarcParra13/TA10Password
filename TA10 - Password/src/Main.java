import java.util.Arrays;

class Password {
	//Atributos clase Password
	int longitud = 8;
	String contraseña;
	public static String NUMEROS = "0123456789";
	public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
	
	//Constructores
	Password() {
		
	}
	
	Password(int longitud) {
		this.longitud = longitud;
		this.contraseña = generarPassword(longitud);
	}
	
	//Métodos get y set
	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getContraseña() {
		return contraseña;
	}
	
	//Método para generar una contraseña aleatoria
	public static String generarPassword(int longitud) {
		String passwd = "";
		
		for (int i = 0; i < longitud; i++) {
			passwd = passwd + (passwd.charAt((int)(Math.random() * passwd.length()))); 
		}
		
		return passwd;
	}
	
	//Método para comprobar si la contraseña es fuerte
	public static boolean esFuerte() {
		boolean esFuerte = false;
		
		return esFuerte;
	}

	
	//Método toString para cambiar la salida por teclado
	@Override
	public String toString() {
		return "La contraseña generada es: ";
	}
}

//Clase Main
public class Main {

	public static void main(String[] args) {
		

	}

}
