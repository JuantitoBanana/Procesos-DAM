package Aplicacion;

import java.util.ArrayList;
import java.util.Random;

public class App {

	public static void main(String[] args) {
		Random num = new Random();
		ArrayList<Integer> listaNum = new ArrayList<Integer>();
		Impresora imp1 = new Impresora(listaNum);
		imp1.start();
		Impresora imp2 = new Impresora(listaNum);
		imp2.start();
		Impresora imp3 = new Impresora(listaNum);
		imp3.start();
		Impresora imp4 = new Impresora(listaNum);
		imp4.start();
		Impresora imp5 = new Impresora(listaNum);
		imp5.start();
		
		for (int i = 0; i < 3; i++) {
			while (listaNum.size() != 5) {
				int n = num.nextInt(1,11);
				if(!listaNum.contains(n)) {
					listaNum.add(n);
				}
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int j = 0; j < 5; j++) {
				synchronized (listaNum) {
					listaNum.notify();
				}
			}
			System.out.println("------------------------------------");
			
		}
	}
}
