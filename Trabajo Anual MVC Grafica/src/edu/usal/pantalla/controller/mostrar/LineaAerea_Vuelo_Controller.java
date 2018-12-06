package edu.usal.pantalla.controller.mostrar;

import java.sql.SQLException;

import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.MenuPrincipalControllerTabla;
import edu.usal.pantalla.vista.mostrar.LineaAerea_Vuelo_Vista;
import edu.usal.util.ActualizarDatos;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneralDAO;

public class LineaAerea_Vuelo_Controller {
		
	private LineaAerea_Vuelo_Vista vista;
	private MenuPrincipalControllerTabla mPController;
	private LineaAerea linea;
	private ActualizarDatos datos;
	
	public LineaAerea_Vuelo_Controller(MenuPrincipalControllerTabla menu, LineaAerea linea) {
		this.linea = linea;
		this.mPController= menu;
		this.vista = new LineaAerea_Vuelo_Vista(this, linea);
		this.datos= new ActualizarDatos();
		this.CargarVuelos();
	}
	

	public MenuPrincipalControllerTabla getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalControllerTabla mPController) {
		this.mPController = mPController;
	}
	
	public void finalizarVentana() {
		vista.dispose();
	}

	public void CargarVuelos() {
		this.vista.getTable().setModel(datos.vuelosAero(this.linea));
		this.actualizar();
	}

	public void VerClientes() {
		Vuelo vuelo = buscarVuelo();
		vista.setVisible(false);
		new Vuelo_Cliente_Controller(this, vuelo);
	}
	
	private Vuelo buscarVuelo() {
		try {
			VueloDAO linea = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
			return linea.readVuelo((String) this.vista.getTable().getModel().getValueAt(this.vista.getTable().getSelectedRow(), 0));	
			} catch (SQLException e) {
				IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			} catch(ArrayIndexOutOfBoundsException e) {
				IOGeneralDAO.pritln(">>>>>Error debe seleccionar un elemento<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			}
			return null;
	}

	public void Volver() {
		this.vista.dispose();
		this.mPController.hacerVisibleMP();
	}
	

	private void actualizar() {
		this.vista.revalidate();
		this.vista.repaint();
	}


	public void hacerVisible() {
		this.vista.setVisible(true);
	}
	
}
