package Aplicacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) {
		try(Socket socket =  new Socket("localhost",4444)){
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			Mensaje mensaje =  new Mensaje("Cliente", "Hola Servidor");
			oos.writeObject(mensaje);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}