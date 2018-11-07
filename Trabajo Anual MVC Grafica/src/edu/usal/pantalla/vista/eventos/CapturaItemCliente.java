package edu.usal.pantalla.vista.eventos;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.pantalla.vista.Cliente_Datos_Vista;

public class CapturaItemCliente implements ItemListener {
	Cliente_Datos_Vista vista;
	
	
	
	public CapturaItemCliente(Cliente_Datos_Vista vista) {
		super();
		this.vista = vista;
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(vista.getComboBox_Aerolinea())) {
			Integer seleccion=((LineaAerea)(vista.getComboBox_Aerolinea().getSelectedItem())).getAlianza();
			if(seleccion==1) {
				vista.getLbl_Alianza().setText("Skyteam");
			}else if (seleccion==2) {
				vista.getLbl_Alianza().setText("Oneworld");
			}else if (seleccion==3) {
				vista.getLbl_Alianza().setText("Star Alliance");
			}else {
				vista.getLbl_Alianza().setText("");
			}
		}else if(e.getSource().equals(vista.getComboBox_Pais())) {
			Integer seleccion=((Pais)(vista.getComboBox_Pais().getSelectedItem())).getId();
			if(seleccion==9) {
				vista.getComboBox_Provincia().setEnabled(true);
			}else {
				vista.getComboBox_Provincia().setEnabled(false);
			}
			
		}

	}

}
