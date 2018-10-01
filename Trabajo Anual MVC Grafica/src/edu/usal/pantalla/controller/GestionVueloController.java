package edu.usal.pantalla.controller;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.vista.GestionClienteVista;
import edu.usal.pantalla.vista.GestionVueloVista;
import edu.usal.pantalla.vista.frames.FrameNuevoCliente;
import edu.usal.pantalla.vista.frames.FrameNuevoVuelo;
import edu.usal.principal.Ejecutar;
import edu.usal.principal.Principal;
import edu.usal.util.IOGeneral;

public class GestionVueloController {


	GestionVueloVista menu;
	MenuPrincipalController mPController;
	private VueloDAO vuelodao;
	private List<Vuelo> vuelos;
	
	
	public GestionVueloController(MenuPrincipalController menuPrincipalController) {
		this.mPController= menuPrincipalController;
		this.menu = new GestionVueloVista(this);
	}

	public void EjecutarOpcionSeleccionada(int opc) {
		if(opc==1) {//Nuevo cliente
			menu.getLblCartelSelec().setVisible(false);
			menu.getNuevoVuelo().setVisible(true);
			
		}else if (opc==2) {//Modificar Vuelo
			modificarVuelo();
		}else if (opc==3) {//Eliminar Vuelo
			
		}else if (opc==4) {//Ver Vuelo
			
		}else if (opc==5) {//Volver al Menu Principal
			menu.dispose();
			mPController.hacerVisibleMP();
			
		}
	}
	
	public void almacenarDatos(FrameNuevoVuelo datos) {
		//System.out.println("Datos recibidos");
		vuelodao = VueloFactory.getVueloDAO(Principal.source);
		Vuelo vuelo = new Vuelo();
		vuelo.setNombreAerolinea(datos.getTextNombre().getText());
		/*
		cliente.setApellido(datos.getTextApellido().getText());
		cliente.setDNI(Integer.parseInt((datos.getTextDNI().getText())));
		cliente.setCuitcuil(datos.getTextCuit().getText());
		cliente.setEmail(datos.getTextEmail().getText());
		vuelo.setFechaHoraLlegada(new GregorianCalendar(Integer.parseInt(datos.getTextFechaAAAA().getText()),
				Integer.parseInt(datos.getTextFechaMM().getText()), Integer.parseInt(datos.getTextFechaDD().getText())));
		cliente.setFechaNac(new GregorianCalendar(Integer.parseInt(datos.getTextFechaAAAA().getText()),
				Integer.parseInt(datos.getTextFechaMM().getText()), Integer.parseInt(datos.getTextFechaDD().getText())));
				*/
				
		Vuelo asd = new Vuelo();
		asd.setID(123);
		try {
			if(vuelodao.addVuelo(vuelo)) {
				menu.exitoOperacion();
			}else {
				menu.fracasoOperacion();
			}
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		menu.getLblCartelSelec().setVisible(true);
		menu.getNuevoVuelo().setVisible(false);
		
	}

	public GestionVueloVista getMenu() {
		return menu;
	}

	public void setMenu(GestionVueloVista menu) {
		this.menu = menu;
	}

	public MenuPrincipalController getmPController() {
		return mPController;
	}

	public void setmPController(MenuPrincipalController mPController) {
		this.mPController = mPController;
	}
	
	private void modificarVuelo() {
		int dni = menu.solicitarID();
		Vuelo selec = new Vuelo();
		/*
		selec.setApellido("Castro");
		selec.setNombre("Agustin");
		selec.setDNI(40648652);
		switch(menu.confirmarSeleccion(selec)) {
			case 0:datosClienteDB(selec);
				break;
			case 1:menu.cancelaOperacion();
		
		}
	*/
		
	}
	
	private void datosVueloDB(Vuelo vuelo) {
		//menu.setModVuelo(new FrameModVuelo(menu, ......));
		return;
	}
	
}
