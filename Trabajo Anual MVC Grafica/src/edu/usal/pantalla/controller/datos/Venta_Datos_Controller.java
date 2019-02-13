package edu.usal.pantalla.controller.datos;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.text.BadLocationException;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.factory.VentaFactory;
import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Venta;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.MenuPrincipalControllerTabla;
import edu.usal.pantalla.controller.mostrar.Cliente_Mostrar_Controller;
import edu.usal.pantalla.controller.mostrar.Vuelo_Mostrar_Controller;
import edu.usal.pantalla.vista.datos.Venta_Datos_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneralDAO;

@SuppressWarnings("deprecation")
public class Venta_Datos_Controller {
		
	Venta_Datos_Vista vista;
	MenuPrincipalControllerTabla controllerMP;
	private VentaDAO ventadao;
	private Venta venta;
	
	public Venta_Datos_Controller(MenuPrincipalControllerTabla menuPrincipalController) {
		this.venta = new Venta();
		this.controllerMP= menuPrincipalController;
		this.vista = new Venta_Datos_Vista(this);
	}
	
	public Venta_Datos_Controller(MenuPrincipalControllerTabla menuPrincipalController, Venta modificar) {
		this.venta=modificar;
		this.controllerMP= menuPrincipalController;
		this.vista = new Venta_Datos_Vista(this , modificar);
		this.vista.cargarDatos(modificar);
	}

	public void updateDatos(Venta_Datos_Vista datos) {
		try {
			System.out.println("Proceso comenzado(alta)");
			if(corroborarDatos()) {
				ventadao = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
				if(ventadao.updateVenta(venta)) {
					vista.exitoOperacion();
					controllerMP.seleccionVenta();
				}else {
					vista.errorOperacion("No se pudo guardar la venta");
				}
				vista.dispose();
				controllerMP.hacerVisibleMP();
			}
			
		} catch (SQLException e) {
			vista.errorBaseDatos(e.getMessage());

		} 	
		IOGeneralDAO.pritln(">>>>>Proceso terminado<<<<<");
	}

	public void almacenarDatos() {
		try {
			System.out.println("Proceso comenzado(alta)");
			if(corroborarDatos()) {
				ventadao = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
				VueloDAO vuelodao = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
				this.venta.getVuelo().setAsientosDisponibles(this.venta.getVuelo().getAsientosDisponibles()-1);
				
				if(ventadao.addVenta(venta)&&vuelodao.updateVuelo(this.venta.getVuelo())) {
					vista.exitoOperacion();
					controllerMP.seleccionVenta();
				}else {
					vista.errorOperacion("No se pudo guardar la venta");
				}
				vista.dispose();
				controllerMP.hacerVisibleMP();
			}
			
		} catch (SQLException e) {
			vista.errorBaseDatos(e.getMessage());

		} 	
		IOGeneralDAO.pritln(">>>>>Proceso terminado<<<<<");
	}

	private boolean corroborarDatos() {
		if(this.venta.getCliente()!=null) {
			if(this.venta.getVuelo()!=null) {
				try {
					this.venta.setTotalPagar(Double.parseDouble(vista.getTextTotalPagar().getText()));
					if(comprobarFechas()) {
						if(this.venta.getVuelo().getAsientosDisponibles()>0) {
							return true;
						}else {
							vista.errorOperacion("El vuelo no posee lugares disponibles");
						}
					}
				}catch(NumberFormatException e) {
					vista.errorOperacion("El valor debe ser un numero decimal");
				}
			}else {
				vista.errorOperacion("Debe seleccionar un vuelo");
			}
		}else {
			vista.errorOperacion("Debe seleccionar un cliente");
		}
		return false;
	}

	private boolean comprobarFechas() {
		if(cumpleañosCliente()&&FechaEmision()&&fechaVencimiento(this.venta.getVuelo().getFechaHoraLlegada())) {
			this.venta.setFechaHoraVenta(new Date());
			return true;
		}
		return false;
	}
	
	private boolean fechaVencimiento(Date fechaHoraLlegada) {
		Date venc = this.venta.getCliente().getPasaporte().getVencimiento();
		venc.setMonth(venc.getMonth()+6);
		if(venc.compareTo(fechaHoraLlegada)==1) {
			return true;
		}
		vista.errorOperacion("El pasaporte del cliente vencerá pronto. No se puede vender el vuelo");
		return false;
	}

	private boolean FechaEmision() {
		Date fecha= new Date();
		if(fecha.compareTo(this.venta.getCliente().getPasaporte().getEmision())==1) {
			return true;
		}
		 vista.errorOperacion("El pasaporte del cliente tiene una fecha de emision invalida");
		return false;
	}

	private boolean cumpleañosCliente() {
		Date fecha= new Date();
		fecha.setYear(fecha.getYear()-18);
		 if(fecha.compareTo(this.venta.getCliente().getFechaNac())==1) {
			 return true;
		 }
		 vista.errorOperacion("El cliente es menor de 18 anios");
		return false;
	}

	public MenuPrincipalControllerTabla getmPController() {
		return controllerMP;
	}

