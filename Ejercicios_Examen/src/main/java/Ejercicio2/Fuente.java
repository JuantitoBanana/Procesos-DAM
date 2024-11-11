package Ejercicio2;

import java.util.ArrayList;
import java.util.Random;

public class Fuente extends Thread{
	 private final ArrayList<Gota> almacenGotas;
	    private final int duracionGoteo;
	    private final Random random;

	    public Fuente(ArrayList<Gota> almacenGotas, int duracionGoteo) {
	        this.almacenGotas = almacenGotas;
	        this.duracionGoteo = duracionGoteo;
	        this.random = new Random();
	    }

	    @Override
	    public void run() {
	        long tiempoInicio = System.currentTimeMillis();
	        while (System.currentTimeMillis() - tiempoInicio < duracionGoteo) {
	            try {
	            	Gota gota = new Gota();

	                synchronized (almacenGotas) {
	                    almacenGotas.add(gota);
	                    almacenGotas.notifyAll();
	                }

	                Thread.sleep(1 + random.nextInt(10));
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
}
