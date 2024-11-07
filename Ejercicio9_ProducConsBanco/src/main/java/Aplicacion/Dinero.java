package Aplicacion;


import java.util.Random;

public class Dinero {
	private int dineroDisponible;
	private int dinero;

	public Dinero(int cantidadDinero) {
		this.dineroDisponible = cantidadDinero;
	}
	
	public synchronized void colocarDinero() {
		Random gen = new Random();
		dinero = gen.nextInt(1000, 2001);
	}
	public synchronized int cogerDinero() {
		if(dinero > dineroDisponible) {
			dinero = dineroDisponible;
			dineroDisponible = 0;
		}
		else {
			dineroDisponible -= dinero;
		}
		return dinero;
	}
}
