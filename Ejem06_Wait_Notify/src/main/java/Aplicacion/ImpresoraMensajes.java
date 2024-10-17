package Aplicacion;

public class ImpresoraMensajes extends Thread {

	private Mensaje mensaje;
	
	public ImpresoraMensajes(String nombre, Mensaje m) {
		super(nombre);
		this.mensaje = m;
	}

	@Override
	public void run() {
		
		super.run();
		do {
			synchronized (mensaje) {
				try {
					mensaje.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ", " + mensaje);
			}
		}while(!mensaje.getMensaje().equalsIgnoreCase("Salir"));
		
		
	}

}
