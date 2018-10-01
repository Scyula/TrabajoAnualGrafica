package edu.usal.pantalla.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.implementacion.SQL.ClienteDAOImplSQL;
import edu.usal.negocio.dao.implementacion.SQL.LineaAereaDAOImplSQL;
import edu.usal.negocio.dao.implementacion.Stream.LineaAereaDAOImplFileStream;
import edu.usal.negocio.dao.implementacion.String.PaisesDAOImplFileString;
import edu.usal.negocio.dao.implementacion.String.ProvinciasDAOImplFileString;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dao.interfaces.PaisesDAO;
import edu.usal.negocio.dao.interfaces.ProvinciasDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Direccion;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.PasajeroFrecuente;
import edu.usal.negocio.dominio.Pasaporte;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Telefono;
import edu.usal.pantalla.vista.GestionClienteVista;
import edu.usal.pantalla.vista.frames.CartelSeleccionar;
import edu.usal.pantalla.vista.frames.FrameModCliente;
import edu.usal.pantalla.vista.frames.FrameNuevoCliente;
import edu.usal.principal.Principal;
import edu.usal.util.IOGeneral;
import edu.usal.util.PropertiesUtil;

public class GestionClienteController {
	
	GestionClienteVista menu;
	MenuPrincipalController mPController;
	private ClienteDAO clientedao;
	private List<Cliente> clientes;
	
	
	public GestionClienteController(MenuPrincipalController menuPrincipalController) {
		this.mPController= menuPrincipalController;
		this.menu = new GestionClienteVista(this);
	}

	public void EjecutarOpcionSeleccionada(int opc) {
		if(opc==1) {//Nuevo cliente
			menu.getLblCartelSelec().setVisible(false);
			menu.getNuevoCliente().setVisible(true);			
		}else if (opc==2) {//Modificar Cliente
			modificarCliente();
		}else if (opc==3) {//Eliminar Cliente
			
		}else if (opc==4) {//Ver Clientes
			
		}else if (opc==5) {//Volver al Menu Principal
			menu.dispose();
			mPController.hacerVisibleMP();
			
		}
	}
	
	
	public void almacenarDatos(FrameNuevoCliente datos) {
		//System.out.println("Datos recibidos");
		
		if(guardarCliente(datos)) {
			menu.exitoOperacion();
		}else {
			menu.fracasoOperacion();
		}
		menu.getLblCartelSelec().setVisible(true);
		menu.getNuevoCliente().setVisible(false);
		//menu.setNuevoCliente(new FrameNuevoCliente(menu));
		//menu.getNuevoCliente().setBounds(5, 53, 969, 590);
		
		IOGeneral.pritln(">>>>>Proceso OK<<<<<");
	}
	@SuppressWarnings("deprecation")
	private boolean guardarCliente(FrameNuevoCliente datos) {
		clientedao = ClienteFactory.getClienteDAO(Principal.source);
		Cliente cliente = new Cliente();
		cliente.setNombre(datos.getTextNombre().getText());
		cliente.setApellido(datos.getTextApellido().getText());
		cliente.setDNI(Integer.parseInt((datos.getTextDNI().getText())));
		cliente.setCuitcuil(datos.getTextCuit().getText());
		cliente.setEmail(datos.getTextEmail().getText());
		cliente.setFechaNac(new Date(Integer.parseInt((String)datos.getComboBox_FechaNacYYYY().getSelectedItem()), Integer.parseInt((String)datos.getComboBox_FechaNacMM().getSelectedItem()), Integer.parseInt((String)datos.getComboBox_FechaNacDD().getSelectedItem())));
		
		cliente.setTelefono(new Telefono(datos.getTextTelPersonal().getText(), datos.getTextTelCelular().getText(), datos.getTextTelLaboral().getText()));
		
		cliente.setDireccion(obtenerDireccion(datos));
		
		cliente.setPasaporte(obtenerPasaporte(datos));
		
		cliente.setPasajeroFrecuente(obtenerPasajeroFrecuente(datos));
		
		try {
			if(clientedao.addCliente(cliente)) {
				return true;
			}
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		return false;
	}	

	public GestionClienteVista getMenu() {
		return menu;
	}

	public void setMenu(GestionClienteVista menu) {
		this.menu = menu;
	}

	public MenuPrincipalController getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalController mPController) {
		this.mPController = mPController;
	}
	
