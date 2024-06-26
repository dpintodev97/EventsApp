package es.events.modelo;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario { //NO NECESITA QUE IMPLEMENTE SERIALIZABLA, YA QUE NO SE ENVIARÁ SUS DATOS A ARCHIVOS EXTERNOS O POP LA RED; SOLO EN LA BBDD SE GUARDARÁ
						// NO NECESITA SER COMPARABLE TAMPOCO, NI COMPARATORS
	//ATRIBUTOS PRIVADOS DE CLASE:
	private int idUsuario;
	private String nombre;
	private String ape1;
	private String ape2;
	private String nickname;
	private String correo;
	private String password;
	private LocalDateTime fechaRegistro; //GUARDO EN ESTE TIPO DE DATO, YA QUE ES MODERNO (JAVA8 EN ADELANTE), Y NO NECESITO PRECISIÓN EN NANOSEGUNDOS
	
	private Set<Evento> eventos; //Usuario DUEÑA DE LA RELACION OneToMany; 
	//NOTA: SET y no List PARA QUE UN USUARIO NO PUEDA AGREGAR DOS VECES MISMO EVENTO (NO DUPLICADOS) Y PARA PODER BUSCAR POR Categorias DE FORMA MÁS RAPIDO Y EFICIENTE.
	
	//METODOS:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "fecha_registro")
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@OneToMany(mappedBy = "user") //MAPEADO POR user, en CLASE EVENTO; QUE ES DONDE SE ESPECIFICA LA fk_usuario QUE APUNTA A id_usuario EN LA BBDD
	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return idUsuario == other.idUsuario;
	}
	//**** NOTA: METODOS HASHCODE Y EQUALS: NO SON NECESARIOS AHORA MISMO, NO ES NECESARIO ORDENAR USUARIOS... 
	//(SI A FUTURO CRECE LA APP Y NECESITO ORDENAR EN COLECCIONES LOS USUARIOS, SEGUN ROLES EN LA APP, ES INTERESANTE)

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2
				+ ", nickname=" + nickname + ", correo=" + correo + ", password=" + password + ", fechaRegistro="
				+ fechaRegistro + ", eventos=" + eventos + "]";
	}
	
	

	
}
