package Aplicacion;

public class App {

	public static void main(String[] args) {
		
		ThreadGroup listaProcesos = new ThreadGroup("Lista de Procesos");
		
		for (int i = 1; i <= 100; i++) {
			Proceso p = new Proceso("Proceso " + i, listaProcesos);
			p.start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listaProcesos.interrupt();
		
		/*
		Proceso[] procesos= new Proceso[tg.activeCount()];
		tg.enumerate(procesos);
		for (Proceso proceso : procesos) {
			proceso.interrupt();
		}
		*/
	}

}
