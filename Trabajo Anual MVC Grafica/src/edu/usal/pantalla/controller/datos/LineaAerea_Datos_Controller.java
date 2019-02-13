package edu.usal.pantalla.controller.datos;

import java.sql.SQLException;

import edu.usal.negocio.dao.factory.LineaAereaFactory;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.pantalla.controller.MenuPrincipalControllerTabla;
import edu.usal.pantalla.vista.datos.LineaAerea_Datos_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneralDAO;

public class LineaAerea_Datos_Controller {
	
	LineaAerea_Datos_Vista menu;
	MenuPrincipalControllerTabla mPController;
	private LineaAereaDAO aerolineadao;
	

	public LineaAerea_Datos_Controller(MenuPrincipalControllerTabla menuPrincipalController) {
		this.mPController= menuPrincipalController;
		menu = new LineaAerea_Datos_Vista(this);
	}
	
	public LineaAerea_Datos_Controller(MenuPrincipalControllerTabla menuPrincipalController, LineaAerea aerolinea) {
		this.mPController= menuPrincipalController;
		menu = new LineaAerea_Datos_Vista(this , aerolinea);
		
	}

	public void guardarDatos() {
		if(validarDatos()) {
			try {
				aerolineadao = LineaAereaFactory.getLineaAereaDAO(DatosEstaticos.getSource());
				if(aerolineadao.addLineaAerea(new LineaAerea(0, menu.getTextNombre().getText(), menu.getComboBoxAlianza().getSelectedIndex(),	 null))) {
					menu.exitoOperacion();
					DatosEstaticos.actualizarAerolineas();
					mPController.seleccionAerolinea();
				}else {
					menu.fracasoOperacion();
				}
			} catch (SQLException e) {
				IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			}
			menu.dispose();
			mPController.seleccionAerolinea();
			mPController.hacerVisibleMP();
		}
	}

	private boolean validarDatos() {
		char[] aux = this.menu.getTextNombre().getText().toCharArray();
		boolean aprobado = false;
		for (int i = 0; i < aux.length; i++) {
			if(Character.isAlphabetic(aux[i])) {
				aprobado = true;
			}
		}
		if(!aprobado) {
			this.menu.errorOperacion("\nNombre ingresado no valido");
		}
		return aprobado;
	}

	public void updateDatos() {
		if(validarDatos()) {
			try {
				aerolineadao = LineaAereaFactory.getLineaAereaDAO(DatosEstaticos.getSource());
				if(aerolineadao.updateLineaAerea(new LineaAerea(Integer.parseInt(menu.getLblID_Asignado().getText()), menu.getTextNombre().getText(), menu.getComboBoxAlianza().getSelectedIndex(), null))) {
						menu.exitoOperacion();
						DatosEstaticos.actualizarAerolineas();
						mPController.seleccionAerolinea();
				}else {
					menu.fracasoOperacion();
				}
			}catch (SQLException e) {
				IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			}
			menu.dispose();
			mPController.seleccionAerolinea();
			mPController.hacerVisibleMP();
		}
	}		
	public void cerrarVentana() {
		menu.dispose();
	}

	public MenuPrincipalControllerTabla getmPController() {
		return mPController;
	}
	
}
