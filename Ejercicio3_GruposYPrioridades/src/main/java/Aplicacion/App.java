package Aplicacion;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Contador contador = new Contador();
		Scanner dato  = new Scanner(System.in);
		boolean continuar = true;
		int numProcesos = 0;
		while (continuar) {
			if(numProcesos <2) {
				System.out.print("Introduce el número de procesos (máx 2):");
				numProcesos = dato.nextInt();
			}else {
				continuar = false;
			}
		}
		
		ThreadGroup primero = new ThreadGroup("Primer proceso");
		ThreadGroup resto = new ThreadGroup("Resto de procesos");
		for(int i = 1; i <= numProcesos;i++) {
			if(i == 1) {
				Proceso proceso = new Proceso(contador, primero, "Proceso " + i);
				proceso.setPriority(Thread.MIN_PRIORITY);
				proceso.start();
			}else {
				Proceso proceso = new Proceso(contador, resto, "Proceso " + i);
				proceso.setPriority(Thread.MAX_PRIORITY);
				proceso.start();
			}
		}
	}

}
 