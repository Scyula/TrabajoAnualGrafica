package edu.usal.pantalla.controller;

import java.sql.SQLException;
import java.util.Date;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.factory.VentaFactory;
import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Venta;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.vista.Venta_Datos_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneral;

@SuppressWarnings("deprecation")
public class Venta_Datos_Controller {
		
	Venta_Datos_Vista menu;
	MenuPrincipalControllerTabla mPController;
	private VentaDAO ventadao;
	private Venta venta; 
	
	public Venta_Datos_Controller(MenuPrincipalControllerTabla menuPrincipalController) {
		this.venta = new Venta();
		this.mPController= menuPrincipalController;
		this.menu = new Venta_Datos_Vista(this);
	}
	
	public Venta_Datos_Controller(MenuPrincipalControllerTabla menuPrincipalController, Venta modificar) {
		this.venta=modificar;
		this.mPController= menuPrincipalController;
		this.menu = new Venta_Datos_Vista(this , modificar);
		this.menu.cargarDatos(modificar);
	}

	public void updateDatos(Venta_Datos_Vista datos) {
		try {
			System.out.println("Proceso comenzado(alta)");
			if(corroborarDatos()) {
				ventadao = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
				if(ventadao.updateVenta(venta)) {
					menu.exitoOperacion();
				}else {
					menu.errorOperacion("No se pudo guardar la venta");
				}
				menu.dispose();
				mPController.hacerVisibleMP();
			}
			
		} catch (SQLException e) {
			menu.errorBaseDatos(e.getMessage());

		} 	
		IOGeneral.pritln(">>>>>Proceso terminado<<<<<");
	}

	public void almacenarDatos() {
		try {
			System.out.println("Proceso comenzado(alta)");
			if(corroborarDatos()) {
				ventadao = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
				VueloDAO vuelodao = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
				this.venta.getVuelo().setAsientosDisponibles(this.venta.getVuelo().getAsientosDisponibles()-1);
				
				if(ventadao.addVenta(venta)&&vuelodao.updateVuelo(this.venta.getVuelo())) {
					menu.exitoOperacion();
				}else {
					menu.errorOperacion("No se pudo guardar la venta");
				}
				menu.dispose();
				mPController.hacerVisibleMP();
			}
			
		} catch (SQLException e) {
			menu.errorBaseDatos(e.getMessage());

		} 	
		IOGeneral.pritln(">>>>>Proceso terminado<<<<<");
	}

	private boolean corroborarDatos() {
		if(this.venta.getCliente()!=null) {
			if(this.venta.getVuelo()!=null) {
				try {
					this.venta.setTotalPagar(Double.parseDouble(menu.getTextTotalPagar().getText()));
					if(comprobarFechas()) {
						if(this.venta.getVuelo().getAsientosDisponibles()>0) {
							return true;
						}else {
							menu.errorOperacion("El vuelo no posee lugares disponibles");
						}
					}
				}catch(NumberFormatException e) {
					menu.errorOperacion("El valor debe ser un numero decimal");
				}
			}else {
				menu.errorOperacion("Debe seleccionar un vuelo");
			}
		}else {
			menu.errorOperacion("Debe seleccionar un cliente");
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
		menu.errorOperacion("El pasaporte del cliente vencerá pronto. No se puede vender el vuelo");
		return false;
	}

	private boolean FechaEmision() {
		Date fecha= new Date();
		if(fecha.compareTo(this.venta.getCliente().getPasaporte().getEmision())==1) {
			return true;
		}
		 menu.errorOperacion("El pasaporte del cliente tiene una fecha de emision invalida");
		return false;
	}

	private boolean cumpleañosCliente() {
		Date fecha= new Date();
		fecha.setYear(fecha.getYear()-18);
		 if(fecha.compareTo(this.venta.getCliente().getFechaNac())==1) {
			 return true;
		 }
		 menu.errorOperacion("El cliente es menor de 18 anios");
		return false;
	}

	public MenuPrincipalControllerTabla getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalControllerTabla mPController) {
		this.mPController = mPController;
	}
	
		
	
	public void finalizarVentana() {
				menu.dispose();
	}

	public void obtenerValorCuotas() {
		int buscar = Integer.valueOf((String) menu.getComboBox_Cuotas().getSelectedItem());
		try {
		double valor;
		switch(buscar) {
		case 12: 
		case 24: valor = formatearDecimales((Double.parseDouble(menu.getTextValor().getText())*1.1));
		break;
			default: valor = formatearDecimales(Double.parseDouble(menu.getTextValor().getText()));
		}
		this.venta.setCuotas(buscar);
		menu.getTextTotalPagar().setText(String.valueOf(valor));
		}catch(NumberFormatException e) {
			menu.errorOperacion("El valor debe ser un numero decimal");
		}
	}
	public static Double formatearDecimales(Double numero) {
		return Math.round(numero * Math.pow(10, 3)) / Math.pow(10, 3);
		}

	public void buscarCliente() {
		ClienteDAO clientedao = ClienteFactory.getClienteDAO("SQL");
		try {
			Cliente buscar = clientedao.readCliente(Integer.parseInt(menu.getTextBuscarDNI().getText()));
			if(buscar!=null) {
				if(menu.seleccionarCliente(buscar)) {
					ingresarDatosCliente(buscar);
					this.venta.setCliente(buscar);
					menu.exitoOperacion();
				}else {
					menu.cancelaOperacion();
				}
			}else {
				menu.errorOperacion("No se encontró un cliente con el DNI ingresado");
			}
		} catch (NumberFormatException e) {
			menu.errorOperacion("El id del cliente deben ser numeros");
		} catch (SQLException e) {
			menu.errorBaseDatos(e.getMessage());
		}
	}
	
