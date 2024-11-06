package Aplicacion;

public class App {

	public static void main(String[] args) {
		 Aprobado aprobado = new Aprobado(10);
	     Profesor profesor = new Profesor(aprobado);   
	     profesor.start();

	     for (int i = 1; i <= 20; i++) {
	    	 Alumno alumno = new Alumno(i, aprobado);
	    	 alumno.start();
	     }
	}
}
