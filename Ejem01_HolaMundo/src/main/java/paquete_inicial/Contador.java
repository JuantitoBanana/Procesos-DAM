package paquete_inicial;

public class Contador {
	
	private static int contador = 1;

	public Contador() {
		super();
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	@Override
	public String toString() {
		return "Contador [contador=" + contador + "]";
	}
	
}
