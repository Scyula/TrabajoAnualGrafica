package edu.usal.pantalla.controller.datos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.swing.ComboBoxModel;

import edu.usal.negocio.dao.factory.AeropuertoFactory;
import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.AeropuertoDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.pantalla.controller.MenuPrincipalControllerTabla;
import edu.usal.pantalla.vista.datos.Vuelo_Datos_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneralDAO;
@SuppressWarnings("deprecation")

public class Vuelo_Datos_Controller {
	Vuelo_Datos_Vista menu;
	MenuPrincipalControllerTabla mPController;
	private Vuelo vuelo;
	private VueloDAO vuelodao;
	private boolean cargaCorrecta = true;
	
	public Vuelo_Datos_Controller(MenuPrincipalControllerTabla menuPrincipalController) {
		this.mPController= menuPrincipalController;
		menu = new Vuelo_Datos_Vista(this);
	}
	
	public Vuelo_Datos_Controller(MenuPrincipalControllerTabla menuPrincipalController, Vuelo vuelo) {
		this.vuelo = vuelo;
		this.mPController= menuPrincipalController;
		menu = new Vuelo_Datos_Vista(this , vuelo);
		
	}

	public void updateDatos(Vuelo_Datos_Vista datos) {
		vuelodao = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
		Vuelo vuelo = new Vuelo();
		if(this.corroborarDatos()) {
			vuelo = this.leerVueloUpdate(datos);
			vuelo.setId_vuelo(this.vuelo.getId_vuelo());
			try {
				if(vuelodao.updateVuelo(vuelo)) {
					menu.exitoOperacion();
					mPController.seleccionVuelos();
				}else {
					menu.fracasoOperacion();
				}
			} catch (SQLException e) {
				IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			}
			menu.dispose();
			mPController.hacerVisibleMP();
		}
	}

	public void almacenarDatos(Vuelo_Datos_Vista datos) {
		vuelodao = VueloFactory.getVueloDAO(DatosEstaticos.getSource());
		Vuelo vuelo = new Vuelo();
		if(this.corroborarDatos()) {
			vuelo = this.leerVuelo(datos);
			try {
				if(vuelodao.addVuelo(vuelo)) {
					menu.exitoOperacion();
					mPController.seleccionVuelos();
				}else {
					menu.fracasoOperacion();
				}
			} catch (SQLException e) {
				IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			}
			menu.dispose();
			mPController.hacerVisibleMP();
		}
	}

	private boolean corroborarDatos() {
		boolean resultado = true;
		String error = "";
		if(this.menu.getComboBox_Aerolinea().getSelectedIndex()==0) {
			error = error + "\nDebe seleccionar una aerolinea";
			resultado = false;
		}
		if(this.menu.getComboBox_AeropuertoSalida().getSelectedIndex()==0) {
			error = error + "\nDebe seleccionar un aeropuerto de salida";
			resultado = false;
		}
		if(this.menu.getComboBox_AeropuertoLlegada().getSelectedIndex()==0) {
			error = error + "\nDebe seleccionar un aeropuerto de llegada";
			resultado = false;
		}
		if(this.menu.getDateSalida().getDate() == null) {
			error = error + "\nDebe seleccionar una fecha de llegada";
			resultado = false;
		}
		if(this.menu.getDateLlegada().getDate() == null) {
			error = error + "\nDebe seleccionar una fecha de llegada";
			resultado = false;
		}
		try{
			Integer.valueOf(this.menu.getTextCantidadAsientos().getText());
		}catch (NumberFormatException e) {
			error = error + "\nDebe ingresar un numero entero en la cantidad de asientos";
			resultado = false;
		}
		if(this.menu.getTextTiempoVuelo().getText().isEmpty()) {
			error = error + "\nDebe ingresar un tiempo de vuelo";
			resultado = false;
		}else {
			char[] aux = this.menu.getTextTiempoVuelo().getText().toCharArray();
			boolean aprobado = false;
			for (int i = 0; i < aux.length; i++) {
				if(Character.isAlphabetic(aux[i])||Character.isDigit(aux[i])) {
					aprobado = true;
				}
			}
			if(!aprobado) {
				error = error + "\nTiempo de vuelo ingresado no valido";
			}
		}
		if(!resultado) {			
			this.menu.errorOperacion(error);
		}
		return resultado;
	}

