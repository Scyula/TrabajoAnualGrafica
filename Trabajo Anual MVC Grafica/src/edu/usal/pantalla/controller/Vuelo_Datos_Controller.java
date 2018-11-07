package edu.usal.pantalla.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.ComboBoxModel;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.negocio.dominio.Direccion;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.PasajeroFrecuente;
import edu.usal.negocio.dominio.Pasaporte;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Telefono;
import edu.usal.pantalla.vista.Cliente_Datos_Vista;
import edu.usal.pantalla.vista.Vuelo_Datos_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneral;

public class Vuelo_Datos_Controller {
	Vuelo_Datos_Vista menu;
	MenuPrincipalController mPController;
	private VueloDAO vuelodao;
	
	public Vuelo_Datos_Controller(MenuPrincipalController menuPrincipalController) {
		this.mPController= menuPrincipalController;
		menu = new Vuelo_Datos_Vista(this);
	}
	
	public Vuelo_Datos_Controller(MenuPrincipalController menuPrincipalController, Vuelo vuelo) {
		this.mPController= menuPrincipalController;
		menu = new Vuelo_Datos_Vista(this , vuelo);
		
	}

	public void updateDatos(Vuelo_Datos_Vista datos) {
		System.out.println("Datos recibidos(update)");
		vuelodao = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
		Vuelo vuelo = new Vuelo();
		vuelo = this.leerVuelo(datos);
		try {
			if(vuelodao.updateVuelo(vuelo)) {
				menu.exitoOperacion();
			}else {
				menu.fracasoOperacion();
			}
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		} finally {
			menu.dispose();
			mPController.hacerVisibleMP();
		}
		IOGeneral.pritln(">>>>>Proceso terminado<<<<<");
	}

	public void almacenarDatos(Vuelo_Datos_Vista datos) {
		System.out.println("Datos recibidos(alta)");
		vuelodao = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
		Vuelo vuelo = new Vuelo();
		vuelo = this.leerVuelo(datos);
		try {
			if(vuelodao.addVuelo(vuelo)) {
				menu.exitoOperacion();
			}else {
				menu.fracasoOperacion();
			}
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		} finally {
			menu.dispose();
			mPController.hacerVisibleMP();
		}
		IOGeneral.pritln(">>>>>Proceso terminado<<<<<");
	}

	public MenuPrincipalController getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalController mPController) {
		this.mPController = mPController;
	}
	
	private Vuelo leerVuelo(Vuelo_Datos_Vista datos) {
		Vuelo vuelo = new Vuelo();
		vuelo.setAerolinea((LineaAerea)datos.getComboBox_Aerolinea().getSelectedItem());
		vuelo.setCantAsientos(Integer.valueOf(datos.getTextCantAsientos().getText()));
		vuelo.setAeroSalida(obtenerAeroSalida(datos));
		vuelo.setAeroLlegada(obtenerAeroLlegada(datos));
		vuelo.setFechaHoraSalida(datos.getFechaSalida().getDate());
		vuelo.setFechaHoraLlegada(datos.getFechaLlegada().getDate());
		vuelo.setTiempoVuelo(datos.getTextTiempoVuelo().getText());
		
		return vuelo;
	}
	
/*	
	private Direccion obtenerDireccion(Cliente_Datos_Vista datos) {
		Direccion direc = new Direccion();
		direc.setPais((Pais)datos.getComboBox_Pais().getSelectedItem());
		if(direc.getPais().getId()==9) {
			direc.setProvincia((Provincia)datos.getComboBox_Provincia().getSelectedItem());
		}else {
			direc.setProvincia(new Provincia(-1, ""));
		}
		direc.setCiudad(datos.getTextCiudad().getText());
		direc.setCodPostal(datos.getTextCodPostal().getText());
		direc.setCalle(datos.getTextCalle().getText());
		direc.setAltura(datos.getTextAltura().getText());
		return direc;
	}*/
/*	private Pasaporte obtenerPasaporte(Cliente_Datos_Vista datos) {
		Pasaporte pasa = new Pasaporte();
		pasa.setAutoridademision(datos.getTextAutoridadEmision().getText());
		pasa.setNroPasaporte(datos.getTextNroPasaporte().getText());
		pasa.setPais((Pais)datos.getComboBox_PaisEmision().getSelectedItem());
		pasa.setEmision(datos.getEmisionPasaport().getDate());
		pasa.setVencimiento(datos.getVencPasaport().getDate());
		return pasa;
	}*/
	/*private PasajeroFrecuente obtenerPasajeroFrecuente(Cliente_Datos_Vista datos) {
		return new PasajeroFrecuente(((LineaAerea)datos.getComboBox_Aerolinea().getSelectedItem()).getAlianza(), 
				((LineaAerea)datos.getComboBox_Aerolinea().getSelectedItem()).getId(), 
				datos.getTextNroPasajero().getText(), datos.getTextCategoria().getText());
	}*/
	
	public Pais[] obtenerListaPaises() {	
		Hashtable<Integer, String> lista= DatosEstaticos.getPaises();
		Pais[] modelo = new Pais[(lista.size()+1)];
		modelo[0]= new Pais(-1,"Seleccione un pais");
		for (int i=1; i<lista.size();i++) {
			modelo[i]=new Pais(i,lista.get(i));
		}
		modelo[lista.size()] = new Pais(0,lista.get(0));
		return modelo;
	}

	public Provincia[] obtenerListaProvincias() {
		Hashtable<Integer, String> lista= DatosEstaticos.getProvincias();
		Provincia[] modelo = new Provincia[(lista.size()+1)];
		modelo[0]= new Provincia(-1,"Seleccione una provincia");
		for (int i=1; i<lista.size();i++) {
			modelo[i]=new Provincia(i,lista.get(i));
		}
		modelo[lista.size()] = new Provincia(0,lista.get(0));
		return modelo;
}
	
