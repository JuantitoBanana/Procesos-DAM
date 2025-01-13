package Aplicacion;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(4444);){
			
			for(int i = 0; i < 4; i++) {
				Socket socket =  server.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
				
				Thread procesoCliente = new Thread(() -> {
					Mensaje msj = null;
					
					try {
						msj = (Mensaje) ois.readObject();
						System.out.println(msj.toString());
					} catch (Exception e) {
						// TODO: handle exception
					}
				});
				procesoCliente.start();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
