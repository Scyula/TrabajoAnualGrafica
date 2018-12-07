package edu.usal.pantalla.controller;

import java.awt.Component;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.factory.LineaAereaFactory;
import edu.usal.negocio.dao.factory.VentaFactory;
import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Venta;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.datos.Cliente_Datos_Controller;
import edu.usal.pantalla.controller.datos.LineaAerea_Datos_Controller;
import edu.usal.pantalla.controller.datos.Venta_Datos_Controller;
import edu.usal.pantalla.controller.datos.Vuelo_Datos_Controller;
import edu.usal.pantalla.controller.mostrar.LineaAerea_Vuelo_Controller;
import edu.usal.pantalla.controller.mostrar.Vuelo_Cliente_Controller;
import edu.usal.pantalla.vista.MenuPrincipalVista__Tabla;
import edu.usal.util.ActualizarDatos;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneralDAO;

public class MenuPrincipalControllerTabla{
		private MenuPrincipalVista__Tabla vista;
		private ActualizarDatos datos;
		private OperacionesController oper;
		private TableRowSorter<TableModel> modeloOrdenado;
		
		public MenuPrincipalControllerTabla() {
			this.vista = new MenuPrincipalVista__Tabla(this);
			this.oper = new OperacionesController();
			this.datos = new ActualizarDatos();
		}

		public void hacerVisibleMP() {
			this.vista.setVisible(true);
		}

		public void Salir() {
			if(vista.confirmarSalida()==JFrame.EXIT_ON_CLOSE) {
				System.exit(0);
			}
		}

		private void actualizar() {
			this.vista.revalidate();
			this.vista.repaint();
		}

		public MenuPrincipalVista__Tabla getMenuPrincipal() {
			return vista;
		}

		public void seleccionClientes() {
			try {
				this.vista.getTable().setModel(datos.clientes());
				this.centrarStrings();
				this.permitirOrdenar("Cliente");

				this.vista.getPanel_Agregar().removeAll();
				this.vista.getPanel_Eliminar().removeAll();
				this.vista.getPanel_Modificar().removeAll();
				if(this.vista.getPanel_Ver().getComponentCount()==1) {
					this.vista.getPanel_Ver().remove(0);
				}
				this.vista.getComboBox_Busqueda().setModel(this.datos.cargarCombo("Cliente"));
				
				this.vista.getPanel_Agregar().add(this.vista.getBtnAddCliente());
				this.vista.getPanel_Modificar().add(this.vista.getBtnModCliente());
				this.vista.getPanel_Eliminar().add(this.vista.getBtnDelCliente());
				
				this.vista.getBtnAddCliente().setVisible(true);
				this.vista.getBtnDelCliente().setVisible(true);
				this.vista.getBtnModCliente().setVisible(true);
				
				this.formatoTextoFecha(3);
				this.actualizar();
			} catch (SQLException e) {
				vista.fracasoOperacion("No se pudieron cargar los clientes\n"+e.getMessage());
			}
		}

		private void formatoTextoFecha(int i) {
			DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

			    SimpleDateFormat f = new SimpleDateFormat("MM - dd - yyyy");

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
			this.getMenuPrincipal().getTable().getColumnModel().getColumn(i).setCellRenderer(tableCellRenderer);
		}
		
		private void formatoTextoFechaHora(int i) {
			DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

			    SimpleDateFormat f = new SimpleDateFormat("MM - dd - yyyy HH:MM");

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
			this.getMenuPrincipal().getTable().getColumnModel().getColumn(i).setCellRenderer(tableCellRenderer);
		}

		public void nuevoCliente() {
			this.vista.setVisible(false);
			new Cliente_Datos_Controller(this);	
		}
		
		public void modCliente() {
				Cliente select = buscarCliente();
				if(select==null) {
					this.vista.fracasoOperacion("Debe seleccionar un cliente");
				}else {
					if(this.vista.confirmarSeleccion(select, "(MODIFICACION)")){
						this.vista.setVisible(false);
						new Cliente_Datos_Controller(this, select);
					}else{
						this.vista.cancelaOperacion();
					}
					
				}
		}

