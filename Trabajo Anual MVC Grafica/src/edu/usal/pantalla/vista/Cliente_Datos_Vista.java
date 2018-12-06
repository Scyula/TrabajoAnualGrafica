package edu.usal.pantalla.vista;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.pantalla.controller.Cliente_Datos_Controller;
import edu.usal.pantalla.vista.eventos.CapturaBtnCliente_Datos;
import edu.usal.pantalla.vista.eventos.CapturaItemCliente;

import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class Cliente_Datos_Vista extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	Cliente_Datos_Controller vista;
	
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField textEmail;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDNI;
	private JButton btnGuardar;
	private JButton btnGuardarMod;
	private JButton btnCancelar;
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
	private JTextField textTelCelular;
	private JTextField textTelLaboral;
	private JTextField textTelPersonal;
	private JTextField textNroPasaporte;
	private JTextField textAutoridadEmision;
	private JTextField textNroPasajero;
	private JTextField textCategoria;
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
	private JTextField textAlianza;
	private JDateChooser VencPasaport;
	private JDateChooser EmisionPasaport;
	private JDateChooser FechaNacimiento;
	private JLabel lbl_Alianza;
	
	public Cliente_Datos_Vista(Cliente_Datos_Controller vista) {
		
		this.vista = vista;
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
		setBounds(5, 53, 980, 694);
		setLocationRelativeTo(null);
		
		
		setTitle("Alta de Cliente");
		getContentPane().setLayout(null);
		
		lbl_Alianza = new JLabel("");
		lbl_Alianza.setBounds(691, 492, 122, 14);
		getContentPane().add(lbl_Alianza);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(14, 154, 208, 22);
		getContentPane().add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(242, 154, 208, 22);
		getContentPane().add(textApellido);
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(14, 201, 210, 22);
		getContentPane().add(textDNI);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(242, 203, 208, 22);
		getContentPane().add(textEmail);
		
		textCuit = new JTextField();
		textCuit.setBounds(242, 251, 208, 20);
		getContentPane().add(textCuit);
		textCuit.setColumns(10);
		
		FechaNacimiento = new JDateChooser();
		FechaNacimiento.setBounds(24, 249, 107, 22);
		getContentPane().add(FechaNacimiento);
		
		textTelCelular = new JTextField();
		textTelCelular.setColumns(10);
		textTelCelular.setBounds(242, 330, 208, 22);
		getContentPane().add(textTelCelular);
		
		textTelLaboral = new JTextField();
		textTelLaboral.setColumns(10);
		textTelLaboral.setBounds(14, 383, 208, 22);
		getContentPane().add(textTelLaboral);
		
		textTelPersonal = new JTextField();
		textTelPersonal.setColumns(10);
		textTelPersonal.setBounds(14, 330, 208, 22);
		getContentPane().add(textTelPersonal);
		
		comboBox_Pais = new JComboBox<Pais>();
		comboBox_Pais.addItemListener(new CapturaItemCliente(this));
		comboBox_Pais.setBounds(14, 468, 208, 20);
		comboBox_Pais.setModel(new DefaultComboBoxModel<Pais>(vista.obtenerListaPaises()));
		getContentPane().add(comboBox_Pais);
		
		comboBox_Provincia = new JComboBox<Provincia>();
		comboBox_Provincia.setEnabled(false);
		comboBox_Provincia.setBounds(242, 468, 208, 20);
		comboBox_Provincia.setModel(new DefaultComboBoxModel<Provincia>(vista.obtenerListaProvincias()));
		getContentPane().add(comboBox_Provincia);
		
		textCiudad = new JTextField();
		textCiudad.setColumns(10);
		textCiudad.setBounds(14, 513, 208, 22);
		getContentPane().add(textCiudad);
		
		textCodPostal = new JTextField();
		textCodPostal.setColumns(10);
		textCodPostal.setBounds(242, 513, 107, 22);
		getContentPane().add(textCodPostal);
		
		textCalle = new JTextField();
		textCalle.setColumns(10);
		textCalle.setBounds(14, 563, 208, 22);
		getContentPane().add(textCalle);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(242, 563, 107, 22);
		getContentPane().add(textAltura);
		
		textNroPasaporte = new JTextField();
		textNroPasaporte.setColumns(10);
		textNroPasaporte.setBounds(526, 154, 198, 22);
		getContentPane().add(textNroPasaporte);
		
		textAutoridadEmision = new JTextField();
		textAutoridadEmision.setColumns(10);
		textAutoridadEmision.setBounds(743, 154, 199, 22);
		getContentPane().add(textAutoridadEmision);
		
		EmisionPasaport = new JDateChooser();
		EmisionPasaport.setBounds(526, 203, 107, 22);
		getContentPane().add(EmisionPasaport);
		
		comboBox_PaisEmision = new JComboBox<Pais>();
		comboBox_PaisEmision.setModel(new DefaultComboBoxModel<Pais>(vista.obtenerListaPaises()));
		comboBox_PaisEmision.setBounds(743, 204, 199, 20);
		getContentPane().add(comboBox_PaisEmision);
		
		VencPasaport = new JDateChooser();
		VencPasaport.setBounds(526, 260, 107, 22);
		getContentPane().add(VencPasaport);
		
		textNroPasajero = new JTextField();
		textNroPasajero.setColumns(10);
		textNroPasajero.setBounds(526, 386, 198, 22);
		getContentPane().add(textNroPasajero);
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		textCategoria.setBounds(743, 386, 199, 22);
		getContentPane().add(textCategoria);
		
		comboBox_Aerolinea = new JComboBox<LineaAerea>();
		comboBox_Aerolinea.addItemListener(new CapturaItemCliente(this));
		comboBox_Aerolinea.setModel(new DefaultComboBoxModel<LineaAerea>(vista.obtenerListaAerolinea()));
		comboBox_Aerolinea.setBounds(686, 446, 233, 22);
		getContentPane().add(comboBox_Aerolinea);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(96, 176, 57, 16);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(324, 176, 62, 16);
		getContentPane().add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(96, 223, 126, 16);
		getContentPane().add(lblDni);
		
		label_4 = new JLabel("Fecha de Nacimiento");
		label_4.setBounds(24, 276, 126, 16);
		getContentPane().add(label_4);
		
		label_5 = new JLabel("E-mail");
		label_5.setBounds(324, 223, 35, 16);
		getContentPane().add(label_5);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new CapturaBtnCliente_Datos(this));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CapturaBtnCliente_Datos(this));
		btnCancelar.setBounds(822, 602, 97, 25);
		getContentPane().add(btnCancelar);
		btnGuardar.setBounds(698, 601, 97, 25);
		getContentPane().add(btnGuardar);
		
		lblPais = new JLabel("Pais");
		lblPais.setBounds(110, 491, 26, 16);
		getContentPane().add(lblPais);
		
		lblCiudad = new JLabel("Provincia");
		lblCiudad.setBounds(324, 491, 54, 16);
		getContentPane().add(lblCiudad);
		
		lblCiudad_1 = new JLabel("Ciudad");
		lblCiudad_1.setBounds(96, 537, 57, 16);
		getContentPane().add(lblCiudad_1);
		
		lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setBounds(263, 537, 96, 16);
		getContentPane().add(lblCodigoPostal);
		
		lblCalle = new JLabel("Calle");
		lblCalle.setBounds(107, 587, 56, 16);
		getContentPane().add(lblCalle);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(277, 587, 37, 16);
		getContentPane().add(lblAltura);
		
		JLabel lblTelCelular = new JLabel("Tel. Celular");
		lblTelCelular.setBounds(324, 354, 78, 16);
		getContentPane().add(lblTelCelular);
		
		JLabel lblTelLaboral = new JLabel("Tel. Laboral");
		lblTelLaboral.setBounds(71, 407, 97, 16);
		getContentPane().add(lblTelLaboral);
		
		JLabel lblTelPersonal = new JLabel("Tel. Personal");
		lblTelPersonal.setBounds(71, 354, 97, 16);
		getContentPane().add(lblTelPersonal);
		
		JLabel label_1 = new JLabel("Numero de Pasaporte");
		label_1.setBounds(560, 176, 126, 16);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Autoridad de Emision");
		label_2.setBounds(793, 176, 126, 16);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Fecha de Emision");
		label_3.setBounds(526, 233, 126, 16);
		getContentPane().add(label_3);
		
		JLabel label_6 = new JLabel("Pais de Emision");
		label_6.setBounds(805, 226, 114, 16);
		getContentPane().add(label_6);
		
		JLabel label_9 = new JLabel("Aerolinea");
		label_9.setBounds(607, 446, 72, 16);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Alianza");
		label_10.setBounds(607, 491, 45, 16);
		getContentPane().add(label_10);
		
		JLabel lblNumeroPasajero = new JLabel("Numero Pasajero");
		lblNumeroPasajero.setBounds(586, 407, 126, 16);
		getContentPane().add(lblNumeroPasajero);
		
		JLabel label_12 = new JLabel("Categoria");
		label_12.setBounds(816, 407, 85, 16);
		getContentPane().add(label_12);
		
		JLabel label_14 = new JLabel("Fecha de Vencimiento");
		label_14.setBounds(526, 291, 126, 16);
		getContentPane().add(label_14);
		
		lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
		lblPasajeroFrecuente.setBounds(516, 358, 221, 17);
		getContentPane().add(lblPasajeroFrecuente);
		
		lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setBounds(526, 123, 138, 16);
		getContentPane().add(lblPasaporte);
		
		lblDatosBasicos = new JLabel("Datos Basicos");
		lblDatosBasicos.setBounds(14, 123, 221, 16);
		getContentPane().add(lblDatosBasicos);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(14, 308, 221, 16);
		getContentPane().add(lblTelefono);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(14, 446, 221, 16);
		getContentPane().add(lblDireccion);
		
		JLabel lblCuitcuil = new JLabel("CUIT/CUIL");
		lblCuitcuil.setBounds(306, 277, 72, 14);
		getContentPane().add(lblCuitcuil);
		
		textAlianza = new JTextField();
		textAlianza.setEnabled(false);
		textAlianza.setEditable(false);
		textAlianza.setBounds(686, 489, 127, 20);
		getContentPane().add(textAlianza);
		textAlianza.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(14, 446, 476, 177);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 308, 476, 139);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(500, 358, 449, 265);
		getContentPane().add(separator_2);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del Cliente para su alta");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngreseLosDatos.setBounds(96, 33, 805, 55);
		getContentPane().add(lblIngreseLosDatos);
		this.setVisible(true);
	}
	
