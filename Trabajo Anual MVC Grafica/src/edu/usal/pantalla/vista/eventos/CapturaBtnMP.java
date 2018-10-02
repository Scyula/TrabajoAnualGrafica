package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.MenuPrincipalVista;

public class CapturaBtnMP implements ActionListener {
	MenuPrincipalVista vista;
	
	public CapturaBtnMP(MenuPrincipalVista vista) {
		this.vista = vista;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtn_Cliente_Nuevo())){
			vista.getMpController().EjecutarSubmenuCliente(1);
		} else if(e.getSource().equals(vista.getBtn_Cliente_Ver())){
			vista.getMpController().EjecutarSubmenuCliente(2);
		}
				
		
		if(e.getSource().equals(vista.getBtnSalir())){
			vista.getMpController().Salir();
		}
				
				
	}

}
