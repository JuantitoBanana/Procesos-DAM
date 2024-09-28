package Aplicacion;

public class Contador {

	private static int contador = 1;
	
	public Contador() {
		super();
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Contador.contador = contador;
	}
}
