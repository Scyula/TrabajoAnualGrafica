package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.datos.LineaAerea_Datos_Vista;

public class CapturaBtnLineaAerea_Datos implements ActionListener {

	LineaAerea_Datos_Vista vista;
	
	public CapturaBtnLineaAerea_Datos(LineaAerea_Datos_Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnGuardar())) {
			vista.getControl().guardarDatos();
		}else if(e.getSource().equals(vista.getBtnCancelar())) {
			vista.getControl().getmPController().hacerVisibleMP();
			vista.getControl().cerrarVentana();
		}else if(e.getSource().equals(vista.getBtnGuardarMod())) {
			vista.getControl().updateDatos();
		}

	}

}
