package Aplicacion;

public class Productor extends Thread{

	Informacion info;
	
	public Productor(Informacion info) {
		this.info = info;
	}

	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			info.producir();
		}
		}


	
}
