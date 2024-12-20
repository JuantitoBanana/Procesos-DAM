package Ejercicio1;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumidor extends Thread{
	
	private ArrayBlockingQueue<Integer> buffer;
	private int numeroDatosConsumidos;
	
	
	public Consumidor(String nombre, ArrayBlockingQueue<Integer> buffer) {
		super(nombre);
		this.buffer = buffer;
		
	}
	
	@Override
	public void run() {
		super.run();
		
		while (!buffer.isEmpty()) {
			try {
				Thread.sleep(100);
				System.out.println("Consumidor consume: " + buffer.take());
				numeroDatosConsumidos++;
				System.out.println("Total consumidos del " + currentThread().getName() + ": " + numeroDatosConsumidos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
