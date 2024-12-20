package Ejercicio1;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
	public static void main(String[] args) throws InterruptedException {
		
		ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(10);
		ExecutorService executor =  Executors.newFixedThreadPool(3);
		
		Productor p =  new Productor(buffer);
		p.start();
		Consumidor c1 = new Consumidor("Consumidor 1", buffer);
		//listaConsumidores.add(c1);
		executor.submit(c1);
		Consumidor c2 = new Consumidor("Consumidor 2", buffer);
		//listaConsumidores.add(c1);
		executor.submit(c2);
		Consumidor c3 = new Consumidor("Consumidor 3", buffer);
		//listaConsumidores.add(c1);
		executor.submit(c3);
		
		ArrayList<Future<Integer>> listaResultados =  new ArrayList<Future<Integer>>();
		listaResultados = (ArrayList<Future<Integer>>) executor.invokeAll(buffer);
	}
}
