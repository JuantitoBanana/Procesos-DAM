package paquete_inicial;


public class MiProceso extends Thread {
	
	private Contador contador;
	
	public MiProceso(String name,Contador contador) {
		super(name);
		this.contador = contador;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		//Quantum -> tiempo de proceso en cpu
		super.run();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "-> " + contador.getContador());
			int aux = contador .getContador();
			aux++;
			contador.setContador(aux); 
			/*try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}
	
	
	
	
}
