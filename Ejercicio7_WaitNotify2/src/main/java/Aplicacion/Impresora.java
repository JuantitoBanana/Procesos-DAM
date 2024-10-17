package Aplicacion;

import java.util.ArrayList;

public class Impresora extends Thread{
	
	private ArrayList<Integer> lista;
	private int numero;
	
	public Impresora(ArrayList<Integer> lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i < 3; i++) {
			synchronized (lista) {
				try {
					lista.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				numero = lista.getFirst();
				lista.removeFirst();
			}
			System.out.println(Thread.currentThread().getName()+ " : " + numero);
		}
		
	}
	
}
