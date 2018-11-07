package edu.usal.negocio.dominio;

import java.util.Date;

public class Venta {
	
	private int id_venta;
	private Cliente cliente;
	private Vuelo vuelo;
	private LineaAerea lineaAerea;
	private Date fechaHoraVenta;
	private String formaPago;
	private int cuotas;
	private Double totalPagar;
	private int cant_vuelos;
	
	public Venta(){

	}

	public Venta(int id_venta, Cliente cliente, Vuelo vuelo, LineaAerea lineaAerea, Date fechaHoraVenta,
			String formaPago, int cuotas, Double totalPagar, int cant_vuelos) {
		super();
		this.id_venta = id_venta;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.lineaAerea = lineaAerea;
		this.fechaHoraVenta = fechaHoraVenta;
		this.formaPago = formaPago;
		this.cuotas = cuotas;
		this.totalPagar = totalPagar;
		this.cant_vuelos = cant_vuelos;
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public LineaAerea getLineaAerea() {
		return lineaAerea;
	}

	public void setLineaAerea(LineaAerea lineaAerea) {
		this.lineaAerea = lineaAerea;
	}

	public Date getFechaHoraVenta() {
		return fechaHoraVenta;
	}

	public void setFechaHoraVenta(Date fechaHoraVenta) {
		this.fechaHoraVenta = fechaHoraVenta;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public int getCant_vuelos() {
		return cant_vuelos;
	}

	public void setCant_vuelos(int cant_vuelos) {
		this.cant_vuelos = cant_vuelos;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	@Override
	public String toString() {
		return "Venta [id_venta=" + id_venta + ", cliente=" + cliente.getDNI() + ", vuelo=" + vuelo.getId_vuelo() + ", lineaAerea="
				+ lineaAerea.getNombre() + ", fechaHoraVenta=" + fechaHoraVenta + ", formaPago=" + formaPago + ", cuotas=" + cuotas
				+ ", totalPagar=" + totalPagar + ", cant_vuelos=" + cant_vuelos + "]";
	}
	
	
}
