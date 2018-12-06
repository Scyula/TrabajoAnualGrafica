package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.mostrar.LineaAerea_Vuelo_Vista;

public class CapturaBtnAeroLinea_Vuelo implements ActionListener {
	LineaAerea_Vuelo_Vista vista;

	public CapturaBtnAeroLinea_Vuelo(LineaAerea_Vuelo_Vista lineaAerea_Vuelo_Vista) {
		this.vista = lineaAerea_Vuelo_Vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnVolver())) {
			vista.getControl().Volver();
		}
		if(e.getSource().equals(vista.getBtnVerPasajeros())) {
			vista.getControl().VerClientes();
		}
	}

}
