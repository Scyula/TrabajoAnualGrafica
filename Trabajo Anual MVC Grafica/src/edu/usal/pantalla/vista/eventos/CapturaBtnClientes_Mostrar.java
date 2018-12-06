package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.mostrar.Cliente_Mostrar_Vista;

public class CapturaBtnClientes_Mostrar implements ActionListener {

	Cliente_Mostrar_Vista vista;
	
	public CapturaBtnClientes_Mostrar(Cliente_Mostrar_Vista cliente_Mostrar_Vista) {
		this.vista=cliente_Mostrar_Vista;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnSeleccionar())){
			vista.getController().seleccionar();
		}
		if(e.getSource().equals(vista.getBtnVolver())) {
			vista.getController().volver();
		}

	}

}
