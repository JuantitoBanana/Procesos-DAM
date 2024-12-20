import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Socket socket = new Socket("localhost", 4444);){
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);
			String cadena = "";
			
			Thread procesoServidor = new Thread(() -> {
				Mensaje obj;
				boolean continuar = true;
				while(!Thread.currentThread().interrupted()) {
					try {
						obj = (Mensaje) ois.readObject();
						System.out.println("Servidor: he recibido el mensaje (" + obj.mensaje() + ")");
					} catch (ClassNotFoundException | IOException e) {
						Thread.currentThread().interrupt();
					}
				}
			});
			procesoServidor.start();
			
			while(!cadena.toLowerCase().equals("fin"))
			{
				cadena=sc.nextLine();
				
				Mensaje mensaje = new Mensaje("Cliente " + socket.getInetAddress().getHostAddress(), cadena);
				
				oos.writeObject(mensaje);
				
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
