package edu.usal.negocio.dominio;

import java.io.Serializable;

public class Aeropuerto implements Serializable {
	
	private static final long serialVersionUID = 333L;
	private String idAeropuerto;
	private String ciudad;
	private int provincia;
	private int pais;
	
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
	public int getProvincia() {
		return provincia;
	}
	public void setProvincia(int provincia) {
		this.provincia = provincia;
	}
	public int getPais() {
		return pais;
	}
	public void setPais(int pais) {
		this.pais = pais;
	}
	public Aeropuerto(String idAeropuerto, String ciudad, int provincia, int pais) {
		super();
		this.idAeropuerto = idAeropuerto;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}
	public Aeropuerto() {
	}
		
}