package edu.usal.pantalla.controller;

import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
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
import edu.usal.util.DatosEstaticos;

public class OperacionesController {

	public void eliminar(MenuPrincipalControllerTabla control, LineaAerea select) {
		try {
			LineaAereaDAO linea = LineaAereaFactory.getLineaAereaDAO(DatosEstaticos.getSource());
			if(linea.deleteLineaAerea(select)) {
				control.getMenuPrincipal().exitoOperacion();
				control.seleccionAerolinea();
			}else {
				control.getMenuPrincipal().fracasoOperacion("No se pudo eliminar la aerolinea");				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void eliminar(MenuPrincipalControllerTabla control, Cliente select) {
		try {
			ClienteDAO linea = ClienteFactory.getClienteDAO(DatosEstaticos.getSource());
			if(linea.deleteCliente(select)) {
				control.getMenuPrincipal().exitoOperacion();
				control.seleccionClientes();
			}else {
				control.getMenuPrincipal().fracasoOperacion("No se pudo eliminar el cliente");				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminar(MenuPrincipalControllerTabla control, Vuelo select) {
		try {
			VueloDAO linea = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
			if(linea.deleteVuelo(select)) {
				control.getMenuPrincipal().exitoOperacion();
				control.seleccionVuelos();
			}else {
				control.getMenuPrincipal().fracasoOperacion("No se pudo eliminar el vuelo");				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminar(MenuPrincipalControllerTabla control, Venta select) {
		try {
			VentaDAO linea = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
			if(linea.deleteVentas(select)) {
				control.getMenuPrincipal().exitoOperacion();
				control.seleccionVenta();
			}else {
				control.getMenuPrincipal().fracasoOperacion("No se pudo eliminar el vuelo");				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
	public void ordenar(MenuPrincipalControllerTabla controller) {
		switch((String)controller.getMenuPrincipal().getComboBox_Busqueda().getSelectedItem()) {
			//Vuelo
		case "ID de Vuelo": controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 0));
		break;
		case "Despues de (Fecha)":controller.getModeloOrdenado().setRowFilter(RowFilter.dateFilter(ComparisonType.AFTER,controller.getMenuPrincipal().getFecha().getDate(), 3));
		break;
		case "Aeropuerto Salida": controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 2));
		break;
		case "Aeropuerto Llegada":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 4));
		break;
		case "Aerolinea":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 1));
		break;
		case "Disponibilidad":try {
			LinkedList<RowFilter<TableModel, Integer>> lista = new LinkedList<RowFilter<TableModel, Integer>>();
			lista.add(RowFilter.numberFilter(ComparisonType.AFTER,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 7));
			lista.add(RowFilter.numberFilter(ComparisonType.EQUAL,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 7));
			controller.getModeloOrdenado().setRowFilter(RowFilter.orFilter(lista));}
		catch(NumberFormatException e) {
			
		}
		break;

			//Venta
		case "ID de Venta":try {
			controller.getModeloOrdenado().setRowFilter(RowFilter.numberFilter(ComparisonType.EQUAL,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 0));}
		catch(NumberFormatException e) {}
		break;
		case "Vuelo por ID":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 1));
		break;
		case "por Aerolinea":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 2));
		break;
		case "DNI Cliente":try {
			controller.getModeloOrdenado().setRowFilter(RowFilter.numberFilter(ComparisonType.EQUAL,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 3));}
		catch(NumberFormatException e) {}
		break;
		case "Valor mayor que":try {
			LinkedList<RowFilter<TableModel, Integer>> lista = new LinkedList<RowFilter<TableModel, Integer>>();
			lista.add(RowFilter.numberFilter(ComparisonType.AFTER,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 4));
			lista.add(RowFilter.numberFilter(ComparisonType.EQUAL,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 4));
			controller.getModeloOrdenado().setRowFilter(RowFilter.orFilter(lista));}
		catch(NumberFormatException e) {}
		break;
		case "Valor menor que":try {
			LinkedList<RowFilter<TableModel, Integer>> lista = new LinkedList<RowFilter<TableModel, Integer>>();
			lista.add(RowFilter.numberFilter(ComparisonType.BEFORE,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 4));
			lista.add(RowFilter.numberFilter(ComparisonType.EQUAL,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 4));
			controller.getModeloOrdenado().setRowFilter(RowFilter.orFilter(lista));}
		catch(NumberFormatException e) {}
		break;
		case "Forma de pago":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 6));
		break;
		case "Cantidad cuotas":try {
			controller.getModeloOrdenado().setRowFilter(RowFilter.numberFilter(ComparisonType.EQUAL,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 7));}
		catch(NumberFormatException e) {}
		break;

			//Cliente
		case"DNI":try {
			controller.getModeloOrdenado().setRowFilter(RowFilter.numberFilter(ComparisonType.EQUAL,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 2));}
		catch(NumberFormatException e) {}
		break;
		case "Nombre":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 0));
		break;
		case "Apellido":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(),1));
		break;
		case "Pais":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 3));
		break;
		case "E-mail":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 5));
		break;

			//Aerolinea
		case "ID":try {
			controller.getModeloOrdenado().setRowFilter(RowFilter.numberFilter(ComparisonType.EQUAL,Integer.valueOf(controller.getMenuPrincipal().getTextBuscar().getText()), 0));}
		catch(NumberFormatException e) {}
		break;
		case "Nombre Aerolinea":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 1));
		break;
		case "Alianza":controller.getModeloOrdenado().setRowFilter(RowFilter.regexFilter("(?i)" + controller.getMenuPrincipal().getTextBuscar().getText(), 2));
		break;

			default:
		}
		
	}
	
	
	
	
}
