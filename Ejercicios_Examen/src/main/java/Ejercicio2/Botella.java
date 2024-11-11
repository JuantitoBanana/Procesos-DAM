package Ejercicio2;

import java.util.ArrayList;

public class Botella extends Thread{
	private final ArrayList<Gota> almacenGotas;
    private int volumen; 

    public Botella(ArrayList<Gota> almacenGotas) {
        this.almacenGotas = almacenGotas;
        this.volumen = 0;
    }

    @Override
    public void run() {
        while (true) {
        	Gota gota = null;

            synchronized (almacenGotas) {
                while (almacenGotas.isEmpty()) {
                    try {
                        almacenGotas.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                gota = almacenGotas.remove(0);
            }


            if (gota != null) {
                volumen += 1;
            }
        }
    }

    public int getVolumen() {
        return volumen;
    }

}
