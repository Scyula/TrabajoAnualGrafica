package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Venta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 837L;
	private int id_venta;
	private String cliente;
	private Vuelo vuelo;
	private String lineaAerea;
	private Calendar fechaHoraVenta;
	private String formaPago;
	private String totalPagar;
	private int cant_vuelos;
	
	public Venta(){
		Cliente cliente = new Cliente();
		Vuelo vuelo = new Vuelo();
		Calendar fechaHoraVenta = new GregorianCalendar();
	}
		
	
	public Venta(int id_venta, String cliente, Vuelo vuelo, String lineaAerea, Calendar fechaHoraVenta,
			String formaPago, String totalPagar, int cant_vuelos) {
		super();
		this.id_venta = id_venta;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.lineaAerea = lineaAerea;
		this.fechaHoraVenta = fechaHoraVenta;
		this.formaPago = formaPago;
		this.totalPagar = totalPagar;
		this.cant_vuelos = cant_vuelos;
	}


	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public String getLineaAerea() {
		return lineaAerea;
	}
	public void setLineaAerea(String lineaAerea) {
		this.lineaAerea = lineaAerea;
	}
	public Calendar getFechaHoraVenta() {
		return fechaHoraVenta;
	}
	public void setFechaHoraVenta(Calendar fechaHoraVenta) {
		this.fechaHoraVenta = fechaHoraVenta;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(String totalPagar) {
		this.totalPagar = totalPagar;
	}

	public int getCant_vuelos() {
		return cant_vuelos;
	}

	public void setCant_vuelos(int cant_vuelos) {
		this.cant_vuelos = cant_vuelos;
	}
	
}
