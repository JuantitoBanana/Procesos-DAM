package Aplicacion;

public class Proceso extends Thread{

	@Override
	public void run() {
		
		super.run();
		/*
		boolean salir = false;
		while(!salir) {
			System.out.println("Proceso en ejecución");
			
			if(Thread.currentThread().isInterrupted())
				salir = true;
				// Liberar recursos los que sea.
		}
		*/
		
		 while(!Thread.currentThread().isInterrupted()) {
			 System.out.println("Proceso en ejecución");
			 
			 try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		 }
		 
		
	}
	
}
