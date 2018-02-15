package es.uniovi.asw.model;

import javax.persistence.*;

@Entity
@Table(name = "TAGENT")
public class Agent {

	@Id
	@Column(unique = true)
	private String ID;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "LOCALIZACION")
	private String localizacion;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "TIPO")
	private int tipo;
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	public void setID(String id)
	{
		this.ID = id;
	}


	// Constructor vacio para JPA
	public Agent() {
	}

	
	
	public Agent(String iD, String nombre, String localizacion, String email, int tipo) {
		super();
		this.ID = iD;
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



	public String getID() {
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
		Agent other = (Agent) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	
	
	

}