	public void setmPController(MenuPrincipalControllerTabla mPController) {
		this.controllerMP = mPController;
	}
	
		
	
	public void finalizarVentana() {
				vista.dispose();
	}

	public void obtenerValorCuotas() {
		int buscar = Integer.valueOf((String) vista.getComboBox_Cuotas().getSelectedItem());
		try {
		double valor;
		switch(buscar) {
		case 12: 
		case 24: valor = formatearDecimales((Double.parseDouble(vista.getTextValor().getText())*1.1));
		break;
			default: valor = formatearDecimales(Double.parseDouble(vista.getTextValor().getText()));
		}
		this.venta.setCuotas(buscar);
		vista.getTextTotalPagar().setText(String.valueOf(valor));
		}catch(NumberFormatException e) {
			vista.errorOperacion("El valor debe ser un numero decimal");
		}
	}
	public static Double formatearDecimales(Double numero) {
		return Math.round(numero * Math.pow(10, 3)) / Math.pow(10, 3);
		}

	public boolean buscarCliente() {
		ClienteDAO clientedao = ClienteFactory.getClienteDAO("SQL");
		try {
			Cliente buscar = clientedao.readCliente(Integer.parseInt(vista.getTextBuscarDNI().getText()));
			if(buscar!=null) {
				if(vista.seleccionarCliente(buscar)) {
					ingresarDatosCliente(buscar);
					this.venta.setCliente(buscar);
					vista.exitoOperacion();
					return true;
				}else {
					vista.cancelaOperacion();
				}
			}else {
				vista.errorOperacion("No se encontró un cliente con el DNI ingresado");
			}
		} catch (NumberFormatException e) {
			vista.errorOperacion("El id del cliente deben ser numeros");
		} catch (SQLException e) {
			vista.errorBaseDatos(e.getMessage());
		}

		return false;
	}
	
	public void ingresarDatosCliente(Cliente buscar){
		this.vista.getTextNombre().setText(buscar.getNombre());
		this.vista.getTextApellido().setText(buscar.getApellido());
		this.vista.getTextDNI().setText(String.valueOf(buscar.getDNI()));
		this.vista.getTextEmail().setText(buscar.getEmail());
		this.vista.getTextFechaNac().setText(generarTextoFecha(buscar.getFechaNac()));
	}
	

	private String generarTextoFecha(Date fechaNac) {
		if(fechaNac!=null) {
			return fechaNac.getDate()+"-"+(fechaNac.getMonth()+1)+"-"+fechaNac.getYear();
		}
		return "No tiene";
	}
	private String generarTextoFechaHora(Date fecha) {
		if(fecha!=null) {
			return fecha.getDate()+"-"+(fecha.getMonth()+1)+"-"+(fecha.getYear())+"  "+fecha.getHours()+":"+fecha.getMinutes();
		}
		return "No tiene";
	}

	public boolean buscarVuelo() {
		VueloDAO vuelodao = VueloFactory.getVueloDAO("SQL");
		try {
			Vuelo buscar = vuelodao.readVuelo(vista.getTextBuscarVuelo().getText());
			if(buscar!=null) {
				if(vista.seleccionarVuelo(buscar)) {
					ingresarDatosVuelo(buscar);
					vista.exitoOperacion();
					return true;
				}else {
					vista.cancelaOperacion();
					return false;
				}
			}else {
				vista.errorOperacion("No se encontró un vuelo con el ID ingresado");
			}
		} catch (SQLException e) {
			vista.errorBaseDatos(e.getMessage());
		}

		return false;
	}
	public void ingresarDatosVuelo(Vuelo buscar) {
		vista.getTextID_Vuelo().setText(buscar.getId_vuelo());
		vista.getTextAerolinea().setText(buscar.getAerolinea().getNombre());
		vista.getTextAeropuertoSalida().setText(buscar.getAeroSalida().getCiudad());
		vista.getTextAeropuertoLlegada().setText(buscar.getAeroLlegada().getCiudad());
		vista.getTextFechaSalida().setText(generarTextoFechaHora(buscar.getFechaHoraSalida()));
		vista.getTextFechaLlegada().setText(generarTextoFechaHora(buscar.getFechaHoraLlegada()));
		this.venta.setLineaAerea(buscar.getAerolinea());;
		this.venta.setVuelo(buscar);
	}
	

	public void habilitarCuotas() {
		this.venta.setFormaPago("Tarjeta");
		vista.getComboBox_Cuotas().setEnabled(true);
		vista.getTextTotalPagar().setText(vista.getTextValor().getText());
	}
	
