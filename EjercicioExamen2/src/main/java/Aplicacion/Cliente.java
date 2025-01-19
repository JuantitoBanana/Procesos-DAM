package Aplicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	public static int numCliente;
	
	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		String confirmacion = "";
		Socket socket;
		
		
		
			try{
				do {
					socket = new Socket("localhost", 4444);
					if(!socket.isConnected()) {
						System.out.print("Quieres volver a intentar conectarte?   (Si/No): ");
						confirmacion = sc.nextLine();
					}
				} while (confirmacion.equalsIgnoreCase("Si"));
				numCliente ++;
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				
				
				
				Thread procesoServidor = new Thread(() -> {
					Mensaje msjServidor = null;
					while(!Thread.currentThread().isInterrupted()) {
						try {
							msjServidor = (Mensaje) ois.readObject();
							System.out.println("Servidor: " + msjServidor.contenido());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				procesoServidor.start();
				
				Mensaje msj = null;
				int contenido = 0;
				do {
					
					msj = new Mensaje(numCliente, contenido);
					oos.writeObject(msj);
				}while(msj.contenido() < 10);
				
				procesoServidor.interrupt();
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		
		
	}
}
