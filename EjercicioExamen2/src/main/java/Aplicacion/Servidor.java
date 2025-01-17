package Aplicacion;

import java.net.ServerSocket;

public class Servidor {
	public static void main(String[] args) {
		try(ServerSocket server =  new ServerSocket(4444)){
			do {
				
			} while (true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
