package edu.usal.pantalla.controller;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

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
import edu.usal.pantalla.vista.MenuPrincipalVista__Tabla;
import edu.usal.util.ActualizarDatos;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneral;

public class MenuPrincipalControllerTabla{
		private MenuPrincipalVista__Tabla menuPrincipal;
		private Cliente_Datos_Controller menuDatosCliente;
		private LineaAerea_Datos_Controller menuDatosLineaAerea;
		private Venta_Datos_Controller menuDatosVenta;
		private Vuelo_Datos_Controller menuDatosVuelo;	
		private ActualizarDatos datos;
		private OperacionesController oper;
		
		public MenuPrincipalControllerTabla() {
			this.menuPrincipal = new MenuPrincipalVista__Tabla(this);
			this.oper = new OperacionesController();
		}
		
		public void hacerVisibleMP() {
			this.menuPrincipal.setVisible(true);
		}

		public void Salir() {
			if(menuPrincipal.confirmarSalida()==JFrame.EXIT_ON_CLOSE) {
				System.exit(0);
			}
		}
		
		private void actualizar() {
			this.menuPrincipal.revalidate();
			this.menuPrincipal.repaint();
		}

		public MenuPrincipalVista__Tabla getMenuPrincipal() {
			return menuPrincipal;
		}

		public void seleccionClientes() {
			try {
				datos = new ActualizarDatos();
				this.menuPrincipal.getTable().setModel(datos.clientes(this.menuPrincipal.getTable()));
				this.calcularEspacio();

				this.menuPrincipal.getPanel_Agregar().removeAll();
				this.menuPrincipal.getPanel_Eliminar().removeAll();
				this.menuPrincipal.getPanel_Modificar().removeAll();
				if(this.menuPrincipal.getPanel_Ver().getComponentCount()==1) {
					this.menuPrincipal.getPanel_Ver().remove(0);
				}
				
				this.menuPrincipal.getPanel_Agregar().add(this.menuPrincipal.getBtnAddCliente());
				this.menuPrincipal.getPanel_Modificar().add(this.menuPrincipal.getBtnModCliente());
				this.menuPrincipal.getPanel_Eliminar().add(this.menuPrincipal.getBtnDelCliente());
				
				this.menuPrincipal.getBtnAddCliente().setVisible(true);
				this.menuPrincipal.getBtnDelCliente().setVisible(true);
				this.menuPrincipal.getBtnModCliente().setVisible(true);
				
				this.actualizar();
			} catch (SQLException e) {
				menuPrincipal.fracasoOperacion("No se pudieron cargar los clientes\n"+e.getMessage());
			}
		}

		public void nuevoCliente() {
			this.menuPrincipal.setVisible(false);
			menuDatosCliente = new Cliente_Datos_Controller(this);	
			seleccionClientes();
		}
		
		public void modCliente() {
				Cliente select = buscarCliente();
				if(select==null) {
					this.menuPrincipal.fracasoOperacion("La seleccion del cliente");
				}else {
					if(this.menuPrincipal.confirmarSeleccion(select, "(MODIFICACION)")){
						this.menuPrincipal.setVisible(false);
						menuDatosCliente = new Cliente_Datos_Controller(this, select);
						seleccionClientes();
					}else{
						this.menuPrincipal.cancelaOperacion();
					}
					
				}
		}

		public void delCliente() {
			Cliente select = buscarCliente();
			if(select==null) {
				this.menuPrincipal.fracasoOperacion("La seleccion del cliente");
			}else {
				if(this.menuPrincipal.confirmarSeleccion(select, "(ELIMINACION)")){
					oper.eliminar(this, select);
					seleccionClientes();
				}else{
					this.menuPrincipal.cancelaOperacion();
				}
				
			}
		}
		
		private Cliente buscarCliente() {
			try {
			ClienteDAO clientedao = ClienteFactory.getClienteDAO(DatosEstaticos.getSource());
			return clientedao.readCliente(Integer.valueOf((String) this.menuPrincipal.getTable().getModel().getValueAt(this.menuPrincipal.getTable().getSelectedRow(), 2)));	
			} catch (SQLException e) {
				IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneral.pritln(e.getMessage());
			}	catch(ArrayIndexOutOfBoundsException e) {
				IOGeneral.pritln(">>>>>Error debe seleccionar un elemento<<<<<");
				IOGeneral.pritln(e.getMessage());
			}
			return null;
		}
		
		
		public void seleccionAerolinea() {
			try {
				datos = new ActualizarDatos();
				this.menuPrincipal.getTable().setModel(datos.aerolineas(this.menuPrincipal.getTable()));
				this.calcularEspacio();
				
				this.menuPrincipal.getPanel_Agregar().removeAll();
				this.menuPrincipal.getPanel_Eliminar().removeAll();
				this.menuPrincipal.getPanel_Modificar().removeAll();
				if(this.menuPrincipal.getPanel_Ver().getComponentCount()==1) {
					this.menuPrincipal.getPanel_Ver().remove(0);
				}
				
				this.menuPrincipal.getPanel_Agregar().add(this.menuPrincipal.getBtnAddAerolinea());
				this.menuPrincipal.getPanel_Modificar().add(this.menuPrincipal.getBtnModAerolinea());
				this.menuPrincipal.getPanel_Eliminar().add(this.menuPrincipal.getBtnDelAerolinea());
				this.menuPrincipal.getPanel_Ver().add(this.menuPrincipal.getBtnVerVuelos());
				
				this.menuPrincipal.getBtnAddAerolinea().setVisible(true);
				this.menuPrincipal.getBtnDelAerolinea().setVisible(true);
				this.menuPrincipal.getBtnModAerolinea().setVisible(true);
								
				this.actualizar();
			} catch (SQLException e) {
				menuPrincipal.fracasoOperacion("No se pudieron cargar las aerolineas\n"+e.getMessage());
			}
		}
		
