package Aplicacion;

import java.io.Serializable;

public record Mensaje(String emisor, String mensaje) implements Serializable{

	@Override
	public String toString() {
		return emisor + ": " + mensaje;
	}
	
}