		public void delCliente() {
			Cliente select = buscarCliente();
			if(select==null) {
				this.vista.fracasoOperacion("Debe seleccionar un cliente");
			}else {
				if(this.vista.confirmarSeleccion(select, "(ELIMINACION)")){
					oper.eliminar(this, select);
				}else{
					this.vista.cancelaOperacion();
				}
				
			}
		}
		
		private Cliente buscarCliente() {
			try {
			ClienteDAO clientedao = ClienteFactory.getClienteDAO(DatosEstaticos.getSource());
			return clientedao.readCliente(Integer.valueOf((String) this.vista.getTable().getModel().getValueAt(this.vista.getTable().getSelectedRow(), 2)));	
			} catch (SQLException e) {
				IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			}	catch(ArrayIndexOutOfBoundsException e) {
			}
			return null;
		}
		
		
		public void seleccionAerolinea() {
			try {
				this.vista.getTable().setModel(datos.aerolineas());
				this.centrarStrings();
				this.permitirOrdenar("Aerolinea");
				
				this.vista.getPanel_Agregar().removeAll();
				this.vista.getPanel_Eliminar().removeAll();
				this.vista.getPanel_Modificar().removeAll();
				if(this.vista.getPanel_Ver().getComponentCount()==1) {
					this.vista.getPanel_Ver().remove(0);
				}
				this.vista.getComboBox_Busqueda().setModel(this.datos.cargarCombo("Aerolinea"));
				
				this.vista.getPanel_Agregar().add(this.vista.getBtnAddAerolinea());
				this.vista.getPanel_Modificar().add(this.vista.getBtnModAerolinea());
				this.vista.getPanel_Eliminar().add(this.vista.getBtnDelAerolinea());
				this.vista.getPanel_Ver().add(this.vista.getBtnVerVuelos());
				
				this.vista.getBtnAddAerolinea().setVisible(true);
				this.vista.getBtnDelAerolinea().setVisible(true);
				this.vista.getBtnModAerolinea().setVisible(true);
								
				this.actualizar();
			} catch (SQLException e) {
				vista.fracasoOperacion("No se pudieron cargar las aerolineas\n"+e.getMessage());
			}
		}
		
		private void permitirOrdenar(String tipo) {
			modeloOrdenado = new TableRowSorter<TableModel>(this.vista.getTable().getModel());
			this.vista.getTable().setRowSorter(modeloOrdenado);
		}

		private void centrarStrings() {
//			for (int column = 0; column < this.vista.getTable().getColumnCount(); column++)
//			{
//			    TableColumn tableColumn = this.vista.getTable().getColumnModel().getColumn(column);
//			    int preferredWidth = tableColumn.getMinWidth();
//			    int maxWidth = tableColumn.getMaxWidth();
//
//			    for (int row = 0; row < this.vista.getTable().getRowCount(); row++)
//			    {
//			        TableCellRenderer cellRenderer = this.vista.getTable().getCellRenderer(row, column);
//			        Component c = this.vista.getTable().prepareRenderer(cellRenderer, row, column);
//			        int width = c.getPreferredSize().width + this.vista.getTable().getIntercellSpacing().width;
//			        preferredWidth = Math.max(preferredWidth, width);
//
//			        if (preferredWidth >= maxWidth)
//			        {
//			            preferredWidth = maxWidth;
//			            break;
//			        }
//			    }
//
//			    tableColumn.setPreferredWidth( preferredWidth );
//			}
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			this.getMenuPrincipal().getTable().setDefaultRenderer(String.class, centerRenderer);
			this.getMenuPrincipal().getTable().setDefaultRenderer(Date.class, centerRenderer);
			this.getMenuPrincipal().getTable().setDefaultRenderer(Integer.class, centerRenderer);
			this.getMenuPrincipal().getTable().setDefaultRenderer(Double.class, centerRenderer);
		}