		private void calcularEspacio() {
			for (int column = 0; column < this.menuPrincipal.getTable().getColumnCount(); column++)
			{
			    TableColumn tableColumn = this.menuPrincipal.getTable().getColumnModel().getColumn(column);
			    int preferredWidth = tableColumn.getMinWidth();
			    int maxWidth = tableColumn.getMaxWidth();

			    for (int row = 0; row < this.menuPrincipal.getTable().getRowCount(); row++)
			    {
			        TableCellRenderer cellRenderer = this.menuPrincipal.getTable().getCellRenderer(row, column);
			        Component c = this.menuPrincipal.getTable().prepareRenderer(cellRenderer, row, column);
			        int width = c.getPreferredSize().width + this.menuPrincipal.getTable().getIntercellSpacing().width;
			        preferredWidth = Math.max(preferredWidth, width);

			        //  We've exceeded the maximum width, no need to check other rows

			        if (preferredWidth >= maxWidth)
			        {
			            preferredWidth = maxWidth;
			            break;
			        }
			    }

			    tableColumn.setPreferredWidth( preferredWidth );
			}
		}

		public void nuevoAerolinea() {
			this.menuPrincipal.setVisible(false);
			menuDatosLineaAerea = new LineaAerea_Datos_Controller(this);
			seleccionAerolinea();	
		}

		public void modAerolinea() {
			LineaAerea select = buscarAerolinea();
			if(select==null) {
				this.menuPrincipal.fracasoOperacion("La seleccion de la aerolinea");
			}else {
				if(this.menuPrincipal.confirmarSeleccion(select, "(MODIFICACION)")){
					this.menuPrincipal.setVisible(false);
					menuDatosLineaAerea = new LineaAerea_Datos_Controller(this, select);
					seleccionAerolinea();
				}else{
					this.menuPrincipal.cancelaOperacion();
				}
				
			}
		}
		
		public void delAerolinea() {
			LineaAerea select = buscarAerolinea();
			if(select==null) {
				this.menuPrincipal.fracasoOperacion("La seleccion de la aerolinea");
			}else {
				if(this.menuPrincipal.confirmarSeleccion(select, "(ELIMINACION)")){
					oper.eliminar(this, select);
					seleccionAerolinea();
				}else{
					this.menuPrincipal.cancelaOperacion();
				}
			}
		}

		private LineaAerea buscarAerolinea() {
			try {
				LineaAereaDAO linea = LineaAereaFactory.getLineaAereaDAO(DatosEstaticos.getSource());
				return linea.readLineaAerea(Integer.valueOf((String) this.menuPrincipal.getTable().getModel().getValueAt(this.menuPrincipal.getTable().getSelectedRow(), 0)));	
				} catch (SQLException e) {
					IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
					IOGeneral.pritln(e.getMessage());
				} catch(ArrayIndexOutOfBoundsException e) {
					IOGeneral.pritln(">>>>>Error debe seleccionar un elemento<<<<<");
					IOGeneral.pritln(e.getMessage());
				}
				return null;
		}
		

		
		public void seleccionVuelos() {
			try {
				datos = new ActualizarDatos();
				this.menuPrincipal.getTable().setModel(datos.vuelos(this.menuPrincipal.getTable()));
				
				this.menuPrincipal.getPanel_Agregar().removeAll();
				this.menuPrincipal.getPanel_Eliminar().removeAll();
				this.menuPrincipal.getPanel_Modificar().removeAll();
				if(this.menuPrincipal.getPanel_Ver().getComponentCount()==1) {
					this.menuPrincipal.getPanel_Ver().remove(0);
				}
				
				this.menuPrincipal.getPanel_Agregar().add(this.menuPrincipal.getBtnAddVuelo());
				this.menuPrincipal.getPanel_Eliminar().add(this.menuPrincipal.getBtnDelVuelo());
				this.menuPrincipal.getPanel_Modificar().add(this.menuPrincipal.getBtnModVuelo());
				this.menuPrincipal.getPanel_Ver().add(this.menuPrincipal.getBtnVerClientes());
				
				this.menuPrincipal.getBtnAddVuelo().setVisible(true);
				this.menuPrincipal.getBtnDelVuelo().setVisible(true);
				this.menuPrincipal.getBtnModVuelo().setVisible(true);
				this.menuPrincipal.getBtnVerClientes().setVisible(true);
				
				this.actualizar();
			} catch (SQLException e) {
				menuPrincipal.fracasoOperacion("No se pudieron cargar los vuelos\n"+e.getMessage());
			}
		}
		
