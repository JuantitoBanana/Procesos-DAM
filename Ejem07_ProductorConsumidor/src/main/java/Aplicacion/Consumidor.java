package Aplicacion;


public class Consumidor extends Thread {
	private Informacion info;
	private int cont;
	
	public  Consumidor(Informacion info, String name) {
		super(name);
		this.info = info;
	}
	
	public int getCont() {
		return cont;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while() {
			cont++;
			System.out.println(Thread.currentThread().getName() + " - " + info.consumir());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
