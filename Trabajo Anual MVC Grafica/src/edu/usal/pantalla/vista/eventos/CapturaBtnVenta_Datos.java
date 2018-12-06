package edu.usal.pantalla.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.pantalla.vista.datos.Venta_Datos_Vista;

public class CapturaBtnVenta_Datos implements ActionListener {

	Venta_Datos_Vista vista;
	
	public CapturaBtnVenta_Datos(Venta_Datos_Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnGuardar())) {
			vista.getController().almacenarDatos();
		}
		
		if(e.getSource().equals(vista.getBtnCancelar())) {
			vista.getController().getmPController().hacerVisibleMP();
			vista.getController().finalizarVentana();
		}
		
		if(e.getSource().equals(vista.getBtnBuscarCliente())) {
			vista.getController().buscarCliente();
		}
		
		if(e.getSource().equals(vista.getBtnBuscarVuelo())) {
			vista.getController().buscarVuelo();
		}
		
		if (e.getSource().equals(vista.getBtnGuardarMod())) {
			vista.getController().almacenarDatosMod();
		}

		if(e.getSource().equals(vista.getTextValor())) {
			vista.getController().actualizarValor();
		}
		
		if(e.getSource().equals(vista.getBtnVerClientes())) {
			vista.getController().MostrarClientes();
		}
		
		if(e.getSource().equals(vista.getBtnVerVuelos())) {
			vista.getController().mostrarVuelos();
		}
		
	}

}
