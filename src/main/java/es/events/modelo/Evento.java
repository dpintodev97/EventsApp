package es.events.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	private Set<Categoria> categorias; //RELACION EVENTO - CATEGORIA, YA QUE 1 EVENTO TIENE 1 SET DE CATEGORIAS A LAS CUALES PUEDE PERTENECER; @ManyToMany
										//CLASE EVENTO ES DUEÑA DE LA RELACIÓN, POR LO QUE AQUÍ SE ESPECIFICA LA SET. EN EL OTRO LADO DE LA RELACIÓN IRÁ EL @MappedBy
	
	//METODOS:
	
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

	@Column(name = "fecha_hora")
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

	//MAPEO RELACIÓN Evento - Categoria
	@ManyToMany
	@JoinTable( //DEFINE TABLA DE UNION QUE CONECTA Evento CON Categoría, LLAMADA eventos_categorias, ALMACENANDO LAS RELACIONES ENTRE ESTAS. SE REFERENCIAN LAS FK.
			name = "eventos_categorias",
			joinColumns = @JoinColumn(name = "fk_evento"),
			inverseJoinColumns = @JoinColumn(name = "fk_categoria")
			)
	public Set<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
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
	
	//------  COMPARATOR MULTICRITERIO DE ORDENACIÓN DE OBJETOS Evento: .compare<---------------------------- CENTRALIZACIÓN DE LA LÓGICA DE ORDENACIÓN
	/**
	 * COMPARATOR MULTICRITERIO: por nombre, fecha y hora, y por nombre + fecha y hora
	 * a)crea un comparador que ordena los eventos según el resultado 	del método getNombre() de la clase Evento; devuelve eventos por orden alfabético
	 * b)el thenComparing, se llama en el resultado del primer comparador. 
			Así,si dos eventos tienen el mismo nombre, se compararán basándose en el resultado del método getFechaHora().
			Esto asegura que los eventos con el mismo nombre se ordenen cronológicamente por su fecha y hora
	 * @return Comparator
	 * 
	 * NOTA: Al diseñar la CAPA DE NEGOCIO (Lógica), el usuario pueda ordenar eventos según el criterio que elija: 
	 * 		por nombre, por fecha y hora, o por ambos (nombre + fecha y hora)
	 * NOTA: Las dobles dos puntos :: ES: operador de referencia a método. Se utiliza para hacer referencia a métodos o constructores de forma compacta y más legible, 
	 * especialmente cuando se utilizan con expresiones lambda. 
	 * En el contexto del Comparator, Evento::getNombre y Evento::getFechaHora son referencias a métodos que indican que se deben usar los métodos getNombre y getFechaHora 
	 * de la clase Evento para la comparación.
	 */
	public static Comparator<Evento> getComparatorMulti(){
		return Comparator.comparing(Evento::getNombre).thenComparing(Evento::getFechaHora);
			
	}

	
}