	private void modificarCliente() {
		
		try {
			clientedao = ClienteFactory.getClienteDAO(Principal.source);
			int dni = menu.solicitarDNI();
			Cliente selec = clientedao.readCliente(dni);
			switch(menu.confirmarSeleccion(selec)) {
				case 0:datosClienteDB(selec);
					break;
				case 1:menu.cancelaOperacion();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void datosClienteDB(Cliente cliente) {
		menu.setModCliente(new FrameModCliente(menu, cliente, cliente.getTelefono(), cliente.getDireccion(), cliente.getPasaporte(),cliente.getPasajeroFrecuente()));
		return;
	}
	
	private Direccion obtenerDireccion(FrameNuevoCliente datos) {
		Direccion direc = new Direccion();
		direc.setPais((Pais)datos.getComboBox_Pais().getSelectedItem());
		if(direc.getPais().getId()==9) {
			direc.setProvincia((Provincia)datos.getComboBox_Provincia().getSelectedItem());
		}
		direc.setCiudad(datos.getTextCiudad().getText());
		direc.setCodPostal(datos.getTextCodPostal().getText());
		direc.setCalle(datos.getTextCalle().getText());
		direc.setAltura(datos.getTextAltura().getText());
		return direc;
	}
	@SuppressWarnings("deprecation")
	private Pasaporte obtenerPasaporte(FrameNuevoCliente datos) {
		Pasaporte pasa = new Pasaporte();
		pasa.setAutoridademision(datos.getTextAutoridadEmision().getText());
		pasa.setNroPasaporte(datos.getTextNroPasaporte().getText());
		pasa.setPais((Pais)datos.getComboBox_PaisEmision().getSelectedItem());
		pasa.setEmision(new Date(Integer.parseInt((String)datos.getComboBox_FechaEmiYYYY().getSelectedItem()), Integer.parseInt((String)datos.getComboBox_FechaEmiMM().getSelectedItem()), Integer.parseInt((String)datos.getComboBox_FechaEmiDD().getSelectedItem())));
		pasa.setVencimiento(new Date(Integer.parseInt((String)datos.getComboBox_FechaVencYYYY().getSelectedItem()), Integer.parseInt((String)datos.getComboBox_FechaVencMM().getSelectedItem()), Integer.parseInt((String)datos.getComboBox_FechaVencDD().getSelectedItem())));
		return pasa;
	}
	private PasajeroFrecuente obtenerPasajeroFrecuente(FrameNuevoCliente datos) {
		return new PasajeroFrecuente(((LineaAerea)datos.getComboBox_Aerolinea().getSelectedItem()).getAlianza(), ((LineaAerea)datos.getComboBox_Aerolinea().getSelectedItem()).getId(), datos.getTextNroPasajero().getText(), datos.getTextCategoria().getText());
	}
	
	public Pais[] obtenerListaPaises() {	
		try {
			PaisesDAO paisesdao = new PaisesDAOImplFileString();
			Hashtable<Integer, String> lista= paisesdao.leerPaises();
			Pais[] modelo = new Pais[(lista.size()+1)];
			modelo[0]= new Pais(-1,"Seleccione un pais");
			for (int i=1; i<lista.size();i++) {
				modelo[i+1]=new Pais(i,lista.get(i));
			}
			modelo[lista.size()] = new Pais(0,lista.get(0));
			return modelo;
		} catch (IOException e) {
			IOGeneral.pritln(">>>>>Ocurrio un error al leer los paises<<<<<");
			IOGeneral.pritln(e.getMessage());
		}		
		return null;
	}

	public Provincia[] obtenerListaProvincias() {
		try {
			ProvinciasDAO provinciasdao = new ProvinciasDAOImplFileString();
			Hashtable<Integer, String> lista= provinciasdao.leerProvincias();
			Provincia[] modelo = new Provincia[(lista.size()+1)];
			modelo[0]= new Provincia(-1,"Seleccione una provincia");
			for (int i=1; i<lista.size();i++) {
				modelo[i+1]=new Provincia(i,lista.get(i));
			}
			modelo[lista.size()] = new Provincia(0,lista.get(0));
			return modelo;
		} catch (IOException e) {
			IOGeneral.pritln(">>>>>Ocurrio un error al leer las provincias<<<<<");
			IOGeneral.pritln(e.getMessage());
		}	
		return null;
	}

	public LineaAerea[] obtenerListaAerolinea() {
		try {
			LineaAereaDAO lineaAerea = new LineaAereaDAOImplSQL();
			LineaAerea[] lista = lineaAerea.primeraLectura();
			LineaAerea[] modelo = new LineaAerea[lista.length+1];
			modelo[0]= new LineaAerea();
			modelo[0].setNombre("Seleccione una aerolinea");
			for (int i=1; i<lista.length;i++) {
				modelo[i+1]= lista[i];
			}
			return modelo;
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Ocurrio un error al leer las aerolineas de la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		return null;
		
		
	}
	
	
}
