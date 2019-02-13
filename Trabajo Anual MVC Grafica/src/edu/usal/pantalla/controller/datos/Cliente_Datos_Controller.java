package edu.usal.pantalla.controller.datos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ComboBoxModel;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Direccion;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.PasajeroFrecuente;
import edu.usal.negocio.dominio.Pasaporte;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Telefono;
import edu.usal.pantalla.controller.MenuPrincipalControllerTabla;
import edu.usal.pantalla.vista.datos.Cliente_Datos_Vista;
import edu.usal.util.DatosEstaticos;
import edu.usal.util.IOGeneralDAO;

public class Cliente_Datos_Controller {
		
	Cliente_Datos_Vista menu;
	MenuPrincipalControllerTabla mPController;
	private ClienteDAO clientedao;
	private boolean cargaCorrecta = true;
	
	public Cliente_Datos_Controller(MenuPrincipalControllerTabla menuPrincipalControllerTabla) {
		this.mPController= menuPrincipalControllerTabla;
		menu = new Cliente_Datos_Vista(this);
		this.corroboraCarga();
	}
	
	public Cliente_Datos_Controller(MenuPrincipalControllerTabla menuPrincipalController, Cliente cliente) {
		this.mPController= menuPrincipalController;
		menu = new Cliente_Datos_Vista(this , cliente);
	}

	public void updateDatos(Cliente_Datos_Vista datos) {
		if(corroborarDatos()) {			
			clientedao = ClienteFactory.getClienteDAO(DatosEstaticos.getSource());
			Cliente cliente = new Cliente();
			cliente = this.leerCliente(datos);
			try {
				if(clientedao.updateCliente(cliente)) {
					menu.exitoOperacion();
					mPController.seleccionClientes();
				}else {
					menu.fracasoOperacion();
				}
			} catch (SQLException e) {
				IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			} finally {
				mPController.hacerVisibleMP();
			}
		}
	}
	
