package Ejercicio9_Banco;


public class Banco {

    private int dineroDelBanco = 23000000;
    private int dineroEnVentanilla = 0;

    public int getDineroDelBanco() {
        return dineroDelBanco;
    }

    public synchronized int getDineroDisponible() {

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int dinero = dineroEnVentanilla;
        System.out.println("..............."+dinero+"-"+dineroEnVentanilla);
        dineroEnVentanilla = 0;

        return dinero;
    }

    public synchronized void setDineroEnVentanilla(int dineroEnVentanilla) {

        dineroDelBanco -= dineroEnVentanilla;
        this.dineroEnVentanilla = dineroEnVentanilla;
        
        if (dineroEnVentanilla == 0){
            notifyAll();
        } else {
            notify();
        }
    }
}
