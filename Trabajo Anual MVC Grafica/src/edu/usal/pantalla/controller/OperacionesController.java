package edu.usal.pantalla.controller;

import java.sql.SQLException;

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
import edu.usal.pantalla.controller.mostrar.Cliente_Mostrar_Controller;
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

	
	public void ordenar(Cliente_Mostrar_Controller cliente_Buscar_Controller) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
