package Aplicacion;

public class App {

	public static void main(String[] args) {
		Proceso proceso = new Proceso();
		proceso.setDaemon(true);
		proceso.start();
		System.out.println("Fin del proceso padre");
	}

}
