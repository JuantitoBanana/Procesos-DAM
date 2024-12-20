package Ejercicio1;

import java.util.concurrent.ArrayBlockingQueue;

public class Productor extends Thread {
	private ArrayBlockingQueue<Integer> buffer;
	
	
		
	public Productor(ArrayBlockingQueue<Integer> buffer) {
		super();
		this.buffer = buffer;
	}



	@Override
	public void run() {
		super.run();
		
		for (int i = 1; i <= 50; i++) {
			try {
				buffer.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
