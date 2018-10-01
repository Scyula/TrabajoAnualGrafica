package edu.usal.pantalla.vista.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.usal.pantalla.vista.GestionClienteVista;
import edu.usal.pantalla.vista.GestionLineaVista;
import edu.usal.pantalla.vista.eventos.CapturaBtnNuevaLinea;
import edu.usal.pantalla.vista.eventos.CapturaBtnNuevoCliente;

public class FrameNuevaLinea extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GestionLineaVista vista;
	
	private JLabel lblNombre;
	private JLabel lblAlianza;
	private JTextField textNombre;
	private JTextField textAlianza;
	private JLabel lblDatosdeLinea;
	private JButton btnGuardar;
	
	
	public FrameNuevaLinea(GestionLineaVista vista) {
		this.vista = vista;
		
		
		setBounds(5, 53, 969, 590);
		this.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(431, 89, 73, 16);
		this.add(lblNombre);
		
		lblAlianza = new JLabel("Alianza");
		lblAlianza.setBounds(437, 164, 82, 16);
		this.add(lblAlianza);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(353, 55, 208, 22);
		this.add(textNombre);
		
		textAlianza = new JTextField();
		textAlianza.setColumns(10);
		textAlianza.setBounds(353, 130, 208, 22);
		this.add(textAlianza);
		
		lblDatosdeLinea = new JLabel("Datos de la Linea");
		lblDatosdeLinea.setBounds(24, 12, 221, 16);
		this.add(lblDatosdeLinea);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new CapturaBtnNuevaLinea(this));
		btnGuardar.setBounds(406, 464, 98, 26);
		this.add(btnGuardar);
		this.setVisible(false);
		
	}


	public JTextField getTextNombre() {
		return textNombre;
	}


	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}


	public JTextField getTextAlianza() {
		return textAlianza;
	}


	public void setTextAlianza(JTextField textAlianza) {
		this.textAlianza = textAlianza;
	}


	public JButton getBtnGuardar() {
		return btnGuardar;
	}


	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}


	public GestionLineaVista getVista() {
		return vista;
	}


	public void setVista(GestionLineaVista vista) {
		this.vista = vista;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
