package Aplicacion;

public class App {

	public static void main(String[] args) throws Exception {
		
		Contador contador = new Contador();
		ThreadGroup pares = new ThreadGroup("Pares");
		ThreadGroup impares = new ThreadGroup("Impares");
		Proceso proceso1 = new Proceso(contador, impares, "Proceso1");
		proceso1.setPriority(Thread.MAX_PRIORITY);
		proceso1.start();
		Proceso proceso2 = new Proceso(contador, pares, "Proceso2");
		proceso2.setPriority(Thread.MIN_PRIORITY);
		proceso2.start();
		Proceso proceso3 = new Proceso(contador, impares, "Proceso3");
		proceso3.setPriority(Thread.MAX_PRIORITY);
		proceso3.start();
		Proceso proceso4 = new Proceso(contador, pares, "Proceso4");
		proceso4.setPriority(Thread.MIN_PRIORITY);
		proceso4.start();
		
		proceso1.join();
		proceso2.join();
		proceso3.join();
		proceso4.join();
		
		System.out.println("Soy el hilo " + proceso1.getName() + " y he contado " + proceso1.getContLocal() + " y pertenezco al grupo ");
		System.out.println("Soy el hilo " + proceso2.getName() + " y he contado " + proceso2.getContLocal() + " y pertenezco al grupo ");
		System.out.println("Soy el hilo " + proceso3.getName() + " y he contado " + proceso3.getContLocal() + " y pertenezco al grupo ");
		System.out.println("Soy el hilo " + proceso4.getName() + " y he contado " + proceso4.getContLocal() + " y pertenezco al grupo ");
		
	}

}
