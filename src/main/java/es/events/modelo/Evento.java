package es.events.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventos")
public class Evento implements Serializable{ //NO IMPLEMENTA INTERFACE COMPARABLE, YA QUE USARÉ COMPARATORS PERSONALIZADOS
	//ATRIBUTOS PRIVADOS DE CLASE:
	private int idEvento;
	private String nombre;
	private String descripcion;
	private String ubicacion;
	private LocalDateTime fechaHora; //GUARDO EN ESTE TIPO DE DATO, YA QUE ES MODERNO (JAVA8 EN ADELANTE), Y NO NECESITO PRECISIÓN EN NANOSEGUNDOS
	
	private Usuario user; //LADO DEL N (FK): Evento TIENE ASIGNADO UN Usuario; 1 Usuario TIENE N Eventos (List)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento")
	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	//METODOS HASHCODE Y EQUALS (por ID): PARA GESTIONAR EL ESTADO DE LAS ENTIDADES 
		//(por ejemplo, la detección de duplicados, la comparación de entidades en el contexto de persistencia)
	@Override
	public int hashCode() {
		return Objects.hash(idEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return idEvento == other.idEvento;
	}
	

	

}
