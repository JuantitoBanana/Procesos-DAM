package Aplicacion;

import java.io.Serializable;

public record Mensaje(String cadena) implements Serializable {

	@Override
	public String toString() {
		return cadena;
	}

}
