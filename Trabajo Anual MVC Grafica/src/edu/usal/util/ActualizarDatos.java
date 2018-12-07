package edu.usal.util;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataListener;
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
	    columnNames.addElement("Pais");
	    columnNames.addElement("Fecha de Nacimiento");
	    columnNames.addElement("E-mail");
	    
		ClienteDAO clientes = ClienteFactory.getClienteDAO("SQL");
		List<Cliente> lista = clientes.getAllCliente();
		
		Vector<Vector> rowData = new Vector<Vector>();
		if(!lista.isEmpty()) {	
			for (Cliente cliente : lista) {
				Vector<Object> aux = new Vector<Object>();
			    aux.addElement(cliente.getNombre());
			    aux.addElement(cliente.getApellido());
			    aux.addElement((cliente.getDNI()));
			    aux.addElement(cliente.getDireccion().getPais().getNombre());
			    aux.addElement((cliente.getFechaNac()));
			    aux.addElement(cliente.getEmail());
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames){
			@Override
			public Class getColumnClass(int column)
			{
			    if (column == 2)
			        {	return Integer.class;}
			    else if( column == 3)
			    	{	return Date.class;}
			    else 
			    	{	return String.class;}
			}
		};
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
				Vector<Object> aux = new Vector<Object>();
			    aux.addElement(linea.getId());
			    aux.addElement(linea.getNombre());
			    aux.addElement(obtenerAlianza(linea.getAlianza()));
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames) {
			@Override
			public Class getColumnClass(int column)
			{
			    if (column == 0)
			        return Integer.class;
			    else
			        return String.class;
			}
		};
		
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
				Vector<Object> aux = new Vector<Object>();
			    aux.addElement(vue.getId_vuelo());
			    aux.addElement(vue.getAerolinea().getNombre());
			    aux.addElement(vue.getAeroSalida().getCiudad());
			    aux.addElement((vue.getFechaHoraSalida()));
			    aux.addElement(vue.getAeroLlegada().getCiudad());
			    aux.addElement((vue.getFechaHoraLlegada()));
			    aux.addElement((vue.getCantAsientos()));
			    aux.addElement((vue.getAsientosDisponibles()));
			    aux.addElement(vue.getTiempoVuelo());
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames){
			@Override
			public Class getColumnClass(int column)
			{
			    if (column == 6 || column == 7)
			        {	return Integer.class;}
			    else if( column == 3 || column == 5)
			    	{	return Date.class;}
			    else
			    	{	return String.class;}
			}
		};
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
				Vector<Object> aux = new Vector<Object>();
			    aux.addElement((vent.getId_venta()));
			    aux.addElement(vent.getVuelo().getId_vuelo());
			    aux.addElement(vent.getLineaAerea().getNombre());
			    aux.addElement((vent.getCliente().getDNI()));
			    aux.addElement((vent.getTotalPagar()));
			    aux.addElement((vent.getFechaHoraVenta()));
			    aux.addElement((vent.getFormaPago()));
			    aux.addElement((vent.getCuotas()));
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames){
			@Override
			public Class getColumnClass(int column)
			{
			    if (column == 3 || column == 7 || column == 0)
			        {	return Integer.class;}
			    else if( column == 5)
			    	{	return Date.class;}
			    else if(column == 4)
			    	{ return Double.class;}
			    else
			    	{	return String.class;}
			}
		};
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
				Vector<Object> aux = new Vector<Object>();
			    aux.addElement(vue.getId_vuelo());
			    aux.addElement(vue.getAerolinea().getNombre());
			    aux.addElement(vue.getAeroSalida().getCiudad());
			    aux.addElement((vue.getFechaHoraSalida()));
			    aux.addElement(vue.getAeroLlegada().getCiudad());
			    aux.addElement((vue.getFechaHoraLlegada()));
			    aux.addElement((vue.getCantAsientos()));
			    aux.addElement((vue.getAsientosDisponibles()));
			    aux.addElement(vue.getTiempoVuelo());
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames){
			@Override
			public Class getColumnClass(int column)
			{
			    if (column == 6 || column == 7)
			        {	return Integer.class;}
			    else if( column == 3 || column == 5)
			    	{	return Date.class;}
			    else
			    	{	return String.class;}
			}
		};
		return tabla1;
	}
	
	public TableModel clientesVuelo(Vuelo vuelo){
		Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("Nombre");
	    columnNames.addElement("Apellido");
	    columnNames.addElement("DNI");
	    columnNames.addElement("Pais");
	    columnNames.addElement("Fecha");
	    columnNames.addElement("E-mail");
	    
		List<Cliente> lista = vuelo.getClientes();
		
		Vector<Vector> rowData = new Vector<Vector>();
		if(!lista.isEmpty()) {	
			for (Cliente cliente : lista) {
				Vector<Object> aux = new Vector<Object>();
			    aux.addElement(cliente.getNombre());
			    aux.addElement(cliente.getApellido());
			    aux.addElement((cliente.getDNI()));
			    aux.addElement(cliente.getDireccion().getPais().getNombre());
			    aux.addElement((cliente.getFechaNac()));
			    aux.addElement(cliente.getEmail());
			    rowData.add(aux);
			}
		}
		TableModel tabla1 = new DefaultTableModel(rowData,columnNames){
			@Override
			public Class getColumnClass(int column)
			{
			    if (column == 2)
			        {	return Integer.class;}
			    else if( column == 3)
			    	{	return Date.class;}
			    else 
			    	{	return String.class;}
			}
		};
		return tabla1;
	}

	public ComboBoxModel<String> cargarCombo(String string) {
		ComboBoxModel<String> model = new DefaultComboBoxModel<String>(new String[] {"Error"});
		switch (string) {
		case "Vuelo": model = new DefaultComboBoxModel<String>(new String[] {"Seleccione un Item","ID de Vuelo","Despues de (Fecha)","Aeropuerto Salida","Aeropuerto Llegada","Aerolinea","Disponibilidad"});
		break;
		case "Venta": model = new DefaultComboBoxModel<String>(new String[] {"Seleccione un Item","ID de Venta","Vuelo por ID","por Aerolinea","DNI Cliente"
				,"Valor mayor que","Valor menor que","Forma de pago","Cantidad cuotas"});
		break;
		case "Cliente": model = new DefaultComboBoxModel<String>(new String[] {"Seleccione un Item","DNI","Nombre","Apellido","Pais","E-mail"});
		break;
		case "Aerolinea": model = new DefaultComboBoxModel<String>(new String[] {"Seleccione un Item","ID","Nombre Aerolinea","Alianza"});
		break;
		default:
			break;
		}
		return model;
		
	}
	
}
