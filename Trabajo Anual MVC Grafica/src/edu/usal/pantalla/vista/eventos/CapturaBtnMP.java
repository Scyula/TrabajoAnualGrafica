package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.GestionClienteVista;
import edu.usal.pantalla.vista.MenuPrincipalVista;

public class CapturaBtnMP implements ActionListener {
	MenuPrincipalVista vista;
	GestionClienteVista menuCliente;
	
	public CapturaBtnMP(MenuPrincipalVista vista) {
		this.vista = vista;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnClientes())){
			vista.getMpController().EjecutarSubmenu(1);
			
		} else if(e.getSource().equals(vista.getBtnLineasAereas())){
			
		} else if(e.getSource().equals(vista.getBtnVenta())){
			
		} else if(e.getSource().equals(vista.getBtnVuelos())){
			
		} else if(e.getSource().equals(vista.getBtnSalir())){
			
		}
	}

}
