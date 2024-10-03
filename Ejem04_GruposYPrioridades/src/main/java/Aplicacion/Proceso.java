package Aplicacion;

import java.util.Iterator;

public class Proceso extends Thread{
	
	private Contador contador;
	private int contLocal;
	
	public int getContLocal() {
		return contLocal;
	}

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
		System.out.println("Soy el hilo " + getName() + " y en el grupo " + getThreadGroup().getName() + " y hay estos procesos activos: " + this.getThreadGroup().activeCount());
		Thread [] procesos = new Thread [getThreadGroup().activeCount()];
		getThreadGroup().enumerate(procesos);
		System.out.println("---------");
		for (int i = 0; i < procesos.length; i++) {
			System.out.println(procesos[i].getName());
		} 
		System.out.println("---------");
		
		//System.out.println("Soy el hilo " + getName() + " y he contado " + contLocal + " y pertenezco al grupo " + getThreadGroup().getName());
	}
}
