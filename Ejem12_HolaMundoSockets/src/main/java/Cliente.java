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
			
			Mensaje obj;
			String cadena = "";
			while(!cadena.toLowerCase().equals("fin"))
			{
				cadena=sc.nextLine();
				
				Mensaje mensaje = new Mensaje("Cliente " + socket.getLocalPort(), cadena);
				
				oos.writeObject(mensaje);
				
				try {
					obj = (Mensaje) ois.readObject();
					System.out.println("he recibido el mensaje (" + obj.mensaje() + ")");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
