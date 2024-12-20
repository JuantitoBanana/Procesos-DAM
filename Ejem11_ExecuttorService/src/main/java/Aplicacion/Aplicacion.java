package Aplicacion;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Aplicacion {

	public static void main(String[] args) {

		ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);
		
		ExecutorService executor =  Executors.newFixedThreadPool(3);
		
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor("consumidor1",buffer);
		productor.start();
		//consumidor.start();
		executor.submit(consumidor);
		
		Consumidor consumidor2 = new Consumidor("consumidor2",buffer);
		//consumidor2.start();
		executor.submit(consumidor2);
		
		Consumidor consumidor3 = new Consumidor("consumidor3",buffer);
		//consumidor3.start();
		executor.submit(consumidor3);
		
		try {
			productor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		try {
			if(!executor.awaitTermination(4, TimeUnit.SECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}