package Aplicacion;

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
		
		for (int i = 0; i < 100; i++) {
			try {
				buffer.put(i);
				System.out.println("Productor produce: " + i);
				System.out.println("Lista con: " + buffer.size());
				//Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
