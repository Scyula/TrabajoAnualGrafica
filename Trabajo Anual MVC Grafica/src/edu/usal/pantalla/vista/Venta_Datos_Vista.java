package edu.usal.pantalla.vista;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Venta;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.Cliente_Datos_Controller;
import edu.usal.pantalla.controller.Venta_Datos_Controller;
import edu.usal.pantalla.vista.eventos.CapturaBtnCliente_Datos;
import edu.usal.pantalla.vista.eventos.CapturaBtnVenta_Datos;
import edu.usal.pantalla.vista.eventos.CapturaItemCliente;
import edu.usal.pantalla.vista.eventos.CapturaItemVenta;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;

public class Venta_Datos_Vista extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	Venta_Datos_Controller vista;
	
	private JPanel contentPane;
	
	private JButton btnCancelar;
	private JButton btnBuscarCliente;
	private JButton btnBuscarVuelo;
	private JButton btnGuardarMod;
	private JButton btnGuardar;
	
	
	private JTextField textBuscarDNI;
	private JTextField textNombreVenta;
	private JTextField textApellido;
	private JTextField textDNI;
	private JTextField textFechaNac;
	private JTextField textEmail;
	private JTextField textBuscarVuelo;
	private JTextField textID_Vuelo;
	private JTextField textAerolinea;
	private JTextField textAeropuertoSalida;
	private JTextField textAeropuertoLlegada;
	private JTextField textFechaSalida;
	private JTextField textValor;
	private JTextField textFechaLlegada;
	private JTextField textTotalPagar;
	
	private ButtonGroup botones;
	private JRadioButton rdbtnTarjeta;
	private JRadioButton rdbtnEfectivo;
	
	private JComboBox<String> comboBox_Cuotas;
	
	public Venta_Datos_Vista(Venta_Datos_Controller vista) {

		this.vista = vista;
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		
	    addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent evt) {
	            close();
	        }
	    });
		setBounds(5, 53, 603, 673);
		setLocationRelativeTo(null);
		
		
		setTitle("Nueva Venta");
		getContentPane().setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		btnCancelar.setBounds(481, 598, 97, 25);
		getContentPane().add(btnCancelar);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setBounds(149, 116, 89, 23);
		btnBuscarCliente.addActionListener(new CapturaBtnVenta_Datos(this));
		getContentPane().add(btnBuscarCliente);
		
		btnBuscarVuelo = new JButton("Buscar");
		btnBuscarVuelo.setBounds(149, 287, 89, 23);
		btnBuscarVuelo.addActionListener(new CapturaBtnVenta_Datos(this));
		getContentPane().add(btnBuscarVuelo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(376, 599, 89, 23);
		btnGuardar.addActionListener(new CapturaBtnVenta_Datos(this));
		getContentPane().add(btnGuardar);
		
		textBuscarDNI = new JTextField();
		textBuscarDNI.setBounds(31, 117, 86, 20);
		getContentPane().add(textBuscarDNI);
		textBuscarDNI.setColumns(10);
		
		textBuscarVuelo = new JTextField();
		textBuscarVuelo.setColumns(10);
		textBuscarVuelo.setBounds(31, 288, 86, 20);
		getContentPane().add(textBuscarVuelo);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(31, 491, 109, 20);
		getContentPane().add(textValor);
		
		textNombreVenta = new JTextField();
		textNombreVenta.setEditable(false);
		textNombreVenta.setEnabled(false);
		textNombreVenta.setBounds(441, 93, 136, 20);
		getContentPane().add(textNombreVenta);
		textNombreVenta.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setEnabled(false);
		textApellido.setEditable(false);
		textApellido.setColumns(10);
		textApellido.setBounds(441, 116, 136, 20);
		getContentPane().add(textApellido);
		
		textDNI = new JTextField();
		textDNI.setEnabled(false);
		textDNI.setEditable(false);
		textDNI.setColumns(10);
		textDNI.setBounds(441, 141, 136, 20);
		getContentPane().add(textDNI);
		
		textFechaNac = new JTextField();
		textFechaNac.setEnabled(false);
		textFechaNac.setEditable(false);
		textFechaNac.setColumns(10);
		textFechaNac.setBounds(441, 166, 136, 20);
		getContentPane().add(textFechaNac);
		
		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		textEmail.setBounds(441, 191, 136, 20);
		getContentPane().add(textEmail);
		
		textID_Vuelo = new JTextField();
		textID_Vuelo.setEnabled(false);
		textID_Vuelo.setEditable(false);
		textID_Vuelo.setColumns(10);
		textID_Vuelo.setBounds(441, 264, 136, 20);
		getContentPane().add(textID_Vuelo);
		
		textAerolinea = new JTextField();
		textAerolinea.setEnabled(false);
		textAerolinea.setEditable(false);
		textAerolinea.setColumns(10);
		textAerolinea.setBounds(441, 287, 136, 20);
		getContentPane().add(textAerolinea);
		
		textAeropuertoSalida = new JTextField();
		textAeropuertoSalida.setEnabled(false);
		textAeropuertoSalida.setEditable(false);
		textAeropuertoSalida.setColumns(10);
		textAeropuertoSalida.setBounds(441, 312, 136, 20);
		getContentPane().add(textAeropuertoSalida);
		
		textAeropuertoLlegada = new JTextField();
		textAeropuertoLlegada.setEnabled(false);
		textAeropuertoLlegada.setEditable(false);
		textAeropuertoLlegada.setColumns(10);
		textAeropuertoLlegada.setBounds(441, 337, 136, 20);
		getContentPane().add(textAeropuertoLlegada);
		
		textFechaSalida = new JTextField();
		textFechaSalida.setEnabled(false);
		textFechaSalida.setEditable(false);
		textFechaSalida.setColumns(10);
		textFechaSalida.setBounds(441, 362, 136, 20);
		getContentPane().add(textFechaSalida);
		
		textFechaLlegada = new JTextField();
		textFechaLlegada.setEnabled(false);
		textFechaLlegada.setEditable(false);
		textFechaLlegada.setColumns(10);
		textFechaLlegada.setBounds(441, 386, 136, 20);
		getContentPane().add(textFechaLlegada);

		botones = new ButtonGroup();
		rdbtnTarjeta = new JRadioButton("Tarjeta");
		rdbtnTarjeta.setBounds(163, 488, 61, 23);
		rdbtnTarjeta.addItemListener(new CapturaItemVenta(this));
		botones.add(rdbtnTarjeta);
		
		textTotalPagar = new JTextField();
		textTotalPagar.setEnabled(false);
		textTotalPagar.setEditable(false);
		textTotalPagar.setBounds(123, 563, 112, 20);
		getContentPane().add(textTotalPagar);
		textTotalPagar.setColumns(10);
		
		
		rdbtnEfectivo = new JRadioButton("Efectivo");
		rdbtnEfectivo.setBounds(163, 514, 70, 23);
		rdbtnEfectivo.addItemListener(new CapturaItemVenta(this));
		botones.add(rdbtnEfectivo);
		
		getContentPane().add(rdbtnEfectivo);
		getContentPane().add(rdbtnTarjeta);
		
		comboBox_Cuotas = new JComboBox();
		comboBox_Cuotas.setEnabled(false);
		comboBox_Cuotas.setModel(new DefaultComboBoxModel(new String[] {"1", "3", "6", "12", "24"}));
		comboBox_Cuotas.addItemListener(new CapturaItemVenta(this));
		comboBox_Cuotas.setBounds(300, 491, 53, 20);
		getContentPane().add(comboBox_Cuotas);
			
		JLabel lblIngreseLosDatos = new JLabel("Ingrese de los datos para una nueva venta");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngreseLosDatos.setBounds(10, 11, 567, 35);
		getContentPane().add(lblIngreseLosDatos);
		
		JLabel lblIngreseDniDel = new JLabel("DNI del cliente");
		lblIngreseDniDel.setBounds(31, 97, 86, 14);
		getContentPane().add(lblIngreseDniDel);
		
		JLabel lblClienteSeleccionado = new JLabel("Cliente seleccionado");
		lblClienteSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClienteSeleccionado.setBounds(302, 57, 162, 25);
		getContentPane().add(lblClienteSeleccionado);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(309, 97, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(309, 120, 46, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(309, 145, 46, 14);
		getContentPane().add(lblDni);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(309, 170, 97, 14);
		getContentPane().add(lblFechaNacimiento);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(309, 195, 46, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblSeleccionarCliente = new JLabel("Seleccionar cliente");
		lblSeleccionarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionarCliente.setBounds(31, 57, 162, 25);
		getContentPane().add(lblSeleccionarCliente);
		
		JLabel lblIdDelVuelo = new JLabel("ID del Vuelo");
		lblIdDelVuelo.setBounds(31, 268, 86, 14);
		getContentPane().add(lblIdDelVuelo);
		
		JLabel lblVueloSeleccionado = new JLabel("Vuelo seleccionado");
		lblVueloSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVueloSeleccionado.setBounds(302, 228, 162, 25);
		getContentPane().add(lblVueloSeleccionado);
		
		JLabel lblIdVuelo = new JLabel("ID Vuelo");
		lblIdVuelo.setBounds(309, 268, 46, 14);
		getContentPane().add(lblIdVuelo);
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(309, 291, 46, 14);
		getContentPane().add(lblAerolinea);
		
		JLabel lblAeropuertoDeSalida = new JLabel("Aeropuerto de salida");
		lblAeropuertoDeSalida.setBounds(309, 316, 108, 14);
		getContentPane().add(lblAeropuertoDeSalida);
		
		JLabel lblAeropuertoDeLlegada = new JLabel("Aeropuerto de llegada");
		lblAeropuertoDeLlegada.setBounds(309, 341, 108, 14);
		getContentPane().add(lblAeropuertoDeLlegada);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora de salida");
		lblFechaYHora.setBounds(309, 366, 108, 14);
		getContentPane().add(lblFechaYHora);
		
		JLabel lblSeleccionarVuelo = new JLabel("Seleccionar Vuelo");
		lblSeleccionarVuelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionarVuelo.setBounds(31, 228, 162, 25);
		getContentPane().add(lblSeleccionarVuelo);
		
		JLabel lblValorSinRecargo = new JLabel("Valor sin recargo");
		lblValorSinRecargo.setBounds(31, 470, 86, 14);
		getContentPane().add(lblValorSinRecargo);
		
		JLabel lblMetodoDePago = new JLabel("Metodo de pago");
		lblMetodoDePago.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMetodoDePago.setBounds(163, 465, 116, 25);
		getContentPane().add(lblMetodoDePago);
		
		JLabel lblFormaDePago = new JLabel("Cobro del vuelo");
		lblFormaDePago.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFormaDePago.setBounds(31, 429, 162, 25);
		getContentPane().add(lblFormaDePago);
		
		
		JLabel lblCuotas = new JLabel("Cuotas");
		lblCuotas.setBounds(254, 492, 46, 14);
		getContentPane().add(lblCuotas);
		
		JLabel lblNewLabel = new JLabel("3 y 6 cuotas sin interes");
		lblNewLabel.setBounds(418, 491, 116, 17);
		getContentPane().add(lblNewLabel);
		
		JLabel lblO = new JLabel("12 o 24 con 10% de recargo");
		lblO.setBounds(418, 514, 143, 14);
		getContentPane().add(lblO);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 220, 567, 14);
		getContentPane().add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 414, 567, 110);
		getContentPane().add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 59, 567, 20);
		getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(274, 57, 12, 335);
		getContentPane().add(separator_3);
		
		JLabel lblFechaYHora_1 = new JLabel("Fecha y hora de llegada");
		lblFechaYHora_1.setBounds(309, 389, 122, 14);
		getContentPane().add(lblFechaYHora_1);
		
		JLabel lblTotalAPagar = new JLabel("TOTAL A PAGAR");
		lblTotalAPagar.setBounds(31, 566, 82, 14);
		getContentPane().add(lblTotalAPagar);
		this.setVisible(true);
		}

	/**
	 * @wbp.parser.constructor
	 */
	public Venta_Datos_Vista(Venta_Datos_Controller vista, Venta venta) {

		this.vista = vista;
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		
	    addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent evt) {
	            close();
	        }
	    });
		setBounds(5, 53, 603, 673);
		setLocationRelativeTo(null);
		
		
		setTitle("Nueva Venta");
		getContentPane().setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		btnCancelar.setBounds(481, 598, 97, 25);
		getContentPane().add(btnCancelar);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setBounds(149, 116, 89, 23);
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		getContentPane().add(btnBuscarCliente);
		
		btnBuscarVuelo = new JButton("Buscar");
		btnBuscarVuelo.setEnabled(false);
		btnBuscarVuelo.setBounds(149, 287, 89, 23);
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		getContentPane().add(btnBuscarVuelo);
		
		btnGuardarMod = new JButton("Guardar");
		btnGuardarMod.setBounds(376, 599, 89, 23);
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		getContentPane().add(btnGuardarMod);
		
		textBuscarDNI = new JTextField();
		textBuscarDNI.setBounds(31, 117, 86, 20);
		getContentPane().add(textBuscarDNI);
		textBuscarDNI.setColumns(10);
		
		textBuscarVuelo = new JTextField();
		textBuscarVuelo.setColumns(10);
		textBuscarVuelo.setBounds(31, 288, 86, 20);
		getContentPane().add(textBuscarVuelo);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(31, 491, 109, 20);
		getContentPane().add(textValor);
		
		textNombreVenta = new JTextField();
		textNombreVenta.setEditable(false);
		textNombreVenta.setBounds(441, 93, 136, 20);
		getContentPane().add(textNombreVenta);
		textNombreVenta.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setEditable(false);
		textApellido.setColumns(10);
		textApellido.setBounds(441, 116, 136, 20);
		getContentPane().add(textApellido);
		
		textDNI = new JTextField();
		textDNI.setEditable(false);
		textDNI.setColumns(10);
		textDNI.setBounds(441, 141, 136, 20);
		getContentPane().add(textDNI);
		
		textFechaNac = new JTextField();
		textFechaNac.setEditable(false);
		textFechaNac.setColumns(10);
		textFechaNac.setBounds(441, 166, 136, 20);
		getContentPane().add(textFechaNac);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		textEmail.setBounds(441, 191, 136, 20);
		getContentPane().add(textEmail);
		
		textID_Vuelo = new JTextField();
		textID_Vuelo.setEditable(false);
		textID_Vuelo.setColumns(10);
		textID_Vuelo.setBounds(441, 264, 136, 20);
		getContentPane().add(textID_Vuelo);
		
		textAerolinea = new JTextField();
		textAerolinea.setEditable(false);
		textAerolinea.setColumns(10);
		textAerolinea.setBounds(441, 287, 136, 20);
		getContentPane().add(textAerolinea);
		
		textAeropuertoSalida = new JTextField();
		textAeropuertoSalida.setEditable(false);
		textAeropuertoSalida.setColumns(10);
		textAeropuertoSalida.setBounds(441, 312, 136, 20);
		getContentPane().add(textAeropuertoSalida);
		
		textAeropuertoLlegada = new JTextField();
		textAeropuertoLlegada.setEditable(false);
		textAeropuertoLlegada.setColumns(10);
		textAeropuertoLlegada.setBounds(441, 337, 136, 20);
		getContentPane().add(textAeropuertoLlegada);
		
		textFechaSalida = new JTextField();
		textFechaSalida.setEditable(false);
		textFechaSalida.setColumns(10);
		textFechaSalida.setBounds(441, 362, 136, 20);
		getContentPane().add(textFechaSalida);
		
		textFechaLlegada = new JTextField();
		textFechaLlegada.setEditable(false);
		textFechaLlegada.setColumns(10);
		textFechaLlegada.setBounds(441, 386, 136, 20);
		getContentPane().add(textFechaLlegada);

		botones = new ButtonGroup();
		rdbtnTarjeta = new JRadioButton("Tarjeta");
		rdbtnTarjeta.setBounds(163, 488, 61, 23);
		rdbtnTarjeta.addItemListener(new CapturaItemVenta(this));
		botones.add(rdbtnTarjeta);
		
		textTotalPagar = new JTextField();
		textTotalPagar.setText(String.valueOf(venta.getTotalPagar()));
		textTotalPagar.setEnabled(false);
		textTotalPagar.setEditable(false);
		textTotalPagar.setBounds(123, 563, 112, 20);
		getContentPane().add(textTotalPagar);
		textTotalPagar.setColumns(10);
		
		
		rdbtnEfectivo = new JRadioButton("Efectivo");
		rdbtnEfectivo.setBounds(163, 514, 70, 23);
		rdbtnEfectivo.addItemListener(new CapturaItemVenta(this));
		botones.add(rdbtnEfectivo);
		
		getContentPane().add(rdbtnEfectivo);
		getContentPane().add(rdbtnTarjeta);
		
		comboBox_Cuotas = new JComboBox();
		comboBox_Cuotas.setEnabled(false);
		comboBox_Cuotas.setModel(new DefaultComboBoxModel(new String[] {"1", "3", "6", "12", "24"}));
		comboBox_Cuotas.addItemListener(new CapturaItemVenta(this));
		comboBox_Cuotas.setBounds(300, 491, 53, 20);
		getContentPane().add(comboBox_Cuotas);
		
		JLabel lblIngreseLosDatos = new JLabel("Mostrando los datos de la venta para su modificacion");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngreseLosDatos.setBounds(10, 11, 567, 35);
		getContentPane().add(lblIngreseLosDatos);
		
		JLabel lblIngreseDniDel = new JLabel("DNI del cliente");
		lblIngreseDniDel.setBounds(31, 97, 86, 14);
		getContentPane().add(lblIngreseDniDel);
		
		JLabel lblClienteSeleccionado = new JLabel("Cliente seleccionado");
		lblClienteSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClienteSeleccionado.setBounds(302, 57, 162, 25);
		getContentPane().add(lblClienteSeleccionado);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(309, 97, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(309, 120, 46, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(309, 145, 46, 14);
		getContentPane().add(lblDni);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(309, 170, 97, 14);
		getContentPane().add(lblFechaNacimiento);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(309, 195, 46, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblSeleccionarCliente = new JLabel("Seleccionar cliente");
		lblSeleccionarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionarCliente.setBounds(31, 57, 162, 25);
		getContentPane().add(lblSeleccionarCliente);
		
		JLabel lblIdDelVuelo = new JLabel("ID del Vuelo");
		lblIdDelVuelo.setBounds(31, 268, 86, 14);
		getContentPane().add(lblIdDelVuelo);
		
		JLabel lblVueloSeleccionado = new JLabel("Vuelo seleccionado");
		lblVueloSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVueloSeleccionado.setBounds(302, 228, 162, 25);
		getContentPane().add(lblVueloSeleccionado);
		
		JLabel lblIdVuelo = new JLabel("ID Vuelo");
		lblIdVuelo.setBounds(309, 268, 46, 14);
		getContentPane().add(lblIdVuelo);
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(309, 291, 46, 14);
		getContentPane().add(lblAerolinea);
		
		JLabel lblAeropuertoDeSalida = new JLabel("Aeropuerto de salida");
		lblAeropuertoDeSalida.setBounds(309, 316, 108, 14);
		getContentPane().add(lblAeropuertoDeSalida);
		
		JLabel lblAeropuertoDeLlegada = new JLabel("Aeropuerto de llegada");
		lblAeropuertoDeLlegada.setBounds(309, 341, 108, 14);
		getContentPane().add(lblAeropuertoDeLlegada);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora de salida");
		lblFechaYHora.setBounds(309, 366, 108, 14);
		getContentPane().add(lblFechaYHora);
		
		JLabel lblSeleccionarVuelo = new JLabel("Vuelo (no se puede modificar) ");
		lblSeleccionarVuelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionarVuelo.setBounds(31, 228, 233, 25);
		getContentPane().add(lblSeleccionarVuelo);
		
		JLabel lblValorSinRecargo = new JLabel("Valor sin recargo");
		lblValorSinRecargo.setBounds(31, 470, 86, 14);
		getContentPane().add(lblValorSinRecargo);
		
		JLabel lblMetodoDePago = new JLabel("Metodo de pago");
		lblMetodoDePago.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMetodoDePago.setBounds(163, 465, 116, 25);
		getContentPane().add(lblMetodoDePago);
		
		JLabel lblFormaDePago = new JLabel("Cobro del vuelo");
		lblFormaDePago.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFormaDePago.setBounds(31, 429, 162, 25);
		getContentPane().add(lblFormaDePago);
		
		
		JLabel lblCuotas = new JLabel("Cuotas");
		lblCuotas.setBounds(254, 492, 46, 14);
		getContentPane().add(lblCuotas);
		
		JLabel lblNewLabel = new JLabel("3 y 6 cuotas sin interes");
		lblNewLabel.setBounds(418, 491, 116, 17);
		getContentPane().add(lblNewLabel);
		
		JLabel lblO = new JLabel("12 o 24 con 10% de recargo");
		lblO.setBounds(418, 514, 143, 14);
		getContentPane().add(lblO);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 220, 567, 14);
		getContentPane().add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 414, 567, 110);
		getContentPane().add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 59, 567, 20);
		getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(274, 57, 12, 335);
		getContentPane().add(separator_3);
		
		JLabel lblFechaYHora_1 = new JLabel("Fecha y hora de llegada");
		lblFechaYHora_1.setBounds(309, 389, 122, 14);
		getContentPane().add(lblFechaYHora_1);
		
		JLabel lblTotalAPagar = new JLabel("TOTAL A PAGAR");
		lblTotalAPagar.setBounds(31, 566, 82, 14);
		getContentPane().add(lblTotalAPagar);

		
		}

	
	public Venta_Datos_Controller getController() {
		return vista;
	}



	public void setController(Venta_Datos_Controller vista) {
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
		return textNombreVenta;
	}



	public void setTextNombre(JTextField textNombre) {
		this.textNombreVenta = textNombre;
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
	
	

	public Venta_Datos_Controller getVista() {
		return vista;
	}


	public void setVista(Venta_Datos_Controller vista) {
		this.vista = vista;
	}


	public JButton getBtnBuscarCliente() {
		return btnBuscarCliente;
	}


	public void setBtnBuscarCliente(JButton btnBuscarCliente) {
		this.btnBuscarCliente = btnBuscarCliente;
	}


	public JButton getBtnBuscarVuelo() {
		return btnBuscarVuelo;
	}


	public void setBtnBuscarVuelo(JButton btnBuscarVuelo) {
		this.btnBuscarVuelo = btnBuscarVuelo;
	}


	public JButton getBtnGuardar() {
		return btnGuardar;
	}


	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}



	public JTextField getTextNombreVenta() {
		return textNombreVenta;
	}

	

	public JTextField getTextBuscarDNI() {
		return textBuscarDNI;
	}


	public void setTextBuscarDNI(JTextField textBuscarDNI) {
		this.textBuscarDNI = textBuscarDNI;
	}


	public JTextField getTextBuscarVuelo() {
		return textBuscarVuelo;
	}


	public void setTextBuscarVuelo(JTextField textBuscarVuelo) {
		this.textBuscarVuelo = textBuscarVuelo;
	}


	public JTextField getTextTotalPagar() {
		return textTotalPagar;
	}


	public void setTextTotalPagar(JTextField textTotalPagar) {
		this.textTotalPagar = textTotalPagar;
	}


	public void setTextNombreVenta(JTextField textNombreVenta) {
		this.textNombreVenta = textNombreVenta;
	}


	public JTextField getTextFechaNac() {
		return textFechaNac;
	}


	public void setTextFechaNac(JTextField textFechaNac) {
		this.textFechaNac = textFechaNac;
	}


	public JTextField getTextID_Vuelo() {
		return textID_Vuelo;
	}


	public void setTextID_Vuelo(JTextField textID_Vuelo) {
		this.textID_Vuelo = textID_Vuelo;
	}


	public JTextField getTextAerolinea() {
		return textAerolinea;
	}


	public void setTextAerolinea(JTextField textAerolinea) {
		this.textAerolinea = textAerolinea;
	}


	public JTextField getTextAeropuertoSalida() {
		return textAeropuertoSalida;
	}


	public void setTextAeropuertoSalida(JTextField textAeropuertoSalida) {
		this.textAeropuertoSalida = textAeropuertoSalida;
	}


	public JTextField getTextAeropuertoLlegada() {
		return textAeropuertoLlegada;
	}


	public void setTextAeropuertoLlegada(JTextField textAeropuertoLlegada) {
		this.textAeropuertoLlegada = textAeropuertoLlegada;
	}


	public JTextField getTextFechaSalida() {
		return textFechaSalida;
	}


	public void setTextFechaSalida(JTextField textFechaSalida) {
		this.textFechaSalida = textFechaSalida;
	}


	public JTextField getTextValor() {
		return textValor;
	}


	public void setTextValor(JTextField textValor) {
		this.textValor = textValor;
	}


	public JTextField getTextFechaLlegada() {
		return textFechaLlegada;
	}


	public void setTextFechaLlegada(JTextField textFechaLlegada) {
		this.textFechaLlegada = textFechaLlegada;
	}


	public ButtonGroup getBotones() {
		return botones;
	}


	public void setBotones(ButtonGroup botones) {
		this.botones = botones;
	}


	public JRadioButton getRdbtnTarjeta() {
		return rdbtnTarjeta;
	}


	public void setRdbtnTarjeta(JRadioButton rdbtnTarjeta) {
		this.rdbtnTarjeta = rdbtnTarjeta;
	}


	public JRadioButton getRdbtnEfectivo() {
		return rdbtnEfectivo;
	}


	public void setRdbtnEfectivo(JRadioButton rdbtnEfectivo) {
		this.rdbtnEfectivo = rdbtnEfectivo;
	}


	public JComboBox<String> getComboBox_Cuotas() {
		return comboBox_Cuotas;
	}


	public void setComboBox_Cuotas(JComboBox<String> comboBox_Cuotas) {
		this.comboBox_Cuotas = comboBox_Cuotas;
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
	public void errorOperacion(String problema) {
		JOptionPane.showMessageDialog(null, "La operacion no se pudo realizar\n"+problema, "", JOptionPane.WARNING_MESSAGE);
	}
	public void errorBaseDatos(String causa) {
		JOptionPane.showMessageDialog(null, "Error en la base de datos\n"+causa, "", JOptionPane.WARNING_MESSAGE);
	}
	
	
	
	private void close(){
        if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }


	public boolean seleccionarCliente(Cliente buscar) {
			if(JOptionPane.showConfirmDialog(null, ("Desea seleccionar al siaguiente cliente?\n Apellido: "+buscar.getApellido()+
					"\nNombre: "+buscar.getNombre()+"\nDNI: ["+buscar.getDNI()+"]"), "Confirmacion de seleccion",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
				return true;
			}
			return false;
	}


	public boolean seleccionarVuelo(Vuelo buscar) {
		if(JOptionPane.showConfirmDialog(null, ("Desea seleccionar al siguiente vuelo?\n ID del Vuelo: "+buscar.getId_vuelo()+
				"\nAerolinea: "+buscar.getAerolinea().getNombre()+"\nAeropuerto de salida: ["+buscar.getAeroSalida().getCiudad()+"]"
				+"\nAeropuerto de llegada: ["+buscar.getAeroLlegada().getCiudad()+"]"
				+"\nHorario de salida: ["+buscar.getFechaHoraSalida().getHours()+":"+buscar.getFechaHoraSalida().getMinutes()+"]"
				+"\nHorario de salida: ["+buscar.getFechaHoraLlegada().getHours()+":"+buscar.getFechaHoraLlegada().getMinutes()+"]"
				+"\nTiempo de vuelo: ["+buscar.getTiempoVuelo()+"]"), "Confirmacion de seleccion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	public void cargarDatos(Venta venta) {

		getController().ingresarDatosCliente(venta.getCliente());
		getController().ingresarDatosVuelo(venta.getVuelo());
		getController().asignarDatos(venta);
		
		this.setVisible(true);
		
	} 
}
