package Ejercicio9_Banco;


public class Politico extends Thread {

    private Banco b;
    private int dineroTotalRobado = 0;
    private int vecesRobado = 0;

    public Politico(String name, Banco b) {
        super(name);
        this.b = b;
        start();
    }

    @Override
    public void run() {
        super.run();

        int dineroRobado = 0;

        do{
            dineroRobado = b.getDineroDisponible();
            dineroTotalRobado += dineroRobado;
            vecesRobado++;
        } while (dineroRobado != 0);

        System.out.println("El politico " + getName() + " ha robado " + dineroTotalRobado + "€, en " + vecesRobado + " veces.");
    }

    public int getDineroTotalRobado() {
        return dineroTotalRobado;
    }
}
