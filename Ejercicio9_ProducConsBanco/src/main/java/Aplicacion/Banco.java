package Aplicacion;


public class Banco extends Thread{
	private Dinero dinero;
	
	public Banco(Dinero dinero) {
		this.dinero = dinero;
	}

	@Override
	public void run() {
		super.run();

		for (int i = 0; i < 10; i++) {
			dinero.colocarDinero();		
		}
	}
}
