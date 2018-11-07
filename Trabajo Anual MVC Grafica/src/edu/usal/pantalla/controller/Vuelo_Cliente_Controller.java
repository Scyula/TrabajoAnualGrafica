package edu.usal.pantalla.controller;

import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.vista.Cliente_All_Vista;
import edu.usal.pantalla.vista.Vuelo_Cliente_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneral;

public class Vuelo_Cliente_Controller {
		
	Vuelo_Cliente_Vista menuModDel;
	Vuelo_All_Controller mPController;
	private ClienteDAO clientedao;
	Vuelo vuelo;
	
	public Vuelo_Cliente_Controller(Vuelo_All_Controller vuelo_All_Controller, Vuelo vuelo) {
		this.vuelo= vuelo;
		this.mPController= vuelo_All_Controller;
		menuModDel = new Vuelo_Cliente_Vista(this);
	}
	

	public Vuelo_All_Controller getmPController() {
		return mPController;
	}

	public void setmPController(Vuelo_All_Controller mPController) {
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
		vista.dispose();
		mPController.mostrarVentana();
		
	}

	
}
