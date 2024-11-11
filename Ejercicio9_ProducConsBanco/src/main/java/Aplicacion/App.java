package Ejercicio9_Banco;


import java.util.ArrayList;
import java.util.Random;

public class Aplicacion {

    private static final int min = 1000000, max = 2000000;

    public static void main(String[] args) {
        Banco b = new Banco();

        ArrayList<Politico> politicos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            politicos.add(new Politico(String.valueOf(i), b));
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int dineroARobar = 0;

        do {
            int aleatorio = new Random().nextInt(min + max) + min;
            dineroARobar = b.getDineroDelBanco() < min ? 0 : (aleatorio > b.getDineroDelBanco() ? b.getDineroDelBanco() : aleatorio);
            System.out.println("----Dinero a Robar:----"+dineroARobar);
            b.setDineroEnVentanilla(dineroARobar);
            try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } while (dineroARobar != 0);

        for (Politico p : politicos) {
            try {
                p.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Dinero restante " + b.getDineroDelBanco());

        int dineroTotalRobado = 0;

        for (Politico p : politicos) {
            dineroTotalRobado += p.getDineroTotalRobado();
        }

        System.out.println("Dinero total robado " + dineroTotalRobado);

    }

}
