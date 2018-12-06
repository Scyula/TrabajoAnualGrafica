package edu.usal.util;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.factory.LineaAereaFactory;
import edu.usal.negocio.dao.factory.VentaFactory;
import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Venta;
import edu.usal.negocio.dominio.Vuelo;

public class ActualizarDatos {
	
	public TableModel clientes() throws SQLException {
		Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("Nombre");
	    columnNames.addElement("Apellido");
	    columnNames.addElement("DNI");
	    columnNames.addElement("Fecha");
	    columnNames.addElement("E-mail");
	    
		ClienteDAO clientes = ClienteFactory.getClienteDAO("SQL");
		List<Cliente> lista = clientes.getAllCliente();
		
		Vector<Vector> rowData = new Vector<Vector>();
		if(!lista.isEmpty()) {	
			for (Cliente cliente : lista) {
				Vector<String> aux = new Vector<String>();
			    aux.addElement(cliente.getNombre());
			    aux.addElement(cliente.getApellido());
			    aux.addElement(String.valueOf(cliente.getDNI()));
			    aux.addElement(obtenerFecha(cliente.getFechaNac()));
			    aux.addElement(cliente.getEmail());
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames);
		return tabla1;
	}

	@SuppressWarnings("deprecation")
	private String obtenerFecha(Date fechaNac) {
		return fechaNac.getDate()+"-"+(fechaNac.getMonth()+1)+"-"+(fechaNac.getYear()+1900);
	}

	public TableModel aerolineas() throws SQLException {
		Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("ID");
	    columnNames.addElement("Nombre");
	    columnNames.addElement("Alianza");
	    
	    LineaAereaDAO aero = LineaAereaFactory.getLineaAereaDAO("SQL");
	    List<LineaAerea> lista = aero.getAllLineaAerea();
	     
	    Vector<Vector> rowData = new Vector<Vector>();
		if(!lista.isEmpty()) {	
			for (LineaAerea linea : lista) {
				Vector<String> aux = new Vector<String>();
			    aux.addElement(String.valueOf(linea.getId()));
			    aux.addElement(linea.getNombre());
			    aux.addElement(obtenerAlianza(linea.getAlianza()));
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames);
		return tabla1;
	}

	private String obtenerAlianza(int ali) {
		if(ali==1) {
			return "Skyteam";
		}else if(ali==2) {
			return "One World";
		}else if(ali==3) {
			return "Star Alliance";
		}else {return "";}
	}

	public TableModel vuelos() throws SQLException {
		Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("ID");
	    columnNames.addElement("Aerolinea");
	    columnNames.addElement("Aero Salida");
	    columnNames.addElement("Fecha y Hora Salida");
	    columnNames.addElement("Aero Llegada");
	    columnNames.addElement("Fecha y Hora Llegada");
	    columnNames.addElement("Asientos");
	    columnNames.addElement("Disponibles");
	    columnNames.addElement("Tiempo Vuelo");
	    
	    
	    VueloDAO vuelo = VueloFactory.getVueloDAO("SQL");
	    List<Vuelo> lista = vuelo.getAllVuelo();
	     
	    Vector<Vector> rowData = new Vector<Vector>();
		if(!lista.isEmpty()) {	
			for (Vuelo vue : lista) {
				Vector<String> aux = new Vector<String>();
			    aux.addElement(vue.getId_vuelo());
			    aux.addElement(vue.getAerolinea().getNombre());
			    aux.addElement(vue.getAeroSalida().getCiudad());
			    aux.addElement(obtenerFechaHora(vue.getFechaHoraSalida()));
			    aux.addElement(vue.getAeroLlegada().getCiudad());
			    aux.addElement(obtenerFechaHora(vue.getFechaHoraLlegada()));
			    aux.addElement(String.valueOf(vue.getCantAsientos()));
			    aux.addElement(String.valueOf(vue.getCantAsientos()));
			    aux.addElement(vue.getTiempoVuelo());
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames);
		return tabla1;
	}

	private String obtenerFechaHora(Date fechaNac) {
		return fechaNac.getDate()+"-"+(fechaNac.getMonth()+1)+"-"+(fechaNac.getYear()+1900)+" "+fechaNac.getHours()+":"+fechaNac.getMinutes();
	}

	public TableModel ventas() throws SQLException {
		Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("ID");
	    columnNames.addElement("Vuelo");
	    columnNames.addElement("LineaAerea");
	    columnNames.addElement("ID Cliente");
	    columnNames.addElement("Total a pagar");
	    columnNames.addElement("Fecha y Hora");
	    columnNames.addElement("Forma de Pago");
	    columnNames.addElement("Cuotas");
	    
	    
	    VentaDAO venta = VentaFactory.getVentaDAO("SQL");
	    List<Venta> lista = venta.getAllVenta();
	     
	    Vector<Vector> rowData = new Vector<Vector>();
		if(!lista.isEmpty()) {	
			for (Venta vent : lista) {
				Vector<String> aux = new Vector<String>();
			    aux.addElement(String.valueOf(vent.getId_venta()));
			    aux.addElement(vent.getVuelo().getId_vuelo());
			    aux.addElement(vent.getLineaAerea().getNombre());
			    aux.addElement(String.valueOf(vent.getCliente().getDNI()));
			    aux.addElement(String.valueOf(vent.getTotalPagar()));
			    aux.addElement(obtenerFechaHora(vent.getFechaHoraVenta()));
			    aux.addElement(String.valueOf(vent.getFormaPago()));
			    aux.addElement(String.valueOf(vent.getCuotas()));
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames);
		return tabla1;
	}
	
	public TableModel vuelosAero(LineaAerea linea) {
		Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("ID");
	    columnNames.addElement("Aerolinea");
	    columnNames.addElement("Aero Salida");
	    columnNames.addElement("Fecha y Hora Salida");
	    columnNames.addElement("Aero Llegada");
	    columnNames.addElement("Fecha y Hora Llegada");
	    columnNames.addElement("Asientos");
	    columnNames.addElement("Disponibles");
	    columnNames.addElement("Tiempo Vuelo");
	    
	    List<Vuelo> lista = linea.getVuelos();
	     
	    Vector<Vector> rowData = new Vector<Vector>();
		if(!lista.isEmpty()) {	
			for (Vuelo vue : lista) {
				Vector<String> aux = new Vector<String>();
			    aux.addElement(vue.getId_vuelo());
			    aux.addElement(vue.getAerolinea().getNombre());
			    aux.addElement(vue.getAeroSalida().getCiudad());
			    aux.addElement(obtenerFechaHora(vue.getFechaHoraSalida()));
			    aux.addElement(vue.getAeroLlegada().getCiudad());
			    aux.addElement(obtenerFechaHora(vue.getFechaHoraLlegada()));
			    aux.addElement(String.valueOf(vue.getCantAsientos()));
			    aux.addElement(String.valueOf(vue.getCantAsientos()));
			    aux.addElement(vue.getTiempoVuelo());
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames);
		return tabla1;
	}
	
	public TableModel clientesVuelo(Vuelo vuelo){
		Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("Nombre");
	    columnNames.addElement("Apellido");
	    columnNames.addElement("DNI");
	    columnNames.addElement("Fecha");
	    columnNames.addElement("E-mail");
	    
		List<Cliente> lista = vuelo.getClientes();
		
		Vector<Vector> rowData = new Vector<Vector>();
		if(!lista.isEmpty()) {	
			for (Cliente cliente : lista) {
				Vector<String> aux = new Vector<String>();
			    aux.addElement(cliente.getNombre());
			    aux.addElement(cliente.getApellido());
			    aux.addElement(String.valueOf(cliente.getDNI()));
			    aux.addElement(obtenerFecha(cliente.getFechaNac()));
			    aux.addElement(cliente.getEmail());
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames);
		return tabla1;
	}
	
}