	private boolean corroborarDatos() {
		boolean resultado = true;
		String error = "";
		if(this.menu.getComboBox_Aerolinea().getSelectedIndex()==0) {
			error = error + "\nDebe seleccionar una aerolinea";
			resultado = false;
		}
		if(this.menu.getComboBox_Pais().getSelectedIndex()==0) {
			error = error + "\nDebe seleccionar un pais en la direccion";
			resultado = false;
		}
		if(this.menu.getComboBox_Provincia().getSelectedIndex() == 0 && this.menu.getComboBox_Pais().getSelectedIndex() == 9) {
			error = error + "\nDebe seleccionar una provincia en la direccion";
			resultado = false;
		}
		if(this.menu.getComboBox_PaisEmision().getSelectedIndex()==0) {
			error = error + "\nDebe seleccionar un pais de emision del pasaporte";
			resultado = false;
		}
		if(this.menu.getFechaNacimiento().getDate() == null) {
			error = error + "\nDebe ingresar una fecha de nacimiento";
			resultado = false;
		}
		if(this.menu.getEmisionPasaport().getDate() == null) {
			error = error + "\nDebe ingresar una fecha de emision del pasaporte";
			resultado = false;
		}
		if(this.menu.getVencPasaport().getDate() == null) {
			error = error + "\nDebe ingresar una fecha de vencimiento del pasaporte";
			resultado = false;
		}
		try{
			Integer.valueOf(this.menu.getTextDNI().getText());
		}catch (NumberFormatException e) {
			error = error + "\nEl DNI deben ser solo numeros";
			resultado = false;
		}
		try{
			Integer.valueOf(this.menu.getTextCuit().getText());
		}catch (NumberFormatException e) {
			error = error + "\nEl CUIT deben ser solo numeros";
			resultado = false;
		}
		if(this.menu.getTextNombre().getText().isEmpty()) {
			error = error + "\nDebe ingresar el nombre del cliente";
			resultado = false;
		}else {
			char[] aux = this.menu.getTextNombre().getText().toCharArray();
			boolean aprobado = false;
			for (int i = 0; i < aux.length; i++) {
				if(Character.isAlphabetic(aux[i])) {
					aprobado = true;
				}
			}
			if(!aprobado) {
				error = error + "\nNombre del cliente no valido";
			}
		}
		if(this.menu.getTextApellido().getText().isEmpty()) {
			error = error + "\nDebe ingresar el Apellido del cliente";
			resultado = false;
		}else {
			char[] aux = this.menu.getTextApellido().getText().toCharArray();
			boolean aprobado = false;
			for (int i = 0; i < aux.length; i++) {
				if(Character.isAlphabetic(aux[i])) {
					aprobado = true;
				}
			}
			if(!aprobado) {
				error = error + "\nApellido del cliente no valido";
			}
		}
		if(this.menu.getTextEmail().getText().isEmpty()) {
			error = error + "\nDebe ingresar el e-mail del cliente";
			resultado = false;
		}else {
			char[] aux = this.menu.getTextEmail().getText().toCharArray();
			boolean aprobado = false;
			for (int i = 0; i < aux.length; i++) {
				if(Character.isAlphabetic(aux[i])) {
					aprobado = true;
				}
			}
			if(!aprobado) {
				error = error + "\nE-mail del cliente no valido";
			}
		}
		if(this.menu.getTextCiudad().getText().isEmpty()) {
			error = error + "\nDebe ingresar una ciudad en direccion";
			resultado = false;
		}else {
			char[] aux = this.menu.getTextCiudad().getText().toCharArray();
			boolean aprobado = false;
			for (int i = 0; i < aux.length; i++) {
				if(Character.isAlphabetic(aux[i])) {
					aprobado = true;
				}
			}
			if(!aprobado) {
				error = error + "\nCiudad ingresada no valida";
			}
		}
		if(this.menu.getTextCodPostal().getText().isEmpty()) {
			error = error + "\nDebe ingresar el codigo postal de la direccion";
			resultado = false;
		}else {
			char[] aux = this.menu.getTextCodPostal().getText().toCharArray();
			boolean aprobado = false;
			for (int i = 0; i < aux.length; i++) {
				if(Character.isAlphabetic(aux[i]) || Character.isDigit(aux[i])) {
					aprobado = true;
				}
			}
			if(!aprobado) {
				error = error + "\nCodigo postal ingresado no valido";
			}
		}
		if(this.menu.getTextCalle().getText().isEmpty()) {
			error = error + "\nDebe ingresar la calle de la direccion";
			resultado = false;
		}else {
			char[] aux = this.menu.getTextCalle().getText().toCharArray();
			boolean aprobado = false;
			for (int i = 0; i < aux.length; i++) {
				if(Character.isAlphabetic(aux[i])) {
					aprobado = true;
				}
			}
			if(!aprobado) {
				error = error + "\nCalle ingresada no valida";
			}
		}
		if(this.menu.getTextAltura().getText().isEmpty()) {
			error = error + "\nDebe ingresar la altura de la calle";
			resultado = false;
		}else {
			char[] aux = this.menu.getTextAltura().getText().toCharArray();
			boolean aprobado = false;
			for (int i = 0; i < aux.length; i++) {
				if(Character.isAlphabetic(aux[i]) || Character.isDigit(aux[i])) {
					aprobado = true;
				}
			}
			if(!aprobado) {
				error = error + "\nAltura de calle ingresada no valida";
			}
		}
		try{
			Integer.valueOf(this.menu.getTextNroPasaporte().getText());
		}catch (NumberFormatException e) {
			error = error + "\nEl numero de pasaporte debe ser solo numeros";
			resultado = false;
		}
		if(this.menu.getTextAutoridadEmision().getText().isEmpty()) {
			error = error + "\nDebe ingresar una autoridad de emision";
			resultado = false;
		}else {
			char[] aux = this.menu.getTextAutoridadEmision().getText().toCharArray();
			boolean aprobado = false;
			for (int i = 0; i < aux.length; i++) {
				if(Character.isAlphabetic(aux[i])) {
					aprobado = true;
				}
			}
			if(!aprobado) {
				error = error + "\nAutoridad de emision ingresada no valida";
			}
		}
		if(!resultado) {			
			this.menu.errorOperacion(error);
		}
		return resultado;
	}

	public void almacenarDatos(Cliente_Datos_Vista datos) {
		if(corroborarDatos()) {			
			clientedao = ClienteFactory.getClienteDAO(DatosEstaticos.getSource());
			Cliente cliente = new Cliente();
			cliente = this.leerCliente(datos);
			try {
				if(clientedao.addCliente(cliente)) {
					menu.exitoOperacion();
					mPController.seleccionClientes();
				}else {
					menu.fracasoOperacion();
				}
			} catch (SQLException e) {
				IOGeneralDAO.pritln(">>>>>Error con la base de datos<<<<<");
				IOGeneralDAO.pritln(e.getMessage());
			} finally {
				mPController.hacerVisibleMP();
			}
		}
	}

