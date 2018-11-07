package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.Vuelo_Datos_Vista;

public class CapturaBtnVuelo_Datos implements ActionListener {

	Vuelo_Datos_Vista vista;
	
	public CapturaBtnVuelo_Datos(Vuelo_Datos_Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnGuardar())) {
			vista.getController().almacenarDatos(vista);
			vista.getController().finalizarVentana();
		}else if(e.getSource().equals(vista.getBtnCancelar())) {
			vista.getController().getmPController().hacerVisibleMP();
			vista.getController().finalizarVentana();
		}else if(e.getSource().equals(vista.getBtnGuardarMod())) {
			vista.getController().updateDatos(vista);
			vista.getController().finalizarVentana();
		}

	}

}