		public void nuevoVuelo() {
			this.menuPrincipal.setVisible(false);
			menuDatosVuelo = new Vuelo_Datos_Controller(this);	
			seleccionVuelos();
		}

		public void modVuelo() {
			Vuelo select = buscarVuelo();
			if(select==null) {
				this.menuPrincipal.fracasoOperacion("La seleccion de la aerolinea");
			}else {
				if(this.menuPrincipal.confirmarSeleccion(select, "(MODIFICACION)")){
					this.menuPrincipal.setVisible(false);
					menuDatosVuelo = new Vuelo_Datos_Controller(this, select);
					seleccionVuelos();
				}else{
					this.menuPrincipal.cancelaOperacion();
				}
				
			}
		}
		
		public void delVuelo() {
			Vuelo select = buscarVuelo();
			if(select==null) {
				this.menuPrincipal.fracasoOperacion("La seleccion de la aerolinea");
			}else {
				if(this.menuPrincipal.confirmarSeleccion(select, "(ELIMINACION)")){
					oper.eliminar(this, select);
					seleccionVuelos();
				}else{
					this.menuPrincipal.cancelaOperacion();
				}
			}
		}

		private Vuelo buscarVuelo() {
			try {
				VueloDAO linea = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
				return linea.readVuelo((String) this.menuPrincipal.getTable().getModel().getValueAt(this.menuPrincipal.getTable().getSelectedRow(), 0));	
				} catch (SQLException e) {
					IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
					IOGeneral.pritln(e.getMessage());
				} catch(ArrayIndexOutOfBoundsException e) {
					IOGeneral.pritln(">>>>>Error debe seleccionar un elemento<<<<<");
					IOGeneral.pritln(e.getMessage());
				}
				return null;
		}
		
		

		public void seleccionVenta() {
			try {
				datos = new ActualizarDatos();
				this.menuPrincipal.getTable().setModel(datos.ventas(this.menuPrincipal.getTable()));
				
				this.menuPrincipal.getPanel_Agregar().removeAll();
				this.menuPrincipal.getPanel_Eliminar().removeAll();
				this.menuPrincipal.getPanel_Modificar().removeAll();
				if(this.menuPrincipal.getPanel_Ver().getComponentCount()==1) {
					this.menuPrincipal.getPanel_Ver().remove(0);
				}
				
				this.menuPrincipal.getPanel_Agregar().add(this.menuPrincipal.getBtnAddVenta());
				this.menuPrincipal.getPanel_Eliminar().add(this.menuPrincipal.getBtnDelVenta());
				this.menuPrincipal.getPanel_Modificar().add(this.menuPrincipal.getBtnModVenta());
				
				this.menuPrincipal.getBtnAddVenta().setVisible(true);
				this.menuPrincipal.getBtnDelVenta().setVisible(true);
				this.menuPrincipal.getBtnModVenta().setVisible(true);
				
				this.actualizar();
			} catch (SQLException e) {
				menuPrincipal.fracasoOperacion("No se pudieron cargar los vuelos\n"+e.getMessage());
			}
		}

		public void nuevoVenta() {
			this.menuPrincipal.setVisible(false);
			menuDatosVuelo = new Vuelo_Datos_Controller(this);
			seleccionVenta();	
		}

		public void modVenta() {
			Venta select = buscarVenta();
			if(select==null) {
				this.menuPrincipal.fracasoOperacion("La seleccion de la aerolinea");
			}else {
				if(this.menuPrincipal.confirmarSeleccion(select, "(MODIFICACION)")){
					this.menuPrincipal.setVisible(false);
					menuDatosVenta = new Venta_Datos_Controller(this, select);
					seleccionVenta();
				}else{
					this.menuPrincipal.cancelaOperacion();
				}
				
			}
		}
		
		public void delVenta() {
			Venta select = buscarVenta();
			if(select==null) {
				this.menuPrincipal.fracasoOperacion("La seleccion de la aerolinea");
			}else {
				if(this.menuPrincipal.confirmarSeleccion(select, "(ELIMINACION)")){
					oper.eliminar(this, select);
					seleccionVenta();
				}else{
					this.menuPrincipal.cancelaOperacion();
				}
			}
		}

		private Venta buscarVenta() {
			try {
				VentaDAO linea = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
				return linea.readVenta((int) this.menuPrincipal.getTable().getModel().getValueAt(this.menuPrincipal.getTable().getSelectedRow(), 0));	
				} catch (SQLException e) {
					IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
					IOGeneral.pritln(e.getMessage());
				} catch(ArrayIndexOutOfBoundsException e) {
					IOGeneral.pritln(">>>>>Error debe seleccionar un elemento<<<<<");
					IOGeneral.pritln(e.getMessage());
				}
				return null;
		}
}
