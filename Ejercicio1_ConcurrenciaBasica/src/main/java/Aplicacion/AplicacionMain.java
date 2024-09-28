package Aplicacion;

import java.util.Scanner;

public class AplicacionMain {

	public static void main(String[] args) {
		Scanner datos = new Scanner(System.in);
		System.out.print("Introudce el número de repeticiones: ");
		int numVueltas = datos.nextInt();
		System.out.print("Introudce el intervalo: ");
		int intervalo = datos.nextInt();
		System.out.print("Número de procesos: ");
		int numProcesos = datos.nextInt();
		
		for (int i = 1; i <= numProcesos; i++) {
			Proceso p = new Proceso("Proceso " + i, intervalo, numVueltas);
			p.start();
		}
	}

}