		public void nuevoAerolinea() {
			this.vista.setVisible(false);
			new LineaAerea_Datos_Controller(this);
		}

		public void modAerolinea() {
			LineaAerea select = buscarAerolinea();
			if(select==null) {
				this.vista.fracasoOperacion("Debe seleccionar una aerolinea");
			}else {
				if(this.vista.confirmarSeleccion(select, "(MODIFICACION)")){
					this.vista.setVisible(false);
					new LineaAerea_Datos_Controller(this, select);
				}else{
					this.vista.cancelaOperacion();
				}
				
			}
		}
		
		public void delAerolinea() {
			LineaAerea select = buscarAerolinea();
			if(select==null) {
				this.vista.fracasoOperacion("Debe seleccionar una aerolinea");
			}else {
				if(this.vista.confirmarSeleccion(select, "(ELIMINACION)")){
					oper.eliminar(this, select);
				}else{
					this.vista.cancelaOperacion();
				}
			}
		}

		private LineaAerea buscarAerolinea() {
			try {
				LineaAereaDAO linea = LineaAereaFactory.getLineaAereaDAO(DatosEstaticos.getSource());
				return linea.readLineaAerea(Integer.valueOf((String) this.vista.getTable().getModel().getValueAt(this.vista.getTable().getSelectedRow(), 0)));	
				} catch (SQLException e) {
					IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
					IOGeneralDAO.pritln(e.getMessage());
				} catch(ArrayIndexOutOfBoundsException e) {
				}
				return null;
		}
		

		
		public void seleccionVuelos() {
			try {
				this.vista.getTable().setModel(datos.vuelos());
				this.vista.getComboBox_Busqueda().setModel(this.datos.cargarCombo("Vuelo"));
				this.permitirOrdenar("Vuelo");
				
				this.vista.getPanel_Agregar().removeAll();
				this.vista.getPanel_Eliminar().removeAll();
				this.vista.getPanel_Modificar().removeAll();
				if(this.vista.getPanel_Ver().getComponentCount()==1) {
					this.vista.getPanel_Ver().remove(0);
				}
				
				this.vista.getPanel_Agregar().add(this.vista.getBtnAddVuelo());
				this.vista.getPanel_Eliminar().add(this.vista.getBtnDelVuelo());
				this.vista.getPanel_Modificar().add(this.vista.getBtnModVuelo());
				this.vista.getPanel_Ver().add(this.vista.getBtnVerClientes());
				
				this.vista.getBtnAddVuelo().setVisible(true);
				this.vista.getBtnDelVuelo().setVisible(true);
				this.vista.getBtnModVuelo().setVisible(true);
				this.vista.getBtnVerClientes().setVisible(true);

				this.formatoTextoFechaHora(3);
				this.formatoTextoFechaHora(5);
				this.centrarStrings();
				this.actualizar();
			} catch (SQLException e) {
				vista.fracasoOperacion("No se pudieron cargar los vuelos\n"+e.getMessage());
			}
		}
		
		

		public void nuevoVuelo() {
			this.vista.setVisible(false);
			new Vuelo_Datos_Controller(this);	
		}

		public void modVuelo() {
			Vuelo select = buscarVuelo();
			if(select==null) {
				this.vista.fracasoOperacion("Debe seleccionar una aerolinea");
			}else {
				if(this.vista.confirmarSeleccion(select, "(MODIFICACION)")){
					this.vista.setVisible(false);
					new Vuelo_Datos_Controller(this, select);
				}else{
					this.vista.cancelaOperacion();
				}
				
			}
		}
		
		public void delVuelo() {
			Vuelo select = buscarVuelo();
			if(select==null) {
				this.vista.fracasoOperacion("Debe seleccionar una aerolinea");
			}else {
				if(this.vista.confirmarSeleccion(select, "(ELIMINACION)")){
					oper.eliminar(this, select);
				}else{
					this.vista.cancelaOperacion();
				}
			}
		}

