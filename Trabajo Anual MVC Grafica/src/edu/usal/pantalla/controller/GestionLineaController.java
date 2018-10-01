package edu.usal.pantalla.controller;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JComboBox;

import edu.usal.negocio.dao.factory.LineaAereaFactory;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.pantalla.vista.GestionLineaVista;
import edu.usal.pantalla.vista.frames.FrameNuevaLinea;
import edu.usal.principal.Ejecutar;
import edu.usal.util.IOGeneral;

public class GestionLineaController {
	GestionLineaVista menu;
	MenuPrincipalController mPController;
	private LineaAereaDAO lineaaereadao;
	private List<LineaAerea> lineas;
	
	
	public GestionLineaController(MenuPrincipalController menuPrincipalController) {
		this.mPController= menuPrincipalController;
		this.menu = new GestionLineaVista(this);
	}

	public void EjecutarOpcionSeleccionada(int opc) {
		if(opc==1) {//Nuevo cliente
			menu.getLblCartelSelec().setVisible(false);
			menu.getNuevaLinea().setVisible(true);
			
		}else if (opc==2) {//Modificar Linea
			modificarLinea();
		}else if (opc==3) {//Eliminar Linea
			
		}else if (opc==4) {//Ver Linea
			
		}else if (opc==5) {//Volver al Menu Principal
			menu.dispose();
			mPController.hacerVisibleMP();
			
		}
	}
	
	public void almacenarDatos(FrameNuevaLinea datos) {
		//System.out.println("Datos recibidos");
		lineaaereadao = LineaAereaFactory.getLineaAereaDAO(Ejecutar.source);
		LineaAerea linea = new LineaAerea();
		linea.setNombre(datos.getTextNombre().getText());
		linea.setAlianza(Integer.parseInt(datos.getTextAlianza().getText()));

		LineaAerea asd = new LineaAerea();
		asd.setAlianza(123);
		try {
			if(lineaaereadao.addLineaAerea(linea)) {
				menu.exitoOperacion();
			}else {
				menu.fracasoOperacion();
			}
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		menu.getLblCartelSelec().setVisible(true);
		menu.getNuevaLinea().setVisible(false);
		
	}

	public GestionLineaVista getMenu() {
		return menu;
	}

	public void setMenu(GestionLineaVista menu) {
		this.menu = menu;
	}

	public MenuPrincipalController getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalController mPController) {
		this.mPController = mPController;
	}
	
	public void modificarLinea() {
		
		JComboBox l  = menu.solicitarLinea();
		/*
		LineaAerea selec = new LineaAerea();
		selec.setNombre("LineaA");
		selec.setAlianza(40648652);
		switch(menu.confirmarSeleccion(selec)) {
			case 0:datosLineaDB(selec);
				break;
			case 1:menu.cancelaOperacion();
		}*/
		
	}
	
	private void datosLineaDB(LineaAerea linea) {
		//menu.setModLinea(new FrameModLinea(menu, .....));
		return;
	}
	
	
}
