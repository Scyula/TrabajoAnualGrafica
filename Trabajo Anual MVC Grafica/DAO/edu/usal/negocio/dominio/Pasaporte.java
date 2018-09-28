package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pasaporte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 754L;
	private String nroPasaporte;
	private int pais;
	private String autoridademision;
	private Calendar emision;
	private Calendar vencimiento;
	
	public Pasaporte(){
		Calendar emision= new GregorianCalendar();
		Calendar vencimiento= new GregorianCalendar();
	}
		
	public Pasaporte(String nroPasaporte, int pais, String autoridademision, Calendar emision, Calendar vencimiento) {
		super();
		this.nroPasaporte = nroPasaporte;
		this.pais = pais;
		this.autoridademision = autoridademision;
		this.emision = emision;
		this.vencimiento = vencimiento;
	}

	public String getNroPasaporte() {
		return nroPasaporte;
	}
	public void setNroPasaporte(String nroPasaporte) {
		this.nroPasaporte = nroPasaporte;
	}
	public int getPais() {
		return pais;
	}
	public void setPais(int pais) {
		this.pais = pais;
	}
	public String getAutoridademision() {
		return autoridademision;
	}
	public void setAutoridademision(String autoridademision) {
		this.autoridademision = autoridademision;
	}
	public Calendar getEmision() {
		return emision;
	}
	public void setEmision(Calendar emision) {
		this.emision = emision;
	}
	public Calendar getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(Calendar vencimiento) {
		this.vencimiento = vencimiento;
	}
	
}
