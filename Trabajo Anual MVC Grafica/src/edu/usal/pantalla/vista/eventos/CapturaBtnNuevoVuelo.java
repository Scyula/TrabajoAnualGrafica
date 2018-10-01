package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.controller.GestionClienteController;
import edu.usal.pantalla.controller.GestionVueloController;
import edu.usal.pantalla.vista.frames.FrameNuevoCliente;
import edu.usal.pantalla.vista.frames.FrameNuevoVuelo;

public class CapturaBtnNuevoVuelo implements ActionListener {

	GestionVueloController control;
	FrameNuevoVuelo frame;
	
	
	public CapturaBtnNuevoVuelo(FrameNuevoVuelo frame) {
		this.frame = frame;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getBtnGuardar())) {
			frame.getVista().getVueloController().almacenarDatos(frame);
		}
	}
}
