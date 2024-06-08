package es.events.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Usuario implements Serializable, Comparable<Usuario> {
	//ATRIBUTOS PRIVADOS DE CLASE:
	private int idUsuario;
	private String nombre;
	private String ape1;
	private String ape2;
	private String nickname;
	private String correo;
	private String password;
	private LocalDateTime fechaRegistro; //GUARDO EN ESTE TIPO DE DATO, YA QUE ES MODERNO (JAVA8 EN ADELANTE), Y NO NECESITO PRECISIÓN EN NANOSEGUNDOS
	
	
	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