/**
 * @wbp.parser.constructor
 */
public Cliente_Datos_Vista(Cliente_Datos_Controller vista, Cliente c) {

	this.vista = vista;
	setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	
    addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent evt) {
            close();
        }
    });
	setBounds(5, 53, 980, 694);
	setLocationRelativeTo(null);
	
	
	setTitle("Modificacion de Cliente");
	getContentPane().setLayout(null);
	
	
	textNombre = new JTextField();
	textNombre.setText(c.getNombre());
	textNombre.setColumns(10);
	textNombre.setBounds(14, 154, 208, 22);
	getContentPane().add(textNombre);
	
	textApellido = new JTextField();
	textApellido.setText(c.getApellido());
	textApellido.setColumns(10);
	textApellido.setBounds(242, 154, 208, 22);
	getContentPane().add(textApellido);
	
	textDNI = new JTextField();
	textDNI.setText(String.valueOf(c.getDNI()));
	textDNI.setColumns(10);
	textDNI.setBounds(14, 201, 210, 22);
	getContentPane().add(textDNI);
	
	textEmail = new JTextField();
	textEmail.setText(c.getEmail());
	textEmail.setColumns(10);
	textEmail.setBounds(242, 203, 208, 22);
	getContentPane().add(textEmail);
	
	textCuit = new JTextField();
	textCuit.setText(c.getCuitcuil());
	textCuit.setBounds(242, 251, 208, 20);
	getContentPane().add(textCuit);
	textCuit.setColumns(10);
	
	FechaNacimiento = new JDateChooser();
	FechaNacimiento.setBounds(24, 249, 107, 22);
	FechaNacimiento.setDate(c.getFechaNac());
	getContentPane().add(FechaNacimiento);
	
	textTelCelular = new JTextField();
	textTelCelular.setText(c.getTelefono().getNroCelular());
	textTelCelular.setColumns(10);
	textTelCelular.setBounds(242, 330, 208, 22);
	getContentPane().add(textTelCelular);
	
	textTelLaboral = new JTextField();
	textTelLaboral.setColumns(10);
	textTelLaboral.setBounds(14, 383, 208, 22);
	textTelLaboral.setText(c.getTelefono().getNroLaboral());
	getContentPane().add(textTelLaboral);
	
	textTelPersonal = new JTextField();
	textTelPersonal.setColumns(10);
	textTelPersonal.setBounds(14, 330, 208, 22);
	textTelPersonal.setText(c.getTelefono().getNroPersonal());
	getContentPane().add(textTelPersonal);
	
	comboBox_Provincia = new JComboBox<Provincia>();
	comboBox_Provincia.setEnabled(false);
	comboBox_Provincia.setBounds(242, 468, 208, 20);
	comboBox_Provincia.setModel(new DefaultComboBoxModel<Provincia>(vista.obtenerListaProvincias()));
	comboBox_Provincia.setSelectedIndex(vista.obtenerIndexProvincia(comboBox_Provincia.getModel(),c));
	getContentPane().add(comboBox_Provincia);
	
	comboBox_Pais = new JComboBox<Pais>();
	DefaultComboBoxModel<Pais> modelo2 = new DefaultComboBoxModel<Pais>(vista.obtenerListaPaises());
	comboBox_Pais.setModel(modelo2);
	comboBox_Pais.setBounds(14, 468, 208, 20);
	comboBox_Pais.addItemListener(new CapturaItemCliente(this));
	comboBox_Pais.setSelectedIndex(vista.obtenerIndexPais(comboBox_Pais.getModel(),c));
	getContentPane().add(comboBox_Pais);
	
	textCiudad = new JTextField();
	textCiudad.setColumns(10);
	textCiudad.setBounds(14, 513, 208, 22);
	textCiudad.setText(c.getDireccion().getCiudad());
	getContentPane().add(textCiudad);
	
	textCodPostal = new JTextField();
	textCodPostal.setColumns(10);
	textCodPostal.setBounds(242, 513, 107, 22);
	textCodPostal.setText(c.getDireccion().getCodPostal());
	getContentPane().add(textCodPostal);
	
	textCalle = new JTextField();
	textCalle.setColumns(10);
	textCalle.setBounds(14, 563, 208, 22);
	textCalle.setText(c.getDireccion().getCalle());
	getContentPane().add(textCalle);
	
	textAltura = new JTextField();
	textAltura.setColumns(10);
	textAltura.setBounds(242, 563, 107, 22);
	textAltura.setText(c.getDireccion().getAltura());
	getContentPane().add(textAltura);
	
	textNroPasaporte = new JTextField();
	textNroPasaporte.setColumns(10);
	textNroPasaporte.setBounds(526, 154, 198, 22);
	textNroPasaporte.setText(c.getPasaporte().getNroPasaporte());
	getContentPane().add(textNroPasaporte);
	
	textAutoridadEmision = new JTextField();
	textAutoridadEmision.setColumns(10);
	textAutoridadEmision.setBounds(743, 154, 199, 22);
	textAutoridadEmision.setText(c.getPasaporte().getAutoridademision());
	getContentPane().add(textAutoridadEmision);
	
	EmisionPasaport = new JDateChooser();
	EmisionPasaport.setBounds(526, 203, 107, 22);
	EmisionPasaport.setDate(c.getPasaporte().getEmision());
	getContentPane().add(EmisionPasaport);
	
	comboBox_PaisEmision = new JComboBox<Pais>();
	DefaultComboBoxModel<Pais> modelo = new DefaultComboBoxModel<Pais>(vista.obtenerListaPaises());
	comboBox_PaisEmision.setModel(modelo);
	comboBox_PaisEmision.setBounds(743, 204, 199, 20);
	comboBox_PaisEmision.setSelectedIndex(vista.obtenerIndexPaisEmision(comboBox_PaisEmision.getModel(), c));
	getContentPane().add(comboBox_PaisEmision);
	
	VencPasaport = new JDateChooser();
	VencPasaport.setBounds(526, 260, 107, 22);
	VencPasaport.setDate(c.getPasaporte().getVencimiento());
	getContentPane().add(VencPasaport);
	
	textNroPasajero = new JTextField();
	textNroPasajero.setColumns(10);
	textNroPasajero.setBounds(526, 386, 198, 22);
	textNroPasajero.setText(c.getPasajeroFrecuente().getNumero());
	getContentPane().add(textNroPasajero);
	
	textCategoria = new JTextField();
	textCategoria.setColumns(10);
	textCategoria.setBounds(743, 386, 199, 22);
	textCategoria.setText(c.getPasajeroFrecuente().getCatergoria());
	getContentPane().add(textCategoria);

	
	comboBox_Aerolinea = new JComboBox<LineaAerea>();
	comboBox_Aerolinea.setModel(new DefaultComboBoxModel<LineaAerea>(vista.obtenerListaAerolinea()));
	comboBox_Aerolinea.setSelectedIndex(vista.obtenerIndexAerolinea(comboBox_Aerolinea.getModel(), c));
	
	lbl_Alianza = new JLabel(vista.alianza(((LineaAerea) comboBox_Aerolinea.getModel().getSelectedItem()).getAlianza()));
	lbl_Alianza.setBounds(691, 492, 122, 14);
	getContentPane().add(lbl_Alianza);
	
	comboBox_Aerolinea.setBounds(686, 446, 233, 22);
	comboBox_Aerolinea.addItemListener(new CapturaItemCliente(this));
	getContentPane().add(comboBox_Aerolinea);
	
	lblNombre = new JLabel("Nombre");
	lblNombre.setBounds(96, 176, 62, 16);
	getContentPane().add(lblNombre);
	
	lblApellido = new JLabel("Apellido");
	lblApellido.setBounds(324, 176, 62, 16);
	getContentPane().add(lblApellido);
	
	lblDni = new JLabel("DNI");
	lblDni.setBounds(96, 223, 126, 16);
	getContentPane().add(lblDni);
	
	label_4 = new JLabel("Fecha de Nacimiento");
	label_4.setBounds(24, 276, 126, 16);
	getContentPane().add(label_4);
	
	label_5 = new JLabel("E-mail");
	label_5.setBounds(324, 223, 35, 16);
	getContentPane().add(label_5);
	
	btnGuardarMod = new JButton("Guardar");
	btnGuardarMod.addActionListener(new CapturaBtnCliente_Datos(this));
	btnGuardarMod.setBounds(698, 601, 97, 25);
	getContentPane().add(btnGuardarMod);
	
	btnCancelar = new JButton("Cancelar");
	btnCancelar.addActionListener(new CapturaBtnCliente_Datos(this));
	btnCancelar.setBounds(822, 602, 97, 25);
	getContentPane().add(btnCancelar);
	
	lblPais = new JLabel("Pais");
	lblPais.setBounds(110, 491, 26, 16);
	getContentPane().add(lblPais);
	
	lblCiudad = new JLabel("Provincia");
	lblCiudad.setBounds(324, 491, 54, 16);
	getContentPane().add(lblCiudad);
	
	lblCiudad_1 = new JLabel("Ciudad");
	lblCiudad_1.setBounds(96, 537, 72, 16);
	getContentPane().add(lblCiudad_1);
	
	lblCodigoPostal = new JLabel("Codigo Postal");
	lblCodigoPostal.setBounds(263, 537, 96, 16);
	getContentPane().add(lblCodigoPostal);
	
	lblCalle = new JLabel("Calle");
	lblCalle.setBounds(107, 587, 61, 16);
	getContentPane().add(lblCalle);
	
	lblAltura = new JLabel("Altura");
	lblAltura.setBounds(277, 587, 37, 16);
	getContentPane().add(lblAltura);
	
	JLabel lblTelCelular = new JLabel("Tel. Celular");
	lblTelCelular.setBounds(324, 354, 78, 16);
	getContentPane().add(lblTelCelular);
	
	JLabel lblTelLaboral = new JLabel("Tel. Laboral");
	lblTelLaboral.setBounds(71, 407, 97, 16);
	getContentPane().add(lblTelLaboral);
	
	JLabel lblTelPersonal = new JLabel("Tel. Personal");
	lblTelPersonal.setBounds(71, 354, 97, 16);
	getContentPane().add(lblTelPersonal);
	
	JLabel label_1 = new JLabel("Numero de Pasaporte");
	label_1.setBounds(560, 176, 126, 16);
	getContentPane().add(label_1);
	
	JLabel label_2 = new JLabel("Autoridad de Emision");
	label_2.setBounds(793, 176, 126, 16);
	getContentPane().add(label_2);
	
	JLabel label_3 = new JLabel("Fecha de Emision");
	label_3.setBounds(526, 233, 126, 16);
	getContentPane().add(label_3);
	
	JLabel label_6 = new JLabel("Pais de Emision");
	label_6.setBounds(805, 226, 114, 16);
	getContentPane().add(label_6);
	
	JLabel label_9 = new JLabel("Aerolinea");
	label_9.setBounds(607, 446, 72, 16);
	getContentPane().add(label_9);
	
	JLabel label_10 = new JLabel("Alianza");
	label_10.setBounds(607, 491, 45, 16);
	getContentPane().add(label_10);
	
	JLabel lblNumeroPasajero = new JLabel("Numero Pasajero");
	lblNumeroPasajero.setBounds(586, 407, 126, 16);
	getContentPane().add(lblNumeroPasajero);
	
	JLabel label_12 = new JLabel("Categoria");
	label_12.setBounds(816, 407, 85, 16);
	getContentPane().add(label_12);
	
	JLabel label_14 = new JLabel("Fecha de Vencimiento");
	label_14.setBounds(526, 291, 126, 16);
	getContentPane().add(label_14);
	
	lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
	lblPasajeroFrecuente.setBounds(516, 358, 221, 17);
	getContentPane().add(lblPasajeroFrecuente);
	
	lblPasaporte = new JLabel("Pasaporte");
	lblPasaporte.setBounds(526, 123, 138, 16);
	getContentPane().add(lblPasaporte);
	
	lblDatosBasicos = new JLabel("Datos Basicos");
	lblDatosBasicos.setBounds(14, 123, 221, 16);
	getContentPane().add(lblDatosBasicos);
	
	lblTelefono = new JLabel("Telefono");
	lblTelefono.setBounds(14, 308, 221, 16);
	getContentPane().add(lblTelefono);
	
	lblDireccion = new JLabel("Direccion");
	lblDireccion.setBounds(14, 446, 221, 16);
	getContentPane().add(lblDireccion);
	
	JLabel lblCuitcuil = new JLabel("CUIT/CUIL");
	lblCuitcuil.setBounds(306, 277, 72, 14);
	getContentPane().add(lblCuitcuil);
	
	textAlianza = new JTextField();
	textAlianza.setEnabled(false);
	textAlianza.setEditable(false);
	textAlianza.setBounds(686, 489, 127, 20);
