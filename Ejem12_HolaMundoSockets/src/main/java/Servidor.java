import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ServerSocket server= new ServerSocket(4444)){
			System.out.println("Servidor escuchando en el puerto 4444");
			for (int i = 0; i < 5; i++) {
				
				System.out.println("Hilo " + Thread.currentThread().getName() + " en ejecución");
				Socket socket=server.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
				
				Thread procesoCliente = new Thread(() -> {
					Mensaje obj = null;
					boolean continuar = true;
					while(continuar)
					{
						try {
							obj = (Mensaje) ois.readObject();
							oos.writeObject(obj);
							System.out.println(obj);
							if(obj.mensaje().toLowerCase().equals("fin")) {
								continuar = false;
							}
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continuar = false;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continuar = false;
						}
						
					}
					
					
				});
				procesoCliente.start();
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
