package edu.usal.pantalla.controller;

import java.sql.SQLException;

import edu.usal.negocio.dao.implementacion.SQL.LineaAereaDAOImplSQL;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.pantalla.vista.Cliente_Datos_Vista;
import edu.usal.pantalla.vista.LineaAerea_Datos_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneral;

public class LineaAerea_Datos_Controller {
	
	LineaAerea_Datos_Vista menu;
	MenuPrincipalController mPController;
	private LineaAereaDAO aerolineadao;
	

	public LineaAerea_Datos_Controller(MenuPrincipalController menuPrincipalController) {
		this.mPController= menuPrincipalController;
		menu = new LineaAerea_Datos_Vista(this);
	}
	
	public LineaAerea_Datos_Controller(MenuPrincipalController menuPrincipalController, LineaAerea aerolinea) {
		this.mPController= menuPrincipalController;
		menu = new LineaAerea_Datos_Vista(this , aerolinea);
		
	}

	public void guardarDatos() {
		try {
			aerolineadao = new LineaAereaDAOImplSQL();	
			if(aerolineadao.addLineaAerea(new LineaAerea(0, menu.getTextNombre().getText(), menu.getComboBoxAlianza().getSelectedIndex(),	 null))) {
				menu.exitoOperacion();
				DatosEstaticos.actualizarAerolineas();
			}else {
				menu.fracasoOperacion();
			}
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		menu.dispose();
		mPController.hacerVisibleMP();
	}

	public void updateDatos() {
		try {
			aerolineadao = new LineaAereaDAOImplSQL();	
			if(aerolineadao.updateLineaAerea(new LineaAerea(Integer.parseInt(menu.getLblID_Asignado().getText()), menu.getTextNombre().getText(), menu.getComboBoxAlianza().getSelectedIndex(), null))) {
					menu.exitoOperacion();
					DatosEstaticos.actualizarAerolineas();
			}else {
				menu.fracasoOperacion();
			}
		}catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		menu.dispose();
		mPController.hacerVisibleMP();
	}
	public void cerrarVentana() {
		menu.dispose();
	}

	public MenuPrincipalController getmPController() {
		return mPController;
	}
	
}
