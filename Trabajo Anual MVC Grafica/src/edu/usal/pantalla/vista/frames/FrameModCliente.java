package edu.usal.pantalla.vista.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import edu.usal.negocio.dominio.*;
import edu.usal.pantalla.vista.GestionClienteVista;

public class FrameModCliente extends JPanel {

private static final long serialVersionUID = 1L;
	
	GestionClienteVista vista;
	
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField textEmail;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textFechaDD;
	private JTextField textFechaMM;
	private JTextField textFechaAAAA;
	private JTextField textDNI;
	private JButton btnGuardar;
	private JLabel label_8;
	private JLabel lblPais;
	private JTextField textField_3;
	private JLabel lblCiudad;
	private JTextField textField_4;
	private JLabel lblCiudad_1;
	private JTextField textField_5;
	private JLabel lblCodigoPostal;
	private JTextField textField_6;
	private JLabel lblCalle;
	private JTextField textField_7;
	private JLabel lblAltura;
	private JTextField textField_8;
	private JLabel label;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_23;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JLabel lblDdmmaaaa;
	private JLabel label_19;
	private JLabel label_23;
	private JLabel lblPasajeroFrecuente;
	private JLabel lblPasaporte;
	private JLabel lblDatosBasicos;
	private JLabel lblTelefono;
	private JLabel lblDireccion;
	
	public FrameModCliente() {
		
	}
	
