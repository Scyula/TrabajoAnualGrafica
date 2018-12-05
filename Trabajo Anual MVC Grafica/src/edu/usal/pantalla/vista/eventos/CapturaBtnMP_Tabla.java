package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.controller.OperacionesController;
import edu.usal.pantalla.vista.MenuPrincipalVista__Tabla;

public class CapturaBtnMP_Tabla implements ActionListener {
	MenuPrincipalVista__Tabla vista;
	
	public CapturaBtnMP_Tabla(MenuPrincipalVista__Tabla vista) {
		this.vista = vista;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(vista.getBtnClientes())) {
				vista.getMpController().seleccionClientes();
			}
			if(e.getSource().equals(vista.getBtnAerolineas())) {
				vista.getMpController().seleccionAerolinea();
			}
			if(e.getSource().equals(vista.getBtnVuelos())) {
				vista.getMpController().seleccionVuelos();
			}
			if(e.getSource().equals(vista.getBtnVenta())) {
				vista.getMpController().seleccionVenta();
			}
			
			
			
			
			if(e.getSource().equals(vista.getBtnAddCliente())) {
				vista.getMpController().nuevoCliente();
			}
			if(e.getSource().equals(vista.getBtnModCliente())) {
				vista.getMpController().modCliente();
			}
			if(e.getSource().equals(vista.getBtnDelCliente())) {
				vista.getMpController().delCliente();
			}
			
			
			if(e.getSource().equals(vista.getBtnAddAerolinea())) {
				vista.getMpController().nuevoAerolinea();
			}
			if(e.getSource().equals(vista.getBtnModAerolinea())) {
				vista.getMpController().modAerolinea();
			}
			if(e.getSource().equals(vista.getBtnDelAerolinea())) {
				vista.getMpController().delAerolinea();
			}
			if(e.getSource().equals(vista.getBtnVerVuelos())) {
				vista.getMpController().verVuelosAerolinea();
			}

			
			
			if(e.getSource().equals(vista.getBtnAddVuelo())) {
				vista.getMpController().nuevoVuelo();
			}
			if(e.getSource().equals(vista.getBtnModVuelo())) {
				vista.getMpController().modVuelo();
			}
			if(e.getSource().equals(vista.getBtnDelVuelo())) {
				vista.getMpController().delVuelo();
			}
			if(e.getSource().equals(vista.getBtnVerClientes())) {
				vista.getMpController().verClientesVuelo();
			}
			
			
			
			
			if(e.getSource().equals(vista.getBtnAddVenta())) {
				vista.getMpController().nuevoVenta();
			}
			if(e.getSource().equals(vista.getBtnModVenta())) {
				vista.getMpController().modVenta();
			}
			if(e.getSource().equals(vista.getBtnDelVenta())) {
				vista.getMpController().delVenta();
			}
			
	}

}
