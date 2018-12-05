package edu.usal.pantalla.controller;

import javax.swing.DefaultListModel;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.vista.Vuelo_Cliente_Vista;

public class Vuelo_Cliente_Controller {
		
	Vuelo_Cliente_Vista menuModDel;
	MenuPrincipalControllerTabla mPController;
	private ClienteDAO clientedao;
	Vuelo vuelo;
	
	public Vuelo_Cliente_Controller(MenuPrincipalControllerTabla vuelo_All_Controller, Vuelo vuelo) {
		this.vuelo= vuelo;
		this.mPController= vuelo_All_Controller;
		menuModDel = new Vuelo_Cliente_Vista(this);
	}
	

	public MenuPrincipalControllerTabla getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalControllerTabla mPController) {
		this.mPController = mPController;
	}
	
	public void finalizarVentana() {
				menuModDel.dispose();
	}


	public DefaultListModel<Cliente> pedirListaClientes() {
		DefaultListModel<Cliente> lista = new DefaultListModel<Cliente>();
			
		if(!vuelo.getClientes().isEmpty()) {
			for(Cliente cliente: vuelo.getClientes()) {
				lista.addElement(cliente);				
			}		
		}
		
			return lista;
	}


	public void Volver(Vuelo_Cliente_Vista vista) {
	}

	
}
