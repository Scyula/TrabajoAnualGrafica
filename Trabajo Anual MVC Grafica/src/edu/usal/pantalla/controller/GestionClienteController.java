package edu.usal.pantalla.controller;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.implementacion.SQL.ClienteDAOImplSQL;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.pantalla.vista.GestionClienteVista;
import edu.usal.pantalla.vista.frames.FrameNuevoCliente;
import edu.usal.principal.Ejecutar;
import edu.usal.util.IOGeneral;

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
		clientedao = ClienteFactory.getClienteDAO(Ejecutar.source);
		Cliente cliente = new Cliente();
		cliente.setNombre(datos.getTextNombre().getText());
		cliente.setApellido(datos.getTextApellido().getText());
		cliente.setDNI(Integer.parseInt((datos.getTextDNI().getText())));
		cliente.setCuitcuil(datos.getTextCuit().getText());
		cliente.setEmail(datos.getTextEmail().getText());
		cliente.setFechaNac(new GregorianCalendar(Integer.parseInt(datos.getTextFechaAAAA().getText()),
				Integer.parseInt(datos.getTextFechaMM().getText()), Integer.parseInt(datos.getTextFechaDD().getText())));
		Cliente asd = new Cliente();
		asd.setDNI(123);
		try {
			if(clientedao.addCliente(cliente)) {
				menu.exitoOperacion();
			}else {
				menu.fracasoOperacion();
			}
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Error con la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		menu.getLblCartelSelec().setVisible(true);
		menu.getNuevoCliente().setVisible(false);
		
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
		int dni = menu.solicitarDNI();
		Cliente selec = new Cliente();
		selec.setApellido("Castro");
		selec.setNombre("Agustin");
		selec.setDNI(40648652);
		switch(menu.confirmarSeleccion(selec)) {
			case 0:datosClienteDB(selec);
				break;
			case 1:menu.cancelaOperacion();
		}
		
	}
	
	private void datosClienteDB(Cliente cliente) {
		//menu.setModCliente(new FrameModCliente(menu, cliente, telefono, direccion, pasaporte, pasajero));
		return;
	}
	
	
	
}
