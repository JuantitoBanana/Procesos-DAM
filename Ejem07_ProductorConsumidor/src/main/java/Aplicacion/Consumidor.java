package Aplicacion;

public class Consumidor extends Thread{

	Informacion info;
	
	public Consumidor(Informacion info) {
		this.info = info;
	}

	@Override
	public void run() {
		super.run();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(info.consumir() + "\n----------------------");
		}
	}
	
}