	public MenuPrincipalControllerTabla getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalControllerTabla mPController) {
		this.mPController = mPController;
	}
	
	private Cliente leerCliente(Cliente_Datos_Vista datos) {
		Cliente cliente = new Cliente();
		cliente.setNombre(datos.getTextNombre().getText());
		cliente.setApellido(datos.getTextApellido().getText());
		cliente.setDNI(Integer.parseInt((datos.getTextDNI().getText())));
		cliente.setCuitcuil(datos.getTextCuit().getText());
		cliente.setEmail(datos.getTextEmail().getText());
		cliente.setFechaNac(datos.getFechaNacimiento().getDate());
		
		cliente.setTelefono(new Telefono(datos.getTextTelPersonal().getText(), datos.getTextTelCelular().getText(), datos.getTextTelLaboral().getText()));
		
		cliente.setDireccion(obtenerDireccion(datos));
		
		cliente.setPasaporte(obtenerPasaporte(datos));
		
		cliente.setPasajeroFrecuente(obtenerPasajeroFrecuente(datos));
		return cliente;
	}
	
	
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
	}
	private Pasaporte obtenerPasaporte(Cliente_Datos_Vista datos) {
		Pasaporte pasa = new Pasaporte();
		pasa.setAutoridademision(datos.getTextAutoridadEmision().getText());
		pasa.setNroPasaporte(datos.getTextNroPasaporte().getText());
		pasa.setPais((Pais)datos.getComboBox_PaisEmision().getSelectedItem());
		pasa.setEmision(datos.getEmisionPasaport().getDate());
		pasa.setVencimiento(datos.getVencPasaport().getDate());
		return pasa;
	}
	private PasajeroFrecuente obtenerPasajeroFrecuente(Cliente_Datos_Vista datos) {
		return new PasajeroFrecuente(((LineaAerea)datos.getComboBox_Aerolinea().getSelectedItem()).getAlianza(), 
				((LineaAerea)datos.getComboBox_Aerolinea().getSelectedItem()).getId(), 
				datos.getTextNroPasajero().getText(), datos.getTextCategoria().getText());
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
		if(lista.isEmpty()) {
			//this.cargaCorrecta=false;
		}
		LineaAerea[] modelo = new LineaAerea[(lista.size()+1)];
		int i=0;
		modelo[i]= new LineaAerea();
		modelo[i].setNombre("Seleccione una Aerolinea");
		for (i=1;i<lista.size();i++) {
			modelo[i]=lista.get(i-1);
		}
		if(!lista.isEmpty()) {
			modelo[i]=lista.get(i-1);
		}
		return modelo;
	}
	public void finalizarVentana() {
				menu.dispose();
	}

	public int obtenerIndexPais(ComboBoxModel<Pais> comboBoxModel, Cliente c) {
		Pais buscar = c.getDireccion().getPais();
		for (int i=1; i<comboBoxModel.getSize();i++) {
			if(comboBoxModel.getElementAt(i).getId()==buscar.getId()) {
				return i;
			}
		}
		return -1;
	}

	public int obtenerIndexProvincia(ComboBoxModel<Provincia> comboBoxModel, Cliente c) {
		Provincia buscar = c.getDireccion().getProvincia();
		for (int i=1; i<comboBoxModel.getSize();i++) {
			if(comboBoxModel.getElementAt(i).getId()==buscar.getId()) {
				return i;
			}
		}
		return -1;
	}

	public int obtenerIndexPaisEmision(ComboBoxModel<Pais> comboBoxModel, Cliente c) {
		Pais buscar = c.getPasaporte().getPais();
		for (int i=1; i<comboBoxModel.getSize();i++) {
			if(comboBoxModel.getElementAt(i).getId()==buscar.getId()) {
				return i;
			}
		}
		return -1;
	}

	public int obtenerIndexAerolinea(ComboBoxModel<LineaAerea> comboBoxModel, Cliente c) {
		int buscar = c.getPasajeroFrecuente().getAerolinea();
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

	public void corroboraCarga() {
		if(this.cargaCorrecta == false) {
			this.menu.dispose();
			this.menu.errorCarga();
			this.mPController.hacerVisibleMP();
		}
		
	}
	
}
