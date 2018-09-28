package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class LineaAerea implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 664L;
	private String nombre;
	private int alianza;
	private ArrayList<String> vuelos;
	
	public LineaAerea(){
		ArrayList<String> vuelos = new ArrayList<String>();
	}
	
	
	public LineaAerea(String nombre, int alianza, ArrayList<String> vuelos) {
		super();
		this.nombre = nombre;
		this.alianza = alianza;
		this.vuelos = vuelos;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAlianza() {
		return alianza;
	}
	public void setAlianza(int alianza) {
		this.alianza = alianza;
	}
	public ArrayList<String> getVuelos() {
		return vuelos;
	}
	public void setVuelos(ArrayList<String> vuelos) {
		this.vuelos = vuelos;
	}
}
