package edu.usal.pantalla.controller.mostrar;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.MenuPrincipalControllerTabla;
import edu.usal.pantalla.vista.mostrar.Vuelo_Cliente_Vista;
import edu.usal.util.ActualizarDatos;

public class Vuelo_Cliente_Controller {
		
	Vuelo_Cliente_Vista vista;
	MenuPrincipalControllerTabla mPController;
	LineaAerea_Vuelo_Controller Menulinea;
	Vuelo vuelo;
	ActualizarDatos datos;
	Boolean submenu;
	
	public Vuelo_Cliente_Controller(MenuPrincipalControllerTabla vuelo_All_Controller, Vuelo vuelo) {
		System.out.println(this.getClass().getName());
		this.vuelo= vuelo;
		this.mPController= vuelo_All_Controller;
		this.vista = new Vuelo_Cliente_Vista(this,vuelo);
		this.datos = new ActualizarDatos();
		this.submenu = false;
		this.CargarClientes();
		this.formatoTextoFecha(4);
		this.centrarStrings();
	}
	
	private void formatoTextoFecha(int i) {
		DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

		    SimpleDateFormat f = new SimpleDateFormat("dd - MM - yyyy");

		    public Component getTableCellRendererComponent(JTable table,
		            Object value, boolean isSelected, boolean hasFocus,
		            int row, int column) {
		        if( value instanceof Date) {
		            value = f.format(value);
		        }
		        return super.getTableCellRendererComponent(table, value, isSelected,
		                hasFocus, row, column);
		    }
		};
		tableCellRenderer.setHorizontalAlignment( JLabel.CENTER );
		this.vista.getTable().getColumnModel().getColumn(i).setCellRenderer(tableCellRenderer);
	}
	
	public Vuelo_Cliente_Controller(LineaAerea_Vuelo_Controller lineaAerea_Vuelo_Controller, Vuelo vuelo2) {
		System.out.println(this.getClass().getName());
		this.vuelo= vuelo2;
		this.Menulinea= lineaAerea_Vuelo_Controller;
		this.vista = new Vuelo_Cliente_Vista(this,vuelo);
		this.datos = new ActualizarDatos();
		this.submenu = true;
		this.CargarClientes();
		this.formatoTextoFecha(4);
		this.centrarStrings();
	}
	private void centrarStrings() {			
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		this.vista.getTable().setDefaultRenderer(String.class, centerRenderer);
		this.vista.getTable().setDefaultRenderer(Date.class, centerRenderer);
		this.vista.getTable().setDefaultRenderer(Integer.class, centerRenderer);
		this.vista.getTable().setDefaultRenderer(Double.class, centerRenderer);
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
