package Aplicacion;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
	
	private static List<ObjectOutputStream> clientes =  new ArrayList<>();
	
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(4444);){
			
			for(int i = 0; i < 4; i++) {
				Socket socket = null;
				while(clientes.size() < 4) {
					socket =  server.accept();

					ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
					clientes.add(oos);
				}
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				for(ObjectOutputStream out : clientes) {
					out.writeObject(new Mensaje("","Bienvenido al servidor"));
				}
				
				Thread procesoCliente = new Thread(() -> {
					Mensaje msj = null;
					
					try {
						while(true) {
							msj = (Mensaje) ois.readObject();
							System.out.println(msj.toString());
							
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				});
				procesoCliente.start();
				
				while(true) {
					Thread.sleep(5000);
					for(ObjectOutputStream out : clientes) {
						out.writeObject(new Mensaje("","Testeo servidor"));
					}
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
