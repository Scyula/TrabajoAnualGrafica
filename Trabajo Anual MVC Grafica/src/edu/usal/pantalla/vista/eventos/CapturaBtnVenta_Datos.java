package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.Cliente_Datos_Vista;
import edu.usal.pantalla.vista.Venta_Datos_Vista;

public class CapturaBtnVenta_Datos implements ActionListener {

	Venta_Datos_Vista vista;
	
	public CapturaBtnVenta_Datos(Venta_Datos_Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnGuardar())) {
			vista.getController().almacenarDatos();
		}else if(e.getSource().equals(vista.getBtnCancelar())) {
			vista.getController().getmPController().hacerVisibleMP();
			vista.getController().finalizarVentana();
		}else if(e.getSource().equals(vista.getBtnBuscarCliente())) {
			vista.getController().buscarCliente();
		}else if(e.getSource().equals(vista.getBtnBuscarVuelo())) {
			vista.getController().buscarVuelo();
		}else if (e.getSource().equals(vista.getBtnGuardarMod())) {
			vista.getController().almacenarDatosMod();
		}else if(e.getSource().equals(vista.getTextValor())) {
			vista.getController().actualizarValor();
		}

	}

}
