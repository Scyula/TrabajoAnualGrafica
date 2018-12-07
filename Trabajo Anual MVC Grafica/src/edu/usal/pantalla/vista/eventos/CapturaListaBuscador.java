package edu.usal.pantalla.vista.eventos;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import edu.usal.pantalla.vista.MenuPrincipalVista__Tabla;

public class CapturaListaBuscador implements ItemListener {

	MenuPrincipalVista__Tabla vista;
	
	public CapturaListaBuscador(MenuPrincipalVista__Tabla menuPrincipalVista__Tabla) {
		this.vista = menuPrincipalVista__Tabla;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(vista.getComboBox_Busqueda())) {
			
			vista.getMpController().campoBusqueda();
			
		}
		
	}

}
