package Aplicacion;

import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		ImpresoraMensajes impresora = new ImpresoraMensajes();
		impresora.start();
		
		Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un mensaje: ");
        String mensaje = teclado.nextLine();
        Mensaje m = new Mensaje(mensaje);

	}

}