		private Vuelo buscarVuelo() {
			try {
				VueloDAO linea = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
				return linea.readVuelo((String) this.vista.getTable().getModel().getValueAt(this.vista.getTable().getSelectedRow(), 0));	
				} catch (SQLException e) {
					IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
					IOGeneralDAO.pritln(e.getMessage());
					return null;
				} catch(ArrayIndexOutOfBoundsException e) {
					return null;
				}
		}
		
		

		public void seleccionVenta() {
			try {
				this.vista.getTable().setModel(datos.ventas());
				this.permitirOrdenar("");
				
				this.vista.getPanel_Agregar().removeAll();
				this.vista.getPanel_Eliminar().removeAll();
				this.vista.getPanel_Modificar().removeAll();
				if(this.vista.getPanel_Ver().getComponentCount()==1) {
					this.vista.getPanel_Ver().remove(0);
				}
				this.vista.getComboBox_Busqueda().setModel(this.datos.cargarCombo("Venta"));
				
				
				this.vista.getPanel_Agregar().add(this.vista.getBtnAddVenta());
				this.vista.getPanel_Eliminar().add(this.vista.getBtnDelVenta());
				this.vista.getPanel_Modificar().add(this.vista.getBtnModVenta());
				
				this.vista.getBtnAddVenta().setVisible(true);
				this.vista.getBtnDelVenta().setVisible(true);
				this.vista.getBtnModVenta().setVisible(true);

				this.formatoTextoFechaHora(5);
				this.centrarStrings();
				this.actualizar();
			} catch (SQLException e) {
				vista.fracasoOperacion("No se pudieron cargar los vuelos\n"+e.getMessage());
			}
		}

		public void nuevoVenta() {
			this.vista.setVisible(false);
			new Venta_Datos_Controller(this);
		}

		public void modVenta() {
			Venta select = buscarVenta();
			if(select==null) {
				this.vista.fracasoOperacion("Debe seleccionar una venta");
			}else {
				if(this.vista.confirmarSeleccion(select, "(MODIFICACION)")){
					this.vista.setVisible(false);
					new Venta_Datos_Controller(this, select);
				}else{
					this.vista.cancelaOperacion();
				}
				
			}
		}
		
		public void delVenta() {
			Venta select = buscarVenta();
			if(select==null) {
				this.vista.fracasoOperacion("Debe seleccionar una venta");
			}else {
				if(this.vista.confirmarSeleccion(select, "(ELIMINACION)")){
					oper.eliminar(this, select);
				}else{
					this.vista.cancelaOperacion();
				}
			}
		}

		private Venta buscarVenta() {
			try {
				VentaDAO linea = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
				return linea.readVenta(Integer.valueOf((String)this.vista.getTable().getModel().getValueAt(this.vista.getTable().getSelectedRow(), 0)));	
				} catch (SQLException e) {
					IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
					IOGeneralDAO.pritln(e.getMessage());
				} catch(ArrayIndexOutOfBoundsException e) {
				}
				return null;
		}

		public void verVuelosAerolinea() {
			LineaAerea linea = buscarAerolinea();
			if(linea!=null) {
				vista.setVisible(false);
				new LineaAerea_Vuelo_Controller(this,linea);
			}
		}

		public void verClientesVuelo() {
			Vuelo vuelo = buscarVuelo();
			if(vuelo!=null) {
				vista.setVisible(false);
				new Vuelo_Cliente_Controller(this, vuelo);
			}			
		}

		public void buscarEnTabla() {
			oper.ordenar(this);
			
		}

		public TableRowSorter<TableModel> getModeloOrdenado() {
			return modeloOrdenado;
		}

		public void setModeloOrdenado(TableRowSorter<TableModel> modeloOrdenado) {
			this.modeloOrdenado = modeloOrdenado;
		}
		
		
}
