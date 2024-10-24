package Aplicacion;

public class Proceso extends Thread{
	@Override
	public void run() {
		super.run();
		
		while(true)
		{
			System.out.println("Proceso en ejecucion");

		}
		
	}

}
