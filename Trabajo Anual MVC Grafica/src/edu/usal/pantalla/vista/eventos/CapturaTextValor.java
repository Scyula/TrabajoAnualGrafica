package edu.usal.pantalla.vista.eventos;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.usal.pantalla.vista.datos.Venta_Datos_Vista;

public class CapturaTextValor implements DocumentListener {

	Venta_Datos_Vista vista;
		
	public CapturaTextValor(Venta_Datos_Vista vista) {
		super();
		this.vista = vista;
	}
	
	 private void assistText(Venta_Datos_Vista pantalla) {
         Runnable doAssist = new Runnable() {
             @Override
             public void run() {
         		pantalla.getController().actualizarValor();
             }
         };
         SwingUtilities.invokeLater(doAssist);
     }
	

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		this.assistText(this.vista);
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		this.assistText(this.vista);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		this.assistText(this.vista);
	}

}
