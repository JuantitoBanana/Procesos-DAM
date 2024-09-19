package paquete_inicial;


public class MiProceso extends Thread {
	
	public MiProceso(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		//Quantum -> tiempo de proceso en cpu
		super.run();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " Hola mundo desde el proceso");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
