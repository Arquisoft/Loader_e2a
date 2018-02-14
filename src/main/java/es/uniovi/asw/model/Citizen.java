package es.uniovi.asw.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "TAGENTS")
public class Citizen {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long claveAcceso;
	@Id
	private Long ID;

	public void setID(Long iD) {
		ID = iD;
	}
	

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public Long getClaveAcceso() {
		return claveAcceso;
	}


	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "LOCALIZACION")
	private String localizacion;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TIPO")
	private int tipo;


	// Constructor vacio para JPA
	public Citizen() {
	}

	
	
	public Citizen(Long iD, String nombre, String localizacion, String email, int tipo) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.email = email;
		this.tipo = tipo;
	}



	@Override
	public String toString() {
		return "Citizen [ID=" + ID + ", nombre=" + nombre + ", localizacion=" + localizacion + ", email=" + email
				+ ", tipo=" + tipo + "]";
	}



	public Long getID() {
		return ID;
	}

	

	public String getNombre() {
		return nombre;
	}

	

	public String getLocalizacion() {
		return localizacion;
	}



	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}



	public int getTipo() {
		return tipo;
	}



	public String getEmail() {
		return email;
	}

	

	

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public void setEmail(String email) {
		this.email = email;
	}

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((claveAcceso == null) ? 0 : claveAcceso.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((localizacion == null) ? 0 : localizacion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + tipo;
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
		if (claveAcceso == null) {
			if (other.claveAcceso != null)
				return false;
		} else if (!claveAcceso.equals(other.claveAcceso))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (localizacion == null) {
			if (other.localizacion != null)
				return false;
		} else if (!localizacion.equals(other.localizacion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	

}
