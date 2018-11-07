package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.Vuelo_All_Vista;

public class CapturaBtnVuelo_All implements ActionListener {

	Vuelo_All_Vista vista;
	
	public CapturaBtnVuelo_All(Vuelo_All_Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnModificar())) {
			int index=vista.getList().getSelectedIndex();
			if(index!=-1) {
				vista.getControl().Modificar(vista.getModelo().getElementAt(index));
				vista.dispose();
			}
		}else if(e.getSource().equals(vista.getBtnEliminar())) {
			int index=vista.getList().getSelectedIndex();
			if(index!=-1) {
				vista.getControl().Eliminar(vista.getModelo().getElementAt(index));
				vista.dispose();
			}
		}else if(e.getSource().equals(vista.getBtnMenuPrincipal())) {
			vista.getControl().getmPController().hacerVisibleMP();
			vista.dispose();
			
		}else if(e.getSource().equals(vista.getBtnMostrarClientes())) {
			int index=vista.getList().getSelectedIndex();
			if(index!=-1) {
				vista.getControl().mostrarClientes(vista.getModelo().getElementAt(index));
			}
		}

	}

}
