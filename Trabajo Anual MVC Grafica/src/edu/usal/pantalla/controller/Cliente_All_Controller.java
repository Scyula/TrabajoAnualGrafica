package edu.usal.pantalla.controller;

import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.pantalla.vista.Cliente_All_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneral;

public class Cliente_All_Controller {
		
	Cliente_All_Vista menuModDel;
	Cliente_Datos_Controller menuDatos;
	MenuPrincipalController mPController;
	private ClienteDAO clientedao;
	
	public Cliente_All_Controller(MenuPrincipalController menuPrincipalController) {
		this.mPController= menuPrincipalController;
		menuModDel = new Cliente_All_Vista(this);
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


	public DefaultListModel<Cliente> pedirListaClientes() {
		DefaultListModel<Cliente> lista = new DefaultListModel<Cliente>();
		try {
			clientedao = ClienteFactory.getClienteDAO(DatosEstaticos.getSource());
			for(Cliente cliente: clientedao.getAllCliente()) {
				lista.addElement(cliente);				
			}
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		
		return lista;
	}


	public void Eliminar(Cliente cliente) {
		int res = menuModDel.confirmarSeleccion(cliente, "ELIMINACION");
		if(res==JOptionPane.YES_OPTION) {
			try {
				clientedao = ClienteFactory.getClienteDAO(DatosEstaticos.getSource());
				if(clientedao.deleteCliente(cliente)) {
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
	
	public void Modificar(Cliente cliente) {
		int res = menuModDel.confirmarSeleccion(cliente, "MODIFICACION");
		if(res==JOptionPane.YES_OPTION) {
			menuDatos = new Cliente_Datos_Controller(mPController, cliente);
		}
	}
	
}
