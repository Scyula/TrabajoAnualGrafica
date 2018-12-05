package edu.usal.pantalla.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
