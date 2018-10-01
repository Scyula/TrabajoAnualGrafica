package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.usal.pantalla.controller.GestionLineaController;
import edu.usal.pantalla.vista.frames.FrameModLinea;

public class CapturaBtnModLinea implements ActionListener{

	GestionLineaController control;
	FrameModLinea frame;
	
	
	public CapturaBtnModLinea(FrameModLinea frame) {
		this.frame = frame;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getBtnAceptar())&& e.getSource().equals(frame.getComboBoxLinea())) {
			frame.getVista().getLineaController().modificarLinea();
		}
		else {
			if(e.getSource().equals(frame.getBtnAceptar())) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar una Linea Aerea", "", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
