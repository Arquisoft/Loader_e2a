package es.uniovi.asw.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "TCITIZENS")
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDOS")
	private String apellidos;

	@Column(name = "EMAIL")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Column(name = "DIRECCION_POSTAL")
	private String direccionPostal;

	@Column(name = "NACIONALIDAD")
	private String nacionalidad;

	@Column(name = "DNI")
	private String dni;

	@Column(name = "NOMBREUSUARIO")
	private String nombreUsuario;

	@Column(name = "CONTRASENA")
	private String contrasena;

	// Constructor vacio para JPA
	public Citizen() {
	}

	public Citizen(String nombre, String apellidos, String email,
			Date fechaNacimiento, String direccionPostal, String nacionalidad,
			String dni, String nombreUsuario, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionPostal = direccionPostal;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public Citizen(String nombre, String apellidos, String email,
			Date fechaNacimiento, String direccionPostal, String nacionalidad,
			String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionPostal = direccionPostal;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
	}
	
	public Long getID() {
		return ID;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaNacimiento() {
		return (Date) fechaNacimiento.clone();
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getDni() {
		return dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citizen other = (Citizen) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Citizen [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", fechaNacimiento=" + fechaNacimiento
				+ ", direccionPostal=" + direccionPostal + ", nacionalidad="
				+ nacionalidad + ", dni=" + dni + "]";
	}

}
