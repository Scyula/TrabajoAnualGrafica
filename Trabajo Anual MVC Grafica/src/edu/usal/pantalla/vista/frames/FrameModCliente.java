package edu.usal.pantalla.vista.frames;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import edu.usal.negocio.dominio.*;
import edu.usal.pantalla.vista.GestionClienteVista;
import edu.usal.pantalla.vista.eventos.CapturaBtnModCliente;
import edu.usal.pantalla.vista.eventos.CapturaBtnNuevoCliente;

public class FrameModCliente extends JPanel {

private static final long serialVersionUID = 1L;
	
private GestionClienteVista vista;

private JLabel lblNombre;
private JLabel lblApellido;
private JLabel lblDni;
private JLabel label_4;
private JLabel label_5;
private JTextField textEmail;
private JTextField textNombre;
private JTextField textApellido;
private JTextField textFechaNacDD;
private JTextField textFechaNacMM;
private JTextField textFechaNacAAAA;
private JTextField textDNI;
private JButton btnGuardar;
private JLabel label_8;
private JLabel lblPais;
private JLabel lblCiudad;
private JLabel lblCiudad_1;
private JTextField textCiudad;
private JLabel lblCodigoPostal;
private JTextField textCodPostal;
private JLabel lblCalle;
private JTextField textCalle;
private JLabel lblAltura;
private JTextField textAltura;
private JLabel label;
private JTextField textTelCelular;
private JTextField textTelLaboral;
private JTextField textTelPersonal;
private JTextField textNroPasaporte;
private JTextField textAutoridadEmision;
private JTextField textFechaEmiDD;
private JTextField textFechaEmiMM;
private JTextField textFechaEmiAAAA;
private JTextField textNroPasajero;
private JTextField textCategoria;
private JTextField textFechaVencDD;
private JTextField textFechaVencMM;
private JTextField textFechaVencAAAA;
private JLabel lblDdmmaaaa;
private JLabel label_19;
private JLabel label_23;
private JLabel lblPasajeroFrecuente;
private JLabel lblPasaporte;
private JLabel lblDatosBasicos;
private JLabel lblTelefono;
private JLabel lblDireccion;
private JTextField textCuit;
private JComboBox<Pais> comboBox_Pais;
private JComboBox<Provincia> comboBox_Provincia;
private JComboBox<Pais> comboBox_PaisEmision;
private JComboBox<LineaAerea> comboBox_Aerolinea;
	
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
		label_4.setBounds(34, 165, 126, 16);
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
		
		textFechaNacDD = new JTextField();
		textFechaNacDD.setColumns(10);
		textFechaNacDD.setBounds(24, 139, 35, 22);
		this.add(textFechaNacDD);
		
		textFechaNacMM = new JTextField();
		textFechaNacMM.setColumns(10);
		textFechaNacMM.setBounds(68, 139, 35, 22);
		this.add(textFechaNacMM);
		
