package edu.usal.pantalla.controller.mostrar;

import java.awt.Component;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
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
		System.out.println(this.getClass().getName());
		this.menu = venta_Datos_Controller;
		this.vista = new Cliente_Mostrar_Vista(this);
		this.primerCarga();
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
	
	public void primerCarga() {
		try {
			ActualizarDatos datos = new ActualizarDatos();
			this.vista.getTable().setModel(datos.clientes());
			TableRowSorter<TableModel> modeloOrdenado = new TableRowSorter<TableModel>(this.vista.getTable().getModel());
			this.vista.getTable().setRowSorter(modeloOrdenado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void seleccionar() {
		try {
			menu.getVista().getTextBuscarDNI().setText(String.valueOf(this.vista.getTable().getModel().getValueAt(this.vista.getTable().getSelectedRow(), 2)));
			if(menu.buscarCliente()) {
			menu.getVista().setVisible(true);
			this.vista.dispose();
			}else {
				menu.getVista().getTextBuscarDNI().setText("");
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
	}

	public void volver() {
		menu.getVista().setVisible(true);
		this.vista.dispose();
	}
	
	
}
