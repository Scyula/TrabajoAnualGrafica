package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.GestionVueloVista;

public class CapturaBtnGestionVuelo implements ActionListener{
	
	GestionVueloVista vista;
	
	
	public CapturaBtnGestionVuelo(GestionVueloVista vista) {
		this.vista = vista;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnNuevo())){
			vista.getVueloController().EjecutarOpcionSeleccionada(1);
		} else if(e.getSource().equals(vista.getBtnMod())){
			vista.getVueloController().EjecutarOpcionSeleccionada(2);
		} else if(e.getSource().equals(vista.getBtnBuscar())){
			vista.getVueloController().EjecutarOpcionSeleccionada(3);
		} else if(e.getSource().equals(vista.getBtnEliminar())){
			vista.getVueloController().EjecutarOpcionSeleccionada(4);
		} else if(e.getSource().equals(vista.getBtnVolverAlMenu())){
			vista.getVueloController().EjecutarOpcionSeleccionada(5);
		}
	}

}
