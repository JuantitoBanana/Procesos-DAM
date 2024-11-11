package Ejercicio1;

public class App {

	public static void main(String[] args) {
		
		Ventanilla v1 = new Ventanilla("Ventanilla 1");
		v1.setPriority(Thread.MAX_PRIORITY);
		v1.start();
		Ventanilla v2 = new Ventanilla("Ventanilla 2");
		v2.setPriority(Thread.MAX_PRIORITY);
		v2.start();
		Ventanilla v3 = new Ventanilla("Ventanilla 3");
		v3.setPriority(Thread.MIN_PRIORITY);
		v3.start();
		Ventanilla v4 = new Ventanilla("Ventanilla 4");
		v4.setPriority(Thread.MIN_PRIORITY);
		v4.start();
	}

}