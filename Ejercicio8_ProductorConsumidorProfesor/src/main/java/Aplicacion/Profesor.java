package Aplicacion;

public class Profesor extends Thread{
	private Aprobado aprobado;
	
	public Profesor(Aprobado aprobado) {
		this.aprobado = aprobado;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(20);
				aprobado.setAprobados();
			} catch (InterruptedException e) {
				
			}
		}
	}
}
