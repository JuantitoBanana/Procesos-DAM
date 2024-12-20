package Aplicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		try(ServerSocket server =  new ServerSocket(4444)) {
			System.out.println("Servidor escuchando en el puerto 4444");
			
			for (int i = 1; i <= 2; i++) {
				Socket socket = server.accept(); //Espera hasta que establece conexion
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Mensaje obj = (Mensaje) ois.readObject(); //Espera hasta que lea el objeto
				System.out.println(obj + " " + i);
			}
			
			/*
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(new Mensaje("Servidor", "Hola Cliente, me llego tu mensaje"));
			*/
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
