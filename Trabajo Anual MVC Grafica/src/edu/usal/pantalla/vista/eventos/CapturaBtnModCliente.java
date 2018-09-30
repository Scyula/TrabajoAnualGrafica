package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.frames.FrameModCliente;

public class CapturaBtnModCliente implements ActionListener {
	FrameModCliente vista;

	public CapturaBtnModCliente(FrameModCliente vista) {
		super();
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnGuardar())) {
			vista.getVista().getClienteController().EjecutarOpcionSeleccionada(2);
		}
	}

}
