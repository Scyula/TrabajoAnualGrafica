package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Vuelo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 196L;
	private String id_vuelo;
	private LineaAerea aerolinea;
	private Integer cantAsientos;
	private Integer asientosDisponibles;
	private Aeropuerto aeroSalida;
	private Aeropuerto aeroLlegada;
	private Date fechaHoraSalida;
	private Date fechaHoraLlegada;
	private String tiempoVuelo;
	private List<Cliente> clientes;
	
	public Vuelo(){
		
	}
	
	
	public Vuelo(String id_vuelo, LineaAerea aerolinea, Integer cantAsientos, Integer asientosDisponibles,
			 Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada, Date fechaHoraSalida, Date fechaHoraLlegada,
			String tiempoVuelo, List<Cliente> clientes) {
		super();
		this.id_vuelo = id_vuelo;
		this.aerolinea = aerolinea;
		this.cantAsientos = cantAsientos;
		this.asientosDisponibles = asientosDisponibles;
		this.aeroSalida = aeropuertoSalida;
		this.aeroLlegada = aeropuertoLlegada;
		this.fechaHoraSalida = fechaHoraSalida;
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.tiempoVuelo = tiempoVuelo;
		this.clientes=clientes;
	}


	public String getId_vuelo() {
		return id_vuelo;
	}


	public void setId_vuelo(String id_vuelo) {
		this.id_vuelo = id_vuelo;
	}


	public LineaAerea getAerolinea() {
		return aerolinea;
	}


	public void setAerolinea(LineaAerea aerolinea) {
		this.aerolinea = aerolinea;
	}


	public Integer getCantAsientos() {
		return cantAsientos;
	}


	public void setCantAsientos(Integer cantAsientos) {
		this.cantAsientos = cantAsientos;
	}


	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}


	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}


	public Aeropuerto getAeroSalida() {
		return aeroSalida;
	}


	public void setAeroSalida(Aeropuerto aeroSalida) {
		this.aeroSalida = aeroSalida;
	}


	public Aeropuerto getAeroLlegada() {
		return aeroLlegada;
	}


	public void setAeroLlegada(Aeropuerto aeroLlegada) {
		this.aeroLlegada = aeroLlegada;
	}


	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}


	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}


	public Date getFechaHoraLlegada() {
		return fechaHoraLlegada;
	}


	public void setFechaHoraLlegada(Date fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}


	public String getTiempoVuelo() {
		return tiempoVuelo;
	}


	public void setTiempoVuelo(String tiempoVuelo) {
		this.tiempoVuelo = tiempoVuelo;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	@Override
	public String toString() {
		return "ID_vuelo=" + id_vuelo + "     Aerolinea=" + aerolinea.getNombre() + "     Cantidad de asientos=" + cantAsientos
				+ "     Asientos disponibles=" + asientosDisponibles + "     Aeropuerto de salida=" + aeroSalida.getCiudad() + "     Aeropuerto de llegada="
				+ aeroLlegada.getCiudad() + "     Fecha y hora de salida=" + fechaHoraSalida + "     Fecha y hora de llegada=" + fechaHoraLlegada
				+ "     Tiempo de vuelo=" + tiempoVuelo;
	}
	
	
	
}
