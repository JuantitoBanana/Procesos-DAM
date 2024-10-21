package Aplicacion;

import java.util.Random;

public class Informacion {

	private int dato;
	private Random r = new Random();
	
	public synchronized void producir() {
		
		dato = r.nextInt();
		notify();
		
	}
	
	public synchronized int consumir() {
		
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return dato;
	}
	
}
