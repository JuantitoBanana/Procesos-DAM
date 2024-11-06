package Aplicacion;

public class Aprobado {
	 private int aprobados;

	 public Aprobado(int aprobados) {
		 this.aprobados = aprobados;
	 }

	 public synchronized void setAprobados() {
		 aprobados++;
	 }

	 public synchronized boolean getAprobados() {
		 if (aprobados > 0) {
			 aprobados--;
			 return true;
		 }
		 return false;
	 }
}
