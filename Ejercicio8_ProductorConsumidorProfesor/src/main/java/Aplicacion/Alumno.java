package Aplicacion;

public class Alumno extends Thread{
	private int id;
    private Aprobado aprobado;

    public Alumno(int id, Aprobado aprobado) {
        this.id = id;
        this.aprobado = aprobado;
    }

    @Override
    public void run() {
        if (aprobado.getAprobados()) {
            System.out.println("Alumno " + id + ": Aprobado");
        } else {
            System.out.println("Alumno " + id + ": No Aprobado");
        }
    }
}
