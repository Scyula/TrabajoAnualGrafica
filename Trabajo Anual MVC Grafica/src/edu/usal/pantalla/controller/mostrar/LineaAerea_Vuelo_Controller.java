package edu.usal.pantalla.controller.mostrar;

import java.awt.Component;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.MenuPrincipalControllerTabla;
import edu.usal.pantalla.vista.mostrar.LineaAerea_Vuelo_Vista;
import edu.usal.util.ActualizarDatos;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneralDAO;

public class LineaAerea_Vuelo_Controller {
		
	private LineaAerea_Vuelo_Vista vista;
	private MenuPrincipalControllerTabla mPController;
	private LineaAerea linea;
	private ActualizarDatos datos;
	
	public LineaAerea_Vuelo_Controller(MenuPrincipalControllerTabla menu, LineaAerea linea) {
		System.out.println(this.getClass().getName());
		this.linea = linea;
		this.mPController= menu;
		this.vista = new LineaAerea_Vuelo_Vista(this, linea);
		this.datos= new ActualizarDatos();
		this.CargarVuelos();
		this.formatoTextoFechaHora(3);
		this.formatoTextoFechaHora(5);
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

	private void formatoTextoFechaHora(int i) {
		DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

		    SimpleDateFormat f = new SimpleDateFormat("dd - MM - yyyy HH:mm");

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
	
	public MenuPrincipalControllerTabla getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalControllerTabla mPController) {
		this.mPController = mPController;
	}
	
	public void finalizarVentana() {
		vista.dispose();
	}

	public void CargarVuelos() {
		this.vista.getTable().setModel(datos.vuelosAero(this.linea));
		this.actualizar();
	}

	public void VerClientes() {
		Vuelo vuelo = buscarVuelo();
		if(vuelo!=null) {
		vista.setVisible(false);
		new Vuelo_Cliente_Controller(this, vuelo);
		}
	}
	
	private Vuelo buscarVuelo() {
		try {
			VueloDAO linea = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
			return linea.readVuelo((String) this.vista.getTable().getModel().getValueAt(this.vista.getTable().getSelectedRow(), 0));	
			} catch (SQLException e) {
				IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			} catch(ArrayIndexOutOfBoundsException e) {
				IOGeneralDAO.pritln(">>>>>Error debe seleccionar un elemento<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			}
			return null;
	}

	public void Volver() {
		this.vista.dispose();
		this.mPController.hacerVisibleMP();
	}
	

	private void actualizar() {
		this.vista.revalidate();
		this.vista.repaint();
	}


	public void hacerVisible() {
		this.vista.setVisible(true);
	}
	
}