		textFechaNacAAAA = new JTextField();
		textFechaNacAAAA.setColumns(10);
		textFechaNacAAAA.setBounds(115, 139, 47, 22);
		this.add(textFechaNacAAAA);
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(26, 90, 208, 22);
		this.add(textDNI);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new CapturaBtnModCliente(this));
		btnGuardar.setBounds(437, 552, 97, 25);
		this.add(btnGuardar);

		label_8 = new JLabel("-");
		label_8.setBounds(105, 142, 17, 16);
		this.add(label_8);
		
		lblPais = new JLabel("Pais");
		lblPais.setBounds(120, 380, 26, 16);
		this.add(lblPais);
		
		lblCiudad = new JLabel("Provincia");
		lblCiudad.setBounds(334, 380, 54, 16);
		this.add(lblCiudad);
		
		lblCiudad_1 = new JLabel("Ciudad");
		lblCiudad_1.setBounds(106, 426, 37, 16);
		this.add(lblCiudad_1);
		
		textCiudad = new JTextField();
		textCiudad.setColumns(10);
		textCiudad.setBounds(24, 402, 208, 22);
		this.add(textCiudad);
		
		lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setBounds(273, 426, 73, 16);
		this.add(lblCodigoPostal);
		
		textCodPostal = new JTextField();
		textCodPostal.setColumns(10);
		textCodPostal.setBounds(252, 402, 107, 22);
		this.add(textCodPostal);
		
		lblCalle = new JLabel("Calle");
		lblCalle.setBounds(117, 476, 26, 16);
		this.add(lblCalle);
		
		textCalle = new JTextField();
		textCalle.setColumns(10);
		textCalle.setBounds(24, 452, 208, 22);
		this.add(textCalle);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(287, 476, 37, 16);
		this.add(lblAltura);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(252, 452, 107, 22);
		this.add(textAltura);
		
		label = new JLabel("-");
		label.setBounds(61, 142, 17, 16);
		this.add(label);
		
		textTelCelular = new JTextField();
		textTelCelular.setColumns(10);
		textTelCelular.setBounds(252, 219, 208, 22);
		this.add(textTelCelular);
		
		JLabel lblTelCelular = new JLabel("Tel. Celular");
		lblTelCelular.setBounds(334, 243, 54, 16);
		this.add(lblTelCelular);
		
		textTelLaboral = new JTextField();
		textTelLaboral.setColumns(10);
		textTelLaboral.setBounds(24, 272, 208, 22);
		this.add(textTelLaboral);
		
		JLabel lblTelLaboral = new JLabel("Tel. Laboral");
		lblTelLaboral.setBounds(81, 296, 97, 16);
		this.add(lblTelLaboral);
		
		textTelPersonal = new JTextField();
		textTelPersonal.setColumns(10);
		textTelPersonal.setBounds(24, 219, 208, 22);
		this.add(textTelPersonal);
		
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
		
		textNroPasaporte = new JTextField();
		textNroPasaporte.setColumns(10);
		textNroPasaporte.setBounds(526, 43, 208, 22);
		this.add(textNroPasaporte);
		
		textAutoridadEmision = new JTextField();
		textAutoridadEmision.setColumns(10);
		textAutoridadEmision.setBounds(753, 43, 208, 22);
		this.add(textAutoridadEmision);
		
		textFechaEmiDD = new JTextField();
		textFechaEmiDD.setColumns(10);
		textFechaEmiDD.setBounds(526, 96, 35, 22);
		this.add(textFechaEmiDD);
		
		textFechaEmiMM = new JTextField();
		textFechaEmiMM.setColumns(10);
		textFechaEmiMM.setBounds(570, 96, 35, 22);
		this.add(textFechaEmiMM);
		
		textFechaEmiAAAA = new JTextField();
		textFechaEmiAAAA.setColumns(10);
		textFechaEmiAAAA.setBounds(617, 96, 47, 22);
		this.add(textFechaEmiAAAA);
		
		JLabel label_7 = new JLabel("-");
		label_7.setBounds(607, 99, 17, 16);
		this.add(label_7);
		
		JLabel label_9 = new JLabel("Aerolinea");
		label_9.setBounds(617, 335, 47, 16);
		this.add(label_9);
		
		JLabel label_10 = new JLabel("Alianza");
		label_10.setBounds(636, 414, 45, 16);
		this.add(label_10);
		
		JLabel lblNumeroPasajero = new JLabel("Numero Pasajero");
		lblNumeroPasajero.setBounds(596, 296, 85, 16);
		this.add(lblNumeroPasajero);
		
		textNroPasajero = new JTextField();
		textNroPasajero.setColumns(10);
		textNroPasajero.setBounds(526, 275, 208, 22);
		this.add(textNroPasajero);
		
		JLabel label_12 = new JLabel("Categoria");
		label_12.setBounds(826, 296, 54, 16);
		this.add(label_12);
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		textCategoria.setBounds(744, 275, 208, 22);
		this.add(textCategoria);
		
		JLabel label_13 = new JLabel("-");
		label_13.setBounds(563, 99, 17, 16);
		this.add(label_13);
		
		JLabel label_14 = new JLabel("Fecha de Vencimiento");
		label_14.setBounds(536, 170, 126, 16);
		this.add(label_14);
		
		textFechaVencDD = new JTextField();
		textFechaVencDD.setColumns(10);
		textFechaVencDD.setBounds(526, 144, 35, 22);
		this.add(textFechaVencDD);
		
		textFechaVencMM = new JTextField();
		textFechaVencMM.setColumns(10);
		textFechaVencMM.setBounds(570, 144, 35, 22);
		this.add(textFechaVencMM);
		
		textFechaVencAAAA = new JTextField();
		textFechaVencAAAA.setColumns(10);
		textFechaVencAAAA.setBounds(617, 144, 47, 22);
		this.add(textFechaVencAAAA);
		
		JLabel label_15 = new JLabel("-");
		label_15.setBounds(607, 147, 17, 16);
		this.add(label_15);
		
		JLabel label_16 = new JLabel("-");
		label_16.setBounds(563, 147, 17, 16);
		this.add(label_16);
		
		JRadioButton radioButton_Skyteam = new JRadioButton("Skyteam");
		radioButton_Skyteam.setBounds(745, 367, 127, 25);
		
		
		JRadioButton radioButton_OneWorld = new JRadioButton("Oneworld");
		radioButton_OneWorld.setBounds(745, 410, 127, 25);
		
		
		JRadioButton radioButton_StarAlliance = new JRadioButton("Star Alliance");
		radioButton_StarAlliance.setBounds(745, 458, 127, 25);
		
		ButtonGroup grupoAlianza = new ButtonGroup();
		grupoAlianza.add(radioButton_OneWorld);
		grupoAlianza.add(radioButton_Skyteam);
		grupoAlianza.add(radioButton_StarAlliance);
		
		this.add(radioButton_OneWorld);
		this.add(radioButton_Skyteam);
		this.add(radioButton_StarAlliance);
		
		lblDdmmaaaa = new JLabel("DD-MM-AAAA");
		lblDdmmaaaa.setBounds(172, 139, 73, 22);
		this.add(lblDdmmaaaa);
		
		label_19 = new JLabel("DD-MM-AAAA");
		label_19.setBounds(674, 146, 73, 22);
		this.add(label_19);
		
		label_23 = new JLabel("DD-MM-AAAA");
		label_23.setBounds(674, 97, 73, 22);
		this.add(label_23);
		
		lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
		lblPasajeroFrecuente.setBounds(526, 247, 221, 17);
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
		
		JLabel lblCuitcuil = new JLabel("CUIT/CUIL");
		lblCuitcuil.setBounds(316, 166, 72, 14);
		add(lblCuitcuil);
		
		comboBox_Pais = new JComboBox<Pais>();
		comboBox_Pais.setBounds(24, 357, 208, 20);
		DefaultComboBoxModel<Pais> modeloPais = new DefaultComboBoxModel<Pais>(vista.getClienteController().obtenerListaPaises());
		comboBox_Pais.setModel(modeloPais);
		add(comboBox_Pais);
		
		comboBox_Provincia = new JComboBox<Provincia>();
		comboBox_Provincia.setBounds(252, 357, 208, 20);
		DefaultComboBoxModel<Provincia> model = new DefaultComboBoxModel<Provincia>(vista.getClienteController().obtenerListaProvincias());
		comboBox_Provincia.setModel(model);
		add(comboBox_Provincia);
		
		comboBox_PaisEmision = new JComboBox<Pais>();
		DefaultComboBoxModel<Pais> modeloPaisEmision = new DefaultComboBoxModel<Pais>(vista.getClienteController().obtenerListaPaises());
		comboBox_PaisEmision.setModel(modeloPaisEmision);
		comboBox_PaisEmision.setBounds(753, 93, 208, 20);
		add(comboBox_PaisEmision);
		
		textCuit = new JTextField();
		textCuit.setBounds(252, 140, 208, 20);
		add(textCuit);
		textCuit.setColumns(10);
		
		comboBox_Aerolinea = new JComboBox<LineaAerea>();
		DefaultComboBoxModel<LineaAerea> mode = new DefaultComboBoxModel<LineaAerea>(vista.getClienteController().obtenerListaAerolinea());
		comboBox_Aerolinea.setModel(mode);
		comboBox_Aerolinea.setBounds(696, 335, 172, 22);
		add(comboBox_Aerolinea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 335, 476, 177);
		this.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 197, 476, 139);
		this.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(510, 247, 449, 265);
		this.add(separator_2);
		this.setVisible(false);
	}
	public JTextField getTextEmail() {
		return textEmail;
	}


	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}


	public JTextField getTextNombre() {
		return textNombre;
	}


	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}


	public JTextField getTextApellido() {
		return textApellido;
	}


	public void setTextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}


	public JTextField getTextFechaDD() {
		return textFechaNacDD;
	}


	public void setTextFechaDD(JTextField textFechaDD) {
		this.textFechaNacDD = textFechaDD;
	}


	public JTextField getTextFechaMM() {
		return textFechaNacMM;
	}


	public void setTextFechaMM(JTextField textFechaMM) {
		this.textFechaNacMM = textFechaMM;
	}


	public JTextField getTextFechaAAAA() {
		return textFechaNacAAAA;
	}


	public void setTextFechaAAAA(JTextField textFechaAAAA) {
		this.textFechaNacAAAA = textFechaAAAA;
	}


	public JTextField getTextDNI() {
		return textDNI;
	}


	public void setTextDNI(JTextField textDNI) {
		this.textDNI = textDNI;
	}


	public JTextField getTextCuit() {
		return textCuit;
	}


	public void setTextCuit(JTextField textCuit) {
		this.textCuit = textCuit;
	}


	public GestionClienteVista getVista() {
		return vista;
	}


	public void setVista(GestionClienteVista vista) {
		this.vista = vista;
	}


	public JButton getBtnGuardar() {
		return btnGuardar;
	}


	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}


	public JTextField getTextFechaNacDD() {
		return textFechaNacDD;
	}


	public void setTextFechaNacDD(JTextField textFechaNacDD) {
		this.textFechaNacDD = textFechaNacDD;
	}


	public JTextField getTextFechaNacMM() {
		return textFechaNacMM;
	}


	public void setTextFechaNacMM(JTextField textFechaNacMM) {
		this.textFechaNacMM = textFechaNacMM;
	}


	public JTextField getTextFechaNacAAAA() {
		return textFechaNacAAAA;
	}


	public void setTextFechaNacAAAA(JTextField textFechaNacAAAA) {
		this.textFechaNacAAAA = textFechaNacAAAA;
	}


	public JTextField getTextCiudad() {
		return textCiudad;
	}


	public void setTextCiudad(JTextField textCiudad) {
		this.textCiudad = textCiudad;
	}


	public JTextField getTextCodPostal() {
		return textCodPostal;
	}


	public void setTextCodPostal(JTextField textCodPostal) {
		this.textCodPostal = textCodPostal;
	}


	public JTextField getTextCalle() {
		return textCalle;
	}


	public void setTextCalle(JTextField textCalle) {
		this.textCalle = textCalle;
	}


	public JTextField getTextAltura() {
		return textAltura;
	}


	public void setTextAltura(JTextField textAltura) {
		this.textAltura = textAltura;
	}


	public JTextField getTextTelCelular() {
		return textTelCelular;
	}


	public void setTextTelCelular(JTextField textTelCelular) {
		this.textTelCelular = textTelCelular;
	}


	public JTextField getTextTelLaboral() {
		return textTelLaboral;
	}


	public void setTextTelLaboral(JTextField textTelLaboral) {
		this.textTelLaboral = textTelLaboral;
	}


	public JTextField getTextTelPersonal() {
		return textTelPersonal;
	}


	public void setTextTelPersonal(JTextField textTelPersonal) {
		this.textTelPersonal = textTelPersonal;
	}


	public JTextField getTextNroPasaporte() {
		return textNroPasaporte;
	}


	public void setTextNroPasaporte(JTextField textNroPasaporte) {
		this.textNroPasaporte = textNroPasaporte;
	}


	public JTextField getTextAutoridadEmision() {
		return textAutoridadEmision;
	}


	public void setTextAutoridadEmision(JTextField textAutoridadEmision) {
		this.textAutoridadEmision = textAutoridadEmision;
	}


	public JTextField getTextFechaEmiDD() {
		return textFechaEmiDD;
	}


	public void setTextFechaEmiDD(JTextField textFechaEmiDD) {
		this.textFechaEmiDD = textFechaEmiDD;
	}


	public JTextField getTextFechaEmiMM() {
		return textFechaEmiMM;
	}


	public void setTextFechaEmiMM(JTextField textFechaEmiMM) {
		this.textFechaEmiMM = textFechaEmiMM;
	}


	public JTextField getTextFechaEmiAAAA() {
		return textFechaEmiAAAA;
	}


	public void setTextFechaEmiAAAA(JTextField textFechaEmiAAAA) {
		this.textFechaEmiAAAA = textFechaEmiAAAA;
	}


	public JTextField getTextNroPasajero() {
		return textNroPasajero;
	}


	public void setTextNroPasajero(JTextField textNroPasajero) {
		this.textNroPasajero = textNroPasajero;
	}


	public JTextField getTextCategoria() {
		return textCategoria;
	}


	public void setTextCategoria(JTextField textCategoria) {
		this.textCategoria = textCategoria;
	}


	public JTextField getTextFechaVencDD() {
		return textFechaVencDD;
	}


	public void setTextFechaVencDD(JTextField textFechaVencDD) {
		this.textFechaVencDD = textFechaVencDD;
	}


	public JTextField getTextFechaVencMM() {
		return textFechaVencMM;
	}


	public void setTextFechaVencMM(JTextField textFechaVencMM) {
		this.textFechaVencMM = textFechaVencMM;
	}


	public JTextField getTextFechaVencAAAA() {
		return textFechaVencAAAA;
	}


	public void setTextFechaVencAAAA(JTextField textFechaVencAAAA) {
		this.textFechaVencAAAA = textFechaVencAAAA;
	}

	public JComboBox<Pais> getComboBox_Pais() {
		return comboBox_Pais;
	}

	public void setComboBox_Pais(JComboBox<Pais> comboBox_Pais) {
		this.comboBox_Pais = comboBox_Pais;
	}

	public JComboBox<Provincia> getComboBox_Provincia() {
		return comboBox_Provincia;
	}

	public void setComboBox_Provincia(JComboBox<Provincia> comboBox_Provincia) {
		this.comboBox_Provincia = comboBox_Provincia;
	}

	public JComboBox<Pais> getComboBox_PaisEmision() {
		return comboBox_PaisEmision;
	}

	public void setComboBox_PaisEmision(JComboBox<Pais> comboBox_PaisEmision) {
		this.comboBox_PaisEmision = comboBox_PaisEmision;
	}

	public JComboBox<LineaAerea> getComboBox_Aerolinea() {
		return comboBox_Aerolinea;
	}

	public void setComboBox_Aerolinea(JComboBox<LineaAerea> comboBox_Aerolinea) {
		this.comboBox_Aerolinea = comboBox_Aerolinea;
	}
	
}
