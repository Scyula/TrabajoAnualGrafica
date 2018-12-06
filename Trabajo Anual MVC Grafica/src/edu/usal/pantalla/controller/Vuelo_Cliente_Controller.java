package edu.usal.pantalla.controller;

import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.vista.Vuelo_Cliente_Vista;
import edu.usal.util.ActualizarDatos;

public class Vuelo_Cliente_Controller {
		
	Vuelo_Cliente_Vista vista;
	MenuPrincipalControllerTabla mPController;
	LineaAerea_Vuelo_Controller Menulinea;
	Vuelo vuelo;
	ActualizarDatos datos;
	Boolean submenu;
	
	public Vuelo_Cliente_Controller(MenuPrincipalControllerTabla vuelo_All_Controller, Vuelo vuelo) {
		this.vuelo= vuelo;
		this.mPController= vuelo_All_Controller;
		this.vista = new Vuelo_Cliente_Vista(this,vuelo);
		this.datos = new ActualizarDatos();
		this.submenu = false;
		this.CargarClientes();
	}
	

	public Vuelo_Cliente_Controller(LineaAerea_Vuelo_Controller lineaAerea_Vuelo_Controller, Vuelo vuelo2) {
		this.vuelo= vuelo2;
		this.Menulinea= lineaAerea_Vuelo_Controller;
		this.vista = new Vuelo_Cliente_Vista(this,vuelo);
		this.datos = new ActualizarDatos();
		this.submenu = true;
		this.CargarClientes();
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

	public void CargarClientes() {
		this.vista.getTable().setModel(datos.clientesVuelo(this.vuelo));
		this.actualizar();
	}

	public void Volver(Vuelo_Cliente_Vista vista) {
		if(submenu) {
			this.vista.dispose();
			this.Menulinea.hacerVisible();
		}else {
			this.vista.dispose();
			this.mPController.hacerVisibleMP();
		}
	}


	private void actualizar() {
		this.vista.revalidate();
		this.vista.repaint();
	}
}
