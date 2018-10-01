package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.GestionLineaVista;

public class CapturaBtnGestionLinea implements ActionListener{
	GestionLineaVista vista;
	
	
	public CapturaBtnGestionLinea(GestionLineaVista vista) {
		this.vista = vista;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnNuevo())){
			vista.getLineaController().EjecutarOpcionSeleccionada(1);
		} else if(e.getSource().equals(vista.getBtnMod())){
			vista.getLineaController().EjecutarOpcionSeleccionada(2);
		} else if(e.getSource().equals(vista.getBtnBuscar())){
			vista.getLineaController().EjecutarOpcionSeleccionada(3);
		} else if(e.getSource().equals(vista.getBtnEliminar())){
			vista.getLineaController().EjecutarOpcionSeleccionada(4);
		} else if(e.getSource().equals(vista.getBtnVolverAlMenu())){
			vista.getLineaController().EjecutarOpcionSeleccionada(5);
		}
	}

}
