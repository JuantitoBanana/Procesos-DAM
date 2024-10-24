package Aplicacion;

import java.util.Random;

public class Informacion {

	private int dato;
	private boolean continuarProductor = true;
	private Random r = new Random();
	
	public synchronized void producir() {
		if (continuarProductor) {
			dato = r.nextInt();
			notify();
			continuarProductor = false;
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public synchronized int consumir() {
		
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		continuarProductor = true;
		notify();
		return dato;
	}
	
}
