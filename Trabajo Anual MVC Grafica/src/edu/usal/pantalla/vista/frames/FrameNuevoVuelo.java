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
import edu.usal.pantalla.vista.GestionVueloVista;
import edu.usal.pantalla.vista.eventos.CapturaBtnNuevoCliente;
import edu.usal.pantalla.vista.eventos.CapturaBtnNuevoVuelo;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class FrameNuevoVuelo extends JPanel {

private static final long serialVersionUID = 1L;
	
	private GestionVueloVista vista;
	
	private JLabel lblCantAsientos;
	private JLabel lblID;
	private JLabel lblaeroSalida;
	private JTextField textNombre;
	private JTextField textID;
	private JTextField txtDiaSalida;
	private JTextField txtMesSalida;
	private JTextField txtAnioSalida;
	private JTextField txtDiaLlegada;
	private JTextField txtMesLlegada;
	private JTextField txtAnioLlegada;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JLabel label_19;
	private JLabel label_23;
	private JLabel lblDatosBasicos;
	private JTextField txtHoraSalida;
	private JTextField txtHoraLlegada;
	private JButton btnGuardar;
	
	
	public FrameNuevoVuelo(GestionVueloVista vista) {
		this.vista = vista;
		
		
		setBounds(5, 53, 969, 590);
		this.setLayout(null);
		
		lblCantAsientos = new JLabel("Cantidad de Asientos");
		lblCantAsientos.setBounds(196, 211, 139, 16);
		this.add(lblCantAsientos);
		
		lblID = new JLabel("ID");
		lblID.setBounds(241, 106, 126, 16);
		this.add(lblID);
		
		lblaeroSalida = new JLabel("Aeropuerto de Salida");
		lblaeroSalida.setBounds(196, 276, 139, 16);
		this.add(lblaeroSalida);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(159, 188, 208, 22);
		this.add(textNombre);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(159, 84, 208, 22);
		this.add(textID);
		
		JLabel lblFechaSalida = new JLabel("Fecha de Salida");
		lblFechaSalida.setBounds(420, 276, 126, 16);
		this.add(lblFechaSalida);
		
		txtDiaSalida = new JTextField();
		txtDiaSalida.setColumns(10);
		txtDiaSalida.setBounds(410, 250, 35, 22);
		this.add(txtDiaSalida);
		
		txtMesSalida = new JTextField();
		txtMesSalida.setColumns(10);
		txtMesSalida.setBounds(454, 250, 35, 22);
		this.add(txtMesSalida);
		
		txtAnioSalida = new JTextField();
		txtAnioSalida.setColumns(10);
		txtAnioSalida.setBounds(501, 250, 47, 22);
		this.add(txtAnioSalida);
		
		JLabel label_7 = new JLabel("-");
		label_7.setBounds(491, 253, 17, 16);
		this.add(label_7);
		
		JLabel label_13 = new JLabel("-");
		label_13.setBounds(447, 253, 17, 16);
		this.add(label_13);
		
		JLabel lblFechaLlegada = new JLabel("Fecha de Llegada");
		lblFechaLlegada.setBounds(420, 347, 126, 16);
		this.add(lblFechaLlegada);
		
		txtDiaLlegada = new JTextField();
		txtDiaLlegada.setColumns(10);
		txtDiaLlegada.setBounds(410, 321, 35, 22);
		this.add(txtDiaLlegada);
		
		txtMesLlegada = new JTextField();
		txtMesLlegada.setColumns(10);
		txtMesLlegada.setBounds(454, 321, 35, 22);
		this.add(txtMesLlegada);
		
		txtAnioLlegada = new JTextField();
		txtAnioLlegada.setColumns(10);
		txtAnioLlegada.setBounds(501, 321, 47, 22);
		this.add(txtAnioLlegada);
		
		JLabel label_15 = new JLabel("-");
		label_15.setBounds(491, 324, 17, 16);
		this.add(label_15);
		
		JLabel label_16 = new JLabel("-");
		label_16.setBounds(447, 324, 17, 16);
		this.add(label_16);
		
		textField_35 = new JTextField();
		textField_35.setText("DD");
		textField_35.setColumns(10);
		textField_35.setBounds(410, 321, 35, 22);
		this.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setText("MM");
		textField_36.setColumns(10);
		textField_36.setBounds(454, 321, 35, 22);
		this.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setText("AAAA");
		textField_37.setColumns(10);
		textField_37.setBounds(501, 321, 47, 22);
		this.add(textField_37);
		
		JLabel label_17 = new JLabel("-");
		label_17.setBounds(491, 324, 17, 16);
		this.add(label_17);
		
		JLabel label_18 = new JLabel("-");
		label_18.setBounds(447, 324, 17, 16);
		this.add(label_18);
		
		label_19 = new JLabel("DD-MM-AAAA");
		label_19.setBounds(558, 323, 73, 22);
		this.add(label_19);
		
		label_23 = new JLabel("DD-MM-AAAA");
		label_23.setBounds(558, 251, 73, 22);
		this.add(label_23);
		
		lblDatosBasicos = new JLabel("Datos Basicos");
		lblDatosBasicos.setBounds(159, 40, 221, 16);
		this.add(lblDatosBasicos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 132, 208, 25);
		this.add(comboBox);
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(223, 157, 55, 16);
		this.add(lblAerolinea);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(159, 251, 208, 25);
		this.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(159, 315, 208, 25);
		this.add(comboBox_2);
		
		JLabel label = new JLabel("Aeropuerto de Llegada");
		label.setBounds(196, 347, 139, 16);
		this.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(572, 404, 0, -371);
		this.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setToolTipText("lsvjip");
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(437, 388, 0, -360);
		this.add(separator_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new CapturaBtnNuevoVuelo(this));
		btnGuardar.setBounds(392, 464, 98, 26);
		this.add(btnGuardar);
		
		txtHoraSalida = new JTextField();
		txtHoraSalida.setBounds(649, 251, 114, 20);
		this.add(txtHoraSalida);
		txtHoraSalida.setColumns(10);
		
		txtHoraLlegada = new JTextField();
		txtHoraLlegada.setBounds(649, 322, 114, 20);
		this.add(txtHoraLlegada);
		txtHoraLlegada.setColumns(10);
		
		JLabel lblHoraDeSalida = new JLabel("Hora de Salida");
		lblHoraDeSalida.setBounds(659, 272, 104, 16);
		this.add(lblHoraDeSalida);
		
		JLabel lblHoraDeLlegada = new JLabel("Hora de Llegada");
		lblHoraDeLlegada.setBounds(659, 347, 104, 16);
		this.add(lblHoraDeLlegada);
		this.setVisible(false);
	}


	public JTextField getTextNombre() {
		return textNombre;
	}


	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}


	public JTextField getTextID() {
		return textID;
	}


	public void setTextID(JTextField textID) {
		this.textID = textID;
	}


	public JTextField getTxtDiaSalida() {
		return txtDiaSalida;
	}


	public void setTxtDiaSalida(JTextField txtDiaSalida) {
		this.txtDiaSalida = txtDiaSalida;
	}


	public JTextField getTxtMesSalida() {
		return txtMesSalida;
	}


	public void setTxtMesSalida(JTextField txtMesSalida) {
		this.txtMesSalida = txtMesSalida;
	}


	public JTextField getTxtAnioSalida() {
		return txtAnioSalida;
	}


	public void setTxtAnioSalida(JTextField txtAnioSalida) {
		this.txtAnioSalida = txtAnioSalida;
	}


	public JTextField getTxtDiaLlegada() {
		return txtDiaLlegada;
	}


	public void setTxtDiaLlegada(JTextField txtDiaLlegada) {
		this.txtDiaLlegada = txtDiaLlegada;
	}


	public JTextField getTxtMesLlegada() {
		return txtMesLlegada;
	}


	public void setTxtMesLlegada(JTextField txtMesLlegada) {
		this.txtMesLlegada = txtMesLlegada;
	}


	public JTextField getTxtAnioLlegada() {
		return txtAnioLlegada;
	}


	public void setTxtAnioLlegada(JTextField txtAnioLlegada) {
		this.txtAnioLlegada = txtAnioLlegada;
	}


	public JTextField getTxtHoraSalida() {
		return txtHoraSalida;
	}


	public void setTxtHoraSalida(JTextField txtHoraSalida) {
		this.txtHoraSalida = txtHoraSalida;
	}


	public JTextField getTxtHoraLlegada() {
		return txtHoraLlegada;
	}


	public void setTxtHoraLlegada(JTextField txtHoraLlegada) {
		this.txtHoraLlegada = txtHoraLlegada;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JButton getBtnGuardar() {
		return btnGuardar;
	}


	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}


	public GestionVueloVista getVista() {
		return vista;
	}


	public void setVista(GestionVueloVista vista) {
		this.vista = vista;
	}
	
	
}
