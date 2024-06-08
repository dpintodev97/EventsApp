package es.events.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
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
	
	private List<Evento> eventos; //Usuario DUEÑA DE LA RELACION OneToMany; 
	
	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
