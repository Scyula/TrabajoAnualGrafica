package edu.usal.negocio.dominio;

import java.io.Serializable;

public class Aeropuerto implements Serializable {
	
	private static final long serialVersionUID = 333L;
	private String idAeropuerto;
	private String ciudad;
	private Provincia provincia;
	private Pais pais;
	
	public String getIdAeropuerto() {
		return idAeropuerto;
	}
	public void setIdAeropuerto(String idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Aeropuerto(String idAeropuerto, String ciudad, Provincia provincia, Pais pais) {
		super();
		this.idAeropuerto = idAeropuerto;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}
	public Aeropuerto() {
	}
		
}