//	getContentPane().add(textAlianza);
	textAlianza.setColumns(10);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(14, 446, 476, 177);
	getContentPane().add(separator);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setBounds(0, 308, 476, 139);
	getContentPane().add(separator_1);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setBounds(500, 358, 449, 265);
	getContentPane().add(separator_2);
	
	JLabel lblIngreseLosDatos = new JLabel("Modificacion de los datos del Cliente");
	lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
	lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblIngreseLosDatos.setBounds(96, 33, 805, 55);
	getContentPane().add(lblIngreseLosDatos);
	this.setVisible(true);
	}

	
	public Cliente_Datos_Controller getController() {
		return vista;
	}



	public void setController(Cliente_Datos_Controller vista) {
		this.vista = vista;
	}



	public JButton getBtnCancelar() {
		return btnCancelar;
	}



	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
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



	public JTextField getTextDNI() {
		return textDNI;
	}



	public void setTextDNI(JTextField textDNI) {
		this.textDNI = textDNI;
	}



	public JButton getBtnGuardar() {
		return btnGuardar;
	}



	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
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



	public JLabel getLbl_Alianza() {
		return lbl_Alianza;
	}

	public void setLbl_Alianza(JLabel lbl_Alianza) {
		this.lbl_Alianza = lbl_Alianza;
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



	public JTextField getTextCuit() {
		return textCuit;
	}



	public void setTextCuit(JTextField textCuit) {
		this.textCuit = textCuit;
	}



	public JComboBox<Pais> getComboBox_Pais() {
		return comboBox_Pais;
	}



	public void setComboBox_Pais(JComboBox<Pais> comboBox_Pais) {
		this.comboBox_Pais = comboBox_Pais;
	}

	

	public JDateChooser getVencPasaport() {
		return VencPasaport;
	}

	public void setVencPasaport(JDateChooser vencPasaport) {
		VencPasaport = vencPasaport;
	}

	public JDateChooser getEmisionPasaport() {
		return EmisionPasaport;
	}

	public void setEmisionPasaport(JDateChooser emisionPasaport) {
		EmisionPasaport = emisionPasaport;
	}

	public JDateChooser getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(JDateChooser fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
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


	public JButton getBtnGuardarMod() {
		return btnGuardarMod;
	}

	public void setBtnGuardarMod(JButton btnGuardarMod) {
		this.btnGuardarMod = btnGuardarMod;
	}
	
	public void cancelaOperacion() {
		JOptionPane.showMessageDialog(null, "La operacion se ha cancelado", "", JOptionPane.WARNING_MESSAGE);
	}
	public void exitoOperacion() {
		JOptionPane.showMessageDialog(null, "La operacion se ha completado con exito", "", JOptionPane.INFORMATION_MESSAGE);
	}
	public void fracasoOperacion() {
		JOptionPane.showMessageDialog(null, "La operacion no se pudo realizar", "", JOptionPane.WARNING_MESSAGE);
	}
	private void close(){
        if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    } 
}
