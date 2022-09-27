import java.util.Scanner;

//Clase Password
class Password {
	//Atributos clase Password
	static int contNumeros;
	static int contMinusculas;
	static int contMayusculas;
	int longitud = 8;
	String contrasena = generarPassword(longitud);
	
	//Constantes para los números, las mayúsculas y las minúsculas
	public static String NUMEROS = "0123456789";
	public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
	
	//Constructores
	Password() {
		
	}
	
	Password(int longitud) {
		this.contrasena = generarPassword(longitud);
	}
	
	//Métodos get y set
	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getContrasena() {
		return contrasena;
	}
	
	//Método para generar una contraseña aleatoria
	public static String generarPassword(int longitud) {
		String passwd = "";
		contNumeros = 0;
		contMinusculas = 0;
		contMayusculas = 0;
		
		for (int i = 0; i < longitud; i++) {
			
			//Generamos un número aleatorio del 1 al 3
			int numeroAleatorio = (int) (Math.random()*3+1);
			
			//Depende del número coge un carácter y le suma 1 al contador de la constante
			switch(numeroAleatorio) {
			case 1:
				passwd = passwd + (NUMEROS.charAt((int)(Math.random() * NUMEROS.length())));
				contNumeros++;
				break;
			case 2:
				passwd = passwd + (MINUSCULAS.charAt((int)(Math.random() * MINUSCULAS.length())));
				contMinusculas++;
				break;
			case 3:
				passwd = passwd + (MAYUSCULAS.charAt((int)(Math.random() * MAYUSCULAS.length())));
				contMayusculas++;
				break;
			}

		}
		
		return passwd;
	}
	
	//Método para comprobar si la contraseña es fuerte
	public boolean esFuerte() {
		boolean esFuerte;
		
		//Si hay más de 2 mayúsculas, más de 1 minúscula y más de 5 números, la contraseña es fuerte, sino no
		if (contMayusculas > 2 && contMinusculas > 1 && contNumeros > 5) {
			esFuerte = true;
		} else {
			esFuerte = false;
		}
		
		return esFuerte;
	}

	
	//Método toString para cambiar la salida por teclado
	@Override
	public String toString() {
		return "\n" + contrasena;
	}
}

//Clase Main
public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		//Pedimos el número de contraseñas a generar y creamos una array con esa longitud
		System.out.println("Cuántas contraseñas quieres generar?");
		int numPasswds = teclado.nextInt();
		
		Password arrPass[] = new Password[numPasswds];
		
		//Pedimos la longitud de las contraseñas
		System.out.println("\nDe cuánta longitud quieres la contraseña?");
		int longPasswd = teclado.nextInt();
		
		//Por cada iteración, creamos un objeto Password y lo guardamos en el array
		//Creamos un array de booleanos para decir si la contraseña es fuerte o no y guardar esos datos en el array
		for (int i = 0; i < arrPass.length; i++) {
			arrPass[i] = new Password(longPasswd);
			
			boolean arrBoolean[] = new boolean[arrPass.length];
			
			arrBoolean[i] = arrPass[i].esFuerte();
			
			System.out.println(arrPass[i] + " " + arrBoolean[i]);
			
		}
		
	}

}
