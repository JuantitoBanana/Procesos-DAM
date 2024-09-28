package Aplicacion;

public class Proceso extends Thread{
	
	private int intervalo;
	private int numVueltas;
	private static Contador contador = new Contador();
	private int contLocal = 0;
	
	public Proceso(String name, int intervalo, int numVueltas) {
		super(name);
		this.intervalo = intervalo;
		this.numVueltas = numVueltas;
	}
	@Override
	public void run() {
		super.run();
		
		while (contador.getContador() < numVueltas) {
			contLocal++;
			synchronized (contador) {
				System.out.println(Thread.currentThread().getName() + " -> " + contador.getContador()+ " [Número de veces que entra:" + contLocal +"]" );
				int aux = contador.getContador();
				aux += intervalo;
				contador.setContador(aux);
			}
		}
	}
}