	public FrameModCliente(GestionClienteVista vista, Cliente cliente,Telefono telefono, 
			Direccion direccion, Pasaporte pasaporte, PasajeroFrecuente pasajero) {
		this.vista = vista;
		
		
		setBounds(5, 53, 969, 590);
		setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(106, 65, 37, 16);
		this.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(334, 65, 37, 16);
		this.add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(106, 112, 126, 16);
		this.add(lblDni);
		
		label_4 = new JLabel("Fecha de Nacimiento");
		label_4.setBounds(62, 165, 126, 16);
		this.add(label_4);
		
		label_5 = new JLabel("E-mail");
		label_5.setBounds(334, 112, 35, 16);
		this.add(label_5);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(252, 92, 208, 22);
		this.add(textEmail);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(24, 43, 208, 22);
		this.add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(252, 43, 208, 22);
		this.add(textApellido);
		
		textFechaDD = new JTextField();
		textFechaDD.setEditable(false);
		textFechaDD.setColumns(10);
		textFechaDD.setBounds(52, 139, 35, 22);
		this.add(textFechaDD);
		
		textFechaMM = new JTextField();
		textFechaMM.setEditable(false);
		textFechaMM.setColumns(10);
		textFechaMM.setBounds(96, 139, 35, 22);
		this.add(textFechaMM);
		
		textFechaAAAA = new JTextField();
		textFechaAAAA.setEditable(false);
		textFechaAAAA.setColumns(10);
		textFechaAAAA.setBounds(143, 139, 47, 22);
		this.add(textFechaAAAA);
		
		textDNI = new JTextField();
		textDNI.setEditable(false);
		textDNI.setColumns(10);
		textDNI.setBounds(26, 90, 208, 22);
		this.add(textDNI);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.getClienteController().almacenarDatos(vista.getNuevoCliente());
			}
		});
		btnGuardar.setBounds(437, 552, 97, 25);
		this.add(btnGuardar);

		label_8 = new JLabel("-");
		label_8.setBounds(133, 142, 17, 16);
		this.add(label_8);
		
		lblPais = new JLabel("Pais");
		lblPais.setBounds(120, 380, 26, 16);
		this.add(lblPais);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(24, 356, 208, 22);
		this.add(textField_3);
		
		lblCiudad = new JLabel("Provincia");
		lblCiudad.setBounds(334, 380, 54, 16);
		this.add(lblCiudad);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(252, 356, 208, 22);
		this.add(textField_4);
		
		lblCiudad_1 = new JLabel("Ciudad");
		lblCiudad_1.setBounds(106, 426, 37, 16);
		this.add(lblCiudad_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(24, 402, 208, 22);
		this.add(textField_5);
		
		lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setBounds(273, 426, 73, 16);
		this.add(lblCodigoPostal);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(252, 402, 107, 22);
		this.add(textField_6);
		
		lblCalle = new JLabel("Calle");
		lblCalle.setBounds(117, 476, 26, 16);
		this.add(lblCalle);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(24, 452, 208, 22);
		this.add(textField_7);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(287, 476, 37, 16);
		this.add(lblAltura);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(252, 452, 107, 22);
		this.add(textField_8);
		
		label = new JLabel("-");
		label.setBounds(89, 142, 17, 16);
		this.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(252, 219, 208, 22);
		this.add(textField_1);
		
		JLabel lblTelCelular = new JLabel("Tel. Celular");
		lblTelCelular.setBounds(334, 243, 54, 16);
		this.add(lblTelCelular);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(24, 272, 208, 22);
		this.add(textField_2);
		
		JLabel lblTelLaboral = new JLabel("Tel. Laboral");
		lblTelLaboral.setBounds(81, 296, 97, 16);
		this.add(lblTelLaboral);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(24, 219, 208, 22);
		this.add(textField);
		
		JLabel lblTelPersonal = new JLabel("Tel. Personal");
		lblTelPersonal.setBounds(81, 243, 97, 16);
		this.add(lblTelPersonal);
		
		JLabel label_1 = new JLabel("Numero de Pasaporte");
		label_1.setBounds(570, 65, 126, 16);
		this.add(label_1);
		
		JLabel label_2 = new JLabel("Autoridad de Emision");
		label_2.setBounds(803, 65, 126, 16);
		this.add(label_2);
		
		JLabel label_3 = new JLabel("Fecha de Emision");
		label_3.setBounds(536, 122, 126, 16);
		this.add(label_3);
		
		JLabel label_6 = new JLabel("Pais de Emision");
		label_6.setBounds(815, 115, 78, 16);
		this.add(label_6);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(753, 94, 208, 22);
		this.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBounds(526, 43, 208, 22);
		this.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(753, 43, 208, 22);
		this.add(textField_21);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(526, 96, 35, 22);
		this.add(textField_23);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(570, 96, 35, 22);
		this.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(617, 96, 47, 22);
		this.add(textField_27);
		
		JLabel label_7 = new JLabel("-");
		label_7.setBounds(607, 99, 17, 16);
		this.add(label_7);
		
		JLabel label_9 = new JLabel("Aerolinea");
		label_9.setBounds(596, 248, 47, 16);
		this.add(label_9);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(526, 225, 208, 22);
		this.add(textField_29);
		
		JLabel label_10 = new JLabel("Alianza");
		label_10.setBounds(636, 414, 45, 16);
		this.add(label_10);
		
		JLabel label_11 = new JLabel("Numero");
		label_11.setBounds(606, 296, 37, 16);
		this.add(label_11);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(526, 275, 208, 22);
		this.add(textField_30);
		
		JLabel label_12 = new JLabel("Categoria");
		label_12.setBounds(826, 296, 54, 16);
		this.add(label_12);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(744, 275, 208, 22);
		this.add(textField_31);
		
		JLabel label_13 = new JLabel("-");
		label_13.setBounds(563, 99, 17, 16);
		this.add(label_13);
		
		JLabel label_14 = new JLabel("Fecha de Vencimiento");
		label_14.setBounds(536, 170, 126, 16);
		this.add(label_14);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(526, 144, 35, 22);
		this.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(570, 144, 35, 22);
		this.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(617, 144, 47, 22);
		this.add(textField_34);
		
		JLabel label_15 = new JLabel("-");
		label_15.setBounds(607, 147, 17, 16);
		this.add(label_15);
		
		JLabel label_16 = new JLabel("-");
		label_16.setBounds(563, 147, 17, 16);
		this.add(label_16);
		
		textField_35 = new JTextField();
		textField_35.setText("DD");
		textField_35.setColumns(10);
		textField_35.setBounds(526, 144, 35, 22);
		this.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setText("MM");
		textField_36.setColumns(10);
		textField_36.setBounds(570, 144, 35, 22);
		this.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setText("AAAA");
		textField_37.setColumns(10);
		textField_37.setBounds(617, 144, 47, 22);
		this.add(textField_37);
		
		JLabel label_17 = new JLabel("-");
		label_17.setBounds(607, 147, 17, 16);
		this.add(label_17);
		
		JLabel label_18 = new JLabel("-");
		label_18.setBounds(563, 147, 17, 16);
		this.add(label_18);
		
		JRadioButton radioButton = new JRadioButton("Skyteam");
		radioButton.setBounds(745, 367, 127, 25);
		
		
		JRadioButton radioButton_1 = new JRadioButton("Oneworld");
		radioButton_1.setBounds(745, 410, 127, 25);
		
		
		JRadioButton radioButton_2 = new JRadioButton("Star Alliance");
		radioButton_2.setBounds(745, 458, 127, 25);
		
		
		
		this.add(radioButton_1);
		this.add(radioButton);
		this.add(radioButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 335, 476, 177);
		this.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 197, 476, 139);
		this.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(510, 197, 449, 330);
		this.add(separator_2);
		
		lblDdmmaaaa = new JLabel("DD-MM-AAAA");
		lblDdmmaaaa.setBounds(211, 139, 73, 22);
		this.add(lblDdmmaaaa);
		
		label_19 = new JLabel("DD-MM-AAAA");
		label_19.setBounds(674, 146, 73, 22);
		this.add(label_19);
		
		label_23 = new JLabel("DD-MM-AAAA");
		label_23.setBounds(674, 97, 73, 22);
		this.add(label_23);
		
		lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
		lblPasajeroFrecuente.setBounds(526, 197, 221, 16);
		this.add(lblPasajeroFrecuente);
		
		lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setBounds(526, 11, 221, 16);
		this.add(lblPasaporte);
		
		lblDatosBasicos = new JLabel("Datos Basicos");
		lblDatosBasicos.setBounds(24, 12, 221, 16);
		this.add(lblDatosBasicos);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(24, 197, 221, 16);
		this.add(lblTelefono);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(24, 335, 221, 16);
		this.add(lblDireccion);
		this.setVisible(false);
	}
	

}
