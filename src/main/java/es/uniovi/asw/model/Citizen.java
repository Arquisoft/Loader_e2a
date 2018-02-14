package es.uniovi.asw.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "TAGENTS")
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	public void setID(Long iD) {
		ID = iD;
	}
	

	public void setTipo(int tipo) {
		this.tipo = tipo;
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
	

}
