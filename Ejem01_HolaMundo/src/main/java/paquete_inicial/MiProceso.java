package paquete_inicial;


public class MiProceso extends Thread {
	
	private static Contador contador = new Contador();
	
	public MiProceso(String name) {
		super(name);

	}

	@Override
	public void run() {
		int contLocal = 0;
		//Quantum -> tiempo de proceso en cpu
		super.run();
		while (contador.getContador() < 999) {
			contLocal++;
			synchronized (contador) { //Synchronized no tienen que ser muy grandes
				System.out.println(Thread.currentThread().getName() + "-> " + contador.getContador() + " [Número de veces que entra:" + contLocal +"]" );
				int aux = contador .getContador();
				aux++;
				contador.setContador(aux);
			}
			/*try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}
	
	
	
	
}
