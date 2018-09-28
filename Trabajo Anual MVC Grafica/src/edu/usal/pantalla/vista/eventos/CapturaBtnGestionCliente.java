package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.*;

public class CapturaBtnGestionCliente implements ActionListener {
	GestionClienteVista vista;
	
	
	public CapturaBtnGestionCliente(GestionClienteVista vista) {
		this.vista = vista;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnNuevo())){
			vista.getClienteController().EjecutarOpcionSeleccionada(1);
		} else if(e.getSource().equals(vista.getBtnMod())){
			vista.getClienteController().EjecutarOpcionSeleccionada(2);
		} else if(e.getSource().equals(vista.getBtnBuscar())){
			vista.getClienteController().EjecutarOpcionSeleccionada(3);
		} else if(e.getSource().equals(vista.getBtnEliminar())){
			vista.getClienteController().EjecutarOpcionSeleccionada(4);
		} else if(e.getSource().equals(vista.getBtnVolverAlMenu())){
			vista.getClienteController().EjecutarOpcionSeleccionada(5);
		}
	}

}
