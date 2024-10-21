package Aplicacion;

public class App {

	public static void main(String[] args) {
		Informacion info = new Informacion();
		Productor productor = new Productor(info);
		Consumidor consumidor = new Consumidor(info);
		productor.start();
		consumidor.start();
	
	}
}