/*	public Aeropuerto[] obtenerListaAeropuertos(Vuelo_Datos_Vista datos) {
		List<Aeropuerto> lista= DatosEstaticos.getAeropuertos();
		Aeropuerto[] modelo = new Aeropuerto[(lista.size()+1)];
		int i=0;
		modelo[i]= new Aeropuerto();
		modelo[i].setPais((Pais)datos.getComboBox_Pais().getSelectedItem());
		modelo[i].setProvincia((Provincia)datos.getComboBox_Provincia().getSelectedItem());
		modelo[i].setCiudad("Seleccione una Ciudad");

		for (i=1;i<lista.size();i++) {
			modelo[i]=lista.get(i-1);
		}
		modelo[i]=lista.get(i-1);
		return modelo;
}*/


	public LineaAerea[] obtenerListaAerolinea() {
		/*LineaAerea[] lista = DatosEstaticos.getAerolineas();
		LineaAerea[] modelo = new LineaAerea[lista.length+1];
		modelo[0]= new LineaAerea();
		modelo[0].setNombre("Seleccione una aerolinea");
		for (int i=1; i<lista.length;i++) {
			modelo[i+1]= lista[i];
		}
		return modelo;*/
		ArrayList<LineaAerea> lista= DatosEstaticos.getAerolineas();
		LineaAerea[] modelo = new LineaAerea[(lista.size()+1)];
		int i=0;
		modelo[i]= new LineaAerea();
		modelo[i].setNombre("Seleccione una Aerolinea");
		for (i=1;i<lista.size();i++) {
			modelo[i]=lista.get(i-1);
		}
		modelo[i]=lista.get(i-1);
		return modelo;
	}
	public void finalizarVentana() {
				menu.dispose();
	}

	public int obtenerIndexPais(ComboBoxModel<Pais> comboBoxModel, Vuelo v) {
		Pais buscar = v.getAeroSalida().getPais();
		for (int i=1; i<comboBoxModel.getSize();i++) {
			if(comboBoxModel.getElementAt(i).getId()==buscar.getId()) {
				return i;
			}
		}
		return -1;
	}

	public int obtenerIndexProvincia(ComboBoxModel<Provincia> comboBoxModel, Vuelo v) {
		Provincia buscar = v.getAeroSalida().getProvincia();
		for (int i=1; i<comboBoxModel.getSize();i++) {
			if(comboBoxModel.getElementAt(i).getId()==buscar.getId()) {
				return i;
			}
		}
		return -1;
	}

	public int obtenerIndexPaisEmision(ComboBoxModel<Pais> comboBoxModel, Vuelo v) {
		Pais buscar = v.getAeroSalida().getPais();
		for (int i=1; i<comboBoxModel.getSize();i++) {
			if(comboBoxModel.getElementAt(i).getId()==buscar.getId()) {
				return i;
			}
		}
		return -1;
	}

	public int obtenerIndexAerolinea(ComboBoxModel<LineaAerea> comboBoxModel, Vuelo v) {
		int buscar = v.getAerolinea().getId();
		for (int i=1; i<comboBoxModel.getSize();i++) {
			if(comboBoxModel.getElementAt(i).getId()==buscar) {
				return i;
			}
		}
		return -1;
	}

	public String alianza(int alianza) {
		if(alianza==1) {
			return "Skyteam";
		}else if (alianza==2) {
			return "Oneworld";
		}else if (alianza==3) {
			return "Star Alliance";
		}else {
			return "";
		}
	}
	
	private Aeropuerto obtenerAeroLlegada(Vuelo_Datos_Vista datos) {
		Aeropuerto aero = new Aeropuerto();
		aero.setCiudad(datos.getTextCiudadLlegada().getText());
		aero.setProvincia((Provincia)datos.getComboBox_ProvinciaLlegada().getSelectedItem());
		aero.setPais((Pais)datos.getComboBox_PaisLlegada().getSelectedItem());
		return aero;
	}
	
	private Aeropuerto obtenerAeroSalida(Vuelo_Datos_Vista datos) {
		Aeropuerto aero = new Aeropuerto();
		aero.setCiudad(datos.getTextCiudadSalida().getText());
		aero.setProvincia((Provincia)datos.getComboBox_ProvinciaSalida().getSelectedItem());
		aero.setPais((Pais)datos.getComboBox_PaisSalida().getSelectedItem());
		return aero;
	}
	
}
