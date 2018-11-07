package edu.usal.pantalla.controller;

import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.vista.Vuelo_All_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneral;

public class Vuelo_All_Controller {
	
	Vuelo_All_Vista menuModDel;
	Vuelo_Datos_Controller menuDatos;
	MenuPrincipalController mPController;
	private VueloDAO vuelodao;
	
	public Vuelo_All_Controller(MenuPrincipalController menuPrincipalController) {
		this.mPController= menuPrincipalController;
		menuModDel = new Vuelo_All_Vista(this);
	}
	

	public MenuPrincipalController getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalController mPController) {
		this.mPController = mPController;
	}
	
	public void finalizarVentana() {
				menuModDel.dispose();
	}

	public void mostrarVentana() {
		menuModDel.setVisible(true);
	}

	public DefaultListModel<Vuelo> pedirListaVuelos() {
		DefaultListModel<Vuelo> lista = new DefaultListModel<Vuelo>();
		try {
			vuelodao = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
			for(Vuelo vuelo: vuelodao.getAllVuelo()) {
				lista.addElement(vuelo);				
			}
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		
		return lista;
	}


	public void Eliminar(Vuelo vuelo) {
		int res = menuModDel.confirmarSeleccion(vuelo, "ELIMINACION");
		if(res==JOptionPane.YES_OPTION) {
			try {
				vuelodao = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
				if(vuelodao.deleteVuelo(vuelo)) {
					menuModDel.exitoOperacion();
				}else {
					menuModDel.fracasoOperacion();
				}
			} catch (SQLException e) {
				IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneral.pritln(e.getMessage());
			}
		}else {
			menuModDel.cancelaOperacion();
		}
	}
	
	public void Modificar(Vuelo vuelo) {
		int res = menuModDel.confirmarSeleccion(vuelo, "MODIFICACION");
		if(res==JOptionPane.YES_OPTION) {
			menuDatos = new Vuelo_Datos_Controller(mPController, vuelo);
		}
	}


	public void mostrarClientes(Vuelo vuelo) {
		int res = menuModDel.confirmarSeleccion(vuelo, "MOSTRAR CLIENTES");
		if(res==JOptionPane.YES_OPTION) {
			menuModDel.setVisible(false);
			Vuelo_Cliente_Controller mostrar = new Vuelo_Cliente_Controller(this);
			
			
		}else {
			menuModDel.cancelaOperacion();
		}
	}
	
}


