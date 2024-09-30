
public class Proceso implements Runnable {
	
	private Thread hilo; 
	
	public Proceso() {
		hilo = new Thread(this);
		hilo.start();
	}
	
	@Override
	public void run() {
		System.out.println("Hola mundo desde el proceso");

	}

}
