package Aplicacion;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) {
		/*Thread proceso = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Proceso en ejecución");
			}
		});
		proceso.start();*/
		
		//Thread proceso =  new Thread(() -> System.out.println("Proceso en ejecución"));
		
		/*Callable<Integer> tarea = new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				System.out.println("Proceso en ejecución");
				return 10;
			}
		};*/
		
		Callable<Integer> tarea = () -> {
			System.out.println("Proceso en ejecución");
			Thread.sleep(2000);
			return 33;
		};
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> tareaFutura = executor.submit(tarea);
		System.out.println("Esperando el resultado");
		
		try {
			System.out.println("El resultado es " + tareaFutura.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
		
	}

}
