package Aplicacion;


public class Politico extends Thread{
	private Dinero dinero;
	
	public Politico(String name, Dinero dinero) {
		super(name);
		this.dinero = dinero;
	}

	@Override
	public void run() {
		super.run();
		
		System.out.println(Thread.currentThread().getName() + " : " + dinero.cogerDinero() + " €");
	}
	
}