	public void ingresarDatosCliente(Cliente buscar){
		this.menu.getTextNombre().setText(buscar.getNombre());
		this.menu.getTextApellido().setText(buscar.getApellido());
		this.menu.getTextDNI().setText(String.valueOf(buscar.getDNI()));
		this.menu.getTextEmail().setText(buscar.getEmail());
		this.menu.getTextFechaNac().setText(generarTextoFecha(buscar.getFechaNac()));
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

	public void buscarVuelo() {
		VueloDAO vuelodao = VueloFactory.getVueloDAO("SQL");
		try {
			Vuelo buscar = vuelodao.readVuelo(menu.getTextBuscarVuelo().getText());
			if(buscar!=null) {
				if(menu.seleccionarVuelo(buscar)) {
					ingresarDatosVuelo(buscar);
					menu.exitoOperacion();
				}else {
					menu.cancelaOperacion();
				}
			}
		} catch (SQLException e) {
			menu.errorBaseDatos(e.getMessage());
		}
		
	}
	public void ingresarDatosVuelo(Vuelo buscar) {
		menu.getTextID_Vuelo().setText(buscar.getId_vuelo());
		menu.getTextAerolinea().setText(buscar.getAerolinea().getNombre());
		menu.getTextAeropuertoSalida().setText(buscar.getAeroSalida().getCiudad());
		menu.getTextAeropuertoLlegada().setText(buscar.getAeroLlegada().getCiudad());
		menu.getTextFechaSalida().setText(generarTextoFechaHora(buscar.getFechaHoraSalida()));
		menu.getTextFechaLlegada().setText(generarTextoFechaHora(buscar.getFechaHoraLlegada()));
		this.venta.setLineaAerea(buscar.getAerolinea());;
		this.venta.setVuelo(buscar);
	}
	

	public void habilitarCuotas() {
		this.venta.setFormaPago("Tarjeta");
		menu.getComboBox_Cuotas().setEnabled(true);
		menu.getTextTotalPagar().setText(menu.getTextValor().getText());
	}
	
	public void asignarDatos(Venta venta) {
		
		if(venta.getFormaPago().equals("Efectivo")) {

			menu.getTextValor().setText(String.valueOf(venta.getTotalPagar()));
			menu.getTextTotalPagar().setText(String.valueOf(venta.getTotalPagar()));
			menu.getRdbtnEfectivo().setSelected(true);
		}
		if(venta.getFormaPago().equals("Tarjeta")) {
			menu.getRdbtnTarjeta().setSelected(true);
			int c = venta.getCuotas();
			if(c==1) {
				menu.getTextValor().setText(String.valueOf(venta.getTotalPagar()));
				menu.getComboBox_Cuotas().setSelectedIndex(0);
			}
			if(c==3) {
				menu.getTextValor().setText(String.valueOf(venta.getTotalPagar()));
				menu.getComboBox_Cuotas().setSelectedIndex(1);
			}
			if(c==6) {
				menu.getTextValor().setText(String.valueOf(venta.getTotalPagar()));
				menu.getComboBox_Cuotas().setSelectedIndex(2);
			}
			if(c==12) {
				menu.getTextValor().setText(String.valueOf((venta.getTotalPagar()/1.1)));
				menu.getComboBox_Cuotas().setSelectedIndex(3);
			}
			if(c==24) {
				menu.getTextValor().setText(String.valueOf(venta.getTotalPagar()/1.1));
				menu.getComboBox_Cuotas().setSelectedIndex(4);
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
		menu.getComboBox_Cuotas().setEnabled(false);
		menu.getTextTotalPagar().setText(menu.getTextValor().getText());
	}

	public void almacenarDatosMod() {
		try {
			System.out.println("Proceso comenzado(alta)");
			if(corroborarDatosMod()) {
				ventadao = VentaFactory.getVentaDAO(DatosEstaticos.getSource());
				if(ventadao.updateVenta(venta)) {
					menu.exitoOperacion();
				}else {
					menu.errorOperacion("No se pudo guardar la venta");
				}
				menu.dispose();
				mPController.hacerVisibleMP();
			}
			
		} catch (SQLException e) {
			menu.errorBaseDatos(e.getMessage());

		} 	
		IOGeneral.pritln(">>>>>Proceso terminado<<<<<");
		
	}

	private boolean corroborarDatosMod() {
		if(this.venta.getCliente()!=null) {
			if(this.venta.getVuelo()!=null) {
				try {
					this.venta.setTotalPagar(Double.parseDouble(menu.getTextTotalPagar().getText()));
					if(comprobarFechas()) {
						return true;
					}
				}catch(NumberFormatException e) {
					menu.errorOperacion("El valor debe ser un numero decimal");
				}
			}else {
				menu.errorOperacion("Debe seleccionar un vuelo");
			}
		}else {
			menu.errorOperacion("Debe seleccionar un cliente");
		}
		return false;
	}

	public void actualizarValor() {
		try {
			Double valor = (Double.parseDouble(menu.getTextValor().getText()));
		if(menu.getRdbtnEfectivo().isSelected()) {
			
			menu.getTextTotalPagar().setText(String.valueOf(valor));
		}
		if(menu.getRdbtnTarjeta().isSelected()) {
			int c = Integer.valueOf((String) menu.getComboBox_Cuotas().getSelectedItem());
			if(c==1||c==3||c==6) {
				menu.getTextValor().setText(String.valueOf(venta.getTotalPagar()));
			}
			if(c==12||c==24) {
				menu.getTextValor().setText(String.valueOf((venta.getTotalPagar()*1.1)));
			}
		}
		}catch (NumberFormatException e) {
			menu.errorOperacion("El valor solo debe contener numeros");
		}
		
	}
	
}
