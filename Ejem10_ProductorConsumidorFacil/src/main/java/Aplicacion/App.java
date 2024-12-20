package Aplicacion;

import java.util.concurrent.ArrayBlockingQueue;

public class App {

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(10);
		
		
		Productor p =  new Productor(buffer);
		p.start();
		Consumidor c1 = new Consumidor("Consumidor 1", buffer);
		c1.start();
		Consumidor c2 = new Consumidor("Consumidor 2", buffer);
		c2.start();
		Consumidor c3 = new Consumidor("Consumidor 3", buffer);
		c3.start();
		
		try {
			p.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

}
