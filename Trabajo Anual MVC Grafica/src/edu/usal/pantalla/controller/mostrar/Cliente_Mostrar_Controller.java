package edu.usal.pantalla.controller.mostrar;

import java.sql.SQLException;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import edu.usal.pantalla.controller.MenuPrincipalControllerTabla;
import edu.usal.pantalla.controller.datos.Venta_Datos_Controller;
import edu.usal.pantalla.vista.mostrar.Cliente_Mostrar_Vista;
import edu.usal.util.ActualizarDatos;

public class Cliente_Mostrar_Controller {
	
	Venta_Datos_Controller menu;
	Cliente_Mostrar_Vista vista;

	public Cliente_Mostrar_Controller(Venta_Datos_Controller venta_Datos_Controller) {
		this.menu = venta_Datos_Controller;
		this.vista = new Cliente_Mostrar_Vista(this);
		this.primerCarga();
	}
	
	public void primerCarga() {
		try {
			ActualizarDatos datos = new ActualizarDatos();
			this.vista.getTable().setModel(datos.clientes());
			TableRowSorter<TableModel> modeloOrdenado = new TableRowSorter<TableModel>(this.vista.getTable().getModel());
			this.vista.getTable().setRowSorter(modeloOrdenado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void seleccionar() {
		menu.getVista().getTextBuscarDNI().setText((String) this.vista.getTable().getModel().getValueAt(this.vista.getTable().getSelectedRow(), 2));
		menu.buscarCliente();
		menu.getVista().setVisible(true);
		this.vista.dispose();
	}

	public void volver() {
		menu.getVista().setVisible(true);
		this.vista.dispose();
	}
	
	
}
