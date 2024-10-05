package Aplicacion;

public class Proceso extends Thread{
	
	private Contador contador;
	private int contLocal;

	public Proceso(Contador contador, ThreadGroup grupo, String nombre) {
		super(grupo, nombre);
		this.contador = contador;
	}
	
	@Override
	public void run() {
		super.run();
		
		while(contador.getContador() < 100000) {
			contLocal++;
			synchronized (contador) {
				contador.setContador(contador.getContador());
			int aux = contador.getContador();
			aux++;
			contador.setContador(aux);
			}
		}
		System.out.println("Soy el hilo " + getName() + ", he contado " + contLocal + " y pertenezco al grupo " + getThreadGroup().getName());
	}
}
