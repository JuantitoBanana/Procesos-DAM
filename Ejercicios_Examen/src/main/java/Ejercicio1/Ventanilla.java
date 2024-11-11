package Ejercicio1;

public class Ventanilla extends Thread{

	private int NUM_ENTRADAS = 50000;
	private Entrada entrada = new Entrada();
	
	public Ventanilla(String name) {
		super(name);
	}


	@Override
	public void run() {
		super.run();
		
		for (int i = 1; i < NUM_ENTRADAS; i++) {
			synchronized (entrada) {
				entrada.setId();
			}
		System.out.println(Thread.currentThread().getName() + " : Entrada Nº " + entrada.getId());
		}
	}

	
	
}
