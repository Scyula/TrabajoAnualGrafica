package edu.usal.pantalla.vista.datos;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Venta;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.datos.Venta_Datos_Controller;
import edu.usal.pantalla.vista.eventos.CapturaBtnVenta_Datos;
import edu.usal.pantalla.vista.eventos.CapturaItemVenta;
import edu.usal.pantalla.vista.eventos.CapturaTextValor;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;

public class Venta_Datos_Vista extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	Venta_Datos_Controller vista;
		
	private JButton btnCancelar;
	private JButton btnBuscarCliente;
	private JButton btnBuscarVuelo;
	private JButton btnGuardarMod;
	private JButton btnGuardar;
	private JButton btnVerVuelos;
	private JButton btnVerClientes;
	
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
	private JTextField textFechaLlegada;

	JRadioButton rdbtnEfectivo;
	JRadioButton rdbtnTarjeta;
	JComboBox<String> comboBox_Cuotas;
	
	private ButtonGroup botones;
	private JTextField textValor;
	private JTextField textTotalPagar;
	
	public Venta_Datos_Vista(Venta_Datos_Controller vista) {
		this.vista = vista;
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		
	    addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent evt) {
	            close();
	        }
	    });
		setBounds(5, 53, 960, 688);
		setLocationRelativeTo(null);
		
		
		setTitle("Modificar Venta");

		botones = new ButtonGroup();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		getContentPane().add(panel_11);
		panel_11.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_11.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_45 = new JPanel();
		panel_3.add(panel_45);
		
		JLabel lblSeleccionarCliente = new JLabel("Seleccionar cliente");
		lblSeleccionarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblSeleccionarCliente);
		lblSeleccionarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_28 = new JPanel();
		panel_3.add(panel_28);
		panel_28.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_29 = new JPanel();
		panel_28.add(panel_29);
		
		JLabel lblIngreseDniDel = new JLabel("DNI del cliente");
		panel_28.add(lblIngreseDniDel);
		lblIngreseDniDel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_27 = new JPanel();
		panel_5.add(panel_27);
		
		textBuscarDNI = new JTextField();
		panel_5.add(textBuscarDNI);
		textBuscarDNI.setColumns(10);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new CapturaBtnVenta_Datos(this));
		panel_5.add(btnBuscarCliente);
		
		JPanel panel_21 = new JPanel();
		panel_3.add(panel_21);
		panel_21.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_50 = new JPanel();
		panel_21.add(panel_50);
		panel_50.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnVerClientes = new JButton("Ver Clientes");
		btnVerClientes.addActionListener(new CapturaBtnVenta_Datos(this));
		panel_21.add(btnVerClientes);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_22 = new JPanel();
		panel_4.add(panel_22);
		
		JPanel panel_46 = new JPanel();
		panel_4.add(panel_46);
		panel_46.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblClienteSeleccionado = new JLabel("Cliente seleccionado");
		panel_46.add(lblClienteSeleccionado);
		lblClienteSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienteSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_47 = new JPanel();
		panel_4.add(panel_47);
		panel_47.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre ");
		panel_47.add(lblNombre);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textNombreVenta = new JTextField();
		panel_47.add(textNombreVenta);
		textNombreVenta.setEditable(false);
		textNombreVenta.setColumns(10);
		
		JPanel panel_48 = new JPanel();
		panel_4.add(panel_48);
		panel_48.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblApellido = new JLabel("Apellido ");
		panel_48.add(lblApellido);
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textApellido = new JTextField();
		panel_48.add(textApellido);
		textApellido.setEditable(false);
		textApellido.setColumns(10);
		
		JPanel panel_49 = new JPanel();
		panel_4.add(panel_49);
		panel_49.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblDni = new JLabel("DNI ");
		panel_49.add(lblDni);
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textDNI = new JTextField();
		panel_49.add(textDNI);
		textDNI.setEditable(false);
		textDNI.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento ");
		panel_1.add(lblFechaNacimiento);
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFechaNac = new JTextField();
		panel_1.add(textFechaNac);
		textFechaNac.setEditable(false);
		textFechaNac.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblEmail = new JLabel("E-mail ");
		panel_6.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textEmail = new JTextField();
		panel_6.add(textEmail);
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_11.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_34 = new JPanel();
		panel_8.add(panel_34);
		panel_34.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16);
		panel_16.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblSeleccionarVuelo = new JLabel("Seleccionar Vuelo");
		panel_16.add(lblSeleccionarVuelo);
		lblSeleccionarVuelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarVuelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_41 = new JPanel();
		panel_8.add(panel_41);
		panel_41.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_42 = new JPanel();
		panel_41.add(panel_42);
		
		JLabel lblIdVuelo = new JLabel("ID Vuelo");
		lblIdVuelo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_41.add(lblIdVuelo);
		
		JPanel panel_23 = new JPanel();
		panel_8.add(panel_23);
		panel_23.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_39 = new JPanel();
		panel_23.add(panel_39);
		
		textBuscarVuelo = new JTextField();
		panel_23.add(textBuscarVuelo);
		textBuscarVuelo.setColumns(10);
		
		btnBuscarVuelo = new JButton("Buscar");
		panel_23.add(btnBuscarVuelo);
		btnBuscarVuelo.addActionListener(new CapturaBtnVenta_Datos(this));
		
		JPanel panel_24 = new JPanel();
		panel_8.add(panel_24);
		panel_24.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_26 = new JPanel();
		panel_24.add(panel_26);
		
		btnVerVuelos = new JButton("Ver Vuelos");
		btnVerVuelos.addActionListener(new CapturaBtnVenta_Datos(this));
		panel_24.add(btnVerVuelos);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		
		JPanel panel_33 = new JPanel();
		panel_8.add(panel_33);
		panel_33.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setLayout(new GridLayout(8, 3, 0, 0));
		
		JPanel panel_35 = new JPanel();
		panel_9.add(panel_35);
		
		JPanel panel_64 = new JPanel();
		panel_9.add(panel_64);
		
		JPanel panel_65 = new JPanel();
		panel_9.add(panel_65);
		
		JPanel panel_66 = new JPanel();
		panel_9.add(panel_66);
		
		JLabel label = new JLabel("Vuelo seleccionado ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_9.add(label);
		
		JPanel panel_36 = new JPanel();
		panel_9.add(panel_36);
		
		JLabel lblIdDelVuelo = new JLabel("ID del Vuelo ");
		lblIdDelVuelo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblIdDelVuelo);
		
		textID_Vuelo = new JTextField();
		panel_9.add(textID_Vuelo);
		textID_Vuelo.setEditable(false);
		textID_Vuelo.setColumns(10);
		
		JPanel panel_30 = new JPanel();
		panel_9.add(panel_30);
		
		JLabel lblAerolinea = new JLabel("Aerolinea ");
		lblAerolinea.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblAerolinea);
		
		textAerolinea = new JTextField();
		panel_9.add(textAerolinea);
		textAerolinea.setEditable(false);
		textAerolinea.setColumns(10);
		
		JPanel panel_53 = new JPanel();
		panel_9.add(panel_53);
		
		JLabel lblAeropuertoDeSalida = new JLabel("Aeropuerto de salida ");
		panel_9.add(lblAeropuertoDeSalida);
		lblAeropuertoDeSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textAeropuertoSalida = new JTextField();
		panel_9.add(textAeropuertoSalida);
		textAeropuertoSalida.setEditable(false);
		textAeropuertoSalida.setColumns(10);
		
		JPanel panel_52 = new JPanel();
		panel_9.add(panel_52);
		
		JLabel lblAeropuertoDeLlegada = new JLabel("Aeropuerto de llegada ");
		lblAeropuertoDeLlegada.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblAeropuertoDeLlegada);
		
		textAeropuertoLlegada = new JTextField();
		panel_9.add(textAeropuertoLlegada);
		textAeropuertoLlegada.setEditable(false);
		textAeropuertoLlegada.setColumns(10);
		
		JPanel panel_54 = new JPanel();
		panel_9.add(panel_54);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora de salida ");
		lblFechaYHora.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblFechaYHora);
		
		textFechaSalida = new JTextField();
		panel_9.add(textFechaSalida);
		textFechaSalida.setEditable(false);
		textFechaSalida.setColumns(10);
		
		JPanel panel_55 = new JPanel();
		panel_9.add(panel_55);
		
		JLabel lblFechaYHora_1 = new JLabel("Fecha y hora de llegada ");
		lblFechaYHora_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblFechaYHora_1);
		
		textFechaLlegada = new JTextField();
		panel_9.add(textFechaLlegada);
		textFechaLlegada.setEditable(false);
		textFechaLlegada.setColumns(10);
		
		JPanel panel_31 = new JPanel();
		panel_11.add(panel_31);
		panel_31.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_51 = new JPanel();
		panel_31.add(panel_51);
		
		JLabel lblFormaDePago = new JLabel("Cobro del pasaje");
		panel_31.add(lblFormaDePago);
		lblFormaDePago.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormaDePago.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_32 = new JPanel();
		panel_31.add(panel_32);
		panel_32.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_32.add(panel_17);
		panel_17.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblValorSinRecargo_1 = new JLabel("Valor sin recargo  ");
		lblValorSinRecargo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_17.add(lblValorSinRecargo_1);
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 2, 0, 0));
		
		textValor = new JTextField();
		panel_19.add(textValor);
		textValor.getDocument().addDocumentListener(new CapturaTextValor(this));
		textValor.setColumns(10);
		
		JLabel label_2 = new JLabel("Metodo de pago");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_17.add(label_2);
		
		JPanel panel_18 = new JPanel();
		panel_17.add(panel_18);
		panel_18.setLayout(new GridLayout(1, 0, 0, 0));
		
		rdbtnTarjeta = new JRadioButton("Tarjeta");
		rdbtnTarjeta.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnTarjeta.addItemListener(new CapturaItemVenta(this));
		botones.add(rdbtnTarjeta);
		panel_18.add(rdbtnTarjeta);
		
		rdbtnEfectivo = new JRadioButton("Efectivo");
		rdbtnEfectivo.addItemListener(new CapturaItemVenta(this));
		botones.add(rdbtnEfectivo);
		panel_18.add(rdbtnEfectivo);
		
		JPanel panel_15 = new JPanel();
		panel_32.add(panel_15);
		panel_15.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel label_3 = new JLabel("3 y 6 cuotas sin interes");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_15.add(label_3);
		
		JLabel label_5 = new JLabel("Cuotas  ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_15.add(label_5);
		
		comboBox_Cuotas = new JComboBox<String>();
		comboBox_Cuotas.setEnabled(false);
		comboBox_Cuotas.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "3", "6", "12", "24"}));
		comboBox_Cuotas.addItemListener(new CapturaItemVenta(this));
		comboBox_Cuotas.setBounds(300, 491, 53, 20);
		panel_15.add(comboBox_Cuotas);
		
		JPanel panel_56 = new JPanel();
		panel_15.add(panel_56);
		
		JPanel panel_20 = new JPanel();
		panel_15.add(panel_20);
		panel_20.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label_4 = new JLabel("12 o 24 con 10% de recargo");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_20.add(label_4);
		
		JLabel label_6 = new JLabel("TOTAL A PAGAR  ");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_15.add(label_6);
		
		textTotalPagar = new JTextField();
		textTotalPagar.setEditable(false);
		textTotalPagar.setColumns(10);
		panel_15.add(textTotalPagar);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_25 = new JPanel();
		panel.add(panel_25);
		
		JLabel lblIngreseLosDatos = new JLabel("Mostrando los datos de la venta para su modificacion");
		panel.add(lblIngreseLosDatos);
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel_12 = new JPanel();
		getContentPane().add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new GridLayout(2, 7, 0, 0));
		
		JPanel panel_40 = new JPanel();
		panel_12.add(panel_40);
		
		btnCancelar = new JButton("Cancelar");
		panel_12.add(btnCancelar);
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		
		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13);
		
		JPanel panel_60 = new JPanel();
		panel_12.add(panel_60);
		
		JPanel panel_61 = new JPanel();
		panel_12.add(panel_61);
		
		btnGuardar = new JButton("Guardar");
		panel_12.add(btnGuardar);
		btnGuardar.addActionListener(new CapturaBtnVenta_Datos(this));
		
		JPanel panel_62 = new JPanel();
		panel_12.add(panel_62);
		
		JPanel panel_63 = new JPanel();
		panel_12.add(panel_63);
		
		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14);
		
		JPanel panel_38 = new JPanel();
		panel_12.add(panel_38);
		
		JPanel panel_37 = new JPanel();
		panel_12.add(panel_37);
		
		JPanel panel_58 = new JPanel();
		panel_12.add(panel_58);
		
		JPanel panel_59 = new JPanel();
		panel_12.add(panel_59);
		
		JPanel panel_57 = new JPanel();
		panel_12.add(panel_57);
		
		JPanel panel_43 = new JPanel();
		getContentPane().add(panel_43, BorderLayout.WEST);
		
		JPanel panel_44 = new JPanel();
		getContentPane().add(panel_44, BorderLayout.EAST);
		

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
		setBounds(5, 53, 960, 688);
		setLocationRelativeTo(null);
		
		
		setTitle("Modificar Venta");

		botones = new ButtonGroup();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		getContentPane().add(panel_11);
		panel_11.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_11.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_45 = new JPanel();
		panel_3.add(panel_45);
		
		JLabel lblSeleccionarCliente = new JLabel("Seleccionar cliente");
		lblSeleccionarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblSeleccionarCliente);
		lblSeleccionarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_28 = new JPanel();
		panel_3.add(panel_28);
		panel_28.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_29 = new JPanel();
		panel_28.add(panel_29);
		
		JLabel lblIngreseDniDel = new JLabel("DNI del cliente");
		panel_28.add(lblIngreseDniDel);
		lblIngreseDniDel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_27 = new JPanel();
		panel_5.add(panel_27);
		
		textBuscarDNI = new JTextField();
		panel_5.add(textBuscarDNI);
		textBuscarDNI.setColumns(10);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new CapturaBtnVenta_Datos(this));
		panel_5.add(btnBuscarCliente);
		
		JPanel panel_21 = new JPanel();
		panel_3.add(panel_21);
		panel_21.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_50 = new JPanel();
		panel_21.add(panel_50);
		panel_50.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnVerClientes = new JButton("Ver Clientes");
		btnVerClientes.addActionListener(new CapturaBtnVenta_Datos(this));
		panel_21.add(btnVerClientes);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_22 = new JPanel();
		panel_4.add(panel_22);
		
		JPanel panel_46 = new JPanel();
		panel_4.add(panel_46);
		panel_46.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblClienteSeleccionado = new JLabel("Cliente seleccionado");
		panel_46.add(lblClienteSeleccionado);
		lblClienteSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienteSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_47 = new JPanel();
		panel_4.add(panel_47);
		panel_47.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre ");
		panel_47.add(lblNombre);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textNombreVenta = new JTextField();
		panel_47.add(textNombreVenta);
		textNombreVenta.setEditable(false);
		textNombreVenta.setColumns(10);
		
		JPanel panel_48 = new JPanel();
		panel_4.add(panel_48);
		panel_48.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblApellido = new JLabel("Apellido ");
		panel_48.add(lblApellido);
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textApellido = new JTextField();
		panel_48.add(textApellido);
		textApellido.setEditable(false);
		textApellido.setColumns(10);
		
		JPanel panel_49 = new JPanel();
		panel_4.add(panel_49);
		panel_49.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblDni = new JLabel("DNI ");
		panel_49.add(lblDni);
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textDNI = new JTextField();
		panel_49.add(textDNI);
		textDNI.setEditable(false);
		textDNI.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento ");
		panel_1.add(lblFechaNacimiento);
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFechaNac = new JTextField();
		panel_1.add(textFechaNac);
		textFechaNac.setEditable(false);
		textFechaNac.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblEmail = new JLabel("E-mail ");
		panel_6.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textEmail = new JTextField();
		panel_6.add(textEmail);
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_11.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_34 = new JPanel();
		panel_8.add(panel_34);
		panel_34.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16);
		panel_16.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblSeleccionarVuelo = new JLabel("Seleccionar Vuelo");
		panel_16.add(lblSeleccionarVuelo);
		lblSeleccionarVuelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarVuelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_41 = new JPanel();
		panel_8.add(panel_41);
		panel_41.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_42 = new JPanel();
		panel_41.add(panel_42);
		
		JLabel lblIdVuelo = new JLabel("ID Vuelo");
		lblIdVuelo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_41.add(lblIdVuelo);
		
		JPanel panel_23 = new JPanel();
		panel_8.add(panel_23);
		panel_23.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_39 = new JPanel();
		panel_23.add(panel_39);
		
		textBuscarVuelo = new JTextField();
		panel_23.add(textBuscarVuelo);
		textBuscarVuelo.setColumns(10);
		
		btnBuscarVuelo = new JButton("Buscar");
		panel_23.add(btnBuscarVuelo);
		btnBuscarVuelo.addActionListener(new CapturaBtnVenta_Datos(this));
		
		JPanel panel_24 = new JPanel();
		panel_8.add(panel_24);
		panel_24.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_26 = new JPanel();
		panel_24.add(panel_26);
		
		btnVerVuelos = new JButton("Ver Vuelos");
		btnVerVuelos.addActionListener(new CapturaBtnVenta_Datos(this));
		panel_24.add(btnVerVuelos);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		
		JPanel panel_33 = new JPanel();
		panel_8.add(panel_33);
		panel_33.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setLayout(new GridLayout(8, 3, 0, 0));
		
		JPanel panel_35 = new JPanel();
		panel_9.add(panel_35);
		
		JPanel panel_64 = new JPanel();
		panel_9.add(panel_64);
		
		JPanel panel_65 = new JPanel();
		panel_9.add(panel_65);
		
		JPanel panel_66 = new JPanel();
		panel_9.add(panel_66);
		
		JLabel label = new JLabel("Vuelo seleccionado ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_9.add(label);
		
		JPanel panel_36 = new JPanel();
		panel_9.add(panel_36);
		
		JLabel lblIdDelVuelo = new JLabel("ID del Vuelo ");
		lblIdDelVuelo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblIdDelVuelo);
		
		textID_Vuelo = new JTextField();
		panel_9.add(textID_Vuelo);
		textID_Vuelo.setEditable(false);
		textID_Vuelo.setColumns(10);
		
		JPanel panel_30 = new JPanel();
		panel_9.add(panel_30);
		
		JLabel lblAerolinea = new JLabel("Aerolinea ");
		lblAerolinea.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblAerolinea);
		
		textAerolinea = new JTextField();
		panel_9.add(textAerolinea);
		textAerolinea.setEditable(false);
		textAerolinea.setColumns(10);
		
		JPanel panel_53 = new JPanel();
		panel_9.add(panel_53);
		
		JLabel lblAeropuertoDeSalida = new JLabel("Aeropuerto de salida ");
		panel_9.add(lblAeropuertoDeSalida);
		lblAeropuertoDeSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textAeropuertoSalida = new JTextField();
		panel_9.add(textAeropuertoSalida);
		textAeropuertoSalida.setEditable(false);
		textAeropuertoSalida.setColumns(10);
		
		JPanel panel_52 = new JPanel();
		panel_9.add(panel_52);
		
		JLabel lblAeropuertoDeLlegada = new JLabel("Aeropuerto de llegada ");
		lblAeropuertoDeLlegada.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblAeropuertoDeLlegada);
		
		textAeropuertoLlegada = new JTextField();
		panel_9.add(textAeropuertoLlegada);
		textAeropuertoLlegada.setEditable(false);
		textAeropuertoLlegada.setColumns(10);
		
		JPanel panel_54 = new JPanel();
		panel_9.add(panel_54);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora de salida ");
		lblFechaYHora.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblFechaYHora);
		
		textFechaSalida = new JTextField();
		panel_9.add(textFechaSalida);
		textFechaSalida.setEditable(false);
		textFechaSalida.setColumns(10);
		
		JPanel panel_55 = new JPanel();
		panel_9.add(panel_55);
		
		JLabel lblFechaYHora_1 = new JLabel("Fecha y hora de llegada ");
		lblFechaYHora_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblFechaYHora_1);
		
		textFechaLlegada = new JTextField();
		panel_9.add(textFechaLlegada);
		textFechaLlegada.setEditable(false);
		textFechaLlegada.setColumns(10);
		
		JPanel panel_31 = new JPanel();
		panel_11.add(panel_31);
		panel_31.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_51 = new JPanel();
		panel_31.add(panel_51);
		
		JLabel lblFormaDePago = new JLabel("Cobro del pasaje");
		panel_31.add(lblFormaDePago);
		lblFormaDePago.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormaDePago.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_32 = new JPanel();
		panel_31.add(panel_32);
		panel_32.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_32.add(panel_17);
		panel_17.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblValorSinRecargo_1 = new JLabel("Valor sin recargo  ");
		lblValorSinRecargo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_17.add(lblValorSinRecargo_1);
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 2, 0, 0));
		
		textValor = new JTextField();
		panel_19.add(textValor);
		textValor.getDocument().addDocumentListener(new CapturaTextValor(this));
		textValor.setColumns(10);
		
		JLabel label_2 = new JLabel("Metodo de pago");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_17.add(label_2);
		
		JPanel panel_18 = new JPanel();
		panel_17.add(panel_18);
		panel_18.setLayout(new GridLayout(1, 0, 0, 0));
		
		rdbtnTarjeta = new JRadioButton("Tarjeta");
		rdbtnTarjeta.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnTarjeta.addItemListener(new CapturaItemVenta(this));
		botones.add(rdbtnTarjeta);
		panel_18.add(rdbtnTarjeta);
		
		rdbtnEfectivo = new JRadioButton("Efectivo");
		rdbtnEfectivo.addItemListener(new CapturaItemVenta(this));
		botones.add(rdbtnEfectivo);
		panel_18.add(rdbtnEfectivo);
		
		JPanel panel_15 = new JPanel();
		panel_32.add(panel_15);
		panel_15.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel label_3 = new JLabel("3 y 6 cuotas sin interes");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_15.add(label_3);
		
		JLabel label_5 = new JLabel("Cuotas  ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_15.add(label_5);
		
		comboBox_Cuotas = new JComboBox<String>();
		comboBox_Cuotas.setEnabled(false);
		comboBox_Cuotas.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "3", "6", "12", "24"}));
		comboBox_Cuotas.addItemListener(new CapturaItemVenta(this));
		comboBox_Cuotas.setBounds(300, 491, 53, 20);
		panel_15.add(comboBox_Cuotas);
		
		JPanel panel_56 = new JPanel();
		panel_15.add(panel_56);
		
		JPanel panel_20 = new JPanel();
		panel_15.add(panel_20);
		panel_20.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label_4 = new JLabel("12 o 24 con 10% de recargo");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_20.add(label_4);
		
		JLabel label_6 = new JLabel("TOTAL A PAGAR  ");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_15.add(label_6);
		
		textTotalPagar = new JTextField();
		textTotalPagar.setEditable(false);
		textTotalPagar.setColumns(10);
		textTotalPagar.setText(String.valueOf(venta.getTotalPagar()));
		panel_15.add(textTotalPagar);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_25 = new JPanel();
		panel.add(panel_25);
		
		JLabel lblIngreseLosDatos = new JLabel("Mostrando los datos de la venta para su modificacion");
		panel.add(lblIngreseLosDatos);
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel_12 = new JPanel();
		getContentPane().add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new GridLayout(2, 7, 0, 0));
		
		JPanel panel_40 = new JPanel();
		panel_12.add(panel_40);
		
		btnCancelar = new JButton("Cancelar");
		panel_12.add(btnCancelar);
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		btnCancelar.addActionListener(new CapturaBtnVenta_Datos(this));
		
		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13);
		
		JPanel panel_60 = new JPanel();
		panel_12.add(panel_60);
		
		JPanel panel_61 = new JPanel();
		panel_12.add(panel_61);
		
		btnGuardar = new JButton("Guardar");
		panel_12.add(btnGuardar);
		btnGuardar.addActionListener(new CapturaBtnVenta_Datos(this));
		
		JPanel panel_62 = new JPanel();
		panel_12.add(panel_62);
		
		JPanel panel_63 = new JPanel();
		panel_12.add(panel_63);
		
		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14);
		
		JPanel panel_38 = new JPanel();
		panel_12.add(panel_38);
		
		JPanel panel_37 = new JPanel();
		panel_12.add(panel_37);
		
		JPanel panel_58 = new JPanel();
		panel_12.add(panel_58);
		
		JPanel panel_59 = new JPanel();
		panel_12.add(panel_59);
		
		JPanel panel_57 = new JPanel();
		panel_12.add(panel_57);
		
		JPanel panel_43 = new JPanel();
		getContentPane().add(panel_43, BorderLayout.WEST);
		
		JPanel panel_44 = new JPanel();
		getContentPane().add(panel_44, BorderLayout.EAST);
		

		this.setVisible(true);
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



	public JButton getBtnVerVuelos() {
		return btnVerVuelos;
	}

	public void setBtnVerVuelos(JButton btnVerVuelos) {
		this.btnVerVuelos = btnVerVuelos;
	}

	public JButton getBtnVerClientes() {
		return btnVerClientes;
	}

	public void setBtnVerClientes(JButton btnVerClientes) {
		this.btnVerClientes = btnVerClientes;
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


	@SuppressWarnings("deprecation")
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
