package Aplicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		try(Socket socket = new Socket("localhost", 4444);){
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Introduce un nombre:");
			String nombre = sc.nextLine();
			
			Mensaje msjBienvenida = (Mensaje) ois.readObject();
			System.out.println("Servidor: " + msjBienvenida.mensaje());
			
			String cadena = "";
			
			Thread procesoServidor = new Thread(() ->{
					Mensaje msj = null;
					
					try {
						while(true) {
							msj = (Mensaje) ois.readObject();
							System.out.println("Servidor: " + msj.mensaje());
							
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
			});
			procesoServidor.start();
			
			while(true){
				System.out.print("Introduce un mensaje: ");
				cadena = sc.nextLine();
				oos.writeObject(new Mensaje(nombre, cadena));
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
