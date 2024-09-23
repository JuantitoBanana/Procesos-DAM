/**
 * 
 */
package paquete_inicial;

/**
 * 
 */
public class Aplicacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiProceso proceso = new MiProceso("Proceso_Hijo");
		proceso.start();
		MiProceso proceso2 = new MiProceso("Proceso_Hijo 2");
		proceso2.start();
		MiProceso proceso3 = new MiProceso("Proceso_Hijo 3");
		proceso3.start();
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " Hola mundo desde la aplicacion");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
