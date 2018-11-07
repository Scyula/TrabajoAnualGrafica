package edu.usal.pantalla.controller;

import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.factory.VentaFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Venta;
import edu.usal.pantalla.vista.Cliente_ModDel_Vista;
import edu.usal.pantalla.vista.Venta_All_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneral;

public class Venta_All_Controller {
		
	Venta_All_Vista menuModDel;
	Venta_Datos_Controller menuDatos;
	MenuPrincipalController mPController;
	private VentaDAO ventadao;
	
	public Venta_All_Controller(MenuPrincipalController menuPrincipalController) {
		this.mPController= menuPrincipalController;
		menuModDel = new Venta_All_Vista(this);
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


	public DefaultListModel<Venta> pedirListaVentas() {
		DefaultListModel<Venta> lista = new DefaultListModel<Venta>();
		try {
			ventadao = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
			for(Venta venta: ventadao.getAllVenta()) {
				lista.addElement(venta);				
			}
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		
		return lista;
	}


	public void Eliminar(Venta venta) {
		int res = menuModDel.confirmarSeleccion(venta, "ELIMINACION");
		if(res==JOptionPane.YES_OPTION) {
			try {
				ventadao = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
				if(ventadao.deleteVentas(venta)) {
					menuModDel.exitoOperacion();
					mPController.hacerVisibleMP();
					this.finalizarVentana();
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
	
	public void Modificar(Venta venta) {
		int res = menuModDel.confirmarSeleccion(venta, "MODIFICACION");
		if(res==JOptionPane.YES_OPTION) {
			this.menuModDel.dispose();
			this.menuDatos = new Venta_Datos_Controller(mPController, venta);
			
		}
	}
	
}
