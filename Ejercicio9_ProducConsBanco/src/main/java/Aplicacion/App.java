package Aplicacion;


public class App {

	public static void main(String[] args) {
		Dinero dinero = new Dinero(23000);
		Banco banco = new Banco(dinero);
		banco.start();
		
		for (int i = 1; i <= 10; i++) {
	    	 Politico politico = new Politico("Politico " + i, dinero);
	    	 politico.start();
	     }
	}
}
