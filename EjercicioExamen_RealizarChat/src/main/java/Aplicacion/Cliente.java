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
			Mensaje msj;
			String cadena = "";
			
			Thread procesoServidor = new Thread(() ->{
				
			});
			procesoServidor.start();
			
			while(true){
				System.out.print("Introduce un mensaje: ");
				cadena = sc.nextLine();
				msj = new Mensaje(nombre, cadena);
				oos.writeObject(msj);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
