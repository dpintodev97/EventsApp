package es.events.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Evento implements Serializable, Comparable<Evento>{
	//ATRIBUTOS PRIVADOS DE CLASE:
	private int idEvento;
	private String nombre;
	private String descripcion;
	private String ubicacion;
	private LocalDateTime fechaHora; //GUARDO EN ESTE TIPO DE DATO, YA QUE ES MODERNO (JAVA8 EN ADELANTE), Y NO NECESITO PRECISIÓN EN NANOSEGUNDOS
	private Usuario usuario;

	@Override
	public int compareTo(Evento o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
