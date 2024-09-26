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
		
		 
	}

}
