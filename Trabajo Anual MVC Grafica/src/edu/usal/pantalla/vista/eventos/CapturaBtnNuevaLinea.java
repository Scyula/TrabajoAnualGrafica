package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.controller.GestionLineaController;
import edu.usal.pantalla.vista.frames.FrameNuevaLinea;

public class CapturaBtnNuevaLinea implements ActionListener {
	GestionLineaController control;
	FrameNuevaLinea frame;
	
	
	public CapturaBtnNuevaLinea(FrameNuevaLinea frame) {
		this.frame = frame;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getBtnGuardar())) {
			frame.getVista().getLineaController().almacenarDatos(frame);
		}
	}
}