	public MenuPrincipalControllerTabla getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalControllerTabla mPController) {
		this.mPController = mPController;
	}
	
	private Vuelo leerVueloUpdate(Vuelo_Datos_Vista datos) {
		Vuelo vuelo = new Vuelo();
		vuelo.setId_vuelo(this.vuelo.getId_vuelo());
		vuelo.setAerolinea((LineaAerea)datos.getComboBox_Aerolinea().getSelectedItem());
		vuelo.setCantAsientos(Integer.parseInt(datos.getTextCantidadAsientos().getText()));
		vuelo.setAeroSalida((Aeropuerto)datos.getComboBox_AeropuertoSalida().getSelectedItem());
		vuelo.setAeroLlegada((Aeropuerto)datos.getComboBox_AeropuertoLlegada().getSelectedItem());
		vuelo.setFechaHoraSalida(obtenerFechaSalida(datos));
		vuelo.setFechaHoraLlegada(obtenerFechaLlegada(datos));
		vuelo.setTiempoVuelo(datos.getTextTiempoVuelo().getText());
		vuelo.setAsientosDisponibles(vuelo.getCantAsientos()-this.vuelo.getCantAsientos()+this.vuelo.getAsientosDisponibles());
		return vuelo;
	}
	private Vuelo leerVuelo(Vuelo_Datos_Vista datos) {
		Vuelo vuelo = new Vuelo();
		vuelo.setAerolinea((LineaAerea)datos.getComboBox_Aerolinea().getSelectedItem());
		vuelo.setCantAsientos(Integer.parseInt(datos.getTextCantidadAsientos().getText()));
		vuelo.setAeroSalida((Aeropuerto)datos.getComboBox_AeropuertoSalida().getSelectedItem());
		vuelo.setAeroLlegada((Aeropuerto)datos.getComboBox_AeropuertoLlegada().getSelectedItem());
		vuelo.setFechaHoraSalida(obtenerFechaSalida(datos));
		vuelo.setFechaHoraLlegada(obtenerFechaLlegada(datos));
		vuelo.setTiempoVuelo(datos.getTextTiempoVuelo().getText());
		vuelo.setAsientosDisponibles(vuelo.getCantAsientos());
		return vuelo;
	}
		
private Date obtenerFechaLlegada(Vuelo_Datos_Vista datos) {
		Date fecha = new Date();
		fecha= datos.getDateLlegada().getDate();
		fecha.setHours(datos.getComboBox_HoraLlegada().getSelectedIndex());
		fecha.setMinutes(datos.getComboBox_MinutosLlegada().getSelectedIndex());
		return fecha;
	}

private Date obtenerFechaSalida(Vuelo_Datos_Vista datos) {
		Date fecha = new Date();
		fecha= datos.getDateSalida().getDate();
		fecha.setHours(datos.getComboBox_HoraSalida().getSelectedIndex());
		fecha.setMinutes(datos.getComboBox_MinutosSalida().getSelectedIndex());
		return fecha;
	}

	
	public Pais[] obtenerListaPaises() {	
		Hashtable<Integer, String> lista= DatosEstaticos.getPaises();
		if(lista.isEmpty()) {
			this.cargaCorrecta=false;
		}
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
		if(lista.isEmpty()) {
			this.cargaCorrecta=false;
		}
		Provincia[] modelo = new Provincia[(lista.size()+1)];
		modelo[0]= new Provincia(-1,"Seleccione una provincia");
		for (int i=1; i<lista.size();i++) {
			modelo[i]=new Provincia(i,lista.get(i));
		}
		modelo[lista.size()] = new Provincia(0,lista.get(0));
		return modelo;
}

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
		if(lista.size()>0) {
		modelo[i]=lista.get(i-1);
		}
		return modelo;
	}
	
	public void finalizarVentana() {
				menu.dispose();
	}

	public Aeropuerto[] obtenerListaAeropuerto() {
		try {
		AeropuertoDAO aerodao = AeropuertoFactory.getAeropuertoDAO(DatosEstaticos.getSource());
		List<Aeropuerto> lista = aerodao.getAllAeropuerto();
		if(lista.isEmpty()) {
			this.cargaCorrecta=false;
		}
		Aeropuerto[] modelo = new Aeropuerto[(lista.size()+1)];
		int i=0;
		modelo[i]= new Aeropuerto();
		modelo[i].setCiudad("Seleccione un Aeropuerto");
		for (i=1;i<lista.size();i++) {
			modelo[i]=lista.get(i-1);
		}
		if(lista.size()>0) {
			modelo[i]=lista.get(i-1);
		}
		return modelo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
	
	public int obtenerIndexAeropuerto(ComboBoxModel<Aeropuerto> comboBoxModel, Aeropuerto aeropuerto) {
		String buscar = aeropuerto.getIdAeropuerto();
		for (int i=1; i<comboBoxModel.getSize();i++) {
			if(comboBoxModel.getElementAt(i).getIdAeropuerto().equalsIgnoreCase(buscar)) {
				return i;
			}
		}
		return -1;
	}

	public void corroboraCarga() {
		if(this.cargaCorrecta == false) {
			this.menu.dispose();
			this.menu.errorCarga();
			this.mPController.hacerVisibleMP();
		}
		
	}
	
	
}
