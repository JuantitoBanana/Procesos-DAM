package Aplicacion;

public class Productor extends Thread{

	Informacion info;
	
	public Productor(Informacion info) {
		this.info = info;
	}

	@Override
	public void run() {
		super.run();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 10; i++) {
			
			info.producir();
		}
	}


	
}
