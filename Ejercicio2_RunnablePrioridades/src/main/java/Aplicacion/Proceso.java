package Aplicacion;

public class Proceso implements Runnable{

	private Thread hilo;
	private static Contador contador = new Contador();
	private int contLocal = 0;
	private final int NUMVUELTAS = 100000;
	
	public Proceso() {
		hilo = new Thread(this);
		hilo.start();
	}
	
	@Override
	public void run() {
		
		while (contador.getContador() < NUMVUELTAS) {
			contLocal++;
			synchronized (contador) {
				if (contador.getContador() <= NUMVUELTAS) {
					System.out.println(Thread.currentThread().getName() + " -> " + contador.getContador());
					int aux = contador.getContador();
					aux++;
					contador.setContador(aux);
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " - [Número de veces que entra:" + contLocal + "]");
	}
}
