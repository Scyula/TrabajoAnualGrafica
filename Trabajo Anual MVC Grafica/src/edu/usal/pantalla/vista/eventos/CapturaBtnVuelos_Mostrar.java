package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.mostrar.Vuelo_Mostrar_Vista;

public class CapturaBtnVuelos_Mostrar implements ActionListener {

	Vuelo_Mostrar_Vista vista;
	
	public CapturaBtnVuelos_Mostrar(Vuelo_Mostrar_Vista vuelo_Mostrar_Vista) {
		this.vista=vuelo_Mostrar_Vista;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnSeleccionar())){
			vista.getController().seleccionar();
		}
		if(e.getSource().equals(vista.getBtnVolver())) {
			vista.getController().volver();
		}

	}

}
