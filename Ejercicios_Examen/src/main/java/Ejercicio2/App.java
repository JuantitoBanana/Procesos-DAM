package Ejercicio2;

import java.util.ArrayList;

public class App {
	
	public static void main(String[] args) {
        int duracionGoteo = 10000;

        ArrayList<Gota> almacenGotas = new ArrayList<>();

        Fuente fuenteHilo = new Fuente(almacenGotas, duracionGoteo);
        fuenteHilo.start();

        ArrayList<Botella> botellas = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Botella botella = new Botella(almacenGotas);
            botellas.add(botella);
            botella.setName("Botella " + (i + 1));
            botella.start();
        }


        try {
        	fuenteHilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        for (Botella botella : botellas) {
            botella.interrupt();
        }
        
        for (int i = 0; i < botellas.size(); i++) {
            System.out.println(botellas.get(i).getName() + ": " + botellas.get(i).getVolumen() + " ml");
        }
    }
}