	public void asignarDatos(Venta venta) {
		
		if(venta.getFormaPago().equals("Efectivo")) {

			vista.getTextValor().setText(String.valueOf(venta.getTotalPagar()));
			vista.getTextTotalPagar().setText(String.valueOf(venta.getTotalPagar()));
			vista.getRdbtnEfectivo().setSelected(true);
		}
		if(venta.getFormaPago().equals("Tarjeta")) {
			vista.getRdbtnTarjeta().setSelected(true);
			int c = venta.getCuotas();
			if(c==1) {
				vista.getTextValor().setText(String.valueOf(venta.getTotalPagar()));
				vista.getComboBox_Cuotas().setSelectedIndex(0);
			}
			if(c==3) {
				vista.getTextValor().setText(String.valueOf(venta.getTotalPagar()));
				vista.getComboBox_Cuotas().setSelectedIndex(1);
			}
			if(c==6) {
				vista.getTextValor().setText(String.valueOf(venta.getTotalPagar()));
				vista.getComboBox_Cuotas().setSelectedIndex(2);
			}
			if(c==12) {
				vista.getTextValor().setText(String.valueOf((venta.getTotalPagar()/1.1)));
				vista.getComboBox_Cuotas().setSelectedIndex(3);
			}
			if(c==24) {
				vista.getTextValor().setText(String.valueOf(venta.getTotalPagar()/1.1));
				vista.getComboBox_Cuotas().setSelectedIndex(4);
			}
					
		}
//		menu.getTextValor().setText(String.valueOf(venta.getTotalPagar()));
//		menu.getTextTotalPagar().setText(String.valueOf(venta.getTotalPagar()));
//		
//		if(venta.getFormaPago().equals("Tarjeta")) {
//			menu.getRdbtnTarjeta().setSelected(true);
//			menu.getComboBox_Cuotas().setEnabled(true);
//			int c =venta.getCuotas();
//			if(c==1) {
//				menu.getComboBox_Cuotas().setSelectedIndex(0);
//			}
//			if(c==3) {
//				menu.getComboBox_Cuotas().setSelectedIndex(1);
//			}
//			if(c==6) {
//				menu.getComboBox_Cuotas().setSelectedIndex(2);
//			}
//			if(c==12) {
//				menu.getComboBox_Cuotas().setSelectedIndex(3);
//				menu.getTextValor().setText(String.valueOf(venta.getTotalPagar()/1.1));
//			}
//			if(c==24) {
//				menu.getComboBox_Cuotas().setSelectedIndex(4);
//				menu.getTextValor().setText(String.valueOf(venta.getTotalPagar()/1.1));
//			}
//		}
//		if(venta.getFormaPago().equals("Efectivo")){
//			menu.getRdbtnEfectivo().setSelected(true);
//		}
	}
	
	public void cancelarCuotas() {
		this.venta.setFormaPago("Efectivo");
		this.venta.setCuotas(1);
		vista.getComboBox_Cuotas().setEnabled(false);
		vista.getTextTotalPagar().setText(vista.getTextValor().getText());
	}

	public void almacenarDatosMod() {
		try {
			System.out.println("Proceso comenzado(alta)");
			if(corroborarDatosMod()) {
				ventadao = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
				if(ventadao.updateVenta(venta)) {
					vista.exitoOperacion();
				}else {
					vista.errorOperacion("No se pudo guardar la venta");
				}
				vista.dispose();
				controllerMP.hacerVisibleMP();
			}
			
		} catch (SQLException e) {
			vista.errorBaseDatos(e.getMessage());

		} 	
		IOGeneralDAO.pritln(">>>>>Proceso terminado<<<<<");
		
	}

	private boolean corroborarDatosMod() {
		if(this.venta.getCliente()!=null) {
			if(this.venta.getVuelo()!=null) {
				try {
					this.venta.setTotalPagar(Double.parseDouble(vista.getTextTotalPagar().getText()));
					if(comprobarFechas()) {
						return true;
					}
				}catch(NumberFormatException e) {
					this.vista.errorOperacion("El valor debe ser un numero decimal");
				}
			}else {
				this.vista.errorOperacion("Debe seleccionar un vuelo");
			}
		}else {
			this.vista.errorOperacion("Debe seleccionar un cliente");
		}
		return false;
	}

	public void actualizarValor() {
		try {
			Double valor = Double.parseDouble(this.vista.getTextValor().getText());
			if(this.vista.getRdbtnEfectivo().isSelected()) {
				
				this.vista.getTextTotalPagar().setText(String.valueOf(valor));
			}
			if(this.vista.getRdbtnTarjeta().isSelected()) {
				int c = Integer.valueOf((String) this.vista.getComboBox_Cuotas().getSelectedItem());
				if(c==1||c==3||c==6) {
					this.vista.getTextTotalPagar().setText(String.valueOf(valor));
				}
				if(c==12||c==24) {
					this.vista.getTextTotalPagar().setText(String.valueOf((valor*1.1)));
				}
			}
		}catch (NumberFormatException e) {
			try {
				this.vista.errorOperacion("El valor solo debe contener numeros");
				this.vista.getTextValor().getDocument().remove(this.vista.getTextValor().getText().length()-1, 1);
			} catch (BadLocationException e1) {
			}
		}
	}
	
	public void MostrarClientes() {
		this.vista.setVisible(false);
		new Cliente_Mostrar_Controller(this);
	}
	
	public void mostrarVuelos() {
		this.vista.setVisible(false);
		new Vuelo_Mostrar_Controller(this);
	}

	public Venta_Datos_Vista getVista() {
		return vista;
	}

	public void setVista(Venta_Datos_Vista vista) {
		this.vista = vista;
	}
	
}
