package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.controller.GestionClienteController;
import edu.usal.pantalla.vista.*;
import edu.usal.pantalla.vista.frames.FrameNuevoCliente;

public class CapturaBtnNuevoCliente implements ActionListener {
	GestionClienteController control;
	FrameNuevoCliente frame;
	
	
	public CapturaBtnNuevoCliente(FrameNuevoCliente frame) {
		this.frame = frame;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getBtnGuardar())) {
			frame.getVista().getClienteController().almacenarDatos(frame);
		}
	}

}
