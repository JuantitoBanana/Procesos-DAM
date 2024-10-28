package Aplicacion;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Informacion info = new Informacion();
		Productor productor = new Productor(info);
		Consumidor consumidor = new Consumidor(info, "Consumidor 1");
		Consumidor consumidor2 = new Consumidor(info, "Consumidor 2");
		Consumidor consumidor3 = new Consumidor(info, "Consumidor 3");
		productor.start();
		consumidor.start();
		consumidor2.start();
		consumidor3.start();
		
		try {
			productor.join();
			consumidor.join();
			consumidor2.join();
			consumidor3.join();
		} catch (Exception e) {
		}
		
		System.out.println("Consumidor 1: " + consumidor.getCont());
		System.out.println("Consumidor 2: " + consumidor2.getCont());
		System.out.println("Consumidor 3: " + consumidor3.getCont());
		
	}

}
