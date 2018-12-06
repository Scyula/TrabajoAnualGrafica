package edu.usal.pantalla.vista.eventos;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import edu.usal.pantalla.vista.Venta_Datos_Vista;

public class CapturaItemVenta implements ItemListener {
	Venta_Datos_Vista vista;
	
	
	
	public CapturaItemVenta(Venta_Datos_Vista vista) {
		super();
		this.vista = vista;
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(vista.getComboBox_Cuotas())) {
			vista.getController().obtenerValorCuotas();
		}else if(e.getSource().equals(vista.getRdbtnEfectivo())) {
			vista.getController().cancelarCuotas();
		}else if(e.getSource().equals(vista.getRdbtnTarjeta())) {
			vista.getController().habilitarCuotas();
		}

	}

}
