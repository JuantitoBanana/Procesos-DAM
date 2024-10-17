package Aplicacion;

import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Mensaje m = new Mensaje("");
		ImpresoraMensajes impresora1 = new ImpresoraMensajes("Impresora 1", m);
		impresora1.start();
		ImpresoraMensajes impresora2 = new ImpresoraMensajes("Impresora 2", m);
		impresora2.start();
		ImpresoraMensajes impresora3 = new ImpresoraMensajes("Impresora 3", m);
		impresora3.start();
		ImpresoraMensajes impresora4 = new ImpresoraMensajes("Impresora 4", m);
		impresora4.start();
		
        do {
        	System.out.println("Introduce un mensaje: ");
            String mensaje = teclado.nextLine();
            m.setMensaje(mensaje);
            synchronized (m) {
            	m.notifyAll();
            }
        }while(!m.getMensaje().equalsIgnoreCase("Salir"));
        
	}

}
