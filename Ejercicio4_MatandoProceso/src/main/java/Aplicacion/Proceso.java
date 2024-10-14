package Aplicacion;

public class Proceso extends Thread{
	private int cont = 0;
	
	
	public Proceso(String nombre,ThreadGroup grupo) {
		super(grupo, nombre);
		
	}

	@Override
	public void run() {
		
		super.run();
		
		while(!Thread.currentThread().isInterrupted()) {
			cont++;
		}
		System.out.println(Thread.currentThread().getName() + " -> " + cont);
	}
	
}
