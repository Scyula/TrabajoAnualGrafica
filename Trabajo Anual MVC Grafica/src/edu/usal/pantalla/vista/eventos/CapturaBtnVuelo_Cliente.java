package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.mostrar.Vuelo_Cliente_Vista;

public class CapturaBtnVuelo_Cliente implements ActionListener {

	Vuelo_Cliente_Vista vista;
	
	public CapturaBtnVuelo_Cliente(Vuelo_Cliente_Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnVolver())) {
			vista.getControl().Volver(vista);
		}

	}

}
